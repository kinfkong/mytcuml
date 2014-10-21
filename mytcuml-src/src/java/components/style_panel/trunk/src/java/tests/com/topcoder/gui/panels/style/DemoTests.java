/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * The GraphNode instance for testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * The Polyline instance for testing.
     * </p>
     */
    private Polyline polyline;

    /**
     * <p>
     * The GraphEdge instance for testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.NAMESPACE, TestHelper.CONFIG_FILE);
        graphEdge = new GraphEdge();
        graphEdge.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode = new GraphNode();
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
        polyline = new Polyline();

    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(TestHelper.NAMESPACE);
        polyline = null;
        graphNode = null;
        graphEdge = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * This method shows the style panel with the default value specified and
     * all its functionality.
     * </p>
     */
    public void testStylePanelDefaultSpecified() {
        // Prepare style objects
        StyleObject styleObject1 = new GraphNodeStyleObjectAdapter(graphNode);
        StyleObject styleObject2 = new GraphEdgeStyleObjectAdapter(graphEdge);
        StyleObject styleObject3 = new PolylineStyleObjectAdapter(polyline);

        List<StyleObject> list = new ArrayList<StyleObject>();
        list.add(styleObject1);
        list.add(styleObject2);
        list.add(styleObject3);

		// use the horizontal layout
        StylePanel stylePanel = new StylePanel(true);

        // using default constructor
        stylePanel = new StylePanel();

        StyleListener theListener = new StyleListerImpl();
        stylePanel.addStyleListener(theListener);

        // set panel to display information about one style object
        stylePanel.setStyleObject(styleObject1);

        // after this style panel will contain styleObject1, and it supports all styles.
        // user can change any value. In event of change, style event will be sent theListener.

        // after this style event about font family change will be sent to theListener
        stylePanel.setFontFamilyStyle("Arial");

        // after this style event about font size change will be sent to theListener
        stylePanel.setFontSizeStyle(12);

        // after this style event about fill color change will be sent to theListener
        stylePanel.setFillColorStyle(Color.RED);

        // after this style event about outline color change will be sent to theListener
        stylePanel.setOutlineColorStyle(Color.BLUE);

        // after this style event about text color change will be sent to theListener
        stylePanel.setTextColorStyle(Color.ORANGE);

        // after this style event about size change will be sent to theListener
        stylePanel.setSizeStyle(new Dimension(10, 20));

        // after this style event about position change will be sent to theListener
        stylePanel.setPositionStyle(new Point(10, 20));

        // set panel to display information about all style object
        stylePanel.setStyleObjectList(list);

        // style panel will contain all styles that are related to the
        // objects in the list.
        // user can only change outline color.
        // In event of change, style event will be sent theListener.

        // after this style event about outline color change will be sent to theListener
        stylePanel.setOutlineColorStyle(Color.BLUE);
    }

    /**
     * <p>
     * This method shows the style panel with the namespace specified and
     * all its functionality.
     * </p>
     */
    public void testStylePanelNamespaceSpecified() {
        // Prepare style objects
        StyleObject styleObject1 = new GraphNodeStyleObjectAdapter(graphNode);
        StyleObject styleObject2 = new GraphEdgeStyleObjectAdapter(graphEdge);
        StyleObject styleObject3 = new PolylineStyleObjectAdapter(polyline);

        List<StyleObject> list = new ArrayList<StyleObject>();
        list.add(styleObject1);
        list.add(styleObject2);
        list.add(styleObject3);

		// using constructor with namespace and layout flag specified
        StylePanel stylePanel = new StylePanel(TestHelper.NAMESPACE, true);

        // using constructor with namespace specified
        stylePanel = new StylePanel(TestHelper.NAMESPACE);

        StyleListener theListener = new StyleListerImpl();
        stylePanel.addStyleListener(theListener);

        // set panel to display information about one style object
        stylePanel.setStyleObject(styleObject1);

        // after this style panel will contain styleObject1, and it supports all styles.
        // user can change any value. In event of change, style event will be sent theListener.

        // after this style event about font family change will be sent to theListener
        stylePanel.setFontFamilyStyle("Arial");

        // after this style event about font size change will be sent to theListener
        stylePanel.setFontSizeStyle(12);

        // after this style event about fill color change will be sent to theListener
        stylePanel.setFillColorStyle(Color.RED);

        // after this style event about outline color change will be sent to theListener
        stylePanel.setOutlineColorStyle(Color.BLUE);

        // after this style event about text color change will be sent to theListener
        stylePanel.setTextColorStyle(Color.ORANGE);

        // after this style event about size change will be sent to theListener
        stylePanel.setSizeStyle(new Dimension(10, 20));

        // after this style event about position change will be sent to theListener
        stylePanel.setPositionStyle(new Point(10, 20));

        // set panel to display information about all style object
        stylePanel.setStyleObjectList(list);

        // style panel will contain all styles that are related to the
        // objects in the list.
        // user can only change outline color.
        // In event of change, style event will be sent theListener.

        // after this style event about outline color change will be sent to theListener
        stylePanel.setOutlineColorStyle(Color.BLUE);
    }
}
