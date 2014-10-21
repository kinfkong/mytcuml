/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveAssociationEdgeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveAssociationEdgeActionTest extends TestCase {

    /**
     * Test method for 'RemoveAssociationEdgeAction(MainFrame, AssociationEdge)'. The instance should be created
     * successfully.
     */
    public void testRemoveAssociationEdgeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        UseCaseNode startNode = TestHelper.addUseCaseNode();
        UseCaseNode targetNode = TestHelper.addUseCaseNode();
        AddAssociationEdgeAction addAction = new AddAssociationEdgeAction(mainFrame, view, TestHelper.START,
                TestHelper.END, "AssociationEdge", startNode, targetNode);
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        AssociationEdge edge = (AssociationEdge) addAction.getEdge();
        RemoveAssociationEdgeAction removeAction = new RemoveAssociationEdgeAction(TestHelper.getMainFrame(), edge);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
