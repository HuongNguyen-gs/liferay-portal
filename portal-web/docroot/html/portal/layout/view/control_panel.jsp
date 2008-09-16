<%
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
%>

<%@ include file="/html/portal/init.jsp" %>

<%
String ppid = ParamUtil.getString(request, "p_p_id");

if (ppid.equals(PortletKeys.PORTLET_CONFIGURATION)) {
	ppid = ParamUtil.getString(request, PortalUtil.getPortletNamespace(ppid) + "portletResource");
}

String category = PortalUtil.getControlPanelCategory(ppid);

if (Validator.isNull(category)) {
	category = "content";
}

String panelCategory = ParamUtil.getString(request, "panel_category");
%>

<c:if test="<%= !themeDisplay.isStateExclusive() && !themeDisplay.isStatePopUp() %>">
	<div id="content-wrapper">
		<table class="lfr-ctrl-panel <%= panelCategory %>">
		<tr>
			<td class="panel-menu" valign="top">
				<liferay-portlet:runtime portletName="87" /><br />
			</td>
			<td class="panel-content <%= (!layoutTypePortlet.hasStateMax()) ? "panel-frontpage" : "panel-application" %>" valign="top">
				<table class="panel-content-menu">
				<tr>
					<td>
						<c:if test='<%= category.equals(PortletCategoryKeys.CONTENT) %>'>

							<%
							Group scopeGroup = GroupLocalServiceUtil.getGroup(scopeGroupId);

							String currentGroupLabel = "current-community";

							if (scopeGroup.isOrganization()) {
								currentGroupLabel = "current-organization";
							}
							else if (scopeGroup.isUser()) {
								currentGroupLabel = "current-user";
							}
							%>

							<span class="current-community">
								<liferay-ui:message key="<%= currentGroupLabel %>" />: <b><%= scopeGroup.getDescriptiveName() %></b>
							</span>
						</c:if>
					</td>
					<td align="right">
						<c:if test='<%= !category.equals("server") %>'>
							<liferay-ui:message key="current-portal-instance" />: <a href="http://www.<%= company.getWebId() %>"><b><%= company.getWebId() %></b></a>
						</c:if>
					</td>
				</tr>
				</table>
</c:if>

<%
if (themeDisplay.isStateExclusive() || themeDisplay.isStatePopUp() || layoutTypePortlet.hasStateMax()) {
	String content = null;

	if (themeDisplay.isStateExclusive()) {
		content = LayoutTemplateLocalServiceUtil.getContent("exclusive", true, theme.getThemeId());
	}
	else if (themeDisplay.isStatePopUp()) {
		content = LayoutTemplateLocalServiceUtil.getContent("pop_up", true, theme.getThemeId());
	}
	else {
		ppid = StringUtil.split(layoutTypePortlet.getStateMax())[0];

		content = LayoutTemplateLocalServiceUtil.getContent("max", true, theme.getThemeId());
	}
%>

	<%= RuntimePortletUtil.processTemplate(application, request, response, pageContext, ppid, content) %>

<%
}
else {
	String description = StringPool.BLANK;

	if (Validator.isNull(description)) {
		description = LanguageUtil.get(pageContext, "please-select-a-tool-from-the-left-menu");
	}
%>

	<div class="portlet-msg-info" style="margin: auto 10px;">
		<%= description %>
	</div>

<%
}
%>

<c:if test="<%= !themeDisplay.isStateExclusive() && !themeDisplay.isStatePopUp() %>">
			</td>
		</tr>
		</table>
	</div>
</c:if>