/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * About action to display about information.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ZoomInAction extends AbstractAction {

    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = 2689690515448954202L;

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "Zoom In";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Zoom In Current Diagram View";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/ZoomIn.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke('I', Event.ALT_MASK);

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/ZoomIn.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of ZoomIn action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public ZoomInAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(ZoomInAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(ZoomInAction.class
                .getResource(TOOLBAR_ICON_FILE_NAME)));

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
        mainFrame.getDiagramViewer().getZoomInAction().actionPerformed(actionEvent);
    }
}
