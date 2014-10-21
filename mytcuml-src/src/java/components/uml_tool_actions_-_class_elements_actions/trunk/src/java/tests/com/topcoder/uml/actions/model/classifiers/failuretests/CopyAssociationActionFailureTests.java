/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CopyAssociationAction;
import com.topcoder.uml.model.core.relationships.Association;

/**
 * <p>
 * Failure test for <code>{@link CopyAssociationAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopyAssociationActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopyAssociationAction#CopyAssociationAction(Association)}</code> constructor.
     * method.
     * </p>
     */
    public void testCtor_1_NullAssociation() {
        assertConstructorException(CopyAssociationAction.class, new Class[] {Association.class}, new Object[] {null},
            IllegalArgumentException.class, "If the association is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CopyAssociationAction#CopyAssociationAction(Association, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_NullAssociation() {
        assertConstructorException(CopyAssociationAction.class, new Class[] {Association.class, Clipboard.class},
            new Object[] {null, new Clipboard("test")}, IllegalArgumentException.class,
            "If the association is null, should throw IllegalArgumentException.");
    }
}
