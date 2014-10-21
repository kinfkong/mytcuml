/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.projectconfiguration.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
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
        suite.addTestSuite(TestCSharpExceptionElementFormatter.class);
        suite.addTestSuite(TestJava14EnumElementFormatter.class);
        suite.addTestSuite(TestJavaExceptionElementFormatter.class);
        suite.addTestSuite(TestProjectConfigurationManager.class);
        suite.addTestSuite(TestPropertyTemplateDiagramElementFormatter.class);
        suite.addTestSuite(TestXMLStereotypeLoader.class);

        return suite;
    }
}
