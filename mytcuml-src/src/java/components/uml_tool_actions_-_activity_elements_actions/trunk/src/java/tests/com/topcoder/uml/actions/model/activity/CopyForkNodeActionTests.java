/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CopyForkNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyForkNodeActionTests extends TestCase {

    /**
     * <p>
     * The CopyForkNodeAction instance for testing.
     * </p>
     */
    private CopyForkNodeAction action;

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
     */
    protected void setUp() {
        state = new PseudostateImpl();
        state.setKind(PseudostateKind.FORK);
        clipboard = new Clipboard("Test");
        action = new CopyForkNodeAction(state, clipboard);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        action = null;
        clipboard = null;
        state = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CopyForkNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CopyForkNodeAction#CopyForkNodeAction(Pseudostate,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyForkNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CopyForkNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CopyForkNodeAction#CopyForkNodeAction(Pseudostate,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyForkNodeAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CopyForkNodeAction instance.", new CopyForkNodeAction(state, null));
    }

    /**
     * <p>
     * Tests ctor CopyForkNodeAction#CopyForkNodeAction(Pseudostate,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CopyForkNodeAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CopyForkNodeAction#CopyForkNodeAction(Pseudostate,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state kind attribute doesn't equal to
     * PseudostateKind.FORK and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongKind() {
        state = new PseudostateImpl();
        try {
            new CopyForkNodeAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}