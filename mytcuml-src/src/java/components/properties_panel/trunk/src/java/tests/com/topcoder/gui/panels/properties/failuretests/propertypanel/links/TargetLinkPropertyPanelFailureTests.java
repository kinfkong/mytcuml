/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel.links;

import com.topcoder.gui.panels.properties.propertypanel.links.TargetLinkPropertyPanel;

import junit.framework.TestCase;

/**
 * Failure tests for TargetLinkPropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class TargetLinkPropertyPanelFailureTests extends TestCase {
    /**
     * Tests the constructor TargetLinkPropertyPanel(PropertiesPanel) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new TargetLinkPropertyPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}