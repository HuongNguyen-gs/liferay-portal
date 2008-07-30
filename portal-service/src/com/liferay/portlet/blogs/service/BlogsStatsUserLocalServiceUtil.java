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

package com.liferay.portlet.blogs.service;


/**
 * <a href="BlogsStatsUserLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.blogs.service.BlogsStatsUserLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.blogs.service.BlogsStatsUserLocalService
 *
 */
public class BlogsStatsUserLocalServiceUtil {
	public static com.liferay.portlet.blogs.model.BlogsStatsUser addBlogsStatsUser(
		com.liferay.portlet.blogs.model.BlogsStatsUser blogsStatsUser)
		throws com.liferay.portal.SystemException {
		return _service.addBlogsStatsUser(blogsStatsUser);
	}

	public static void deleteBlogsStatsUser(long statsUserId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteBlogsStatsUser(statsUserId);
	}

	public static void deleteBlogsStatsUser(
		com.liferay.portlet.blogs.model.BlogsStatsUser blogsStatsUser)
		throws com.liferay.portal.SystemException {
		_service.deleteBlogsStatsUser(blogsStatsUser);
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

	public static com.liferay.portlet.blogs.model.BlogsStatsUser getBlogsStatsUser(
		long statsUserId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getBlogsStatsUser(statsUserId);
	}

	public static java.util.List<com.liferay.portlet.blogs.model.BlogsStatsUser> getBlogsStatsUsers(
		int start, int end) throws com.liferay.portal.SystemException {
		return _service.getBlogsStatsUsers(start, end);
	}

	public static int getBlogsStatsUsersCount()
		throws com.liferay.portal.SystemException {
		return _service.getBlogsStatsUsersCount();
	}

	public static com.liferay.portlet.blogs.model.BlogsStatsUser updateBlogsStatsUser(
		com.liferay.portlet.blogs.model.BlogsStatsUser blogsStatsUser)
		throws com.liferay.portal.SystemException {
		return _service.updateBlogsStatsUser(blogsStatsUser);
	}

	public static void deleteStatsUserByGroupId(long groupId)
		throws com.liferay.portal.SystemException {
		_service.deleteStatsUserByGroupId(groupId);
	}

	public static void deleteStatsUserByUserId(long userId)
		throws com.liferay.portal.SystemException {
		_service.deleteStatsUserByUserId(userId);
	}

	public static java.util.List<com.liferay.portlet.blogs.model.BlogsStatsUser> getCompanyStatsUsers(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return _service.getCompanyStatsUsers(companyId, start, end, obc);
	}

	public static int getCompanyStatsUsersCount(long companyId)
		throws com.liferay.portal.SystemException {
		return _service.getCompanyStatsUsersCount(companyId);
	}

	public static java.util.List<com.liferay.portlet.blogs.model.BlogsStatsUser> getGroupStatsUsers(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return _service.getGroupStatsUsers(groupId, start, end, obc);
	}

	public static int getGroupStatsUsersCount(long groupId)
		throws com.liferay.portal.SystemException {
		return _service.getGroupStatsUsersCount(groupId);
	}

	public static java.util.List<com.liferay.portlet.blogs.model.BlogsStatsUser> getOrganizationStatsUsers(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return _service.getOrganizationStatsUsers(organizationId, start, end,
			obc);
	}

	public static int getOrganizationStatsUsersCount(long organizationId)
		throws com.liferay.portal.SystemException {
		return _service.getOrganizationStatsUsersCount(organizationId);
	}

	public static com.liferay.portlet.blogs.model.BlogsStatsUser getStatsUser(
		long groupId, long userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getStatsUser(groupId, userId);
	}

	public static void updateStatsUser(long groupId, long userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.updateStatsUser(groupId, userId);
	}

	public static void updateStatsUser(long groupId, long userId,
		java.util.Date displayDate)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.updateStatsUser(groupId, userId, displayDate);
	}

	public static BlogsStatsUserLocalService getService() {
		return _service;
	}

	public void setService(BlogsStatsUserLocalService service) {
		_service = service;
	}

	private static BlogsStatsUserLocalService _service;
}