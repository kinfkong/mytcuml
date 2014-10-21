/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.eventmanager.RedoChangesEvent;

/**
 * <p>
 * Action to redo changes.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RedoChangesAction extends AbstractAction {
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
    private static final String ACTION_NAME = "Redo Changes";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Redo changes.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/Redo_16.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke('Y', Toolkit.getDefaultToolkit()
            .getMenuShortcutKeyMask());

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/Redo.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of redo changes action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public RedoChangesAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(RedoChangesAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(RedoChangesAction.class
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
        RedoChangesEvent redoActionEvent = mainFrame.getLastRedoChangeEvent();
        if (redoActionEvent != null) {
            try {
                mainFrame.getEventManager().handleActionEvent(redoActionEvent);
            } catch (ActionExecutionException e) {
                DeployHelper.handleException(mainFrame, e, "Redo failed");
            }
        }
    }
}
