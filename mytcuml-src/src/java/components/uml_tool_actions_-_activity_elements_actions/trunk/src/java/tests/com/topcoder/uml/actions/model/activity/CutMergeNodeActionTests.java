/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CutMergeNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutMergeNodeActionTests extends TestCase {

    /**
     * <p>
     * The CutMergeNodeAction instance for testing.
     * </p>
     */
    private CutMergeNodeAction action;

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private Pseudostate state;

    /**
     * <p>
     * The Clipboard instance for testing.
     * </p>
     */
    private Clipboard clipboard;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        state = new PseudostateImpl();
        CompositeState container = new CompositeStateImpl();

        state.setContainer(container);
        state.setKind(PseudostateKind.JUNCTION);
        clipboard = new Clipboard("Test");
        action = new CutMergeNodeAction(state, clipboard);
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
        action = null;
        clipboard = null;
        state = null;

        TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CutMergeNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CutMergeNodeAction#CutMergeNodeAction(Pseudostate,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutMergeNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CutMergeNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CutMergeNodeAction#CutMergeNodeAction(Pseudostate,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutMergeNodeAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CutMergeNodeAction instance.", new CutMergeNodeAction(state, null));
    }

    /**
     * <p>
     * Tests ctor CutMergeNodeAction#CutMergeNodeAction(Pseudostate,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CutMergeNodeAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutMergeNodeAction#CutMergeNodeAction(Pseudostate,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state kind attribute doesn't equal to
     * PseudostateKind.JUNCTION and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongKind() {
        state = new PseudostateImpl();
        try {
            new CutMergeNodeAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutMergeNodeAction#CutMergeNodeAction(Pseudostate,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is not set the container
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContainer() {
        state = new PseudostateImpl();
        try {
            new CutMergeNodeAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}