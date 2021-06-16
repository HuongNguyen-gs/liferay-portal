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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.tools.service.builder.test.model.CacheMissEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CacheMissEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CacheMissEntryCacheModel
	implements CacheModel<CacheMissEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CacheMissEntryCacheModel)) {
			return false;
		}

		CacheMissEntryCacheModel cacheMissEntryCacheModel =
			(CacheMissEntryCacheModel)object;

		if (cacheMissEntryId == cacheMissEntryCacheModel.cacheMissEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cacheMissEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{cacheMissEntryId=");
		sb.append(cacheMissEntryId);

		return sb.toString();
	}

	@Override
	public CacheMissEntry toEntityModel() {
		CacheMissEntryImpl cacheMissEntryImpl = new CacheMissEntryImpl();

		cacheMissEntryImpl.setCacheMissEntryId(cacheMissEntryId);

		cacheMissEntryImpl.resetOriginalValues();

		return cacheMissEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cacheMissEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(cacheMissEntryId);
	}

	public long cacheMissEntryId;

}