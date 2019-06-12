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

package com.liferay.powwow.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.powwow.model.PowwowMeeting;
import com.liferay.powwow.model.PowwowMeetingModel;
import com.liferay.powwow.model.PowwowMeetingSoap;

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
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the PowwowMeeting service. Represents a row in the &quot;PowwowMeeting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>PowwowMeetingModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PowwowMeetingImpl}.
 * </p>
 *
 * @author Shinn Lok
 * @see PowwowMeetingImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class PowwowMeetingModelImpl
	extends BaseModelImpl<PowwowMeeting> implements PowwowMeetingModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a powwow meeting model instance should use the <code>PowwowMeeting</code> interface instead.
	 */
	public static final String TABLE_NAME = "PowwowMeeting";

	public static final Object[][] TABLE_COLUMNS = {
		{"powwowMeetingId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"powwowServerId", Types.BIGINT},
		{"name", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"providerType", Types.VARCHAR},
		{"providerTypeMetadata", Types.VARCHAR}, {"languageId", Types.VARCHAR},
		{"calendarBookingId", Types.BIGINT}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("powwowMeetingId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("powwowServerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("providerType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("providerTypeMetadata", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("calendarBookingId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PowwowMeeting (powwowMeetingId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,powwowServerId LONG,name VARCHAR(75) null,description STRING null,providerType VARCHAR(75) null,providerTypeMetadata STRING null,languageId VARCHAR(75) null,calendarBookingId LONG,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table PowwowMeeting";

	public static final String ORDER_BY_JPQL =
		" ORDER BY powwowMeeting.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PowwowMeeting.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.util.service.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.powwow.model.PowwowMeeting"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.util.service.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.powwow.model.PowwowMeeting"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.util.service.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.powwow.model.PowwowMeeting"),
		true);

	public static final long GROUPID_COLUMN_BITMASK = 1L;

	public static final long POWWOWSERVERID_COLUMN_BITMASK = 2L;

	public static final long STATUS_COLUMN_BITMASK = 4L;

	public static final long USERID_COLUMN_BITMASK = 8L;

	public static final long CREATEDATE_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PowwowMeeting toModel(PowwowMeetingSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PowwowMeeting model = new PowwowMeetingImpl();

		model.setPowwowMeetingId(soapModel.getPowwowMeetingId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPowwowServerId(soapModel.getPowwowServerId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setProviderType(soapModel.getProviderType());
		model.setProviderTypeMetadata(soapModel.getProviderTypeMetadata());
		model.setLanguageId(soapModel.getLanguageId());
		model.setCalendarBookingId(soapModel.getCalendarBookingId());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<PowwowMeeting> toModels(PowwowMeetingSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PowwowMeeting> models = new ArrayList<PowwowMeeting>(
			soapModels.length);

		for (PowwowMeetingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.util.service.ServiceProps.get(
			"lock.expiration.time.com.liferay.powwow.model.PowwowMeeting"));

	public PowwowMeetingModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _powwowMeetingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPowwowMeetingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _powwowMeetingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PowwowMeeting.class;
	}

	@Override
	public String getModelClassName() {
		return PowwowMeeting.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PowwowMeeting, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PowwowMeeting, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PowwowMeeting, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PowwowMeeting)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PowwowMeeting, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PowwowMeeting, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PowwowMeeting)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PowwowMeeting, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PowwowMeeting, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PowwowMeeting>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PowwowMeeting.class.getClassLoader(), PowwowMeeting.class,
			ModelWrapper.class);

		try {
			Constructor<PowwowMeeting> constructor =
				(Constructor<PowwowMeeting>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PowwowMeeting, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PowwowMeeting, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PowwowMeeting, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<PowwowMeeting, Object>>();
		Map<String, BiConsumer<PowwowMeeting, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<PowwowMeeting, ?>>();

		attributeGetterFunctions.put(
			"powwowMeetingId", PowwowMeeting::getPowwowMeetingId);
		attributeSetterBiConsumers.put(
			"powwowMeetingId",
			(BiConsumer<PowwowMeeting, Long>)PowwowMeeting::setPowwowMeetingId);
		attributeGetterFunctions.put("groupId", PowwowMeeting::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<PowwowMeeting, Long>)PowwowMeeting::setGroupId);
		attributeGetterFunctions.put("companyId", PowwowMeeting::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<PowwowMeeting, Long>)PowwowMeeting::setCompanyId);
		attributeGetterFunctions.put("userId", PowwowMeeting::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<PowwowMeeting, Long>)PowwowMeeting::setUserId);
		attributeGetterFunctions.put("userName", PowwowMeeting::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<PowwowMeeting, String>)PowwowMeeting::setUserName);
		attributeGetterFunctions.put(
			"createDate", PowwowMeeting::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<PowwowMeeting, Date>)PowwowMeeting::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", PowwowMeeting::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<PowwowMeeting, Date>)PowwowMeeting::setModifiedDate);
		attributeGetterFunctions.put(
			"powwowServerId", PowwowMeeting::getPowwowServerId);
		attributeSetterBiConsumers.put(
			"powwowServerId",
			(BiConsumer<PowwowMeeting, Long>)PowwowMeeting::setPowwowServerId);
		attributeGetterFunctions.put("name", PowwowMeeting::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<PowwowMeeting, String>)PowwowMeeting::setName);
		attributeGetterFunctions.put(
			"description", PowwowMeeting::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<PowwowMeeting, String>)PowwowMeeting::setDescription);
		attributeGetterFunctions.put(
			"providerType", PowwowMeeting::getProviderType);
		attributeSetterBiConsumers.put(
			"providerType",
			(BiConsumer<PowwowMeeting, String>)PowwowMeeting::setProviderType);
		attributeGetterFunctions.put(
			"providerTypeMetadata", PowwowMeeting::getProviderTypeMetadata);
		attributeSetterBiConsumers.put(
			"providerTypeMetadata",
			(BiConsumer<PowwowMeeting, String>)
				PowwowMeeting::setProviderTypeMetadata);
		attributeGetterFunctions.put(
			"languageId", PowwowMeeting::getLanguageId);
		attributeSetterBiConsumers.put(
			"languageId",
			(BiConsumer<PowwowMeeting, String>)PowwowMeeting::setLanguageId);
		attributeGetterFunctions.put(
			"calendarBookingId", PowwowMeeting::getCalendarBookingId);
		attributeSetterBiConsumers.put(
			"calendarBookingId",
			(BiConsumer<PowwowMeeting, Long>)
				PowwowMeeting::setCalendarBookingId);
		attributeGetterFunctions.put("status", PowwowMeeting::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<PowwowMeeting, Integer>)PowwowMeeting::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getPowwowMeetingId() {
		return _powwowMeetingId;
	}

	@Override
	public void setPowwowMeetingId(long powwowMeetingId) {
		_powwowMeetingId = powwowMeetingId;
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
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
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
		_columnBitmask = -1L;

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
	public long getPowwowServerId() {
		return _powwowServerId;
	}

	@Override
	public void setPowwowServerId(long powwowServerId) {
		_columnBitmask |= POWWOWSERVERID_COLUMN_BITMASK;

		if (!_setOriginalPowwowServerId) {
			_setOriginalPowwowServerId = true;

			_originalPowwowServerId = _powwowServerId;
		}

		_powwowServerId = powwowServerId;
	}

	public long getOriginalPowwowServerId() {
		return _originalPowwowServerId;
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
	public void setName(String name) {
		_name = name;
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
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public String getProviderType() {
		if (_providerType == null) {
			return "";
		}
		else {
			return _providerType;
		}
	}

	@Override
	public void setProviderType(String providerType) {
		_providerType = providerType;
	}

	@JSON
	@Override
	public String getProviderTypeMetadata() {
		if (_providerTypeMetadata == null) {
			return "";
		}
		else {
			return _providerTypeMetadata;
		}
	}

	@Override
	public void setProviderTypeMetadata(String providerTypeMetadata) {
		_providerTypeMetadata = providerTypeMetadata;
	}

	@JSON
	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	@JSON
	@Override
	public long getCalendarBookingId() {
		return _calendarBookingId;
	}

	@Override
	public void setCalendarBookingId(long calendarBookingId) {
		_calendarBookingId = calendarBookingId;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), PowwowMeeting.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PowwowMeeting toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PowwowMeeting>
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
		PowwowMeetingImpl powwowMeetingImpl = new PowwowMeetingImpl();

		powwowMeetingImpl.setPowwowMeetingId(getPowwowMeetingId());
		powwowMeetingImpl.setGroupId(getGroupId());
		powwowMeetingImpl.setCompanyId(getCompanyId());
		powwowMeetingImpl.setUserId(getUserId());
		powwowMeetingImpl.setUserName(getUserName());
		powwowMeetingImpl.setCreateDate(getCreateDate());
		powwowMeetingImpl.setModifiedDate(getModifiedDate());
		powwowMeetingImpl.setPowwowServerId(getPowwowServerId());
		powwowMeetingImpl.setName(getName());
		powwowMeetingImpl.setDescription(getDescription());
		powwowMeetingImpl.setProviderType(getProviderType());
		powwowMeetingImpl.setProviderTypeMetadata(getProviderTypeMetadata());
		powwowMeetingImpl.setLanguageId(getLanguageId());
		powwowMeetingImpl.setCalendarBookingId(getCalendarBookingId());
		powwowMeetingImpl.setStatus(getStatus());

		powwowMeetingImpl.resetOriginalValues();

		return powwowMeetingImpl;
	}

	@Override
	public int compareTo(PowwowMeeting powwowMeeting) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), powwowMeeting.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof PowwowMeeting)) {
			return false;
		}

		PowwowMeeting powwowMeeting = (PowwowMeeting)obj;

		long primaryKey = powwowMeeting.getPrimaryKey();

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
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PowwowMeetingModelImpl powwowMeetingModelImpl = this;

		powwowMeetingModelImpl._originalGroupId =
			powwowMeetingModelImpl._groupId;

		powwowMeetingModelImpl._setOriginalGroupId = false;

		powwowMeetingModelImpl._originalUserId = powwowMeetingModelImpl._userId;

		powwowMeetingModelImpl._setOriginalUserId = false;

		powwowMeetingModelImpl._setModifiedDate = false;

		powwowMeetingModelImpl._originalPowwowServerId =
			powwowMeetingModelImpl._powwowServerId;

		powwowMeetingModelImpl._setOriginalPowwowServerId = false;

		powwowMeetingModelImpl._originalStatus = powwowMeetingModelImpl._status;

		powwowMeetingModelImpl._setOriginalStatus = false;

		powwowMeetingModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PowwowMeeting> toCacheModel() {
		PowwowMeetingCacheModel powwowMeetingCacheModel =
			new PowwowMeetingCacheModel();

		powwowMeetingCacheModel.powwowMeetingId = getPowwowMeetingId();

		powwowMeetingCacheModel.groupId = getGroupId();

		powwowMeetingCacheModel.companyId = getCompanyId();

		powwowMeetingCacheModel.userId = getUserId();

		powwowMeetingCacheModel.userName = getUserName();

		String userName = powwowMeetingCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			powwowMeetingCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			powwowMeetingCacheModel.createDate = createDate.getTime();
		}
		else {
			powwowMeetingCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			powwowMeetingCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			powwowMeetingCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		powwowMeetingCacheModel.powwowServerId = getPowwowServerId();

		powwowMeetingCacheModel.name = getName();

		String name = powwowMeetingCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			powwowMeetingCacheModel.name = null;
		}

		powwowMeetingCacheModel.description = getDescription();

		String description = powwowMeetingCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			powwowMeetingCacheModel.description = null;
		}

		powwowMeetingCacheModel.providerType = getProviderType();

		String providerType = powwowMeetingCacheModel.providerType;

		if ((providerType != null) && (providerType.length() == 0)) {
			powwowMeetingCacheModel.providerType = null;
		}

		powwowMeetingCacheModel.providerTypeMetadata =
			getProviderTypeMetadata();

		String providerTypeMetadata =
			powwowMeetingCacheModel.providerTypeMetadata;

		if ((providerTypeMetadata != null) &&
			(providerTypeMetadata.length() == 0)) {

			powwowMeetingCacheModel.providerTypeMetadata = null;
		}

		powwowMeetingCacheModel.languageId = getLanguageId();

		String languageId = powwowMeetingCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			powwowMeetingCacheModel.languageId = null;
		}

		powwowMeetingCacheModel.calendarBookingId = getCalendarBookingId();

		powwowMeetingCacheModel.status = getStatus();

		return powwowMeetingCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PowwowMeeting, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PowwowMeeting, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PowwowMeeting, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PowwowMeeting)this));
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
		Map<String, Function<PowwowMeeting, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PowwowMeeting, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PowwowMeeting, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PowwowMeeting)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PowwowMeeting>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _powwowMeetingId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _powwowServerId;
	private long _originalPowwowServerId;
	private boolean _setOriginalPowwowServerId;
	private String _name;
	private String _description;
	private String _providerType;
	private String _providerTypeMetadata;
	private String _languageId;
	private long _calendarBookingId;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private PowwowMeeting _escapedModel;

}