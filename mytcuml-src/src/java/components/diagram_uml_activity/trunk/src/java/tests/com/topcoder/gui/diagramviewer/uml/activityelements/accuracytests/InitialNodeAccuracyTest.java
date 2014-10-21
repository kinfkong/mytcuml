/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import javax.swing.JFrame;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.InitialNode;

/**
 * Accuracy tests for the class: InitialNode.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class InitialNodeAccuracyTest extends AccuracyBase {

    /**
     * Represents the base node for accuracy tests.
     */
    private BaseNode node;

    /**
     * Represents the graph node.
     */
    private GraphNode graphNode;

    /**
     * Represents the properties.
     */
    private Map<String, String> properties;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {

        graphNode = createGraphNode(
            "InitialNode", 
            new Point(100, 150), 
            new Dimension(20, 20), 
            "000000");
        
        properties = createProperties();

        node = new InitialNode(
            graphNode, 
            properties, 
            new Point(5, 5), 
            new Rectangle(5, 5, 25, 25));
    }

    /**
     * Tests the constructor: InitialNode.
     * 
     */
    public void testInitialNode() {
        assertNotNull("The instance cannot be created.", node);
    }

    /**
     * Tests the method: Contains.
     * 
     */
    public void testContains_True() {
        Point location = node.getSelectionBound().getLocation();
        int x = location.x + (int) Math.round(graphNode.getSize().getWidth() / 2);
        int y = location.y + (int) Math.round(graphNode.getSize().getHeight() / 2);
        assertTrue("The given point should be contained.", node.contains(x, y));
    }

    /**
     * Tests the method: Contains.
     */
    public void testContains_False() {
        assertFalse("This point should be out of the shape.", node.contains(60, 160));
    }

    /**
     * Tests the method: getPreferredGraphNodeSize().
     */
    public void testGetPreferredGraphNodeSize() {

        assertNotNull("The graph node size should be got correctly.", node.getPreferredGraphNodeSize());
    }

    /**
     * Tests the method: notifyGraphNodeChange.
     *
     */
    public void testNotifyGraphNodeChangeAccuracy() {

        int with0 = node.getSelectionBound().width;

        addStereotype(graphNode, "AnotherStereotype");

        node.notifyGraphNodeChange("Stereotype for accuracy tests.");

        assertTrue("The method does not work properly.", node.getSelectionBound().width == with0);
    }

    /**
     * The UI test for the class: InitialNode.
     */
    public static void main(String[] args) {

        GraphNode graphNode = createGraphNode(
            "InitialNode", 
            new Point(100, 100), 
            new Dimension(145, 30), 
            "00FF00");
       

        BaseNode node = new InitialNode(
            graphNode, 
            createProperties(), 
            new Point(5, 5), 
            new Rectangle(5, 5, 75, 75));

        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(node);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}