/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.elementtransformers;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.w3c.dom.Node;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.xmi.writer.XMITransformException;

/**
 * <p>
 * Unit tests for {@link GraphConnectorTransformer} class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphConnectorTransformerTest extends TransformerTestCase {

    /**
     * <p>
     * The Object instance used for testing.
     * </p>
     */
    private GraphConnector element;

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(GraphConnectorTransformerTest.class);
    }

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        element = createGraphConnector();
        transformer = new GraphConnectorTransformer();

    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        super.tearDown();
        element = null;
        transformer = null;
    }


    /**
     * <p>
     * Test constructor for 'GraphConnectorTransformer()' for accuracy.
     * </p>
     *
     * <p>
     * Verify : GraphConnectorTransformer() is correct.
     * </p>
     */
    public void testGraphConnectorTransformer() {
        assertNotNull("Fail to create a GraphConnectorTransformer instance.", transformer);
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document, Diagram2XMITransformer)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that Object is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformWithNullObject() throws Exception {
        try {
            transformer.transform(null, document, d2XMITransformer);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document, Diagram2XMITransformer)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that Object is not of <code>Property</code> type and expects ClassCastException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformWithObjectCannotCast() throws Exception {
        try {
            transformer.transform(new Object(), document, d2XMITransformer);
            fail("ClassCastException is expected.");
        } catch (ClassCastException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document, Diagram2XMITransformer)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that Document is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformWithNullDocument() throws Exception {
        try {
            transformer.transform(element, null, d2XMITransformer);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document, Diagram2XMITransformer)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that Diagram2XMITransformer caller is null and expects IllegalArgumentException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformWithNullCaller() throws Exception {
        try {
            transformer.transform(element, document, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }


    /**
     * <p>
     * Test method for 'transform(Object, Document, Diagram2XMITransformer)' for accuracy.
     * </p>
     *
     * <p>
     * Verify : transform(Object, Document, Diagram2XMITransformer) is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransform() throws Exception {
        Node node = transformer.transform(element, document, d2XMITransformer);
        validateGraphConnector(node, element);
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document, Diagram2XMITransformer)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the GraphConnector is empty and verifies transform(Object, Document,
     * Diagram2XMITransformer).
     * is correct.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformWithEmptyGraphConnector() throws Exception {
        element = createEmptyGraphConnector();
        transformers.put(Point.class.getName(), new PointTransformer());
        Node node = transformer.transform(element, document, d2XMITransformer);
        validateGraphConnector(node, element);
    }

    /**
     * <p>
     * Test method for 'transform(Object, Document, Diagram2XMITransformer)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that could not find the Transformer for the Point class expects XMITransformException.
     * </p>
     * @throws Exception to Junit
     */
    public void testTransformWithoutPointTransformer() throws Exception {
        // remove Transformer for Point
        transformers.remove(Point.class.getName());
        try {
            transformer.transform(element, document, d2XMITransformer);
            fail("XMITransformException is expected.");
        } catch (XMITransformException e) {
            // good
        }
    }
}