/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class StressTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(PanelsStressTests.class);
        suite.addTestSuite(PropertiesPanelStressTest.class);
        return suite;
    }
}
