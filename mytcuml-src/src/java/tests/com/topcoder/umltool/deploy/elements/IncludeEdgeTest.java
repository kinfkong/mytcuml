/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.DiagramType;

/**
 * <p>
 * Tests for adding, removing, and persistence for include edge.
 * </p>
 * @author ly
 * @version 1.0
 */
public class IncludeEdgeTest extends EdgeTest {

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setDiagramType(DiagramType.USECASE);
        super.setStartNodetype(UseCaseNode.class);
        super.setEndNodetype(UseCaseNode.class);
        super.setType(IncludeEdge.class);
        super.setUp();
    }

}
