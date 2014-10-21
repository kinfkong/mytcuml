/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedListener;

/**
 * <p>
 * Mocked TextChangedListener class for testing.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockedTextChangedListener implements TextChangedListener {

    /**
     * <p>
     * Represents the old value of the node name. Initialized in the constructor and can not be null.
     * </p>
     */
    private String oldValue;

    /**
     * <p>
     * Represents the new value of the node name. Initialized in the constructor and can not be null.
     * </p>
     */
    private String newValue;

    /**
     * <p>
     * Performs the name changed event and set the new name to the node.
     * </p>
     * @param event
     *            the new value of the name compartment
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public void textChanged(TextChangedEvent event) {
        oldValue = event.getOldValue();
        newValue = event.getNewValue();
        TextField textField = (TextField) event.getSource();
        textField.setText(newValue);
    }

    /**
     * Gets the old value.
     * @return the old value
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * Gets the new value.
     * @return the new value
     */
    public String getNewValue() {
        return newValue;
    }
}
