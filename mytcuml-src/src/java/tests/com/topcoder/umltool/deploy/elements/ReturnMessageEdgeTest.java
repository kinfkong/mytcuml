/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ReturnMessageEdge;
import com.topcoder.umltool.deploy.DiagramType;

/**
 * <p>
 * Tests for adding, removing, and persistence for return message edge.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ReturnMessageEdgeTest extends EdgeTest {

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setDiagramType(DiagramType.SEQUENCE);
        super.setStartNodetype(ObjectNode.class);
        super.setEndNodetype(ObjectNode.class);
        super.setType(ReturnMessageEdge.class);
        super.setUp();
    }
}
