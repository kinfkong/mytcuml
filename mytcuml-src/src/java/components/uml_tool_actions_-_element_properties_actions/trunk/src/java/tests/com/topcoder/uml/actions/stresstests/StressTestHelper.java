/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.stresstests;

import java.io.File;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the stress test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StressTestHelper {
    /**
     * Represents the namespace for Logging Wrapper component.
     */
    public static final String LOG_NAMESPACE = "com.topcoder.util.log";

    /**
     * Represents the path of config file for Logging Wrapper component.
     */
    public static final String LOG_CONFIGFILE = "test_files/stresstests/Logging.xml";

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private StressTestHelper() {
    }

    /**
     * <p>
     * Use the given file to config the given namespace the format of the config file is
     * ConfigManager.CONFIG_XML_FORMAT.
     * </p>
     *
     * @param namespace use the namespace to load config information to ConfigManager
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadSingleXMLConfig(String namespace, String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        //config namespace
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }

        config.add(namespace, file.getCanonicalPath(), ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * <p>
     * Remove the given namespace in the ConfigManager.
     * </p>
     *
     * @param namespace namespace use to remove the config information in ConfigManager
     *
     * @throws Exception when any exception occurs
     */
    public static void clearConfigFile(String namespace) throws Exception {
        ConfigManager config = ConfigManager.getInstance();

        //clear the environment
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }
    }
}
