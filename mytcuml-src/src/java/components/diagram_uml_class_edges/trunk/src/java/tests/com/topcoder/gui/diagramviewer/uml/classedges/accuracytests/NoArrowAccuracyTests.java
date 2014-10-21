/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests;

import com.topcoder.gui.diagramviewer.uml.classedges.NoArrow;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.TestCase;

import java.awt.Point;


/**
 * <p>Test the accuracy of NoArrow class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class NoArrowAccuracyTests extends TestCase {
    /** <code>NoArrow</code> instance used for testing. */
    private NoArrow edgeEnding;

    /** <code>TextField</code> instance representing name compartment. */
    private TextField name;

    /** <code>TextField</code> instance representing multiplicity compartment. */
    private TextField multiplicity;

    /**
     * <p>Sets up test environment.</p>
     */
    protected void setUp() {
        name = AccuracyTestHelper.createTextFiled("name");
        multiplicity = AccuracyTestHelper.createTextFiled("1..n");
        edgeEnding = new NoArrow(name, multiplicity);
        edgeEnding.setAngle(Math.toRadians(90));
        edgeEnding.setEndingPoint(new Point(20, 20));
    }

    /**
     * <p>Tears down test environment.</p>
     */
    protected void tearDown() {
        name = null;
        multiplicity = null;
        edgeEnding = null;
    }

    /**
     * <p>Accuracy test of constructor . Should create the instance successfully.</p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", edgeEnding);
    }
}
