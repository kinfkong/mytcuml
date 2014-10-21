/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel;

import com.topcoder.gui.panels.properties.propertypanel.GuardPropertyPanel;

import junit.framework.TestCase;

/**
 * Failure tests for GuardPropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class GuardPropertyPanelFailureTests extends TestCase {
    /**
     * Tests the constructor GuardPropertyPanel(PropertiesPanel) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new GuardPropertyPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}