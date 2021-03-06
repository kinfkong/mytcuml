/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 * @author TopCoder
 * @version 1.0
 */
public class StressTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(AddActionTests.class);
        suite.addTestSuite(CopyActionTests.class);
        suite.addTestSuite(CutActionTests.class);
        suite.addTestSuite(PasteActionTests.class);
        suite.addTestSuite(RemoveActionTests.class);
        return suite;
    }
}
