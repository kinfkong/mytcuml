/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.topcoder.diagraminterchange.Image;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.LeafElementTransformer;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>LeafElementTransformer</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestLeafElementTransformerAccuracy extends TestCase {
	/**
     * Represents the DiagramInterchangeElementTransformer instance for testing.
     */
	private DiagramInterchangeElementTransformer transformer = new LeafElementTransformer();

	/**
     * Represents the document instance for testing.
     */
	private Document document;

	/**
     * Represents the Diagram2XMITransformer instance for testing.
     */
	private static Diagram2XMITransformer caller = null;

	/**
     * The transformers map for XMIWriter object.
     */
	private final Map<TransformerType, XMITransformer> transformerMap = new HashMap<TransformerType, XMITransformer>();

	/**
     * Sets up the fixture.
     *
     * @throws Exception
     *             throws to junit.
     * @see junit.framework.TestCase#setUp()
     */
	public void setUp() throws Exception {
		caller = Util.createDiagram2XMITransformer();

		transformerMap.put(TransformerType.Diagram, caller);
		transformerMap.put(TransformerType.Model, caller);
		transformerMap.put(TransformerType.ActivityGraph, caller);
		transformerMap.put(TransformerType.Header, caller);

		caller.setXMIWriter(new XMIWriter(new UMLModelManager(), transformerMap));
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	/**
     * Tear down the environment.
     *
     * @throws Exception
     *             to junit.
     */
	public void tearDown() throws Exception {
		caller = null;
		document = null;
	}

	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_1() throws Exception {
		Image element = new Image();
		element.addProperty(new Property());

		Element node = (Element) transformer.transform(element, document, caller);

        assertEquals("the node name should  be UML:LeafElement", "UML:LeafElement", node.getNodeName());
        assertEquals("the visible attribute should be set", node.getAttribute("visible"), Boolean.toString(element
                .isVisible()));

        assertEquals("the return should be 1", 1, node.getElementsByTagName("UML:Property").getLength());
	}


	/**
     * Test the method transform.
     *
     * @throws Exception
     *             to junit.
     */
	public void testTransform_2() throws Exception {
		Image element = new Image();
		element.addProperty(new Property());

		Property p2 = new Property();
		p2.setKey("k");
		p2.setValue("value");

		element.addProperty(p2);

		Element node = (Element) transformer.transform(element, document, caller);

        assertEquals("the node name should  be UML:LeafElement", "UML:LeafElement", node.getNodeName());
        assertEquals("the visible attribute should be set", node.getAttribute("visible"), Boolean.toString(element
                .isVisible()));

        assertEquals("the return should be 2", 2, node.getElementsByTagName("UML:Property").getLength());
	}
}