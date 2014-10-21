/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression;


/**
 * <p>
 * This class represents an UML2:JoinNode element. It will be used by the XMI Reader and its
 * plugins to create an object representation of the read zuml data. It implements the
 * convertToTCUML() method returning the converted tcuml object that can be used in the
 * internal uml tool model.
 * </p>
 *
 * <p>
 * In order to prevent there are many converted instances of one element, the convertTCUML()
 * will always return the same instance.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is mutable and not thread safe.
 * </p>
 *
 * @author Rica, zhengjuyu
 * @version 1.0
 */
public class ZUMLJoinNodeImpl extends AbstractZUMLActivityNode {
    /**
     * <p>Serial version uid for the Serializable class.</p>
     */
    private static final long serialVersionUID = 7204279993584093293L;

    /**
     * <p>
     * This field represents the OpaqueExpression object that is the joinSpec element of
     * this JoinNode implementation. It can be null immediately after initialization but
     * cannot be reset to null. It can be changed after initialization and accessed in
     * getJoinSpec(), changed in setJoinSpec().
     * </p>
     */
    private ZUMLOpaqueExpression joinSpec;

    /**
     * <p>
     * This field represents the converted instance of this element. If it
     * is not null, it will be returned directly in the convertToTCUML(). This
     * will prevents one element being converted many times.
     * </p>
     */
    private Pseudostate transformed;

    /**
     * <p>Empty constructor. Call super() default constructor.</p>
     */
    public ZUMLJoinNodeImpl() {
        super();
    }

    /**
     * <p>
     * Gets the joinSpec opaque expression of this joinNode implementation.
     * </p>
     *
     * @return the joinSpec OpaqueExpression
     */
    public ZUMLOpaqueExpression getJoinSpec() {
        return joinSpec;
    }

    /**
     * <p>
     * Sets a new ZUMLOpaqueExpression joinSpec.
     * </p>
     *
     * @param joinSpec the joinSpec of the current JoinNode instance
     * @throws IllegalArgumentException if the argument is null
     */
    public void setJoinSpec(ZUMLOpaqueExpression joinSpec) {
        Helper.checkNull(joinSpec, "joinSpec");

        this.joinSpec = joinSpec;
    }

    /**
     * <p>
     * This method converts the current ZUMLJoinNodeImpl representation of an
     * UML2:JoinNode zuml element into the equivalent tcuml instance.
     * </p>
     *
     * <p>
     * Note: the joinSpec is ignored for this version because we don't have an
     * equivalent specification in the tcuml model
     * </p>
     *
     * <p>
     * This method will always return the same instance of converted element. This will
     * prevent there are many converted elements in the diagram of one original element.
     * </p>
     *
     * @return the equivalent tcuml ModelElement
     */
    public ModelElement convertToTCUML() {
        if (transformed == null) {
            transformed = Helper.createPseudostate(this, PseudostateKind.JOIN);
        }

        return transformed;
    }
}
