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

package com.liferay.portlet.wiki.service;


/**
 * <a href="WikiNodeLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.wiki.service.WikiNodeLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.wiki.service.WikiNodeLocalService
 *
 */
public class WikiNodeLocalServiceUtil {
	public static com.liferay.portlet.wiki.model.WikiNode addWikiNode(
		com.liferay.portlet.wiki.model.WikiNode wikiNode)
		throws com.liferay.portal.SystemException {
		return _service.addWikiNode(wikiNode);
	}

	public static void deleteWikiNode(long nodeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteWikiNode(nodeId);
	}

	public static void deleteWikiNode(
		com.liferay.portlet.wiki.model.WikiNode wikiNode)
		throws com.liferay.portal.SystemException {
		_service.deleteWikiNode(wikiNode);
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

	public static com.liferay.portlet.wiki.model.WikiNode getWikiNode(
		long nodeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getWikiNode(nodeId);
	}

	public static java.util.List<com.liferay.portlet.wiki.model.WikiNode> getWikiNodes(
		int start, int end) throws com.liferay.portal.SystemException {
		return _service.getWikiNodes(start, end);
	}

	public static int getWikiNodesCount()
		throws com.liferay.portal.SystemException {
		return _service.getWikiNodesCount();
	}

	public static com.liferay.portlet.wiki.model.WikiNode updateWikiNode(
		com.liferay.portlet.wiki.model.WikiNode wikiNode)
		throws com.liferay.portal.SystemException {
		return _service.updateWikiNode(wikiNode);
	}

	public static com.liferay.portlet.wiki.model.WikiNode addNode(long userId,
		long plid, java.lang.String name, java.lang.String description,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addNode(userId, plid, name, description,
			addCommunityPermissions, addGuestPermissions);
	}

	public static com.liferay.portlet.wiki.model.WikiNode addNode(
		java.lang.String uuid, long userId, long plid, java.lang.String name,
		java.lang.String description, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addNode(uuid, userId, plid, name, description,
			addCommunityPermissions, addGuestPermissions);
	}

	public static com.liferay.portlet.wiki.model.WikiNode addNode(long userId,
		long plid, java.lang.String name, java.lang.String description,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addNode(userId, plid, name, description,
			communityPermissions, guestPermissions);
	}

	public static com.liferay.portlet.wiki.model.WikiNode addNode(
		java.lang.String uuid, long userId, long plid, java.lang.String name,
		java.lang.String description,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.addNode(uuid, userId, plid, name, description,
			addCommunityPermissions, addGuestPermissions, communityPermissions,
			guestPermissions);
	}

	public static void addNodeResources(long nodeId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.addNodeResources(nodeId, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addNodeResources(
		com.liferay.portlet.wiki.model.WikiNode node,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.addNodeResources(node, addCommunityPermissions,
			addGuestPermissions);
	}

	public static void addNodeResources(long nodeId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.addNodeResources(nodeId, communityPermissions, guestPermissions);
	}

	public static void addNodeResources(
		com.liferay.portlet.wiki.model.WikiNode node,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.addNodeResources(node, communityPermissions, guestPermissions);
	}

	public static void deleteNode(long nodeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteNode(nodeId);
	}

	public static void deleteNode(com.liferay.portlet.wiki.model.WikiNode node)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteNode(node);
	}

	public static void deleteNodes(long groupId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.deleteNodes(groupId);
	}

	public static com.liferay.portlet.wiki.model.WikiNode getNode(long nodeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getNode(nodeId);
	}

	public static com.liferay.portlet.wiki.model.WikiNode getNode(
		long groupId, java.lang.String nodeName)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.getNode(groupId, nodeName);
	}

	public static java.util.List<com.liferay.portlet.wiki.model.WikiNode> getNodes(
		long groupId) throws com.liferay.portal.SystemException {
		return _service.getNodes(groupId);
	}

	public static java.util.List<com.liferay.portlet.wiki.model.WikiNode> getNodes(
		long groupId, int start, int end)
		throws com.liferay.portal.SystemException {
		return _service.getNodes(groupId, start, end);
	}

	public static int getNodesCount(long groupId)
		throws com.liferay.portal.SystemException {
		return _service.getNodesCount(groupId);
	}

	public static void importPages(long userId, long nodeId,
		java.lang.String importer, java.io.File[] files,
		java.util.Map<String, String[]> options)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.importPages(userId, nodeId, importer, files, options);
	}

	public static void reIndex(java.lang.String[] ids)
		throws com.liferay.portal.SystemException {
		_service.reIndex(ids);
	}

	public static com.liferay.portal.kernel.search.Hits search(long companyId,
		long groupId, long[] nodeIds, java.lang.String keywords, int start,
		int end) throws com.liferay.portal.SystemException {
		return _service.search(companyId, groupId, nodeIds, keywords, start, end);
	}

	public static void subscribeNode(long userId, long nodeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.subscribeNode(userId, nodeId);
	}

	public static void unsubscribeNode(long userId, long nodeId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		_service.unsubscribeNode(userId, nodeId);
	}

	public static com.liferay.portlet.wiki.model.WikiNode updateNode(
		long nodeId, java.lang.String name, java.lang.String description)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return _service.updateNode(nodeId, name, description);
	}

	public static WikiNodeLocalService getService() {
		return _service;
	}

	public void setService(WikiNodeLocalService service) {
		_service = service;
	}

	private static WikiNodeLocalService _service;
}