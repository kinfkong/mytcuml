/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.util.errorhandling.BaseException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ConfigurationException.
 * </p>
 *
 * <p>
 * This class is pretty simple.
 * The test cases simply verifies the exception can be instantiated with the error message
 * and cause properly propagated, and that it comes with correct inheritance.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ConfigurationExceptionTests extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * An exception instance used to create the ConfigurationException.
     * </p>
     */
    private static final Exception CAUSE_EXCEPTION = new NullPointerException();

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ConfigurationExceptionTests.class);
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message is properly propagated.
     * </p>
     */
    public void testConfigurationException1() {
        ConfigurationException exception = new ConfigurationException(ERROR_MESSAGE);
        assertNotNull("Unable to instantiate ConfigurationException.", exception);
        assertEquals("Error message is not properly propagated to super class.",
                ERROR_MESSAGE, exception.getMessage());
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message and the cause are properly propagated.
     * </p>
     */
    public void testConfigurationException2() {
        ConfigurationException exception =
            new ConfigurationException(ERROR_MESSAGE, CAUSE_EXCEPTION);
        assertNotNull("Unable to instantiate ConfigurationException.", exception);
        assertTrue("The error message should match", exception.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("Cause is not properly propagated to super class.", CAUSE_EXCEPTION, exception.getCause());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies ConfigurationException subclasses BaseException.
     * </p>
     */
    public void testInvalidWeightsExceptionInheritance1() {
        ConfigurationException exception = new ConfigurationException(ERROR_MESSAGE);
        assertTrue("ConfigurationException does not subclass BaseException.", exception instanceof BaseException);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies ConfigurationException subclasses BaseException.
     * </p>
     */
    public void testConfigurationExceptionInheritance2() {
        ConfigurationException exception =
            new ConfigurationException(ERROR_MESSAGE, CAUSE_EXCEPTION);
        assertTrue("ConfigurationException does not subclass BaseException.", exception instanceof BaseException);
    }
}
