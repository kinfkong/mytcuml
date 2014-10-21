/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedListener;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

/**
 * <p>
 * Test the functionality of <code>AcceptEventAction</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AcceptEventActionTest extends JFCTestCase {

    /** An instance of <code>AcceptEventAction</code> for testing. */
    private AcceptEventAction acceptEventAction;

    /** A GraphNode for <code>AcceptEventAction</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private final Map<String, String> properties = new HashMap<String, String>();

    /** Relative position of GraphNode. */
    private Point position;

    /** Selection bound of <code>AcceptEventAction</code>. */
    private Rectangle bound = new Rectangle();

    /** Boundary changed listener for <code>AcceptEventAction</code>. */
    private MockedBoundaryChangedListener listener;

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

        ModelElement state = new SimpleStateImpl();
        state.addTaggedValue(TestUtil.createTagValue("AcceptEventAction", "True"));
        // set nameCompartment text
        state.setName("NameCompartment");
        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("StereotypeCompartment");
        state.addStereotype(stereotypeOne);

        graphNode = TestUtil.createGraphNodeForActivityState(state);
        graphNode.setPosition(TestUtil.createPoint(100, 100));
        graphNode.setSize(TestUtil.createDimension(140, 30));
        graphNode.setContainer(new GraphNode());
        TestUtil.addPropertiesToGraphNode(graphNode);

        properties.put("FillColor", "fill_color");
        properties.put("StrokeColor", "stroke_color");
        properties.put("FontColor", "font_color");
        properties.put("FontFamily", "font_family");
        properties.put("FontStyle", "font_style");
        properties.put("FontSize", "font_size");

        position = new Point(SelectionCorner.DEFAULT_RADIUS * 2, SelectionCorner.DEFAULT_RADIUS * 2);

        acceptEventAction = new AcceptEventAction(graphNode, properties, position, bound);

        listener = new MockedBoundaryChangedListener();
    }

    /**
     * Test method for 'AcceptEventAction(GraphNode, Map, Point, Rectangle)'. The instance should be created
     * successfully.
     */
    public void testAcceptEventAction_Accuracy() {
        assertNotNull("Test method for 'AcceptEventAction(GraphNode, Map<String, String>, Point, Rectangle)' failed.",
                acceptEventAction);
    }

    /**
     * Test method for 'AcceptEventAction(GraphNode, Map, Point, Rectangle)'. The first argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAcceptEventAction_null_1() {
        try {
            new AcceptEventAction(null, properties, position, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'AcceptEventAction(GraphNode, Map, Point, Rectangle)'. The second argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAcceptEventAction_null_2() {
        try {
            new AcceptEventAction(graphNode, null, position, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'AcceptEventAction(GraphNode, Map, Point, Rectangle)'. The third argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAcceptEventAction_null_3() {
        try {
            new AcceptEventAction(graphNode, properties, null, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'AcceptEventAction(GraphNode, Map, Point, Rectangle)'. The fourth argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAcceptEventAction_null_4() {
        try {
            new AcceptEventAction(graphNode, properties, position, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'AcceptEventAction(GraphNode, Map, Point, Rectangle)'. The properties map is empty,
     * IllegalArgumentException should be thrown.
     */
    public void testAcceptEventAction_contain_null() {
        try {
            Map<String, String> map = properties;
            map.put("sfd", null);
            new AcceptEventAction(graphNode, map, position, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'AcceptEventAction(GraphNode, Map, Point, Rectangle)'. Bad GraphNode structure is given,
     * IllegalArgumentException should be thrown.
     */
    public void testAcceptEventAction_Invalid_GraphNode() {
        try {
            GraphNode node = TestUtil.createGraphNodeForActivityState(new ActionStateImpl());
            new AcceptEventAction(node, properties, position, bound);
            fail("IllegalGraphElementException should be thrown.");
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        } catch (IllegalGraphElementException e) {
            // Success
        }
    }

    /**
     * Test method for 'contains(int, int)'. Inner point is given, should be true.
     */
    public void testContains_True() {
        int x = acceptEventAction.getSelectionBound().x + (int) Math.round(graphNode.getSize().getWidth() / 2);
        int y = acceptEventAction.getSelectionBound().y + (int) Math.round(graphNode.getSize().getHeight() / 2);
        assertTrue("The given point should be contained.", acceptEventAction.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. Outer point is given, should be false.
     */
    public void testContains_False_1() {
        int x = -10;
        int y = -10;
        assertFalse("The given point should not be contained.", acceptEventAction.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. A point between selection bound and graph node is given, should be false.
     */
    public void testContains_False_2() {
        int x = acceptEventAction.getSelectionBound().x / 2;
        int y = acceptEventAction.getSelectionBound().y / 2;
        assertFalse("The given point should not be contained.", acceptEventAction.contains(x, y));
    }

    /**
     * Test method for 'notifyGraphNodeChange(String)'. The node should change accordingly.
     */
    public void testNotifyGraphNodeChange() {
        Dimension d = graphNode.getSize();
        d.setWidth(d.getWidth() + 10);
        graphNode.setSize(d);
        acceptEventAction.addBoundaryChangedListener(listener);
        acceptEventAction.notifyGraphNodeChange("GraphNode's width increased.");
        int changed = listener.getNewBound().width - listener.getOldBound().width;
        assertEquals("The changed size of node should be equal to graphNode's.", changed, 10);
    }

    /**
     * Test method for 'getPreferredGraphNodeSize()'. The preferred graph node size should be got correctly.
     */
    public void testGetPreferredGraphNodeSize() {
        assertNotNull("The graph node size should be got correctly.", acceptEventAction.getPreferredGraphNodeSize());
    }

    /**
     * Test method for 'getPreferredGraphNodeSize()'. The default graph node size should be got correctly.
     */
    public void testGetPreferredGraphNodeSize_DefaultSize() {
        acceptEventAction.getStereotypeCompartment().setVisible(false);
        acceptEventAction.getNameCompartment().setVisible(false);
        assertEquals("The default graph node size should be got correctly.", acceptEventAction
                .getPreferredGraphNodeSize(), TestUtil.getPrivateField(AcceptEventAction.class, acceptEventAction,
                "DEFAULT_SIZE"));
    }

    /**
     * Test the GUI. The component should be displayed correctly.
     * @throws Exception
     *             to jfcunit
     */
    public void testGUI() throws Exception {

        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewValue());
            }
        };
        // register the listener
        acceptEventAction.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        acceptEventAction.setName("AcceptEventAction");
        acceptEventAction.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        Diagram diagram = new Diagram();
        diagram.setName("Activity Diagram");
        com.topcoder.diagraminterchange.Dimension dimension =
            new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        com.topcoder.diagraminterchange.Point point =
            new com.topcoder.diagraminterchange.Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        DiagramView view = viewer.openDiagramView(diagram);
        view.add(acceptEventAction);

        view.addMouseListener(acceptEventAction);

        JDialog dialog = new JDialog((JFrame) null, "AcceptEventAction", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);

        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "AcceptEventAction");
        AcceptEventAction action = (AcceptEventAction) finder.find(dialog, 0);
        assertNotNull("AcceptEventAction component should be displayed", action);

        helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

        TextField nameCompartment = action.getNameCompartment();
        helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        sleep(100);
        dialog.dispose();
    }
}
