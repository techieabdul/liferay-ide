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
package com.liferay.ide.eclipse.layouttpl.ui.cmd;

import com.liferay.ide.eclipse.layouttpl.ui.model.LayoutTplDiagram;
import com.liferay.ide.eclipse.layouttpl.ui.model.PortletLayout;

import org.eclipse.gef.commands.Command;

public class PortletLayoutDeleteCommand extends Command {

	protected final PortletLayout child;

	protected final LayoutTplDiagram parent;

	protected boolean wasRemoved;

	public PortletLayoutDeleteCommand(LayoutTplDiagram parent, PortletLayout child) {
		if (parent == null || child == null) {
			throw new IllegalArgumentException();
		}

		setLabel("Portlet Row deleted");

		this.parent = parent;
		this.child = child;
	}


	public boolean canUndo() {
		return wasRemoved;
	}

	public void execute() {
		redo();
	}

	public void redo() {
		wasRemoved = parent.removeRow(child);
	}

	public void undo() {
		parent.addRow(child);
	}
}
