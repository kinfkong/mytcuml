/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.CutCreateMessageAction;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
/**
 * <p>
 * Failure test for CutCreateMessageAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CutCreateMessageActionFailureTest extends TestCase {
    /**
     * <p>
     * Stimulus instance created for testing.
     * </p>
     */
    private Stimulus stimulus;

    /**
     * <p>
     * Clipboard instance created for testing.
     * </p>
     */
    private Clipboard clip = new Clipboard("name");

    /**
     * <p>
     * Loads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
        stimulus = new StimulusImpl();
    }

    /**
     * <p>
     * Unloads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutCreateMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1NullStimulus() {
        try {
            new CutCreateMessageAction(null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException e) {
            fail("stimulus is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CopyReturnMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1InvalidStimulus1() {
        try {
            new CutCreateMessageAction(stimulus);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutCreateMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1InvalidStimulus2() {
        try {
            stimulus.setDispatchAction(new ProcedureImpl());
            new CutCreateMessageAction(stimulus);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutCreateMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1InvalidStimulus3() {
        try {
            Procedure procedure = new ProcedureImpl();
            CallOperationAction action = new CallOperationActionImpl();
            procedure.setAction(action);
            stimulus.setDispatchAction(procedure);
            new CutCreateMessageAction(stimulus);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutCreateMessageAction(Stimulus stimulus, Clipboard clipboard)
     * </code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2NullStimulus() {
        try {
            new CutCreateMessageAction(null, clip);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException e) {
            fail("stimulus is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutCreateMessageAction(Stimulus stimulus, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2NullClipboard() {
        try {
            new CutCreateMessageAction(stimulus, null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException e) {
            fail("stimulus is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutCreateMessageAction(Stimulus stimulus, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2InvalidStimulus1() {
        try {
            new CutCreateMessageAction(stimulus, clip);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutCreateMessageAction(Stimulus stimulus, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2InvalidStimulus2() {
        try {
            stimulus.setDispatchAction(new ProcedureImpl());
            new CutCreateMessageAction(stimulus, clip);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutCreateMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2InvalidStimulus3() {
        try {
            Procedure procedure = new ProcedureImpl();
            CallOperationAction action = new CallOperationActionImpl();
            procedure.setAction(action);
            stimulus.setDispatchAction(procedure);
            new CutCreateMessageAction(stimulus, clip);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }
}
