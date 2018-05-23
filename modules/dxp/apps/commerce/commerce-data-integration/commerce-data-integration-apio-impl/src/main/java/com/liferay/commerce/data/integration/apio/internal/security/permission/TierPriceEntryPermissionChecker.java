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

package com.liferay.commerce.data.integration.apio.internal.security.permission;

import com.liferay.apio.architect.credentials.Credentials;
import com.liferay.apio.architect.functional.Try;
import com.liferay.commerce.data.integration.apio.security.permission.CollectionPermissionChecker;
import com.liferay.commerce.price.list.constants.CommercePriceListActionKeys;
import com.liferay.commerce.price.list.model.CommercePriceEntry;
import com.liferay.commerce.price.list.model.CommerceTierPriceEntry;
import com.liferay.commerce.price.list.service.CommercePriceEntryService;
import com.liferay.commerce.price.list.service.CommerceTierPriceEntryService;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.UserService;

import java.util.function.BiFunction;

import javax.ws.rs.NotFoundException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Zoltán Takács
 */
@Component(immediate = true, service = TierPriceEntryPermissionChecker.class)
public class TierPriceEntryPermissionChecker
	implements CollectionPermissionChecker {

	@Override
	public BiFunction<Credentials, Long, Boolean> forAdding() {
		return (credentials, commercePriceEntryId) -> {
			Try<PermissionChecker> permissionCheckerTry =
				_getPermissionCheckerTry(credentials);

			Try<CommercePriceEntry> commercePriceEntryTry = Try.fromFallible(
				() -> _commercePriceEntryService.fetchCommercePriceEntry(
					commercePriceEntryId));

			return permissionCheckerTry.map(
				permissionChecker -> _portletResourcePermission.contains(
					permissionChecker,
					commercePriceEntryTry.map(
						CommercePriceEntry::getGroupId
					).orElseThrow(
						() -> new NotFoundException()
					),
					CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS)
			).orElse(
				false
			);
		};
	}

	@Override
	public BiFunction<Credentials, Long, Boolean> forDeleting() {
		return _permissionBridge();
	}

	@Override
	public BiFunction<Credentials, Long, Boolean> forUpdating() {
		return (credentials, identifier) -> {
			Try<PermissionChecker> permissionCheckerTry =
				_getPermissionCheckerTry(credentials);

			CommerceTierPriceEntry commerceTierPriceEntry =
				_commerceTierPriceEntryService.fetchCommerceTierPriceEntry(
					identifier);

			return permissionCheckerTry.map(
				permissionChecker -> _portletResourcePermission.contains(
					permissionChecker, commerceTierPriceEntry.getGroupId(),
					CommercePriceListActionKeys.MANAGE_COMMERCE_PRICE_LISTS)
			).orElse(
				false
			);
		};
	}

	private Try<PermissionChecker> _getPermissionCheckerTry(
		Credentials credentials) {

		return Try.success(
			credentials.get()
		).map(
			Long::valueOf
		).map(
			_userService::getUserById
		).map(
			PermissionCheckerFactoryUtil::create
		).recoverWith(
			__ -> Try.fromFallible(PermissionThreadLocal::getPermissionChecker)
		);
	}

	private BiFunction<Credentials, Long, Boolean> _permissionBridge() {
		return forUpdating();
	}

	@Reference
	private CommercePriceEntryService _commercePriceEntryService;

	@Reference
	private CommerceTierPriceEntryService _commerceTierPriceEntryService;

	@Reference(target = "(resource.name=com.liferay.commerce.price.list)")
	private PortletResourcePermission _portletResourcePermission;

	@Reference
	private UserService _userService;

}