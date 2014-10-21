/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.menus.EmptyIcon;

/**
 * <p>
 * About action to display about information.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AboutAction extends AbstractAction {
    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = -2873752707169317598L;

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "About";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "About...";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of about action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public AboutAction(MainFrame mainFrame) {
        super(ACTION_NAME, EmptyIcon.ICON_16);
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);

        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(mainFrame, "TopCoder UML Tool 1.2.5 (c) 2010 TopCoder, Inc.", "About",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
