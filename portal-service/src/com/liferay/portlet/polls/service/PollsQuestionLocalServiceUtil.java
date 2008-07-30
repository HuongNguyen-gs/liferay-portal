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

package com.liferay.portlet.polls.service;


/**
 * <a href="PollsQuestionLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.polls.service.PollsQuestionLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.polls.service.PollsQuestionLocalService
 *
 */
public class PollsQuestionLocalServiceUtil {
	public static com.liferay.portlet.polls.model.PollsQuestion addPollsQuestion(
		com.liferay.portlet.polls.model.PollsQuestion pollsQuestion)
		throws com.liferay.portal.SystemException {
		return _service.addPollsQuestion(pollsQuestion);
	}

	public static void deletePollsQuestion(long questionId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deletePollsQuestion(questionId);
	}

	public static void deletePollsQuestion(
		com.liferay.portlet.polls.model.PollsQuestion pollsQuestion)
		throws com.liferay.portal.SystemException {
		_service.deletePollsQuestion(pollsQuestion);
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

	public static com.liferay.portlet.polls.model.PollsQuestion getPollsQuestion(
		long questionId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getPollsQuestion(questionId);
	}

	public static java.util.List<com.liferay.portlet.polls.model.PollsQuestion> getPollsQuestions(
		int start, int end) throws com.liferay.portal.SystemException {
		return _service.getPollsQuestions(start, end);
	}

	public static int getPollsQuestionsCount()
		throws com.liferay.portal.SystemException {
		return _service.getPollsQuestionsCount();
	}

	public static com.liferay.portlet.polls.model.PollsQuestion updatePollsQuestion(
		com.liferay.portlet.polls.model.PollsQuestion pollsQuestion)
		throws com.liferay.portal.SystemException {
		return _service.updatePollsQuestion(pollsQuestion);
	}

	public static com.liferay.portlet.polls.model.PollsQuestion addQuestion(
		long userId, long plid, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addQuestion(userId, plid, title, description,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire,
			addCommunityPermissions, addGuestPermissions);
	}

	public static com.liferay.portlet.polls.model.PollsQuestion addQuestion(
		java.lang.String uuid, long userId, long plid, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addQuestion(uuid, userId, plid, title, description,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire,
			addCommunityPermissions, addGuestPermissions);
	}

	public static com.liferay.portlet.polls.model.PollsQuestion addQuestion(
		long userId, long plid, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire,
		java.util.List<com.liferay.portlet.polls.model.PollsChoice> choices,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addQuestion(userId, plid, title, description,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire, choices,
			addCommunityPermissions, addGuestPermissions);
	}

	public static com.liferay.portlet.polls.model.PollsQuestion addQuestion(
		long userId, long plid, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire,
		java.util.List<com.liferay.portlet.polls.model.PollsChoice> choices,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addQuestion(userId, plid, title, description,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire, choices,
			communityPermissions, guestPermissions);
	}

	public static com.liferay.portlet.polls.model.PollsQuestion addQuestion(
		java.lang.String uuid, long userId, long plid, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire,
		java.util.List<com.liferay.portlet.polls.model.PollsChoice> choices,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addQuestion(uuid, userId, plid, title, description,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire, choices,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public static void addQuestionResources(long questionId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.addQuestionResources(questionId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addQuestionResources(
		com.liferay.portlet.polls.model.PollsQuestion question,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.addQuestionResources(question, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addQuestionResources(long questionId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.addQuestionResources(questionId, communityPermissions,
			guestPermissions);
	}

	public static void addQuestionResources(
		com.liferay.portlet.polls.model.PollsQuestion question,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.addQuestionResources(question, communityPermissions,
			guestPermissions);
	}

	public static void deleteQuestion(long questionId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteQuestion(questionId);
	}

	public static void deleteQuestion(
		com.liferay.portlet.polls.model.PollsQuestion question)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteQuestion(question);
	}

	public static void deleteQuestions(long groupId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteQuestions(groupId);
	}

	public static com.liferay.portlet.polls.model.PollsQuestion getQuestion(
		long questionId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getQuestion(questionId);
	}

	public static java.util.List<com.liferay.portlet.polls.model.PollsQuestion> getQuestions(
		long groupId) throws com.liferay.portal.SystemException {
		return _service.getQuestions(groupId);
	}

	public static java.util.List<com.liferay.portlet.polls.model.PollsQuestion> getQuestions(
		long groupId, int start, int end)
		throws com.liferay.portal.SystemException {
		return _service.getQuestions(groupId, start, end);
	}

	public static int getQuestionsCount(long groupId)
		throws com.liferay.portal.SystemException {
		return _service.getQuestionsCount(groupId);
	}

	public static com.liferay.portlet.polls.model.PollsQuestion updateQuestion(
		long userId, long questionId, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.updateQuestion(userId, questionId, title, description,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire);
	}

	public static com.liferay.portlet.polls.model.PollsQuestion updateQuestion(
		long userId, long questionId, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, int expirationDateHour,
		int expirationDateMinute, boolean neverExpire,
		java.util.List<com.liferay.portlet.polls.model.PollsChoice> choices)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.updateQuestion(userId, questionId, title, description,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			expirationDateHour, expirationDateMinute, neverExpire, choices);
	}

	public static PollsQuestionLocalService getService() {
		return _service;
	}

	public void setService(PollsQuestionLocalService service) {
		_service = service;
	}

	private static PollsQuestionLocalService _service;
}