package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;


import javax.swing.ImageIcon;

import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import javax.swing.JOptionPane;
import java.util.*;
public class compute extends AbstractCyAction {

	private CySwingApplication desktopApp;
	private CyNetwork network;
	public compute(CySwingApplication desktopApp,Set<CyNetwork> networkSet){
		// Add a menu item -- Plugins->sample03
		super("sample03");
		setPreferredMenu("Apps");

		ImageIcon icon = new ImageIcon(getClass().getResource("/images/tiger.jpg"));
		ImageIcon smallIcon = new ImageIcon(getClass().getResource("/images/tiger_small.jpg"));
		for (Iterator<CyNetwork> it = networkSet.iterator();it.hasNext(); ) {
        		network  = it.next();
			if(network!=null)
        			System.out.println("got network");
    		}
		
		// Add image icons on tool-bar and menu item
		putValue(LARGE_ICON_KEY, icon);
		putValue(SMALL_ICON, smallIcon);
		
		this.desktopApp = desktopApp;
	}
		
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {
		inDegree(network);
		
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @return  DOCUMENT ME!
	 */
	public boolean isInToolBar() {
		return true;
	}

	/**
	 *  DOCUMENT ME!
	 *
	 * @return  DOCUMENT ME!
	 */
	public boolean isInMenuBar() {
		return true;
	}
	//Computes the indegree of a node
	void inDegree(CyNetwork network)
	{
		List<CyEdge> edgelist=new ArrayList<CyEdge>();
		int i=0;
		for(CyNode node : network.getNodeList())
		{
			for(CyEdge edge : network.getAdjacentEdgeList(node,CyEdge.Type.DIRECTED))
			{
				if(node==edge.getTarget())
				{
					i++;
				}	
			
			}
			JOptionPane.showMessageDialog(null,"In Degree of "+node+" = "+i);
			edgelist.clear();
			i=0;
	
		}
	
	}
	void outDegree(CyNetwork network)
	{
		List<CyEdge> edgelist=new ArrayList<CyEdge>();
		int i=0;
		for(CyNode node : network.getNodeList())
		{
			for(CyEdge edge : network.getAdjacentEdgeList(node,CyEdge.Type.DIRECTED))
			{
				if(node==edge.getSource())
				{
					i++;
				}	
			
			}
			JOptionPane.showMessageDialog(null,"Out Degree of "+node+" = "+i);
			edgelist.clear();
			i=0;
	
		}
	
	}
}
