/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.calendar.model.impl;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarModel;
import com.liferay.calendar.model.CalendarSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Calendar service. Represents a row in the &quot;Calendar&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CalendarModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarImpl}.
 * </p>
 *
 * @author Eduardo Lundgren
 * @see CalendarImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CalendarModelImpl
	extends BaseModelImpl<Calendar> implements CalendarModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar model instance should use the <code>Calendar</code> interface instead.
	 */
	public static final String TABLE_NAME = "Calendar";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"calendarId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"calendarResourceId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"timeZoneId", Types.VARCHAR},
		{"color", Types.INTEGER}, {"defaultCalendar", Types.BOOLEAN},
		{"enableComments", Types.BOOLEAN}, {"enableRatings", Types.BOOLEAN},
		{"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("calendarId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("calendarResourceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("timeZoneId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("color", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("defaultCalendar", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("enableComments", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("enableRatings", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Calendar (uuid_ VARCHAR(75) null,calendarId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,calendarResourceId LONG,name STRING null,description STRING null,timeZoneId VARCHAR(75) null,color INTEGER,defaultCalendar BOOLEAN,enableComments BOOLEAN,enableRatings BOOLEAN,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table Calendar";

	public static final String ORDER_BY_JPQL = " ORDER BY calendar.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY Calendar.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long CALENDARRESOURCEID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long DEFAULTCALENDAR_COLUMN_BITMASK = 4L;

	public static final long GROUPID_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long NAME_COLUMN_BITMASK = 32L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Calendar toModel(CalendarSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Calendar model = new CalendarImpl();

		model.setUuid(soapModel.getUuid());
		model.setCalendarId(soapModel.getCalendarId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCalendarResourceId(soapModel.getCalendarResourceId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setTimeZoneId(soapModel.getTimeZoneId());
		model.setColor(soapModel.getColor());
		model.setDefaultCalendar(soapModel.isDefaultCalendar());
		model.setEnableComments(soapModel.isEnableComments());
		model.setEnableRatings(soapModel.isEnableRatings());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Calendar> toModels(CalendarSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Calendar> models = new ArrayList<Calendar>(soapModels.length);

		for (CalendarSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CalendarModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _calendarId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCalendarId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _calendarId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Calendar.class;
	}

	@Override
	public String getModelClassName() {
		return Calendar.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Calendar, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Calendar, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Calendar, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Calendar)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Calendar, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Calendar, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Calendar)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Calendar, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Calendar, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Calendar>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Calendar.class.getClassLoader(), Calendar.class,
			ModelWrapper.class);

		try {
			Constructor<Calendar> constructor =
				(Constructor<Calendar>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Calendar, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Calendar, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Calendar, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Calendar, Object>>();
		Map<String, BiConsumer<Calendar, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Calendar, ?>>();

		attributeGetterFunctions.put("uuid", Calendar::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Calendar, String>)Calendar::setUuid);
		attributeGetterFunctions.put("calendarId", Calendar::getCalendarId);
		attributeSetterBiConsumers.put(
			"calendarId", (BiConsumer<Calendar, Long>)Calendar::setCalendarId);
		attributeGetterFunctions.put("groupId", Calendar::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Calendar, Long>)Calendar::setGroupId);
		attributeGetterFunctions.put("companyId", Calendar::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Calendar, Long>)Calendar::setCompanyId);
		attributeGetterFunctions.put("userId", Calendar::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Calendar, Long>)Calendar::setUserId);
		attributeGetterFunctions.put("userName", Calendar::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Calendar, String>)Calendar::setUserName);
		attributeGetterFunctions.put("createDate", Calendar::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Calendar, Date>)Calendar::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Calendar::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Calendar, Date>)Calendar::setModifiedDate);
		attributeGetterFunctions.put(
			"calendarResourceId", Calendar::getCalendarResourceId);
		attributeSetterBiConsumers.put(
			"calendarResourceId",
			(BiConsumer<Calendar, Long>)Calendar::setCalendarResourceId);
		attributeGetterFunctions.put("name", Calendar::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Calendar, String>)Calendar::setName);
		attributeGetterFunctions.put("description", Calendar::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<Calendar, String>)Calendar::setDescription);
		attributeGetterFunctions.put("timeZoneId", Calendar::getTimeZoneId);
		attributeSetterBiConsumers.put(
			"timeZoneId",
			(BiConsumer<Calendar, String>)Calendar::setTimeZoneId);
		attributeGetterFunctions.put("color", Calendar::getColor);
		attributeSetterBiConsumers.put(
			"color", (BiConsumer<Calendar, Integer>)Calendar::setColor);
		attributeGetterFunctions.put(
			"defaultCalendar", Calendar::getDefaultCalendar);
		attributeSetterBiConsumers.put(
			"defaultCalendar",
			(BiConsumer<Calendar, Boolean>)Calendar::setDefaultCalendar);
		attributeGetterFunctions.put(
			"enableComments", Calendar::getEnableComments);
		attributeSetterBiConsumers.put(
			"enableComments",
			(BiConsumer<Calendar, Boolean>)Calendar::setEnableComments);
		attributeGetterFunctions.put(
			"enableRatings", Calendar::getEnableRatings);
		attributeSetterBiConsumers.put(
			"enableRatings",
			(BiConsumer<Calendar, Boolean>)Calendar::setEnableRatings);
		attributeGetterFunctions.put(
			"lastPublishDate", Calendar::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<Calendar, Date>)Calendar::setLastPublishDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCalendarId() {
		return _calendarId;
	}

	@Override
	public void setCalendarId(long calendarId) {
		_calendarId = calendarId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCalendarResourceId() {
		return _calendarResourceId;
	}

	@Override
	public void setCalendarResourceId(long calendarResourceId) {
		_columnBitmask |= CALENDARRESOURCEID_COLUMN_BITMASK;

		if (!_setOriginalCalendarResourceId) {
			_setOriginalCalendarResourceId = true;

			_originalCalendarResourceId = _calendarResourceId;
		}

		_calendarResourceId = calendarResourceId;
	}

	public long getOriginalCalendarResourceId() {
		return _originalCalendarResourceId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getName(), languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(
				LocalizationUtil.updateLocalization(
					getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(
				LocalizationUtil.removeLocalization(
					getName(), "Name", languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(
			LocalizationUtil.updateLocalization(
				nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDescription(), languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDescription(
		String description, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(
				LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(
				LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale) {

		if (descriptionMap == null) {
			return;
		}

		setDescription(
			LocalizationUtil.updateLocalization(
				descriptionMap, getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getTimeZoneId() {
		if (_timeZoneId == null) {
			return "";
		}
		else {
			return _timeZoneId;
		}
	}

	@Override
	public void setTimeZoneId(String timeZoneId) {
		_timeZoneId = timeZoneId;
	}

	@JSON
	@Override
	public int getColor() {
		return _color;
	}

	@Override
	public void setColor(int color) {
		_color = color;
	}

	@JSON
	@Override
	public boolean getDefaultCalendar() {
		return _defaultCalendar;
	}

	@JSON
	@Override
	public boolean isDefaultCalendar() {
		return _defaultCalendar;
	}

	@Override
	public void setDefaultCalendar(boolean defaultCalendar) {
		_columnBitmask |= DEFAULTCALENDAR_COLUMN_BITMASK;

		if (!_setOriginalDefaultCalendar) {
			_setOriginalDefaultCalendar = true;

			_originalDefaultCalendar = _defaultCalendar;
		}

		_defaultCalendar = defaultCalendar;
	}

	public boolean getOriginalDefaultCalendar() {
		return _originalDefaultCalendar;
	}

	@JSON
	@Override
	public boolean getEnableComments() {
		return _enableComments;
	}

	@JSON
	@Override
	public boolean isEnableComments() {
		return _enableComments;
	}

	@Override
	public void setEnableComments(boolean enableComments) {
		_enableComments = enableComments;
	}

	@JSON
	@Override
	public boolean getEnableRatings() {
		return _enableRatings;
	}

	@JSON
	@Override
	public boolean isEnableRatings() {
		return _enableRatings;
	}

	@Override
	public void setEnableRatings(boolean enableRatings) {
		_enableRatings = enableRatings;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Calendar.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Calendar.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			Calendar.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(
				getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(
				getDescription(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public Calendar toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Calendar>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CalendarImpl calendarImpl = new CalendarImpl();

		calendarImpl.setUuid(getUuid());
		calendarImpl.setCalendarId(getCalendarId());
		calendarImpl.setGroupId(getGroupId());
		calendarImpl.setCompanyId(getCompanyId());
		calendarImpl.setUserId(getUserId());
		calendarImpl.setUserName(getUserName());
		calendarImpl.setCreateDate(getCreateDate());
		calendarImpl.setModifiedDate(getModifiedDate());
		calendarImpl.setCalendarResourceId(getCalendarResourceId());
		calendarImpl.setName(getName());
		calendarImpl.setDescription(getDescription());
		calendarImpl.setTimeZoneId(getTimeZoneId());
		calendarImpl.setColor(getColor());
		calendarImpl.setDefaultCalendar(isDefaultCalendar());
		calendarImpl.setEnableComments(isEnableComments());
		calendarImpl.setEnableRatings(isEnableRatings());
		calendarImpl.setLastPublishDate(getLastPublishDate());

		calendarImpl.resetOriginalValues();

		return calendarImpl;
	}

	@Override
	public int compareTo(Calendar calendar) {
		int value = 0;

		value = getName().compareTo(calendar.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Calendar)) {
			return false;
		}

		Calendar calendar = (Calendar)obj;

		long primaryKey = calendar.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		CalendarModelImpl calendarModelImpl = this;

		calendarModelImpl._originalUuid = calendarModelImpl._uuid;

		calendarModelImpl._originalGroupId = calendarModelImpl._groupId;

		calendarModelImpl._setOriginalGroupId = false;

		calendarModelImpl._originalCompanyId = calendarModelImpl._companyId;

		calendarModelImpl._setOriginalCompanyId = false;

		calendarModelImpl._setModifiedDate = false;

		calendarModelImpl._originalCalendarResourceId =
			calendarModelImpl._calendarResourceId;

		calendarModelImpl._setOriginalCalendarResourceId = false;

		calendarModelImpl._originalDefaultCalendar =
			calendarModelImpl._defaultCalendar;

		calendarModelImpl._setOriginalDefaultCalendar = false;

		calendarModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Calendar> toCacheModel() {
		CalendarCacheModel calendarCacheModel = new CalendarCacheModel();

		calendarCacheModel.uuid = getUuid();

		String uuid = calendarCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			calendarCacheModel.uuid = null;
		}

		calendarCacheModel.calendarId = getCalendarId();

		calendarCacheModel.groupId = getGroupId();

		calendarCacheModel.companyId = getCompanyId();

		calendarCacheModel.userId = getUserId();

		calendarCacheModel.userName = getUserName();

		String userName = calendarCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			calendarCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			calendarCacheModel.createDate = createDate.getTime();
		}
		else {
			calendarCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			calendarCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			calendarCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		calendarCacheModel.calendarResourceId = getCalendarResourceId();

		calendarCacheModel.name = getName();

		String name = calendarCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			calendarCacheModel.name = null;
		}

		calendarCacheModel.description = getDescription();

		String description = calendarCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			calendarCacheModel.description = null;
		}

		calendarCacheModel.timeZoneId = getTimeZoneId();

		String timeZoneId = calendarCacheModel.timeZoneId;

		if ((timeZoneId != null) && (timeZoneId.length() == 0)) {
			calendarCacheModel.timeZoneId = null;
		}

		calendarCacheModel.color = getColor();

		calendarCacheModel.defaultCalendar = isDefaultCalendar();

		calendarCacheModel.enableComments = isEnableComments();

		calendarCacheModel.enableRatings = isEnableRatings();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			calendarCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			calendarCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return calendarCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Calendar, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Calendar, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Calendar, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Calendar)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Calendar, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Calendar, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Calendar, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Calendar)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Calendar>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _calendarId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _calendarResourceId;
	private long _originalCalendarResourceId;
	private boolean _setOriginalCalendarResourceId;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _timeZoneId;
	private int _color;
	private boolean _defaultCalendar;
	private boolean _originalDefaultCalendar;
	private boolean _setOriginalDefaultCalendar;
	private boolean _enableComments;
	private boolean _enableRatings;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private Calendar _escapedModel;

}