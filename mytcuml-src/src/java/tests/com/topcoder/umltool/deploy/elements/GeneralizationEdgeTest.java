/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.umltool.deploy.DiagramType;

/**
 * <p>
 * Tests for adding, removing, and persistence for generalization edge.
 * </p>
 * @author ly
 * @version 1.0
 */
public class GeneralizationEdgeTest extends EdgeTest {

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setDiagramType(DiagramType.CLASS);
        super.setStartNodetype(ClassNode.class);
        super.setEndNodetype(ClassNode.class);
        super.setType(GeneralizationEdge.class);
        super.setUp();
    }

}
