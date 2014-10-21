/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentRelationshipGraphEdgeAction;

/**
 * <p>
 * Set of accuracy tests for PasteCommentRelationshipGraphEdgeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteCommentRelationshipGraphEdgeActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Paste Comment Relationship GraphEdge";

    /**
     * Constructor under test PasteCommentRelationshipGraphEdgeAction().
     * Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testPasteCommentRelationshipGraphEdgeAction() throws Exception {
        // initialization
        AccuracyTestsHelper.loadConfiguration();
        // run successfully
        PasteCommentRelationshipGraphEdgeAction addCommentRelationshipGraphEdgeAction =
            new PasteCommentRelationshipGraphEdgeAction(AccuracyTestsHelper.getCommentRelationshipGraphEdge(),
                new GraphNode());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, addCommentRelationshipGraphEdgeAction
            .getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}