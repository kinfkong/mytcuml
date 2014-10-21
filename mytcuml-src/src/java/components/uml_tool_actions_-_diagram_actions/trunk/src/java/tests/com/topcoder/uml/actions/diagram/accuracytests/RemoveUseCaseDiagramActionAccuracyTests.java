/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ RemoveUseCaseDiagramActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.actions.diagram.RemoveDiagramAction;
import com.topcoder.uml.actions.diagram.RemoveUseCaseDiagramAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * The <code>RemoveUseCaseDiagramAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>RemoveUseCaseDiagramAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class RemoveUseCaseDiagramActionAccuracyTests extends TestCase {
    /**
    * <p>
    * Represents an instance of <code>RemoveUseCaseDiagramAction</code> uses for accuracy tests.
    * </p>
    */
    private RemoveUseCaseDiagramAction test = null;

    /**
     * <p>
     * Represents an instance of <code>Diagram</code> uses for accuracy tests.
     * </p>
     */
    private Diagram diagram = null;

    /**
     * <p>
     * Represents an instance of <code>UMLModelManager</code> uses for accuracy tests.
     * </p>
     */
    private UMLModelManager manager = null;

    /**
     * <p>
     * Test suite of <code>RemoveUseCaseDiagramActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>RemoveUseCaseDiagramActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(RemoveUseCaseDiagramActionAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        manager = UMLModelManager.getInstance();
        TestHelper.configUMLModelManager();
        TestHelper.loadLogFile();
        diagram = new Diagram();
        test = new RemoveUseCaseDiagramAction(diagram);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        // clean the ConfigManager.
        TestHelper.clearConfig();
        // clean the UMLModelManager for test.
        manager.clearActivityGraphs();
        manager.clearDiagrams();
    }

    /**
     * <p>
     * Accuracy Test of the <code>RemoveUseCaseDiagramAction(Diagram)</code>
     * constructor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testRemoveUseCaseDiagramActionCtor_Basic()
        throws Exception {
        // check for creating successful.
        assertNotNull("Create failed.", test);

        //  get all the diagrams.
        List<Diagram> diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have empty.", 0, diagrams.size());

        test.undoAction();
        // get all the diagrams.
        diagrams = manager.getDiagrams();
        // check the number of the diagrams.
        assertEquals("The list should have 1 element.", 1, diagrams.size());

        Diagram getDiagram = diagrams.get(0);
        // check the diagram.
        assertSame("The diagram should besame.", diagram, getDiagram);
    }

    /**
     * <p>
     * Accuracy Test of the <code>RemoveUseCaseDiagramAction</code> calss.
     * It tests class inheritance.
     * </p>
     */
    public void testInheritance() {
        // test class inheritance.
        assertTrue("This class should extend from RemoveDiagramAction",
            test instanceof RemoveDiagramAction);
    }
}
