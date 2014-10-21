/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Class_Edges Version 1.0 StressTest.
 *
 * @ AggregationStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.classedges.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.classedges.Aggregation;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Point;


/**
 * <p>
 * This class tests the <code>Aggregation</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>Aggregation</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class AggregationStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 360;

    /**
     * <p>The instance of <code>Aggregation</code> for test.</p>
     */
    private Aggregation arrow = null;

    /**
     * <p>Return test suite of <code>AggregationStressTest</code>.</p>
     *
     * @return Test suite of <code>AggregationStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(AggregationStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        // create some GraphNode here.
        GraphNode node1 = new GraphNode();
        GraphNode node2 = new GraphNode();
        // create Aggregation here.
        arrow = new Aggregation(new TextField(node1), new TextField(node2));
    }

    /**
     * <p>
     * Basic stress test of <code>contains(int x, int y)</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testAggregation_contains() throws Exception {
        arrow.setEndingPoint(new Point(30, 25));

        // rotate the arrow 0 -270 degree.
        for (int i = 0; i < 270; i++) {
            double angle = (Math.PI * i) / LOOPTIMES;
            arrow.setAngle(angle);

            for (int j = 7; j < 100; j++) {
                assertTrue("The contains method is incorrect.",
                    StressTestHelper.checkForEqual(arrow.contains(j, j + 10),
                        StressTestHelper.diamondContains(j, j + 10, 30, 25,
                            angle)));
            }
        }
    }
}
