/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import com.topcoder.util.errorhandling.ExceptionData;

/**
 * This exception is thrown if there is no sufficient data to perform the
 * validation.
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class InsufficientDataException extends ValidationException {
    /**
     * Constructor with error message.
     *
     * @param message
     *            the error message.
     */
    public InsufficientDataException(String message) {
        super(message);
    }

    /**
     * Usage: Constructor with error message and inner cause.
     *
     * @param message
     *            the error message
     * @param cause
     *            the cause of this exception
     */
    public InsufficientDataException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Usage: Constructor with error message and exception data.
     *
     * @param data
     *            the exception data
     * @param message
     *            the error message
     */
    public InsufficientDataException(String message, ExceptionData data) {
        super(message, data);
    }

    /**
     * Usage: Constructor with error message and inner cause and exception data.
     *
     * @param data
     *            the exception data
     * @param message
     *            the error message
     * @param cause
     *            the cause of this exception
     */
    public InsufficientDataException(String message, Throwable cause, ExceptionData data) {
        super(message, cause, data);
    }
}
