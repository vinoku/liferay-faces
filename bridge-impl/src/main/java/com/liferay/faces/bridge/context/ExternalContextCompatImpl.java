/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.bridge.context;

import javax.faces.context.ExternalContext;
import javax.portlet.ClientDataRequest;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.faces.Bridge;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.faces.bridge.lifecycle.LifecycleIncongruityManager;
import com.liferay.faces.bridge.lifecycle.LifecycleIncongruityMap;


/**
 * This class provides a compatibility layer that isolates differences between JSF1 and JSF2.
 *
 * @author  Neil Griffin
 */
public abstract class ExternalContextCompatImpl extends ExternalContext {

	// Protected Data Members
	protected ServletResponse facesImplementationServletResponse;
	protected LifecycleIncongruityManager lifecycleIncongruityManager;
	protected LifecycleIncongruityMap lifecycleIncongruityMap;
	protected PortletContext portletContext;
	protected PortletRequest portletRequest;
	protected PortletResponse portletResponse;
	protected Bridge.PortletPhase portletPhase;
	protected String requestContextPath;

	public ExternalContextCompatImpl(PortletContext portletContext, PortletRequest portletRequest,
		PortletResponse portletResponse) {

		this.portletContext = portletContext;
		this.portletRequest = portletRequest;
		this.portletResponse = portletResponse;
	}

	public String encodePartialActionURL(String url) {

		// no-op for JSF 1.2
		return null;
	}

	protected HttpServletResponse createFlashHttpServletResponse() {

		// no-op for JSF 1.2
		return null;
	}

	protected boolean isBridgeFlashServletResponseRequired() {

		// no-op for JSF 1.2
		return false;
	}

	protected boolean isEncodingFormWithPrimeFacesAjaxFileUpload() {

		// no-op for JSF 1.2
		return false;
	}

	protected boolean isICEfacesLegacyMode(ClientDataRequest clientDataRequest) {

		// no-op for JSF 1.2
		return false;
	}
}
