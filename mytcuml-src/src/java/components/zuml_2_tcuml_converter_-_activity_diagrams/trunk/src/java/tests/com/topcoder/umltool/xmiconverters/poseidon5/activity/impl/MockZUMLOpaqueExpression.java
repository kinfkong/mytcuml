/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>
 * Mock implementation of <code>AbstractZUMLOpaqueExpression</code> class.
 * It provides an empty implementation of convertToTCUML(). It's just used
 * for testing <code>AbstractZUMLOpaqueExpression</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class MockZUMLOpaqueExpression extends AbstractZUMLOpaqueExpression {
    /**
     * <p>Serial version uid for the Serializable class.</p>
     */
    private static final long serialVersionUID = -7001304273785747397L;

    /**
     * <p>
     * An empty implementation.
     * </p>
     *
     * @return this class is mock implementation and always return null
     */
    public ModelElement convertToTCUML() {
        return null;
    }
}
