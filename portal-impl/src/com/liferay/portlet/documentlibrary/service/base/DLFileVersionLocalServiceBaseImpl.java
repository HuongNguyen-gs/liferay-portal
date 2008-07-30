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

package com.liferay.portlet.documentlibrary.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.bean.InitializingBean;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalService;
import com.liferay.portlet.documentlibrary.service.DLFileEntryService;
import com.liferay.portlet.documentlibrary.service.DLFileRankLocalService;
import com.liferay.portlet.documentlibrary.service.DLFileShortcutLocalService;
import com.liferay.portlet.documentlibrary.service.DLFileShortcutService;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalService;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalService;
import com.liferay.portlet.documentlibrary.service.DLFolderService;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryAndShortcutFinder;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryFinder;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryPersistence;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileRankFinder;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileRankPersistence;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileShortcutFinder;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileShortcutPersistence;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileVersionPersistence;
import com.liferay.portlet.documentlibrary.service.persistence.DLFolderPersistence;

import java.util.List;

/**
 * <a href="DLFileVersionLocalServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class DLFileVersionLocalServiceBaseImpl
	implements DLFileVersionLocalService, InitializingBean {
	public DLFileVersion addDLFileVersion(DLFileVersion dlFileVersion)
		throws SystemException {
		dlFileVersion.setNew(true);

		return dlFileVersionPersistence.update(dlFileVersion, false);
	}

	public void deleteDLFileVersion(long fileVersionId)
		throws PortalException, SystemException {
		dlFileVersionPersistence.remove(fileVersionId);
	}

	public void deleteDLFileVersion(DLFileVersion dlFileVersion)
		throws SystemException {
		dlFileVersionPersistence.remove(dlFileVersion);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return dlFileVersionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) throws SystemException {
		return dlFileVersionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	public DLFileVersion getDLFileVersion(long fileVersionId)
		throws PortalException, SystemException {
		return dlFileVersionPersistence.findByPrimaryKey(fileVersionId);
	}

	public List<DLFileVersion> getDLFileVersions(int start, int end)
		throws SystemException {
		return dlFileVersionPersistence.findAll(start, end);
	}

	public int getDLFileVersionsCount() throws SystemException {
		return dlFileVersionPersistence.countAll();
	}

	public DLFileVersion updateDLFileVersion(DLFileVersion dlFileVersion)
		throws SystemException {
		dlFileVersion.setNew(false);

		return dlFileVersionPersistence.update(dlFileVersion, true);
	}

	public DLFileEntryLocalService getDLFileEntryLocalService() {
		return dlFileEntryLocalService;
	}

	public void setDLFileEntryLocalService(
		DLFileEntryLocalService dlFileEntryLocalService) {
		this.dlFileEntryLocalService = dlFileEntryLocalService;
	}

	public DLFileEntryService getDLFileEntryService() {
		return dlFileEntryService;
	}

	public void setDLFileEntryService(DLFileEntryService dlFileEntryService) {
		this.dlFileEntryService = dlFileEntryService;
	}

	public DLFileEntryPersistence getDLFileEntryPersistence() {
		return dlFileEntryPersistence;
	}

	public void setDLFileEntryPersistence(
		DLFileEntryPersistence dlFileEntryPersistence) {
		this.dlFileEntryPersistence = dlFileEntryPersistence;
	}

	public DLFileEntryFinder getDLFileEntryFinder() {
		return dlFileEntryFinder;
	}

	public void setDLFileEntryFinder(DLFileEntryFinder dlFileEntryFinder) {
		this.dlFileEntryFinder = dlFileEntryFinder;
	}

	public DLFileEntryAndShortcutFinder getDLFileEntryAndShortcutFinder() {
		return dlFileEntryAndShortcutFinder;
	}

	public void setDLFileEntryAndShortcutFinder(
		DLFileEntryAndShortcutFinder dlFileEntryAndShortcutFinder) {
		this.dlFileEntryAndShortcutFinder = dlFileEntryAndShortcutFinder;
	}

	public DLFileRankLocalService getDLFileRankLocalService() {
		return dlFileRankLocalService;
	}

	public void setDLFileRankLocalService(
		DLFileRankLocalService dlFileRankLocalService) {
		this.dlFileRankLocalService = dlFileRankLocalService;
	}

	public DLFileRankPersistence getDLFileRankPersistence() {
		return dlFileRankPersistence;
	}

	public void setDLFileRankPersistence(
		DLFileRankPersistence dlFileRankPersistence) {
		this.dlFileRankPersistence = dlFileRankPersistence;
	}

	public DLFileRankFinder getDLFileRankFinder() {
		return dlFileRankFinder;
	}

	public void setDLFileRankFinder(DLFileRankFinder dlFileRankFinder) {
		this.dlFileRankFinder = dlFileRankFinder;
	}

	public DLFileShortcutLocalService getDLFileShortcutLocalService() {
		return dlFileShortcutLocalService;
	}

	public void setDLFileShortcutLocalService(
		DLFileShortcutLocalService dlFileShortcutLocalService) {
		this.dlFileShortcutLocalService = dlFileShortcutLocalService;
	}

	public DLFileShortcutService getDLFileShortcutService() {
		return dlFileShortcutService;
	}

	public void setDLFileShortcutService(
		DLFileShortcutService dlFileShortcutService) {
		this.dlFileShortcutService = dlFileShortcutService;
	}

	public DLFileShortcutPersistence getDLFileShortcutPersistence() {
		return dlFileShortcutPersistence;
	}

	public void setDLFileShortcutPersistence(
		DLFileShortcutPersistence dlFileShortcutPersistence) {
		this.dlFileShortcutPersistence = dlFileShortcutPersistence;
	}

	public DLFileShortcutFinder getDLFileShortcutFinder() {
		return dlFileShortcutFinder;
	}

	public void setDLFileShortcutFinder(
		DLFileShortcutFinder dlFileShortcutFinder) {
		this.dlFileShortcutFinder = dlFileShortcutFinder;
	}

	public DLFileVersionPersistence getDLFileVersionPersistence() {
		return dlFileVersionPersistence;
	}

	public void setDLFileVersionPersistence(
		DLFileVersionPersistence dlFileVersionPersistence) {
		this.dlFileVersionPersistence = dlFileVersionPersistence;
	}

	public DLFolderLocalService getDLFolderLocalService() {
		return dlFolderLocalService;
	}

	public void setDLFolderLocalService(
		DLFolderLocalService dlFolderLocalService) {
		this.dlFolderLocalService = dlFolderLocalService;
	}

	public DLFolderService getDLFolderService() {
		return dlFolderService;
	}

	public void setDLFolderService(DLFolderService dlFolderService) {
		this.dlFolderService = dlFolderService;
	}

	public DLFolderPersistence getDLFolderPersistence() {
		return dlFolderPersistence;
	}

	public void setDLFolderPersistence(DLFolderPersistence dlFolderPersistence) {
		this.dlFolderPersistence = dlFolderPersistence;
	}

	public void afterPropertiesSet() {
		if (dlFileEntryLocalService == null) {
			dlFileEntryLocalService = (DLFileEntryLocalService)PortalBeanLocatorUtil.locate(DLFileEntryLocalService.class.getName() +
					".impl");
		}

		if (dlFileEntryService == null) {
			dlFileEntryService = (DLFileEntryService)PortalBeanLocatorUtil.locate(DLFileEntryService.class.getName() +
					".impl");
		}

		if (dlFileEntryPersistence == null) {
			dlFileEntryPersistence = (DLFileEntryPersistence)PortalBeanLocatorUtil.locate(DLFileEntryPersistence.class.getName() +
					".impl");
		}

		if (dlFileEntryFinder == null) {
			dlFileEntryFinder = (DLFileEntryFinder)PortalBeanLocatorUtil.locate(DLFileEntryFinder.class.getName() +
					".impl");
		}

		if (dlFileEntryAndShortcutFinder == null) {
			dlFileEntryAndShortcutFinder = (DLFileEntryAndShortcutFinder)PortalBeanLocatorUtil.locate(DLFileEntryAndShortcutFinder.class.getName() +
					".impl");
		}

		if (dlFileRankLocalService == null) {
			dlFileRankLocalService = (DLFileRankLocalService)PortalBeanLocatorUtil.locate(DLFileRankLocalService.class.getName() +
					".impl");
		}

		if (dlFileRankPersistence == null) {
			dlFileRankPersistence = (DLFileRankPersistence)PortalBeanLocatorUtil.locate(DLFileRankPersistence.class.getName() +
					".impl");
		}

		if (dlFileRankFinder == null) {
			dlFileRankFinder = (DLFileRankFinder)PortalBeanLocatorUtil.locate(DLFileRankFinder.class.getName() +
					".impl");
		}

		if (dlFileShortcutLocalService == null) {
			dlFileShortcutLocalService = (DLFileShortcutLocalService)PortalBeanLocatorUtil.locate(DLFileShortcutLocalService.class.getName() +
					".impl");
		}

		if (dlFileShortcutService == null) {
			dlFileShortcutService = (DLFileShortcutService)PortalBeanLocatorUtil.locate(DLFileShortcutService.class.getName() +
					".impl");
		}

		if (dlFileShortcutPersistence == null) {
			dlFileShortcutPersistence = (DLFileShortcutPersistence)PortalBeanLocatorUtil.locate(DLFileShortcutPersistence.class.getName() +
					".impl");
		}

		if (dlFileShortcutFinder == null) {
			dlFileShortcutFinder = (DLFileShortcutFinder)PortalBeanLocatorUtil.locate(DLFileShortcutFinder.class.getName() +
					".impl");
		}

		if (dlFileVersionPersistence == null) {
			dlFileVersionPersistence = (DLFileVersionPersistence)PortalBeanLocatorUtil.locate(DLFileVersionPersistence.class.getName() +
					".impl");
		}

		if (dlFolderLocalService == null) {
			dlFolderLocalService = (DLFolderLocalService)PortalBeanLocatorUtil.locate(DLFolderLocalService.class.getName() +
					".impl");
		}

		if (dlFolderService == null) {
			dlFolderService = (DLFolderService)PortalBeanLocatorUtil.locate(DLFolderService.class.getName() +
					".impl");
		}

		if (dlFolderPersistence == null) {
			dlFolderPersistence = (DLFolderPersistence)PortalBeanLocatorUtil.locate(DLFolderPersistence.class.getName() +
					".impl");
		}
	}

	protected DLFileEntryLocalService dlFileEntryLocalService;
	protected DLFileEntryService dlFileEntryService;
	protected DLFileEntryPersistence dlFileEntryPersistence;
	protected DLFileEntryFinder dlFileEntryFinder;
	protected DLFileEntryAndShortcutFinder dlFileEntryAndShortcutFinder;
	protected DLFileRankLocalService dlFileRankLocalService;
	protected DLFileRankPersistence dlFileRankPersistence;
	protected DLFileRankFinder dlFileRankFinder;
	protected DLFileShortcutLocalService dlFileShortcutLocalService;
	protected DLFileShortcutService dlFileShortcutService;
	protected DLFileShortcutPersistence dlFileShortcutPersistence;
	protected DLFileShortcutFinder dlFileShortcutFinder;
	protected DLFileVersionPersistence dlFileVersionPersistence;
	protected DLFolderLocalService dlFolderLocalService;
	protected DLFolderService dlFolderService;
	protected DLFolderPersistence dlFolderPersistence;
}