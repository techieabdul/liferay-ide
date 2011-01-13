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

package com.liferay.ide.eclipse.server.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jdt.internal.debug.ui.classpath.ClasspathModel;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.wst.server.core.IModule;

import com.liferay.ide.eclipse.server.core.IPortalRuntime;
import com.liferay.ide.eclipse.server.core.PortalServerCorePlugin;
import com.liferay.ide.eclipse.server.util.ServerUtil;
import com.liferay.ide.eclipse.ui.util.LaunchHelper;

/**
 * @author Greg Amerson
 */
@SuppressWarnings("restriction")
public class PortletDeployer extends LaunchHelper {

	private IModule module;

	public PortletDeployer(IModule module) {
		super(IJavaLaunchConfigurationConstants.ID_JAVA_APPLICATION);
		
		setLaunchSync(true);
		
		setLaunchInBackground(true);
		
		setLaunchCaptureInConsole(true);
		
		setLaunchIsPrivate(true);
		
		this.module = module;
	}

	public void deployPortlet(String deployerClass, String[] args)
		throws CoreException {
		
		ILaunchConfigurationWorkingCopy config = createLaunchConfiguration();

		// set default for common settings
		CommonTab tab = new CommonTab();
		
		tab.setDefaults(config);
		tab.dispose();
		
		config.setAttribute(
			IDebugUIConstants.ATTR_CAPTURE_IN_FILE, PortalServerCorePlugin.getDefault().getStateLocation().append(
				"portlet.deployer.log").toOSString());

		config.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, deployerClass);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < args.length; i++) {
			sb.append("\"" + args[i] + "\" ");
		}
		
		config.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, sb.toString());
		// config.setAttribute(IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,
		// "-agentlib:jdwp=transport=dt_socket,address=8383,server=y,suspend=y");

		launch(config, ILaunchManager.RUN_MODE, null);
	}

	@Override
	protected void addUserEntries(ClasspathModel model)
		throws CoreException {		
		
		if (module != null) {
			IPortalRuntime portalRuntime = ServerUtil.getPortalRuntime(module.getProject());
			
			IPath[] userlibs = portalRuntime.getAllUserClasspathLibraries();
			
			for (IPath userlib : userlibs) {
				model.addEntry(ClasspathModel.USER, JavaRuntime.newArchiveRuntimeClasspathEntry(userlib));
			}
		}
	}

	@Override
	protected String getNewLaunchConfigurationName() {
		return super.getNewLaunchConfigurationName();
	}

}
