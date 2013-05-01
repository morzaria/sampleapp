package org.cytoscape.sample.internal;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.CyApplicationManager;

import org.cytoscape.sample.internal.compute;

import org.cytoscape.application.swing.CyAction;

import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.model.CyNetwork;

import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;
import java.util.*;


public class CyActivator extends AbstractCyActivator {

	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		CySwingApplication cytoscapeDesktopService = getService(bc,CySwingApplication.class);
		CyNetworkManager manager = getService(bc, CyNetworkManager.class);
		Set<CyNetwork> networkSet = new HashSet<CyNetwork>();
		networkSet=manager.getNetworkSet();
		compute c = new compute(cytoscapeDesktopService,networkSet);
		registerService(bc,c,CyAction.class, new Properties());
	}
}

