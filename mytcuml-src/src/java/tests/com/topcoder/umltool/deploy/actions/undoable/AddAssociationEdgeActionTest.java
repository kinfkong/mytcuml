/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>AddAssociationEdgeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddAssociationEdgeActionTest extends TestCase {

    /** An instance of <code>AddAssociationEdgeAction</code> for testing. */
    private AddAssociationEdgeAction action;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        UseCaseNode startNode = TestHelper.addUseCaseNode();
        UseCaseNode targetNode = TestHelper.addUseCaseNode();
        action = new AddAssociationEdgeAction(TestHelper.getMainFrame(),
                TestHelper.getDiagramView(DiagramType.USECASE), TestHelper.START, TestHelper.END,
                "AddAssociationEdgeAction", startNode, targetNode);
    }

    /**
     * Test method for 'AddAssociationEdgeAction(MainFrame, DiagramView, Point, Dimension, String)'. The instance should
     * be created successfully.
     */
    public void testAddAssociationEdgeAction_1() {
        assertNotNull(
                "Test method for 'AddAssociationEdgeAction(MainFrame, DiagramView, Point, Dimension, String)' failed.",
                action);
    }

    /**
     * Test method for 'AddAssociationEdgeAction(MainFrame, DiagramView, Point, Dimension, String, NodeContainer)'. The
     * instance should be created successfully.
     */
    public void testAddAssociationEdgeAction_2() {
        UseCaseNode startNode = TestHelper.addUseCaseNode();
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        AddAssociationEdgeAction action = new AddAssociationEdgeAction(mainFrame, view, TestHelper.START,
                TestHelper.END, "AddAssociationEdgeAction", startNode, new AddUseCaseNodeAction(mainFrame, view,
                        TestHelper.POSITION, TestHelper.SIZE, "Use Case"));
        assertNotNull(
                "Test method for 'AddAssociationEdgeAction(MainFrame, DiagramView, Point, Dimension, String, NodeContainer)' failed.",
                action);
    }

    /**
     * Test method for 'createModelElement()'. The model element should have been created.
     */
    public void testCreateModelElement() {
        action.createModelElement();
        Association association = (Association) TestHelper.getPrivateField(AddAssociationEdgeAction.class, action,
                "association");
        assertNotNull("The model element should have been created.", association);
    }

    /**
     * Test method for 'createGraphNode()'. The graph node should have been created.
     */
    public void testCreateGraphNode() {
        action.createModelElement();
        action.createGraphEdge();
        GraphEdge graphEdge = (GraphEdge) TestHelper.getPrivateField(AddAssociationEdgeAction.class, action,
                "graphEdge");
        assertNotNull("The graph node should have been created.", graphEdge);
    }

    /**
     * Test method for 'createNode()'. The node should have been created.
     */
    public void testCreateNode() {
        action.createModelElement();
        action.createGraphEdge();
        action.createEdge();
        Edge edge = (Edge) TestHelper.getPrivateField(AddEdgeAction.class, action, "edge");
        assertNotNull("The node should have been created.", edge);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
