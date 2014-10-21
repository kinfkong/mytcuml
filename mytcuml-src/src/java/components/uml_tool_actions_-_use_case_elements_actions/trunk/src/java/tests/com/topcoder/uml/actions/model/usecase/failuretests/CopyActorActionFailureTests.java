/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CopyActorAction;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;

/**
 * <p>
 * Failure test for <code>{@link CopyActorAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopyActorActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopyActorAction#CopyActorAction(Actor)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullActor() {
        assertConstructorException(CopyActorAction.class, new Class[] {Actor.class}, new Object[] {null},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CopyActorAction#CopyActorAction(Actor, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullActor() {
        assertConstructorException(CopyActorAction.class, new Class[] {Actor.class, Clipboard.class}, new Object[] {
            null, new Clipboard("Hello")}, IllegalArgumentException.class,
            "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CopyActorAction#CopyActorAction(Actor, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullClipboard() {
        assertConstructorException(CopyActorAction.class, new Class[] {Actor.class, Clipboard.class}, new Object[] {
            new ActorImpl(), null}, IllegalArgumentException.class,
            "If clipboard is null, should throw IllegalArgumentException.");
    }
}
