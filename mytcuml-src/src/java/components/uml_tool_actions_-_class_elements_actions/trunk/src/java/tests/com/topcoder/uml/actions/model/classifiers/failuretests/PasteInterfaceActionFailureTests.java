/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.PasteInterfaceAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * <p>
 * Failure test for <code>{@link PasteInterfaceAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class PasteInterfaceActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link PasteInterfaceAction#PasteInterfaceAction(Transferable, Namespace)}</code>
     * </p>
     */
    public void testCtorNullTransferable() {
        assertConstructorException(PasteInterfaceAction.class, new Class[] {Transferable.class, Namespace.class},
            new Object[] {null, new PackageImpl()}, IllegalArgumentException.class,
            "If the transferable is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link PasteInterfaceAction#PasteInterfaceAction(Transferable, Namespace)}</code>
     * </p>
     */
    public void testCtorNullNamespace() {
        assertConstructorException(PasteInterfaceAction.class, new Class[] {Transferable.class, Namespace.class},
            new Object[] {new ClassElementsTransfer(new InterfaceImpl()), null}, IllegalArgumentException.class,
            "If the namespace is null, should throw IllegalArgumentException.");
    }
}
