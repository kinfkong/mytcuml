/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.xmi.writer.transformers.model;
/**
 * The simple mock class used to test the component.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InnerBean implements InnerBeanInterface {
    /**
     * The name field.
     */
    private String name = "n";
    /**
     * The type field.
     */
    private String type = "t";
    /**
     * Empty constructor.
     *
     */
    public InnerBean() {
    }
    /**
     * Get a String.
     *
     * @return a String instance.
     */
    public String getName() {
        return name;
    }
    /**
     * Set a String.
     *
     * @param name a String instance.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get a String.
     *
     * @return a String instance.
     */
    public String getType() {
        return type;
    }
    /**
     * Set a String.
     *
     * @param type a String instance.
     */
    public void setType(String type) {
        this.type = type;
    }
}
