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

package com.liferay.portal.tools.service.builder.test.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CacheMissEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CacheMissEntry
 * @generated
 */
public class CacheMissEntryWrapper
	extends BaseModelWrapper<CacheMissEntry>
	implements CacheMissEntry, ModelWrapper<CacheMissEntry> {

	public CacheMissEntryWrapper(CacheMissEntry cacheMissEntry) {
		super(cacheMissEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cacheMissEntryId", getCacheMissEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cacheMissEntryId = (Long)attributes.get("cacheMissEntryId");

		if (cacheMissEntryId != null) {
			setCacheMissEntryId(cacheMissEntryId);
		}
	}

	/**
	 * Returns the cache miss entry ID of this cache miss entry.
	 *
	 * @return the cache miss entry ID of this cache miss entry
	 */
	@Override
	public long getCacheMissEntryId() {
		return model.getCacheMissEntryId();
	}

	/**
	 * Returns the primary key of this cache miss entry.
	 *
	 * @return the primary key of this cache miss entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cache miss entry ID of this cache miss entry.
	 *
	 * @param cacheMissEntryId the cache miss entry ID of this cache miss entry
	 */
	@Override
	public void setCacheMissEntryId(long cacheMissEntryId) {
		model.setCacheMissEntryId(cacheMissEntryId);
	}

	/**
	 * Sets the primary key of this cache miss entry.
	 *
	 * @param primaryKey the primary key of this cache miss entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CacheMissEntryWrapper wrap(CacheMissEntry cacheMissEntry) {
		return new CacheMissEntryWrapper(cacheMissEntry);
	}

}