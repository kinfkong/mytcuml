/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.CopyAcceptEventActionAction;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

/**
 * <p>
 * Failure test for <code>CopyAcceptEventActionAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CopyAcceptEventActionActionFailureTest extends TestCase {
    /**
     * <p>
     * The SimpleState instance created for testing.
     * </p>
     */
    private SimpleState state;

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
        state = new SimpleStateImpl();
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
     * <code>CopyAcceptEventActionAction(SimpleState state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyAcceptEventActionActionNullState() {
        try {
            new CopyAcceptEventActionAction(null, clipboard);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>CopyAcceptEventActionAction(SimpleState state, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * clipboard is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCopyAcceptEventActionActionNullClipboard() {
        try {
            new CopyAcceptEventActionAction(state, null);
            fail("clipboard is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
