/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.CutObjectFlowStateAction;

/**
 * <p>
 * Failure test for <code>CutObjectFlowStateAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CutObjectFlowStateActionFailureTest extends TestCase {

    /**
     * <p>
     * The Clipboard instance created for testing.
     * </p>
     */
    private Clipboard clipboard;

    /**
     * <p>
     * Set up the environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
        clipboard = new Clipboard("name");
    }

    /**
     * <p>
     * Clear the namespace.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * <p>
     * Failure test for
     * <code>CopyInitialNodeAction(ObjectFlowState state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCutObjectFlowStateActionNullState() {
        try {
            new CutObjectFlowStateAction(null, clipboard);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
