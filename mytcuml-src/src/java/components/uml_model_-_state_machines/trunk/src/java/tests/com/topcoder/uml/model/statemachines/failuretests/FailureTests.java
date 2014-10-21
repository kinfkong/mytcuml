/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.uml.model.statemachines.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class FailureTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(FailureTestAbstractStateImpl.class);
        suite.addTestSuite(FailureTestCompositeStateImpl.class);
        suite.addTestSuite(FailureTestFinalStateImpl.class);
        suite.addTestSuite(FailureTestPseudostateImpl.class);
        suite.addTestSuite(FailureTestSimpleStateImpl.class);
        suite.addTestSuite(FailureTestStateMachineImpl.class);
        suite.addTestSuite(FailureTestStateVertexAbstractImpl.class);
        return suite;
    }
}
