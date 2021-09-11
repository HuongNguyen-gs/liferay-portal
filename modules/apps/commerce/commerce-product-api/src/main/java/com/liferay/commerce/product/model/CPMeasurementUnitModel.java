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

package com.liferay.commerce.product.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CPMeasurementUnit service. Represents a row in the &quot;CPMeasurementUnit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.product.model.impl.CPMeasurementUnitModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.product.model.impl.CPMeasurementUnitImpl</code>.
 * </p>
 *
 * @author Marco Leo
 * @see CPMeasurementUnit
 * @generated
 */
@ProviderType
public interface CPMeasurementUnitModel
	extends BaseModel<CPMeasurementUnit>, LocalizedModel, MVCCModel,
			ShardedModel, StagedGroupedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cp measurement unit model instance should use the {@link CPMeasurementUnit} interface instead.
	 */

	/**
	 * Returns the primary key of this cp measurement unit.
	 *
	 * @return the primary key of this cp measurement unit
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cp measurement unit.
	 *
	 * @param primaryKey the primary key of this cp measurement unit
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this cp measurement unit.
	 *
	 * @return the mvcc version of this cp measurement unit
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this cp measurement unit.
	 *
	 * @param mvccVersion the mvcc version of this cp measurement unit
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this cp measurement unit.
	 *
	 * @return the uuid of this cp measurement unit
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this cp measurement unit.
	 *
	 * @param uuid the uuid of this cp measurement unit
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the cp measurement unit ID of this cp measurement unit.
	 *
	 * @return the cp measurement unit ID of this cp measurement unit
	 */
	public long getCPMeasurementUnitId();

	/**
	 * Sets the cp measurement unit ID of this cp measurement unit.
	 *
	 * @param CPMeasurementUnitId the cp measurement unit ID of this cp measurement unit
	 */
	public void setCPMeasurementUnitId(long CPMeasurementUnitId);

	/**
	 * Returns the group ID of this cp measurement unit.
	 *
	 * @return the group ID of this cp measurement unit
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this cp measurement unit.
	 *
	 * @param groupId the group ID of this cp measurement unit
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this cp measurement unit.
	 *
	 * @return the company ID of this cp measurement unit
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cp measurement unit.
	 *
	 * @param companyId the company ID of this cp measurement unit
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this cp measurement unit.
	 *
	 * @return the user ID of this cp measurement unit
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this cp measurement unit.
	 *
	 * @param userId the user ID of this cp measurement unit
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cp measurement unit.
	 *
	 * @return the user uuid of this cp measurement unit
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this cp measurement unit.
	 *
	 * @param userUuid the user uuid of this cp measurement unit
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this cp measurement unit.
	 *
	 * @return the user name of this cp measurement unit
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this cp measurement unit.
	 *
	 * @param userName the user name of this cp measurement unit
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this cp measurement unit.
	 *
	 * @return the create date of this cp measurement unit
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this cp measurement unit.
	 *
	 * @param createDate the create date of this cp measurement unit
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this cp measurement unit.
	 *
	 * @return the modified date of this cp measurement unit
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cp measurement unit.
	 *
	 * @param modifiedDate the modified date of this cp measurement unit
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this cp measurement unit.
	 *
	 * @return the name of this cp measurement unit
	 */
	public String getName();

	/**
	 * Returns the localized name of this cp measurement unit in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this cp measurement unit
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this cp measurement unit in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this cp measurement unit. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this cp measurement unit in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this cp measurement unit
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this cp measurement unit in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this cp measurement unit
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this cp measurement unit.
	 *
	 * @return the locales and localized names of this cp measurement unit
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this cp measurement unit.
	 *
	 * @param name the name of this cp measurement unit
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this cp measurement unit in the language.
	 *
	 * @param name the localized name of this cp measurement unit
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this cp measurement unit in the language, and sets the default locale.
	 *
	 * @param name the localized name of this cp measurement unit
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this cp measurement unit from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this cp measurement unit
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this cp measurement unit from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this cp measurement unit
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the key of this cp measurement unit.
	 *
	 * @return the key of this cp measurement unit
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this cp measurement unit.
	 *
	 * @param key the key of this cp measurement unit
	 */
	public void setKey(String key);

	/**
	 * Returns the rate of this cp measurement unit.
	 *
	 * @return the rate of this cp measurement unit
	 */
	public double getRate();

	/**
	 * Sets the rate of this cp measurement unit.
	 *
	 * @param rate the rate of this cp measurement unit
	 */
	public void setRate(double rate);

	/**
	 * Returns the primary of this cp measurement unit.
	 *
	 * @return the primary of this cp measurement unit
	 */
	public boolean getPrimary();

	/**
	 * Returns <code>true</code> if this cp measurement unit is primary.
	 *
	 * @return <code>true</code> if this cp measurement unit is primary; <code>false</code> otherwise
	 */
	public boolean isPrimary();

	/**
	 * Sets whether this cp measurement unit is primary.
	 *
	 * @param primary the primary of this cp measurement unit
	 */
	public void setPrimary(boolean primary);

	/**
	 * Returns the priority of this cp measurement unit.
	 *
	 * @return the priority of this cp measurement unit
	 */
	public double getPriority();

	/**
	 * Sets the priority of this cp measurement unit.
	 *
	 * @param priority the priority of this cp measurement unit
	 */
	public void setPriority(double priority);

	/**
	 * Returns the type of this cp measurement unit.
	 *
	 * @return the type of this cp measurement unit
	 */
	public int getType();

	/**
	 * Sets the type of this cp measurement unit.
	 *
	 * @param type the type of this cp measurement unit
	 */
	public void setType(int type);

	/**
	 * Returns the last publish date of this cp measurement unit.
	 *
	 * @return the last publish date of this cp measurement unit
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this cp measurement unit.
	 *
	 * @param lastPublishDate the last publish date of this cp measurement unit
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public CPMeasurementUnit cloneWithOriginalValues();

}