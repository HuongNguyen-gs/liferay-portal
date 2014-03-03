/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.security.pacl.permission.PortalRuntimePermission;

/**
 * Provides utility methods for escaping, rendering, replacing, and stripping
 * HTML text. This class uses XSS recommendations from <a
 * href="http://www.owasp.org/index.php/Cross_Site_Scripting#How_to_Protect_Yourself">http://www.owasp.org/index.php/Cross_Site_Scripting#How_to_Protect_Yourself</a>
 * when escaping HTML text.
 *
 * @author Brian Wing Shun Chan
 * @author Clarence Shen
 * @author Harry Mark
 * @author Samuel Kong
 */
public class HtmlUtil {

	/**
	 * Escapes the HTML text so that it is safe to use in an HTML context.
	 *
	 * @param  html the HTML text to escape
	 * @return the escaped HTML text
	 */
	public static String escape(String html) {
		return getHtml().escape(html);
	}

	/**
	 * Escapes the input text as a hexadecimal value, based on the mode.
	 *
	 * <p>
	 * Note that <code>escape(html, 4)</code> (<code>ESCAPE_MODE_TEXT</code> =
	 * 4) returns the same as <code>escape(html)</code>.
	 * </p>
	 *
	 * @param  html the text to escape
	 * @param  mode the encoding type. For more information on the escape mode
	 *         types and their corresponding integer values, visit {@link
	 *         HtmlImpl}.
	 * @return the escaped hexadecimal value of the input text, based on the
	 *         mode
	 */
	public static String escape(String html, int mode) {
		return getHtml().escape(html, mode);
	}

	/**
	 * Escapes the attribute value so that it is safe to use in an HTML context.
	 *
	 * @param  attribute the HTML attribute to escape
	 * @return the escaped attribute value
	 */
	public static String escapeAttribute(String attribute) {
		return getHtml().escapeAttribute(attribute);
	}

	/**
	 * Escapes the CSS value so that it is safe to use in a CSS context.
	 *
	 * @param  css the CSS value to escape
	 * @return the escaped CSS value
	 */
	public static String escapeCSS(String css) {
		return getHtml().escapeCSS(css);
	}

	/**
	 * Escapes the HREF attribute so that it is safe to use as a URL.
	 *
	 * @param  href the HREF attribute to escape
	 * @return the escaped HREF attribute
	 */
	public static String escapeHREF(String href) {
		return getHtml().escapeHREF(href);
	}

	/**
	 * Escapes the JavaScript value so that it is safe to use in a JavaScript
	 * context.
	 *
	 * @param  js the JavaScript value to escape
	 * @return the escaped JavaScript value
	 */
	public static String escapeJS(String js) {
		return getHtml().escapeJS(js);
	}

	/**
	 * Escapes the URL value so that it is safe to use as a URL.
	 *
	 * @param  url the URL value to escape
	 * @return the escaped URL value
	 */
	public static String escapeURL(String url) {
		return getHtml().escapeURL(url);
	}

	public static String escapeXPath(String xPath) {
		return getHtml().escapeXPath(xPath);
	}

	public static String escapeXPathAttribute(String xPathAttribute) {
		return getHtml().escapeXPathAttribute(xPathAttribute);
	}

	/**
	 * Extracts the raw text from the HTML input. The raw text has compressed
	 * whitespace and no attributes, scripts, or styles.
	 *
	 * <p>
	 * For example, raw text returned by this method can be stored in a search
	 * index.
	 * </p>
	 *
	 * @param  html the HTML text
	 * @return the raw text from the HTML input
	 */
	public static String extractText(String html) {
		return getHtml().extractText(html);
	}

	public static String fromInputSafe(String html) {
		return getHtml().fromInputSafe(html);
	}

	public static Html getHtml() {
		PortalRuntimePermission.checkGetBeanProperty(HtmlUtil.class);

		return _html;
	}

	/**
	 * Renders the HTML content into text. This provides a human readable
	 * version of the segment content that is modeled on the way Mozilla
	 * Thunderbird and other email clients provide an automatic conversion of
	 * HTML content to text in their alternative MIME encoding of emails.
	 *
	 * <p>
	 * Using the default settings, the output complies with the
	 * <code>Text/Plain; Format=Flowed (DelSp=No)</code> protocol described in
	 * <a href="http://tools.ietf.org/html/rfc3676">RFC-3676</a>.
	 * </p>
	 *
	 * @param  html the HTML text
	 * @return the rendered HTML text
	 */
	public static String render(String html) {
		return getHtml().render(html);
	}

	/**
	 * Replaces the Microsoft Word unicode characters with plain HTML entities
	 * or characters.
	 *
	 * @param  html the HTML text
	 * @return the converted HTML text
	 */
	public static String replaceMsWordCharacters(String html) {
		return getHtml().replaceMsWordCharacters(html);
	}

	/**
	 * Replaces all new lines or carriage returns with the <code><br /></code>
	 * HTML tag.
	 *
	 * @param  html the HTML text
	 * @return the converted HTML text
	 */
	public static String replaceNewLine(String html) {
		return getHtml().replaceNewLine(html);
	}

	/**
	 * Strips all content delimited by the tag out of the HTML text.
	 *
	 * <p>
	 * If the tag appears multiple times, all occurrences (including the tag)
	 * are stripped. The tag may have attributes. In order for this method to
	 * recognize the tag, it must consist of a separate opening and closing tag.
	 * Self-closing tags remain in the result.
	 * </p>
	 *
	 * @param  html the HTML text
	 * @param  tag the tag used for delimiting, which should only be the tag's
	 *         name (e.g. no &lt;)
	 * @return the HTML text, without the stripped tag and its contents
	 */
	public static String stripBetween(String html, String tag) {
		return getHtml().stripBetween(html, tag);
	}

	/**
	 * Strips all XML comments out of the HTML text.
	 *
	 * @param  html the HTML text
	 * @return the HTML text, without the stripped XML comments
	 */
	public static String stripComments(String html) {
		return getHtml().stripComments(html);
	}

	public static String stripHtml(String html) {
		return getHtml().stripHtml(html);
	}

	/**
	 * Encodes the HTML text so that it's safe to use as an input field value.
	 *
	 * <p>
	 * For example, the <code>&</code> character is replaced by
	 * <code>&amp;amp;</code>.
	 * </p>
	 *
	 * @param  html the HTML text
	 * @return the encoded text that is safe to use as an input field value
	 */
	public static String toInputSafe(String html) {
		return getHtml().toInputSafe(html);
	}

	public static String unescape(String html) {
		return getHtml().unescape(html);
	}

	public static String unescapeCDATA(String html) {
		return getHtml().unescapeCDATA(html);
	}

	public static String wordBreak(String html, int columns) {
		return getHtml().wordBreak(html, columns);
	}

	public void setHtml(Html html) {
		PortalRuntimePermission.checkSetBeanProperty(getClass());

		_html = html;
	}

	private static Html _html;

}