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

package com.liferay.portal.tools.service.builder.test.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.tools.service.builder.test.model.LocalizedEntryLocalization;
import com.liferay.portal.tools.service.builder.test.model.LocalizedEntryLocalizationModel;

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

/**
 * The base model implementation for the LocalizedEntryLocalization service. Represents a row in the &quot;LocalizedEntryLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>LocalizedEntryLocalizationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LocalizedEntryLocalizationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalizedEntryLocalizationImpl
 * @generated
 */
@ProviderType
public class LocalizedEntryLocalizationModelImpl
	extends BaseModelImpl<LocalizedEntryLocalization>
	implements LocalizedEntryLocalizationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a localized entry localization model instance should use the <code>LocalizedEntryLocalization</code> interface instead.
	 */
	public static final String TABLE_NAME = "LocalizedEntryLocalization";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT},
		{"localizedEntryLocalizationId", Types.BIGINT},
		{"localizedEntryId", Types.BIGINT}, {"languageId", Types.VARCHAR},
		{"title", Types.VARCHAR}, {"content", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("localizedEntryLocalizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("localizedEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table LocalizedEntryLocalization (mvccVersion LONG default 0 not null,localizedEntryLocalizationId LONG not null primary key,localizedEntryId LONG,languageId VARCHAR(75) null,title VARCHAR(75) null,content VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table LocalizedEntryLocalization";

	public static final String ORDER_BY_JPQL =
		" ORDER BY localizedEntryLocalization.localizedEntryLocalizationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY LocalizedEntryLocalization.localizedEntryLocalizationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.entity.cache.enabled.com.liferay.portal.tools.service.builder.test.model.LocalizedEntryLocalization"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.finder.cache.enabled.com.liferay.portal.tools.service.builder.test.model.LocalizedEntryLocalization"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.column.bitmask.enabled.com.liferay.portal.tools.service.builder.test.model.LocalizedEntryLocalization"),
		true);

	public static final long LANGUAGEID_COLUMN_BITMASK = 1L;

	public static final long LOCALIZEDENTRYID_COLUMN_BITMASK = 2L;

	public static final long LOCALIZEDENTRYLOCALIZATIONID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.portal.tools.service.builder.test.model.LocalizedEntryLocalization"));

	public LocalizedEntryLocalizationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _localizedEntryLocalizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLocalizedEntryLocalizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _localizedEntryLocalizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LocalizedEntryLocalization.class;
	}

	@Override
	public String getModelClassName() {
		return LocalizedEntryLocalization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LocalizedEntryLocalization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LocalizedEntryLocalization, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LocalizedEntryLocalization, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(LocalizedEntryLocalization)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LocalizedEntryLocalization, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LocalizedEntryLocalization, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LocalizedEntryLocalization)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LocalizedEntryLocalization, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LocalizedEntryLocalization, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, LocalizedEntryLocalization>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			LocalizedEntryLocalization.class.getClassLoader(),
			LocalizedEntryLocalization.class, ModelWrapper.class);

		try {
			Constructor<LocalizedEntryLocalization> constructor =
				(Constructor<LocalizedEntryLocalization>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map
		<String, Function<LocalizedEntryLocalization, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<LocalizedEntryLocalization, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<LocalizedEntryLocalization, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<LocalizedEntryLocalization, Object>>();
		Map<String, BiConsumer<LocalizedEntryLocalization, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<LocalizedEntryLocalization, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion",
			new Function<LocalizedEntryLocalization, Object>() {

				@Override
				public Object apply(
					LocalizedEntryLocalization localizedEntryLocalization) {

					return localizedEntryLocalization.getMvccVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"mvccVersion",
			new BiConsumer<LocalizedEntryLocalization, Object>() {

				@Override
				public void accept(
					LocalizedEntryLocalization localizedEntryLocalization,
					Object mvccVersion) {

					localizedEntryLocalization.setMvccVersion(
						(Long)mvccVersion);
				}

			});
		attributeGetterFunctions.put(
			"localizedEntryLocalizationId",
			new Function<LocalizedEntryLocalization, Object>() {

				@Override
				public Object apply(
					LocalizedEntryLocalization localizedEntryLocalization) {

					return localizedEntryLocalization.
						getLocalizedEntryLocalizationId();
				}

			});
		attributeSetterBiConsumers.put(
			"localizedEntryLocalizationId",
			new BiConsumer<LocalizedEntryLocalization, Object>() {

				@Override
				public void accept(
					LocalizedEntryLocalization localizedEntryLocalization,
					Object localizedEntryLocalizationId) {

					localizedEntryLocalization.setLocalizedEntryLocalizationId(
						(Long)localizedEntryLocalizationId);
				}

			});
		attributeGetterFunctions.put(
			"localizedEntryId",
			new Function<LocalizedEntryLocalization, Object>() {

				@Override
				public Object apply(
					LocalizedEntryLocalization localizedEntryLocalization) {

					return localizedEntryLocalization.getLocalizedEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"localizedEntryId",
			new BiConsumer<LocalizedEntryLocalization, Object>() {

				@Override
				public void accept(
					LocalizedEntryLocalization localizedEntryLocalization,
					Object localizedEntryId) {

					localizedEntryLocalization.setLocalizedEntryId(
						(Long)localizedEntryId);
				}

			});
		attributeGetterFunctions.put(
			"languageId",
			new Function<LocalizedEntryLocalization, Object>() {

				@Override
				public Object apply(
					LocalizedEntryLocalization localizedEntryLocalization) {

					return localizedEntryLocalization.getLanguageId();
				}

			});
		attributeSetterBiConsumers.put(
			"languageId",
			new BiConsumer<LocalizedEntryLocalization, Object>() {

				@Override
				public void accept(
					LocalizedEntryLocalization localizedEntryLocalization,
					Object languageId) {

					localizedEntryLocalization.setLanguageId(
						(String)languageId);
				}

			});
		attributeGetterFunctions.put(
			"title",
			new Function<LocalizedEntryLocalization, Object>() {

				@Override
				public Object apply(
					LocalizedEntryLocalization localizedEntryLocalization) {

					return localizedEntryLocalization.getTitle();
				}

			});
		attributeSetterBiConsumers.put(
			"title",
			new BiConsumer<LocalizedEntryLocalization, Object>() {

				@Override
				public void accept(
					LocalizedEntryLocalization localizedEntryLocalization,
					Object title) {

					localizedEntryLocalization.setTitle((String)title);
				}

			});
		attributeGetterFunctions.put(
			"content",
			new Function<LocalizedEntryLocalization, Object>() {

				@Override
				public Object apply(
					LocalizedEntryLocalization localizedEntryLocalization) {

					return localizedEntryLocalization.getContent();
				}

			});
		attributeSetterBiConsumers.put(
			"content",
			new BiConsumer<LocalizedEntryLocalization, Object>() {

				@Override
				public void accept(
					LocalizedEntryLocalization localizedEntryLocalization,
					Object content) {

					localizedEntryLocalization.setContent((String)content);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getLocalizedEntryLocalizationId() {
		return _localizedEntryLocalizationId;
	}

	@Override
	public void setLocalizedEntryLocalizationId(
		long localizedEntryLocalizationId) {

		_localizedEntryLocalizationId = localizedEntryLocalizationId;
	}

	@Override
	public long getLocalizedEntryId() {
		return _localizedEntryId;
	}

	@Override
	public void setLocalizedEntryId(long localizedEntryId) {
		_columnBitmask |= LOCALIZEDENTRYID_COLUMN_BITMASK;

		if (!_setOriginalLocalizedEntryId) {
			_setOriginalLocalizedEntryId = true;

			_originalLocalizedEntryId = _localizedEntryId;
		}

		_localizedEntryId = localizedEntryId;
	}

	public long getOriginalLocalizedEntryId() {
		return _originalLocalizedEntryId;
	}

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
		_columnBitmask |= LANGUAGEID_COLUMN_BITMASK;

		if (_originalLanguageId == null) {
			_originalLanguageId = _languageId;
		}

		_languageId = languageId;
	}

	public String getOriginalLanguageId() {
		return GetterUtil.getString(_originalLanguageId);
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, LocalizedEntryLocalization.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LocalizedEntryLocalization toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, LocalizedEntryLocalization>
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
		LocalizedEntryLocalizationImpl localizedEntryLocalizationImpl =
			new LocalizedEntryLocalizationImpl();

		localizedEntryLocalizationImpl.setMvccVersion(getMvccVersion());
		localizedEntryLocalizationImpl.setLocalizedEntryLocalizationId(
			getLocalizedEntryLocalizationId());
		localizedEntryLocalizationImpl.setLocalizedEntryId(
			getLocalizedEntryId());
		localizedEntryLocalizationImpl.setLanguageId(getLanguageId());
		localizedEntryLocalizationImpl.setTitle(getTitle());
		localizedEntryLocalizationImpl.setContent(getContent());

		localizedEntryLocalizationImpl.resetOriginalValues();

		return localizedEntryLocalizationImpl;
	}

	@Override
	public int compareTo(
		LocalizedEntryLocalization localizedEntryLocalization) {

		long primaryKey = localizedEntryLocalization.getPrimaryKey();

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

		if (!(obj instanceof LocalizedEntryLocalization)) {
			return false;
		}

		LocalizedEntryLocalization localizedEntryLocalization =
			(LocalizedEntryLocalization)obj;

		long primaryKey = localizedEntryLocalization.getPrimaryKey();

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
		LocalizedEntryLocalizationModelImpl
			localizedEntryLocalizationModelImpl = this;

		localizedEntryLocalizationModelImpl._originalLocalizedEntryId =
			localizedEntryLocalizationModelImpl._localizedEntryId;

		localizedEntryLocalizationModelImpl._setOriginalLocalizedEntryId =
			false;

		localizedEntryLocalizationModelImpl._originalLanguageId =
			localizedEntryLocalizationModelImpl._languageId;

		localizedEntryLocalizationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LocalizedEntryLocalization> toCacheModel() {
		LocalizedEntryLocalizationCacheModel
			localizedEntryLocalizationCacheModel =
				new LocalizedEntryLocalizationCacheModel();

		localizedEntryLocalizationCacheModel.mvccVersion = getMvccVersion();

		localizedEntryLocalizationCacheModel.localizedEntryLocalizationId =
			getLocalizedEntryLocalizationId();

		localizedEntryLocalizationCacheModel.localizedEntryId =
			getLocalizedEntryId();

		localizedEntryLocalizationCacheModel.languageId = getLanguageId();

		String languageId = localizedEntryLocalizationCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			localizedEntryLocalizationCacheModel.languageId = null;
		}

		localizedEntryLocalizationCacheModel.title = getTitle();

		String title = localizedEntryLocalizationCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			localizedEntryLocalizationCacheModel.title = null;
		}

		localizedEntryLocalizationCacheModel.content = getContent();

		String content = localizedEntryLocalizationCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			localizedEntryLocalizationCacheModel.content = null;
		}

		return localizedEntryLocalizationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LocalizedEntryLocalization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<LocalizedEntryLocalization, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LocalizedEntryLocalization, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(LocalizedEntryLocalization)this));
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
		Map<String, Function<LocalizedEntryLocalization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<LocalizedEntryLocalization, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LocalizedEntryLocalization, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(LocalizedEntryLocalization)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, LocalizedEntryLocalization>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _localizedEntryLocalizationId;
	private long _localizedEntryId;
	private long _originalLocalizedEntryId;
	private boolean _setOriginalLocalizedEntryId;
	private String _languageId;
	private String _originalLanguageId;
	private String _title;
	private String _content;
	private long _columnBitmask;
	private LocalizedEntryLocalization _escapedModel;

}