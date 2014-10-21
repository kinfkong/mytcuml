/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CopyInterfaceAction;
import com.topcoder.uml.model.core.classifiers.Interface;

/**
 * <p>
 * Failure test for <code>{@link CopyInterfaceAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopyInterfaceActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopyInterfaceAction#CopyInterfaceAction(Interface)}</code> constructor. method.
     * </p>
     */
    public void testCtor_1_NullInterface() {
        assertConstructorException(CopyInterfaceAction.class, new Class[] {Interface.class}, new Object[] {null},
            IllegalArgumentException.class, "If the abstraction is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CopyInterfaceAction#CopyInterfaceAction(Interface, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_NullInterface() {
        assertConstructorException(CopyInterfaceAction.class, new Class[] {Interface.class, Clipboard.class},
            new Object[] {null, new Clipboard("test")}, IllegalArgumentException.class,
            "If the abstraction is null, should throw IllegalArgumentException.");
    }
}
