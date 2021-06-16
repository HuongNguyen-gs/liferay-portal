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

package com.liferay.portal.tools.service.builder.test.service.persistence.impl.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import com.liferay.portal.tools.service.builder.test.model.CacheMissEntry;
import com.liferay.portal.tools.service.builder.test.service.persistence.CacheMissEntryPersistence;
import com.liferay.portal.tools.service.builder.test.service.persistence.CacheMissEntryUtil;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Minhchau Dang
 */
@RunWith(Arquillian.class)
public class CacheMissPersistenceImplTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.liferay.portal.tools.service.builder.test.service"));

	@Before
	public void setUp() {
		_persistence = CacheMissEntryUtil.getPersistence();
	}

	@Test
	public void testCacheMiss() throws Throwable {
		Set<Serializable> primaryKeys = new HashSet<>();

		for (long pk = -1; pk > -2000; pk--) {
			primaryKeys.add(pk);
		}

		Map<Serializable, CacheMissEntry> cacheMissEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cacheMissEntries.isEmpty());
	}

	private CacheMissEntryPersistence _persistence;

}