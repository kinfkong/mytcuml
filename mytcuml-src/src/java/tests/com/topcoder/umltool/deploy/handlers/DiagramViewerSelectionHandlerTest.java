/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Rectangle;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.event.SelectionEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>DiagramViewerSelectionHandlerTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class DiagramViewerSelectionHandlerTest extends TestCase {
    /** Main frame window for testing. */
    private MainFrame MAINFRAME = TestHelper.getMainFrame();

    /** An instance of UseCaseNode for testing. */
    private UseCaseNode node;

    /** An instance of GraphNode for testing. */
    private GraphNode graphNode;

    /** An instance of ModelElement for testing. */
    private ModelElement modelElement;

    /** An instance of DiagramView for testing. */
    private DiagramView diagramView;

    /** An instance of <code>DiagramViewerSelectionHandler</code> for testing. */
    private DiagramViewerSelectionHandler handler;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        handler = new DiagramViewerSelectionHandler(MAINFRAME);
        node = TestHelper.addUseCaseNode();
        graphNode = node.getGraphNode();
        modelElement = DeployHelper.getElement(graphNode);
        modelElement.setName("test");
        MAINFRAME.getDocumentTree().updateTree();
        MAINFRAME.getDocumentTree().setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);
        diagramView = TestHelper.getDiagramView(DiagramType.USECASE);
        diagramView.setSize(600, 600);
        MAINFRAME.getDiagramViewer().openDiagramView(diagramView.getDiagram());
    }

    /**
     * Test method for 'DiagramViewerSelectionHandler(MainFrame)'.The instance should be created successfully.
     */
    public void testDiagramViewerSelectionHandler_Accuracy() {
        assertNotNull("Test method for 'DiagramViewerSelectionHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'DiagramViewerSelectionHandler(MainFrame)'.The argument is null, IllegalArgumentException should
     * be thrown.
     */
    public void testDiagramViewerSelectionHandler_null() {
        try {
            new DiagramViewerSelectionHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'selectionRectangleChanged(SelectionEvent)'.Valid selection event is given, should perform
     * successfully. Selects all elements in the diagram view.
     */
    public void testSelectionRectangleChanged_Accuracy1() {
        SelectionEvent event = new SelectionEvent(diagramView, new Rectangle(diagramView.getWidth(), diagramView
                .getHeight()));
        handler.selectionRectangleChanged(event);
        assertEquals("The document tree node corresponding to node should be selected", (MAINFRAME.getDocumentTree()
                .getSelectedTreeNodes())[0].getNodeObject(), graphNode);
    }

    /**
     * Test method for 'selectionRectangleChanged(SelectionEvent)'.Valid selection event is given, should perform
     * successfully. Selects no element.
     */
    public void testSelectionRectangleChanged_Accuracy2() {
        SelectionEvent event = new SelectionEvent(diagramView, new Rectangle(0, 0));
        handler.selectionRectangleChanged(event);
        assertEquals("The document tree node corresponding to node should be selected", (MAINFRAME.getDocumentTree()
                .getSelectedTreeNodes())[0].getNodeObject(), diagramView.getDiagram());
    }

    /**
     * Test method for 'selectionRectangleChanged(SelectionEvent)'.Null event is given, IllegalArgumentException should
     * be thrown.
     */
    public void testSelectionChanged_null() {
        try {
            handler.selectionRectangleChanged(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        MAINFRAME.getDocumentTree().updateTree();

        diagramView.remove(node);

        diagramView.getDiagram().removeContained(node.getGraphNode());

        handler = null;

        diagramView = null;

        node = null;

        graphNode = null;

        modelElement = null;
    }

}
