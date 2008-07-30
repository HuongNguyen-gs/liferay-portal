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

package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBBanLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBBanLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBBanLocalService
 *
 */
public class MBBanLocalServiceUtil {
	public static com.liferay.portlet.messageboards.model.MBBan addMBBan(
		com.liferay.portlet.messageboards.model.MBBan mbBan)
		throws com.liferay.portal.SystemException {
		return _service.addMBBan(mbBan);
	}

	public static void deleteMBBan(long banId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteMBBan(banId);
	}

	public static void deleteMBBan(
		com.liferay.portlet.messageboards.model.MBBan mbBan)
		throws com.liferay.portal.SystemException {
		_service.deleteMBBan(mbBan);
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

	public static com.liferay.portlet.messageboards.model.MBBan getMBBan(
		long banId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getMBBan(banId);
	}

	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> getMBBans(
		int start, int end) throws com.liferay.portal.SystemException {
		return _service.getMBBans(start, end);
	}

	public static int getMBBansCount()
		throws com.liferay.portal.SystemException {
		return _service.getMBBansCount();
	}

	public static com.liferay.portlet.messageboards.model.MBBan updateMBBan(
		com.liferay.portlet.messageboards.model.MBBan mbBan)
		throws com.liferay.portal.SystemException {
		return _service.updateMBBan(mbBan);
	}

	public static com.liferay.portlet.messageboards.model.MBBan addBan(
		long userId, long plid, long banUserId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addBan(userId, plid, banUserId);
	}

	public static void checkBan(long groupId, long banUserId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.checkBan(groupId, banUserId);
	}

	public static void deleteBan(long plid, long banUserId)
		throws com.liferay.portal.SystemException {
		_service.deleteBan(plid, banUserId);
	}

	public static void deleteBansByBanUserId(long banUserId)
		throws com.liferay.portal.SystemException {
		_service.deleteBansByBanUserId(banUserId);
	}

	public static void deleteBansByGroupId(long groupId)
		throws com.liferay.portal.SystemException {
		_service.deleteBansByGroupId(groupId);
	}

	public static void expireBans() throws com.liferay.portal.SystemException {
		_service.expireBans();
	}

	public static java.util.List<com.liferay.portlet.messageboards.model.MBBan> getBans(
		long groupId, int start, int end)
		throws com.liferay.portal.SystemException {
		return _service.getBans(groupId, start, end);
	}

	public static int getBansCount(long groupId)
		throws com.liferay.portal.SystemException {
		return _service.getBansCount(groupId);
	}

	public static boolean hasBan(long groupId, long banUserId)
		throws com.liferay.portal.SystemException {
		return _service.hasBan(groupId, banUserId);
	}

	public static MBBanLocalService getService() {
		return _service;
	}

	public void setService(MBBanLocalService service) {
		_service = service;
	}

	private static MBBanLocalService _service;
}