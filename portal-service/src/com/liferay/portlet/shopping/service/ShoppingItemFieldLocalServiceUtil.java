/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.shopping.service;


/**
 * <a href="ShoppingItemFieldLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.shopping.service.ShoppingItemFieldLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.shopping.service.ShoppingItemFieldLocalService
 *
 */
public class ShoppingItemFieldLocalServiceUtil {
	public static com.liferay.portlet.shopping.model.ShoppingItemField addShoppingItemField(
		com.liferay.portlet.shopping.model.ShoppingItemField shoppingItemField)
		throws com.liferay.portal.SystemException {
		return _service.addShoppingItemField(shoppingItemField);
	}

	public static void deleteShoppingItemField(long itemFieldId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteShoppingItemField(itemFieldId);
	}

	public static void deleteShoppingItemField(
		com.liferay.portlet.shopping.model.ShoppingItemField shoppingItemField)
		throws com.liferay.portal.SystemException {
		_service.deleteShoppingItemField(shoppingItemField);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return _service.dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return _service.dynamicQuery(dynamicQuery, start, end);
	}

	public static com.liferay.portlet.shopping.model.ShoppingItemField getShoppingItemField(
		long itemFieldId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getShoppingItemField(itemFieldId);
	}

	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingItemField> getShoppingItemFields(
		int start, int end) throws com.liferay.portal.SystemException {
		return _service.getShoppingItemFields(start, end);
	}

	public static int getShoppingItemFieldsCount()
		throws com.liferay.portal.SystemException {
		return _service.getShoppingItemFieldsCount();
	}

	public static com.liferay.portlet.shopping.model.ShoppingItemField updateShoppingItemField(
		com.liferay.portlet.shopping.model.ShoppingItemField shoppingItemField)
		throws com.liferay.portal.SystemException {
		return _service.updateShoppingItemField(shoppingItemField);
	}

	public static java.util.List<com.liferay.portlet.shopping.model.ShoppingItemField> getItemFields(
		long itemId) throws com.liferay.portal.SystemException {
		return _service.getItemFields(itemId);
	}

	public static ShoppingItemFieldLocalService getService() {
		return _service;
	}

	public void setService(ShoppingItemFieldLocalService service) {
		_service = service;
	}

	private static ShoppingItemFieldLocalService _service;
}