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

package com.liferay.portlet.social.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.social.kernel.model.SocialActivityCounter;
import com.liferay.social.kernel.model.SocialActivityCounterModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the SocialActivityCounter service. Represents a row in the &quot;SocialActivityCounter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>SocialActivityCounterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SocialActivityCounterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivityCounterImpl
 * @generated
 */
@ProviderType
public class SocialActivityCounterModelImpl
	extends BaseModelImpl<SocialActivityCounter>
	implements SocialActivityCounterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a social activity counter model instance should use the <code>SocialActivityCounter</code> interface instead.
	 */
	public static final String TABLE_NAME = "SocialActivityCounter";

	public static final Object[][] TABLE_COLUMNS = {
		{"activityCounterId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"classNameId", Types.BIGINT},
		{"classPK", Types.BIGINT}, {"name", Types.VARCHAR},
		{"ownerType", Types.INTEGER}, {"currentValue", Types.INTEGER},
		{"totalValue", Types.INTEGER}, {"graceValue", Types.INTEGER},
		{"startPeriod", Types.INTEGER}, {"endPeriod", Types.INTEGER},
		{"active_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("activityCounterId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ownerType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("currentValue", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("totalValue", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("graceValue", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("startPeriod", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("endPeriod", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SocialActivityCounter (activityCounterId LONG not null primary key,groupId LONG,companyId LONG,classNameId LONG,classPK LONG,name VARCHAR(75) null,ownerType INTEGER,currentValue INTEGER,totalValue INTEGER,graceValue INTEGER,startPeriod INTEGER,endPeriod INTEGER,active_ BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table SocialActivityCounter";

	public static final String ORDER_BY_JPQL =
		" ORDER BY socialActivityCounter.activityCounterId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SocialActivityCounter.activityCounterId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.social.kernel.model.SocialActivityCounter"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.social.kernel.model.SocialActivityCounter"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.social.kernel.model.SocialActivityCounter"),
		true);

	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	public static final long ENDPERIOD_COLUMN_BITMASK = 4L;

	public static final long GROUPID_COLUMN_BITMASK = 8L;

	public static final long NAME_COLUMN_BITMASK = 16L;

	public static final long OWNERTYPE_COLUMN_BITMASK = 32L;

	public static final long STARTPERIOD_COLUMN_BITMASK = 64L;

	public static final long ACTIVITYCOUNTERID_COLUMN_BITMASK = 128L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.social.kernel.model.SocialActivityCounter"));

	public SocialActivityCounterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _activityCounterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setActivityCounterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _activityCounterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SocialActivityCounter.class;
	}

	@Override
	public String getModelClassName() {
		return SocialActivityCounter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SocialActivityCounter, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SocialActivityCounter, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SocialActivityCounter, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SocialActivityCounter)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SocialActivityCounter, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SocialActivityCounter, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SocialActivityCounter)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SocialActivityCounter, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SocialActivityCounter, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SocialActivityCounter>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SocialActivityCounter.class.getClassLoader(),
			SocialActivityCounter.class, ModelWrapper.class);

		try {
			Constructor<SocialActivityCounter> constructor =
				(Constructor<SocialActivityCounter>)proxyClass.getConstructor(
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

	private static final Map<String, Function<SocialActivityCounter, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SocialActivityCounter, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SocialActivityCounter, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<SocialActivityCounter, Object>>();
		Map<String, BiConsumer<SocialActivityCounter, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<SocialActivityCounter, ?>>();

		attributeGetterFunctions.put(
			"activityCounterId", SocialActivityCounter::getActivityCounterId);
		attributeSetterBiConsumers.put(
			"activityCounterId",
			(BiConsumer<SocialActivityCounter, Long>)
				SocialActivityCounter::setActivityCounterId);
		attributeGetterFunctions.put(
			"groupId", SocialActivityCounter::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<SocialActivityCounter, Long>)
				SocialActivityCounter::setGroupId);
		attributeGetterFunctions.put(
			"companyId", SocialActivityCounter::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SocialActivityCounter, Long>)
				SocialActivityCounter::setCompanyId);
		attributeGetterFunctions.put(
			"classNameId", SocialActivityCounter::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId",
			(BiConsumer<SocialActivityCounter, Long>)
				SocialActivityCounter::setClassNameId);
		attributeGetterFunctions.put(
			"classPK", SocialActivityCounter::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK",
			(BiConsumer<SocialActivityCounter, Long>)
				SocialActivityCounter::setClassPK);
		attributeGetterFunctions.put("name", SocialActivityCounter::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<SocialActivityCounter, String>)
				SocialActivityCounter::setName);
		attributeGetterFunctions.put(
			"ownerType", SocialActivityCounter::getOwnerType);
		attributeSetterBiConsumers.put(
			"ownerType",
			(BiConsumer<SocialActivityCounter, Integer>)
				SocialActivityCounter::setOwnerType);
		attributeGetterFunctions.put(
			"currentValue", SocialActivityCounter::getCurrentValue);
		attributeSetterBiConsumers.put(
			"currentValue",
			(BiConsumer<SocialActivityCounter, Integer>)
				SocialActivityCounter::setCurrentValue);
		attributeGetterFunctions.put(
			"totalValue", SocialActivityCounter::getTotalValue);
		attributeSetterBiConsumers.put(
			"totalValue",
			(BiConsumer<SocialActivityCounter, Integer>)
				SocialActivityCounter::setTotalValue);
		attributeGetterFunctions.put(
			"graceValue", SocialActivityCounter::getGraceValue);
		attributeSetterBiConsumers.put(
			"graceValue",
			(BiConsumer<SocialActivityCounter, Integer>)
				SocialActivityCounter::setGraceValue);
		attributeGetterFunctions.put(
			"startPeriod", SocialActivityCounter::getStartPeriod);
		attributeSetterBiConsumers.put(
			"startPeriod",
			(BiConsumer<SocialActivityCounter, Integer>)
				SocialActivityCounter::setStartPeriod);
		attributeGetterFunctions.put(
			"endPeriod", SocialActivityCounter::getEndPeriod);
		attributeSetterBiConsumers.put(
			"endPeriod",
			(BiConsumer<SocialActivityCounter, Integer>)
				SocialActivityCounter::setEndPeriod);
		attributeGetterFunctions.put(
			"active", SocialActivityCounter::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<SocialActivityCounter, Boolean>)
				SocialActivityCounter::setActive);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getActivityCounterId() {
		return _activityCounterId;
	}

	@Override
	public void setActivityCounterId(long activityCounterId) {
		_activityCounterId = activityCounterId;
	}

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

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

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
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public int getOwnerType() {
		return _ownerType;
	}

	@Override
	public void setOwnerType(int ownerType) {
		_columnBitmask |= OWNERTYPE_COLUMN_BITMASK;

		if (!_setOriginalOwnerType) {
			_setOriginalOwnerType = true;

			_originalOwnerType = _ownerType;
		}

		_ownerType = ownerType;
	}

	public int getOriginalOwnerType() {
		return _originalOwnerType;
	}

	@Override
	public int getCurrentValue() {
		return _currentValue;
	}

	@Override
	public void setCurrentValue(int currentValue) {
		_currentValue = currentValue;
	}

	@Override
	public int getTotalValue() {
		return _totalValue;
	}

	@Override
	public void setTotalValue(int totalValue) {
		_totalValue = totalValue;
	}

	@Override
	public int getGraceValue() {
		return _graceValue;
	}

	@Override
	public void setGraceValue(int graceValue) {
		_graceValue = graceValue;
	}

	@Override
	public int getStartPeriod() {
		return _startPeriod;
	}

	@Override
	public void setStartPeriod(int startPeriod) {
		_columnBitmask |= STARTPERIOD_COLUMN_BITMASK;

		if (!_setOriginalStartPeriod) {
			_setOriginalStartPeriod = true;

			_originalStartPeriod = _startPeriod;
		}

		_startPeriod = startPeriod;
	}

	public int getOriginalStartPeriod() {
		return _originalStartPeriod;
	}

	@Override
	public int getEndPeriod() {
		return _endPeriod;
	}

	@Override
	public void setEndPeriod(int endPeriod) {
		_columnBitmask |= ENDPERIOD_COLUMN_BITMASK;

		if (!_setOriginalEndPeriod) {
			_setOriginalEndPeriod = true;

			_originalEndPeriod = _endPeriod;
		}

		_endPeriod = endPeriod;
	}

	public int getOriginalEndPeriod() {
		return _originalEndPeriod;
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), SocialActivityCounter.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SocialActivityCounter toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SocialActivityCounter>
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
		SocialActivityCounterImpl socialActivityCounterImpl =
			new SocialActivityCounterImpl();

		socialActivityCounterImpl.setActivityCounterId(getActivityCounterId());
		socialActivityCounterImpl.setGroupId(getGroupId());
		socialActivityCounterImpl.setCompanyId(getCompanyId());
		socialActivityCounterImpl.setClassNameId(getClassNameId());
		socialActivityCounterImpl.setClassPK(getClassPK());
		socialActivityCounterImpl.setName(getName());
		socialActivityCounterImpl.setOwnerType(getOwnerType());
		socialActivityCounterImpl.setCurrentValue(getCurrentValue());
		socialActivityCounterImpl.setTotalValue(getTotalValue());
		socialActivityCounterImpl.setGraceValue(getGraceValue());
		socialActivityCounterImpl.setStartPeriod(getStartPeriod());
		socialActivityCounterImpl.setEndPeriod(getEndPeriod());
		socialActivityCounterImpl.setActive(isActive());

		socialActivityCounterImpl.resetOriginalValues();

		return socialActivityCounterImpl;
	}

	@Override
	public int compareTo(SocialActivityCounter socialActivityCounter) {
		long primaryKey = socialActivityCounter.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialActivityCounter)) {
			return false;
		}

		SocialActivityCounter socialActivityCounter =
			(SocialActivityCounter)obj;

		long primaryKey = socialActivityCounter.getPrimaryKey();

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
		SocialActivityCounterModelImpl socialActivityCounterModelImpl = this;

		socialActivityCounterModelImpl._originalGroupId =
			socialActivityCounterModelImpl._groupId;

		socialActivityCounterModelImpl._setOriginalGroupId = false;

		socialActivityCounterModelImpl._originalClassNameId =
			socialActivityCounterModelImpl._classNameId;

		socialActivityCounterModelImpl._setOriginalClassNameId = false;

		socialActivityCounterModelImpl._originalClassPK =
			socialActivityCounterModelImpl._classPK;

		socialActivityCounterModelImpl._setOriginalClassPK = false;

		socialActivityCounterModelImpl._originalName =
			socialActivityCounterModelImpl._name;

		socialActivityCounterModelImpl._originalOwnerType =
			socialActivityCounterModelImpl._ownerType;

		socialActivityCounterModelImpl._setOriginalOwnerType = false;

		socialActivityCounterModelImpl._originalStartPeriod =
			socialActivityCounterModelImpl._startPeriod;

		socialActivityCounterModelImpl._setOriginalStartPeriod = false;

		socialActivityCounterModelImpl._originalEndPeriod =
			socialActivityCounterModelImpl._endPeriod;

		socialActivityCounterModelImpl._setOriginalEndPeriod = false;

		socialActivityCounterModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SocialActivityCounter> toCacheModel() {
		SocialActivityCounterCacheModel socialActivityCounterCacheModel =
			new SocialActivityCounterCacheModel();

		socialActivityCounterCacheModel.activityCounterId =
			getActivityCounterId();

		socialActivityCounterCacheModel.groupId = getGroupId();

		socialActivityCounterCacheModel.companyId = getCompanyId();

		socialActivityCounterCacheModel.classNameId = getClassNameId();

		socialActivityCounterCacheModel.classPK = getClassPK();

		socialActivityCounterCacheModel.name = getName();

		String name = socialActivityCounterCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			socialActivityCounterCacheModel.name = null;
		}

		socialActivityCounterCacheModel.ownerType = getOwnerType();

		socialActivityCounterCacheModel.currentValue = getCurrentValue();

		socialActivityCounterCacheModel.totalValue = getTotalValue();

		socialActivityCounterCacheModel.graceValue = getGraceValue();

		socialActivityCounterCacheModel.startPeriod = getStartPeriod();

		socialActivityCounterCacheModel.endPeriod = getEndPeriod();

		socialActivityCounterCacheModel.active = isActive();

		return socialActivityCounterCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SocialActivityCounter, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SocialActivityCounter, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SocialActivityCounter, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((SocialActivityCounter)this));
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
		Map<String, Function<SocialActivityCounter, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SocialActivityCounter, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SocialActivityCounter, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((SocialActivityCounter)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SocialActivityCounter>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _activityCounterId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _name;
	private String _originalName;
	private int _ownerType;
	private int _originalOwnerType;
	private boolean _setOriginalOwnerType;
	private int _currentValue;
	private int _totalValue;
	private int _graceValue;
	private int _startPeriod;
	private int _originalStartPeriod;
	private boolean _setOriginalStartPeriod;
	private int _endPeriod;
	private int _originalEndPeriod;
	private boolean _setOriginalEndPeriod;
	private boolean _active;
	private long _columnBitmask;
	private SocialActivityCounter _escapedModel;

}