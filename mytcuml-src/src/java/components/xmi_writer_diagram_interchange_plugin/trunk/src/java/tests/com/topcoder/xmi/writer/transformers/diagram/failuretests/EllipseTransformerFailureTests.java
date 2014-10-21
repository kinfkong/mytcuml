/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import com.topcoder.diagraminterchange.Ellipse;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.EllipseTransformer;


/**
 * <p>
 * Failure tests for class EllipseTransformer. Tests the exceptions in invalid condition.
 * </p>
 *
 * @author magicpig
 * @version 1.0
 */
public class EllipseTransformerFailureTests extends TransformerFailureBase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = new Ellipse();
        suhClassName = "EllipseTransformerFailureTests";
        this.instance = new EllipseTransformer();
    }
}
