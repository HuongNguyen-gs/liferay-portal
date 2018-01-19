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

package com.liferay.message.boards.internal.service;

import com.liferay.message.boards.constants.MBCategoryConstants;
import com.liferay.message.boards.internal.util.MBSubscriptionHelper;
import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.service.MBCategoryLocalService;
import com.liferay.message.boards.service.MBCategoryLocalServiceWrapper;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.subscription.service.SubscriptionLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class SubscriptionMBCategoryLocalServiceWrapper
	extends MBCategoryLocalServiceWrapper {

	public SubscriptionMBCategoryLocalServiceWrapper() {
		super(null);
	}

	public SubscriptionMBCategoryLocalServiceWrapper(
		MBCategoryLocalService mbCategoryLocalService) {

		super(mbCategoryLocalService);
	}

	@Override
	public void deleteCategory(
			MBCategory category, boolean includeTrashedEntries)
		throws PortalException {

		super.deleteCategory(category, includeTrashedEntries);

		_subscriptionLocalService.deleteSubscriptions(
			category.getCompanyId(), MBCategory.class.getName(),
			category.getCategoryId());
	}

	@Override
	public List<MBCategory> getSubscribedCategories(
		long groupId, long userId, int start, int end) {

		List<MBCategory> categories = super.getSubscribedCategories(
			groupId, userId, start, end);

		int count = getSubscribedCategoriesCount(groupId, userId);

		if ((start != QueryUtil.ALL_POS) && (end != QueryUtil.ALL_POS) &&
			((end < count) || ((end - start) == categories.size()))) {

			return categories;
		}

		try {
			return _mbSubscriptionHelper.addSubscribedRootCategory(
				groupId, userId, categories);
		}
		catch (PortalException pe) {
			throw new RuntimeException(pe);
		}
	}

	@Override
	public int getSubscribedCategoriesCount(long groupId, long userId) {
		int count = super.getSubscribedCategoriesCount(groupId, userId);

		try {
			return _mbSubscriptionHelper.addSubscribedRootCategoryCount(
				groupId, userId, count);
		}
		catch (PortalException pe) {
			throw new RuntimeException(pe);
		}
	}

	@Override
	public void subscribeCategory(long userId, long groupId, long categoryId)
		throws PortalException {

		super.subscribeCategory(userId, groupId, categoryId);

		if (categoryId == MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {
			categoryId = groupId;
		}

		_subscriptionLocalService.addSubscription(
			userId, groupId, MBCategory.class.getName(), categoryId);
	}

	@Override
	public void unsubscribeCategory(long userId, long groupId, long categoryId)
		throws PortalException {

		super.unsubscribeCategory(userId, groupId, categoryId);

		if (categoryId == MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {
			categoryId = groupId;
		}

		_subscriptionLocalService.deleteSubscription(
			userId, MBCategory.class.getName(), categoryId);
	}

	@Reference
	private MBSubscriptionHelper _mbSubscriptionHelper;

	@Reference
	private SubscriptionLocalService _subscriptionLocalService;

}