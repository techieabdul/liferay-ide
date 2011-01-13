/*******************************************************************************
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
 *
 *******************************************************************************/

package com.liferay.ide.eclipse.server.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.wst.server.core.internal.InstallableRuntime2;

/**
 * @author Greg Amerson
 */
@SuppressWarnings("restriction")
public class InstallableRuntime2ConfigurationElement implements IConfigurationElement {

	protected InstallableRuntime2 delegateIR;

	protected String archiveURL;

	public InstallableRuntime2ConfigurationElement(InstallableRuntime2 ir, String url) {
		this.delegateIR = ir;

		this.archiveURL = url;
	}

	public Object createExecutableExtension(String propertyName)
		throws CoreException {

		return null;
	}

	public String getAttribute(String name)
		throws InvalidRegistryObjectException {

		if ("archiveUrl".equals(name)) {
			return archiveURL;
		}
		else if ("archivePath".equals(name)) {
			return delegateIR.getArchivePath();
		}
		else if ("licenseUrl".equals(name)) {
			return delegateIR.getLicenseURL();
		}

		return null;
	}

	public String getAttributeAsIs(String name)
		throws InvalidRegistryObjectException {

		return null;
	}

	public String[] getAttributeNames()
		throws InvalidRegistryObjectException {

		return null;
	}

	public IConfigurationElement[] getChildren()
		throws InvalidRegistryObjectException {

		return null;
	}

	public IConfigurationElement[] getChildren(String name)
		throws InvalidRegistryObjectException {

		return null;
	}

	public IContributor getContributor()
		throws InvalidRegistryObjectException {

		return null;
	}

	public IExtension getDeclaringExtension()
		throws InvalidRegistryObjectException {

		return null;
	}

	public String getName()
		throws InvalidRegistryObjectException {

		return null;
	}

	public String getNamespace()
		throws InvalidRegistryObjectException {

		return null;
	}

	public String getNamespaceIdentifier()
		throws InvalidRegistryObjectException {

		return null;
	}

	public Object getParent()
		throws InvalidRegistryObjectException {

		return null;
	}

	public String getValue()
		throws InvalidRegistryObjectException {

		return null;
	}

	public String getValueAsIs()
		throws InvalidRegistryObjectException {

		return null;
	}

	public boolean isValid() {
		return false;
	}

	public String getAttribute(String attrName, String locale)
			throws InvalidRegistryObjectException {
		return null;
	}

	public String getValue(String locale) throws InvalidRegistryObjectException {
		return null;
	}

}
