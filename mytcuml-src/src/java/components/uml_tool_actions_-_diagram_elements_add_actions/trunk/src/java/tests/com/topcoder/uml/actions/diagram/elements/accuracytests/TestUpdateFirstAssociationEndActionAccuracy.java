/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateFirstAssociationEndAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.AssociationCompartmentExtractor;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>UpdateFirstAssociationEnd </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestUpdateFirstAssociationEndActionAccuracy extends TestCase {

    /**
     * Test the constructor.
     *
     */
    public void testUpdateFirstAssociationEndAction() {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();

        AssociationCompartmentExtractor extractor = new AssociationCompartmentExtractor(edge);

        Dimension d = new Dimension();
        d.setHeight(new Double(555));
        d.setWidth(new Double(5555));

        GraphNode firstAssociationEndNode = new GraphNode();
        firstAssociationEndNode.setSemanticModel(HelperUtil.createUmlSemanticModel(new AssociationEndImpl()));
        firstAssociationEndNode.setSize(d);

        UpdateFirstAssociationEndAction action = new UpdateFirstAssociationEndAction(extractor,
                firstAssociationEndNode);

        assertNotNull("The UpdateFirstAssociationEndAction should be created.", action);
    }

    /**
     * Test method <code> execute </code>>
     *
     * @throws Exception to junit.
     */
    public void testExecute() throws Exception {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();

        AssociationCompartmentExtractor extractor = new AssociationCompartmentExtractor(edge);

        Dimension d = new Dimension();
        d.setHeight(new Double(555));
        d.setWidth(new Double(5555));

        GraphNode firstAssociationEndNode = new GraphNode();
        firstAssociationEndNode.setSemanticModel(HelperUtil.createUmlSemanticModel(new AssociationEndImpl()));
        firstAssociationEndNode.setSize(d);

        UpdateFirstAssociationEndAction action = new UpdateFirstAssociationEndAction(extractor,
                firstAssociationEndNode);

        assertNotNull("The UpdateFirstAssociationEndAction should be created.", action);

        // update the firstAssociationEnd node.
        action.execute();

        GraphNode node = (GraphNode) action.getExtractor().extractFirstAssociationEnd();
        Dimension size = node.getSize();

        assertEquals("The height should be 555.", 555.0, size.getHeight());
        assertEquals("The width should be 5555.", 5555.0, size.getWidth());
    }
}