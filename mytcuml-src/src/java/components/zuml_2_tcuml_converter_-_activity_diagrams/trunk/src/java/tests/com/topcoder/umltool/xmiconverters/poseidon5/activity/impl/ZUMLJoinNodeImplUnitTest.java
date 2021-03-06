/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.StateMachineImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>ZUMLJoinNodeImpl</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class ZUMLJoinNodeImplUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ZUMLJoinNodeImplUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>ZUMLJoinNodeImpl()</code>.
     * </p>
     *
     * <p>
     * The constructor is a trivial one, just test whether the instance can be created.
     * </p>
     */
    public void testCtor() {
        ZUMLActivityNode node = new ZUMLJoinNodeImpl();
        assertNotNull("Unable to create ZUMLJoinNodeImpl instance.", node);
    }

    /**
     * <p>
     * Accuracy test for <code>getJoinSpec()</code>.
     * </p>
     *
     * <p>
     * Verify that whether the joinSpec is got successfully.
     * </p>
     */
    public void testGetJoinSpec() {
        ZUMLJoinNodeImpl node = new ZUMLJoinNodeImpl();

        assertNull("The initialized value of jointSpec is null.",
            node.getJoinSpec());

        ZUMLOpaqueExpression expression = new ZUMLOpaqueExpressionImpl();
        node.setJoinSpec(expression);

        assertEquals("The joinSpec should match.", expression,
            node.getJoinSpec());
    }

    /**
     * <p>
     * Accuracy test for <code>setJoinSpec(ZUMLOpaqueExpression)</code>.
     * </p>
     *
     * <p>
     * Verify that the joinSpec is set successfully.
     * </p>
     */
    public void testSetJoinSpec() {
        ZUMLJoinNodeImpl node = new ZUMLJoinNodeImpl();

        ZUMLOpaqueExpression expression = new ZUMLOpaqueExpressionImpl();
        node.setJoinSpec(expression);

        assertEquals("The joinSpec should match.", expression,
            node.getJoinSpec());
    }

    /**
     * <p>
     * Failure test for <code>setJoinSpec()</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the joinSpec to set is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetJoinSpec_Failure() {
        try {
            ZUMLJoinNodeImpl node = new ZUMLJoinNodeImpl();

            node.setJoinSpec(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that the returned ModelElement is instance of Pseudostate, and its
     * kind is PseudostateKind.JOIN. And verify that simple attributes are copied
     * to the converted instance.
     * </p>
     */
    public void testConvertToTCUML1() {
        AbstractZUMLActivityNode node = new ZUMLJoinNodeImpl();

        //Set its simple attributes.
        node.setName("join");

        Namespace namespace = new CollaborationImpl();
        node.setNamespace(namespace);

        node.setVisibility(null);
        node.setSpecification(true);

        ModelElement element = node.convertToTCUML();

        assertTrue("The ZUMLJoinNodeImpl should be converted to Pseudostate class.",
            element instanceof Pseudostate);

        assertEquals("The kind of the state is PseudostateKind.JOIN",
            PseudostateKind.JOIN, ((Pseudostate) element).getKind());

        assertEquals("The name should match.", "join", element.getName());
        assertEquals("The namespace should match.", namespace,
            element.getNamespace());
        assertNull("The visibility is set to null.", element.getVisibility());
        assertTrue("The specification is set to true.",
            element.isSpecification());
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that the common attribute from ModelElement is copied to the converted instance.
     * Complex attributes are verified in this test case. Simple attributes are verified in
     * the previous test case.
     * </p>
     */
    public void testConvertToTCUML2() {
        AbstractZUMLActivityNode node = new ZUMLJoinNodeImpl();

        node.addStereotype(new StereotypeImpl());
        node.addTaggedValue(new TaggedValueImpl());
        node.addReferenceTag(new TaggedValueImpl());
        node.addSupplierDependency(new DependencyImpl());
        node.addClientDependency(new DependencyImpl());
        node.addComment(new CommentImpl());

        TemplateParameter tp = new TemplateParameterImpl();
        node.setParameterTemplate(tp);

        node.addDefaultParameter(new TemplateParameterImpl());
        node.addTemplateParameter(new TemplateParameterImpl());
        node.addTemplateArgument(new TemplateArgumentImpl());
        node.addElementImport(new ElementImportImpl());
        node.addBehavior(new StateMachineImpl());

        ModelElement element = node.convertToTCUML();

        assertEquals("There should be 1 stereotype.", 1,
            element.getStereotypes().size());
        assertEquals("There should be 0 taggedValue.", 0,
            element.getTaggedValues().size());
        assertEquals("There should be 1 referenceTag.", 1,
            element.getReferenceTags().size());
        assertEquals("There should be 1 supplierDependency.", 1,
            element.getSupplierDependencies().size());
        assertEquals("There should be 1 clientDependency.", 1,
            element.getClientDependencies().size());
        assertEquals("There should be 1 comment.", 1,
            element.getComments().size());
        assertEquals("The parameterTemplate should match.", tp,
            element.getParameterTemplate());
        assertEquals("There should be 1 defaultParameter.", 1,
            element.getDefaultParameters().size());
        assertEquals("There should be 1 templateParameter.", 1,
            element.getTemplateParameters().size());
        assertEquals("There should be 1 templateArgument.", 1,
            element.getTemplateArguments().size());
        assertEquals("There should be 1 elementImport.", 1,
            element.getElementImports().size());
        assertEquals("There should be 1 behavior.", 1,
            element.getBehaviors().size());
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that convertToTCUML() always returns the same instance.
     * </p>
     */
    public void testConvertToTCUML3() {
        ZUMLActivityNode node = new ZUMLJoinNodeImpl();

        assertEquals("The convertToTCUML() should always return the same instance.",
            node.convertToTCUML(), node.convertToTCUML());
    }
}
