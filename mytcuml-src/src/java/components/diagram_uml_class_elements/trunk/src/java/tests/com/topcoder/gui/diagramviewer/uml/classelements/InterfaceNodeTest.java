/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;
import com.topcoder.uml.model.core.Classifier;

/**
 * <p>
 * Test the functionality of <code>InterfaceNode</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InterfaceNodeTest extends JFCTestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>InterfaceNode</code> for testing. */
    private InterfaceNode interfaceNode;

    /** A GraphNode for <code>InterfaceNode</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private Map<String, String> properties;

    /** Boundary changed listener for <code>InterfaceNode</code>. */
    private MockedBoundaryChangedListener boundChangedListener;

    /** An instance of JFC <code>TestHelper</code> for testing. */
    private TestHelper helper = null;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        helper = new JFCTestHelper();

        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, true, false);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();

        interfaceNode = new InterfaceNode(graphNode, properties);

        interfaceNode.setAttributesOperationsPopup(new TextInputBox());

        boundChangedListener = new MockedBoundaryChangedListener();
    }

    /**
     * Test method for 'InterfaceNode(GraphNode, Map)'. The instance should be created successfully.
     */
    public void testInterfaceNode_Accuracy() {
        assertNotNull("Test method for 'InterfaceNode(GraphNode, Map<String, String>)' failed.", interfaceNode);
    }

    /**
     * Test method for 'InterfaceNode(GraphNode, Map)'. The first argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testInterfaceNode_null_1() {
        try {
            new InterfaceNode(null, properties);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'InterfaceNode(GraphNode, Map)'. The second argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testInterfaceNode_null_2() {
        try {
            new InterfaceNode(graphNode, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'notifyGraphNodeChange(String)'. The node should change accordingly.
     */
    public void testNotifyGraphNodeChange() {
        Classifier classifier = (Classifier) TestUtil.getElement(graphNode);
        classifier.addFeature(TestUtil.createOperation("operation_4", "void", "parameter_4", "double"));

        Rectangle oldBound = interfaceNode.getSelectionBound();
        interfaceNode.addBoundaryChangedListener(boundChangedListener);
        interfaceNode.notifyGraphNodeChange("New operation added.");
        Rectangle newBound = interfaceNode.getSelectionBound();
        assertTrue("The size should increase.", newBound.height > oldBound.height);
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testconsumeEvent_null() {
        assertFalse("Null event should be ignored.", interfaceNode.consumeEvent(null));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MousePressed event, should be consumed.
     */
    public void testconsumeEvent_Valid_MousePressed() {
        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertTrue("Valid MousePressed event should be consumed.", interfaceNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MousePressed event, should not be
     * consumed.
     */
    public void testconsumeEvent_Invalid_MousePressed() {
        MouseEvent event = new MouseEvent(TestUtil.createAbstractionEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertFalse("Invalid MousePressed event should not be consumed.", interfaceNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MouseReleased event, should be consumed.
     */
    public void testconsumeEvent_Valid_MouseReleased() {
        MouseEvent event = new MouseEvent(TestUtil.createAbstractionEdge(), MouseEvent.MOUSE_RELEASED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertTrue("Valid MouseReleased event should be consumed.", interfaceNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MouseReleased event, should not be
     * consumed.
     */
    public void testconsumeEvent_Invalid_MouseReleased() {
        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_RELEASED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertFalse("Invalid MouseReleased event should not be consumed.", interfaceNode.consumeEvent(event));
    }

    /**
     * Test the GUI. The component should be displayed correctly.
     */
    public void testGUI() throws Exception {

        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
        // register the listener
        interfaceNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        interfaceNode.setName("InterfaceNode");
        interfaceNode.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(interfaceNode);

        JDialog dialog = new JDialog((JFrame) null, "InterfaceNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "InterfaceNode");
        InterfaceNode node = (InterfaceNode) finder.find(dialog, 0);
        assertNotNull("InterfaceNode component should be displayed", node);

        helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

        TextField nameCompartment = node.getNameCompartment();
        helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        sleep(100);
        dialog.dispose();
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        helper = null;

        graphNode = null;

        properties = null;

        interfaceNode = null;

        boundChangedListener = null;
    }
}
