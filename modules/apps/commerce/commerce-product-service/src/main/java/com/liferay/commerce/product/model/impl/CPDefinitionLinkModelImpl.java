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

package com.liferay.commerce.product.model.impl;

import com.liferay.commerce.product.model.CPDefinitionLink;
import com.liferay.commerce.product.model.CPDefinitionLinkModel;
import com.liferay.commerce.product.model.CPDefinitionLinkSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CPDefinitionLink service. Represents a row in the &quot;CPDefinitionLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CPDefinitionLinkModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDefinitionLinkImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDefinitionLinkImpl
 * @generated
 */
@JSON(strict = true)
public class CPDefinitionLinkModelImpl
	extends BaseModelImpl<CPDefinitionLink> implements CPDefinitionLinkModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp definition link model instance should use the <code>CPDefinitionLink</code> interface instead.
	 */
	public static final String TABLE_NAME = "CPDefinitionLink";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"CPDefinitionLinkId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"CPDefinitionId", Types.BIGINT},
		{"CProductId", Types.BIGINT}, {"priority", Types.DOUBLE},
		{"type_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPDefinitionLinkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("CPDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CPDefinitionLink (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,CPDefinitionLinkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,CPDefinitionId LONG,CProductId LONG,priority DOUBLE,type_ VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table CPDefinitionLink";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cpDefinitionLink.priority ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CPDefinitionLink.priority ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CPDEFINITIONID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CPRODUCTID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TYPE_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PRIORITY_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CPDefinitionLink toModel(CPDefinitionLinkSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CPDefinitionLink model = new CPDefinitionLinkImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setCPDefinitionLinkId(soapModel.getCPDefinitionLinkId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCPDefinitionId(soapModel.getCPDefinitionId());
		model.setCProductId(soapModel.getCProductId());
		model.setPriority(soapModel.getPriority());
		model.setType(soapModel.getType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<CPDefinitionLink> toModels(
		CPDefinitionLinkSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CPDefinitionLink> models = new ArrayList<CPDefinitionLink>(
			soapModels.length);

		for (CPDefinitionLinkSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.product.model.CPDefinitionLink"));

	public CPDefinitionLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPDefinitionLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPDefinitionLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPDefinitionLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDefinitionLink.class;
	}

	@Override
	public String getModelClassName() {
		return CPDefinitionLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CPDefinitionLink, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CPDefinitionLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDefinitionLink, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CPDefinitionLink)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CPDefinitionLink, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CPDefinitionLink, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CPDefinitionLink)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CPDefinitionLink, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CPDefinitionLink, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CPDefinitionLink>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CPDefinitionLink.class.getClassLoader(), CPDefinitionLink.class,
			ModelWrapper.class);

		try {
			Constructor<CPDefinitionLink> constructor =
				(Constructor<CPDefinitionLink>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CPDefinitionLink, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CPDefinitionLink, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CPDefinitionLink, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CPDefinitionLink, Object>>();
		Map<String, BiConsumer<CPDefinitionLink, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CPDefinitionLink, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", CPDefinitionLink::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CPDefinitionLink, Long>)
				CPDefinitionLink::setMvccVersion);
		attributeGetterFunctions.put("uuid", CPDefinitionLink::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CPDefinitionLink, String>)CPDefinitionLink::setUuid);
		attributeGetterFunctions.put(
			"CPDefinitionLinkId", CPDefinitionLink::getCPDefinitionLinkId);
		attributeSetterBiConsumers.put(
			"CPDefinitionLinkId",
			(BiConsumer<CPDefinitionLink, Long>)
				CPDefinitionLink::setCPDefinitionLinkId);
		attributeGetterFunctions.put("groupId", CPDefinitionLink::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CPDefinitionLink, Long>)CPDefinitionLink::setGroupId);
		attributeGetterFunctions.put(
			"companyId", CPDefinitionLink::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CPDefinitionLink, Long>)CPDefinitionLink::setCompanyId);
		attributeGetterFunctions.put("userId", CPDefinitionLink::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CPDefinitionLink, Long>)CPDefinitionLink::setUserId);
		attributeGetterFunctions.put("userName", CPDefinitionLink::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CPDefinitionLink, String>)
				CPDefinitionLink::setUserName);
		attributeGetterFunctions.put(
			"createDate", CPDefinitionLink::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CPDefinitionLink, Date>)
				CPDefinitionLink::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CPDefinitionLink::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CPDefinitionLink, Date>)
				CPDefinitionLink::setModifiedDate);
		attributeGetterFunctions.put(
			"CPDefinitionId", CPDefinitionLink::getCPDefinitionId);
		attributeSetterBiConsumers.put(
			"CPDefinitionId",
			(BiConsumer<CPDefinitionLink, Long>)
				CPDefinitionLink::setCPDefinitionId);
		attributeGetterFunctions.put(
			"CProductId", CPDefinitionLink::getCProductId);
		attributeSetterBiConsumers.put(
			"CProductId",
			(BiConsumer<CPDefinitionLink, Long>)
				CPDefinitionLink::setCProductId);
		attributeGetterFunctions.put("priority", CPDefinitionLink::getPriority);
		attributeSetterBiConsumers.put(
			"priority",
			(BiConsumer<CPDefinitionLink, Double>)
				CPDefinitionLink::setPriority);
		attributeGetterFunctions.put("type", CPDefinitionLink::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<CPDefinitionLink, String>)CPDefinitionLink::setType);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getCPDefinitionLinkId() {
		return _CPDefinitionLinkId;
	}

	@Override
	public void setCPDefinitionLinkId(long CPDefinitionLinkId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_CPDefinitionLinkId = CPDefinitionLinkId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCPDefinitionId() {
		return _CPDefinitionId;
	}

	@Override
	public void setCPDefinitionId(long CPDefinitionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_CPDefinitionId = CPDefinitionId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCPDefinitionId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("CPDefinitionId"));
	}

	@JSON
	@Override
	public long getCProductId() {
		return _CProductId;
	}

	@Override
	public void setCProductId(long CProductId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_CProductId = CProductId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCProductId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("CProductId"));
	}

	@JSON
	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_priority = priority;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalType() {
		return getColumnOriginalValue("type_");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CPDefinitionLink.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CPDefinitionLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPDefinitionLink toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CPDefinitionLink>
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
		CPDefinitionLinkImpl cpDefinitionLinkImpl = new CPDefinitionLinkImpl();

		cpDefinitionLinkImpl.setMvccVersion(getMvccVersion());
		cpDefinitionLinkImpl.setUuid(getUuid());
		cpDefinitionLinkImpl.setCPDefinitionLinkId(getCPDefinitionLinkId());
		cpDefinitionLinkImpl.setGroupId(getGroupId());
		cpDefinitionLinkImpl.setCompanyId(getCompanyId());
		cpDefinitionLinkImpl.setUserId(getUserId());
		cpDefinitionLinkImpl.setUserName(getUserName());
		cpDefinitionLinkImpl.setCreateDate(getCreateDate());
		cpDefinitionLinkImpl.setModifiedDate(getModifiedDate());
		cpDefinitionLinkImpl.setCPDefinitionId(getCPDefinitionId());
		cpDefinitionLinkImpl.setCProductId(getCProductId());
		cpDefinitionLinkImpl.setPriority(getPriority());
		cpDefinitionLinkImpl.setType(getType());

		cpDefinitionLinkImpl.resetOriginalValues();

		return cpDefinitionLinkImpl;
	}

	@Override
	public CPDefinitionLink cloneWithOriginalValues() {
		CPDefinitionLinkImpl cpDefinitionLinkImpl = new CPDefinitionLinkImpl();

		cpDefinitionLinkImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		cpDefinitionLinkImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		cpDefinitionLinkImpl.setCPDefinitionLinkId(
			this.<Long>getColumnOriginalValue("CPDefinitionLinkId"));
		cpDefinitionLinkImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		cpDefinitionLinkImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		cpDefinitionLinkImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		cpDefinitionLinkImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		cpDefinitionLinkImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		cpDefinitionLinkImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		cpDefinitionLinkImpl.setCPDefinitionId(
			this.<Long>getColumnOriginalValue("CPDefinitionId"));
		cpDefinitionLinkImpl.setCProductId(
			this.<Long>getColumnOriginalValue("CProductId"));
		cpDefinitionLinkImpl.setPriority(
			this.<Double>getColumnOriginalValue("priority"));
		cpDefinitionLinkImpl.setType(
			this.<String>getColumnOriginalValue("type_"));

		return cpDefinitionLinkImpl;
	}

	@Override
	public int compareTo(CPDefinitionLink cpDefinitionLink) {
		int value = 0;

		if (getPriority() < cpDefinitionLink.getPriority()) {
			value = -1;
		}
		else if (getPriority() > cpDefinitionLink.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CPDefinitionLink)) {
			return false;
		}

		CPDefinitionLink cpDefinitionLink = (CPDefinitionLink)object;

		long primaryKey = cpDefinitionLink.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CPDefinitionLink> toCacheModel() {
		CPDefinitionLinkCacheModel cpDefinitionLinkCacheModel =
			new CPDefinitionLinkCacheModel();

		cpDefinitionLinkCacheModel.mvccVersion = getMvccVersion();

		cpDefinitionLinkCacheModel.uuid = getUuid();

		String uuid = cpDefinitionLinkCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cpDefinitionLinkCacheModel.uuid = null;
		}

		cpDefinitionLinkCacheModel.CPDefinitionLinkId = getCPDefinitionLinkId();

		cpDefinitionLinkCacheModel.groupId = getGroupId();

		cpDefinitionLinkCacheModel.companyId = getCompanyId();

		cpDefinitionLinkCacheModel.userId = getUserId();

		cpDefinitionLinkCacheModel.userName = getUserName();

		String userName = cpDefinitionLinkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpDefinitionLinkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpDefinitionLinkCacheModel.createDate = createDate.getTime();
		}
		else {
			cpDefinitionLinkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpDefinitionLinkCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cpDefinitionLinkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpDefinitionLinkCacheModel.CPDefinitionId = getCPDefinitionId();

		cpDefinitionLinkCacheModel.CProductId = getCProductId();

		cpDefinitionLinkCacheModel.priority = getPriority();

		cpDefinitionLinkCacheModel.type = getType();

		String type = cpDefinitionLinkCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			cpDefinitionLinkCacheModel.type = null;
		}

		return cpDefinitionLinkCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CPDefinitionLink, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CPDefinitionLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDefinitionLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(CPDefinitionLink)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

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
		Map<String, Function<CPDefinitionLink, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CPDefinitionLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDefinitionLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CPDefinitionLink)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CPDefinitionLink>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private String _uuid;
	private long _CPDefinitionLinkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _CPDefinitionId;
	private long _CProductId;
	private double _priority;
	private String _type;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CPDefinitionLink, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CPDefinitionLink)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("CPDefinitionLinkId", _CPDefinitionLinkId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("CPDefinitionId", _CPDefinitionId);
		_columnOriginalValues.put("CProductId", _CProductId);
		_columnOriginalValues.put("priority", _priority);
		_columnOriginalValues.put("type_", _type);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("type_", "type");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("uuid_", 2L);

		columnBitmasks.put("CPDefinitionLinkId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("CPDefinitionId", 512L);

		columnBitmasks.put("CProductId", 1024L);

		columnBitmasks.put("priority", 2048L);

		columnBitmasks.put("type_", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CPDefinitionLink _escapedModel;

}