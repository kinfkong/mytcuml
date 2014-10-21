package com.topcoder.gui.diagramviewer.uml.classelements.failuretests.event;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.failuretests.FailureTestHelper;

/**
 * Failure tests for EdgeAddEvent class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class EdgeAddEventFailureTests extends TestCase {
    /**
     * The Location instance for testing.
     */
    private Point location;

    /**
     * An instance of ClassNode for testing.
     */
    private ClassNode classNode;

    /**
     * Sets up test environment.
     * 
     * @throws Exception
     *             to junit
     */
    public void setUp() throws Exception {
        super.setUp();
        location = new Point(10, 10);

        GraphNode graphNode = FailureTestHelper.createClassGraphNode(new Point(50, 50), new Dimension(20, 20), false,
                false);
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = FailureTestHelper.createProperties();

        classNode = new ClassNode(graphNode, properties);
    }

    /**
     * Tests the constructor EdgeAddEvent(Node, Point, boolean) with null node, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullNode() throws Exception {
        try {
            new EdgeAddEvent(null, location, false);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor EdgeAddEvent(Node, Point, boolean) with null location, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullLocation() throws Exception {
        try {
            new EdgeAddEvent(classNode, null, false);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
