/*******************************************************************************
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
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
 * Contributors:
 *      Kamesh Sampath - initial implementation
 *      Gregory Amerson - initial implementation review and ongoing maintenance
 *******************************************************************************/

package com.liferay.ide.portlet.ui.navigator;

import com.liferay.ide.portlet.ui.PortletUIPlugin;
import com.liferay.ide.ui.navigator.AbstractLabelProvider;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

/**
 * @author <a href="mailto:kamesh.sampath@hotmail.com">Kamesh Sampath</a>
 * @author Gregory Amerson
 */
public class PortletResourcesLabelProvider extends AbstractLabelProvider
{

    private final static String PORTLETS = "PORTLETS"; //$NON-NLS-1$
    private final static String PORTLET = "PORTLET"; //$NON-NLS-1$
    private final static String MODULES = "MODULES"; //$NON-NLS-1$

    public PortletResourcesLabelProvider()
    {
        super();
    }
    
    @Override
    protected void initalizeImageRegistry( ImageRegistry imageRegistry )
    {
        imageRegistry.put(
            PORTLETS,
            PortletUIPlugin.imageDescriptorFromPlugin( PortletUIPlugin.PLUGIN_ID, "icons/e16/portlets_16x16.png" ) ); //$NON-NLS-1$
        imageRegistry.put(
            PORTLET,
            PortletUIPlugin.imageDescriptorFromPlugin( PortletUIPlugin.PLUGIN_ID, "icons/e16/portlet_16x16.png" ) ); //$NON-NLS-1$
        imageRegistry.put(
            MODULES,
            PortletUIPlugin.imageDescriptorFromPlugin( PortletUIPlugin.PLUGIN_ID, "icons/e16/liferay_modules.png" ) ); //$NON-NLS-1$
    }

    @Override
    public Image getImage( Object element )
    {
        if( element instanceof PortletResourcesRootNode )
        {
            return getImageRegistry().get( MODULES );
        }
        else if( element instanceof PortletsNode )
        {
            return this.getImageRegistry().get( PORTLETS );
        }
        else if( element instanceof PortletNode )
        {
            return this.getImageRegistry().get( PORTLET );
        }

        return null;
    }

    @Override
    public String getText( Object element )
    {
        if( element instanceof PortletResourcesRootNode )
        {
            return Msgs.liferayPortletResources;
        }
        else if( element instanceof PortletsNode )
        {
            return Msgs.portlets;
        }
        else if( element instanceof PortletNode )
        {
            PortletNode portletNode = (PortletNode) element;

            return portletNode.getName();
        }

        return null;
    }

    private static class Msgs extends NLS
    {
        public static String liferayPortletResources;
        public static String portlets;

        static
        {
            initializeMessages( PortletResourcesLabelProvider.class.getName(), Msgs.class );
        }
    }
}
