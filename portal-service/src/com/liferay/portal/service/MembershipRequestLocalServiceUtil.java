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

package com.liferay.portal.service;


/**
 * <a href="MembershipRequestLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portal.service.MembershipRequestLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portal.service.MembershipRequestLocalService
 *
 */
public class MembershipRequestLocalServiceUtil {
	public static com.liferay.portal.model.MembershipRequest addMembershipRequest(
		com.liferay.portal.model.MembershipRequest membershipRequest)
		throws com.liferay.portal.SystemException {
		return _service.addMembershipRequest(membershipRequest);
	}

	public static void deleteMembershipRequest(long membershipRequestId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteMembershipRequest(membershipRequestId);
	}

	public static void deleteMembershipRequest(
		com.liferay.portal.model.MembershipRequest membershipRequest)
		throws com.liferay.portal.SystemException {
		_service.deleteMembershipRequest(membershipRequest);
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

	public static com.liferay.portal.model.MembershipRequest getMembershipRequest(
		long membershipRequestId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getMembershipRequest(membershipRequestId);
	}

	public static java.util.List<com.liferay.portal.model.MembershipRequest> getMembershipRequests(
		int start, int end) throws com.liferay.portal.SystemException {
		return _service.getMembershipRequests(start, end);
	}

	public static int getMembershipRequestsCount()
		throws com.liferay.portal.SystemException {
		return _service.getMembershipRequestsCount();
	}

	public static com.liferay.portal.model.MembershipRequest updateMembershipRequest(
		com.liferay.portal.model.MembershipRequest membershipRequest)
		throws com.liferay.portal.SystemException {
		return _service.updateMembershipRequest(membershipRequest);
	}

	public static com.liferay.portal.model.MembershipRequest addMembershipRequest(
		long userId, long groupId, java.lang.String comments)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addMembershipRequest(userId, groupId, comments);
	}

	public static void deleteMembershipRequests(long groupId)
		throws com.liferay.portal.SystemException {
		_service.deleteMembershipRequests(groupId);
	}

	public static void deleteMembershipRequests(long groupId, int statusId)
		throws com.liferay.portal.SystemException {
		_service.deleteMembershipRequests(groupId, statusId);
	}

	public static java.util.List<com.liferay.portal.model.MembershipRequest> search(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.SystemException {
		return _service.search(groupId, status, start, end);
	}

	public static int searchCount(long groupId, int status)
		throws com.liferay.portal.SystemException {
		return _service.searchCount(groupId, status);
	}

	public static void updateStatus(long replierUserId,
		long membershipRequestId, java.lang.String replyComments, int statusId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.updateStatus(replierUserId, membershipRequestId,
			replyComments, statusId);
	}

	public static MembershipRequestLocalService getService() {
		return _service;
	}

	public void setService(MembershipRequestLocalService service) {
		_service = service;
	}

	private static MembershipRequestLocalService _service;
}