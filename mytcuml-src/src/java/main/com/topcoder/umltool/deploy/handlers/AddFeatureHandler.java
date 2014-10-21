/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;

import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * This implementation handles the diagram element added event. It will add the corresponding Node to corresponding
 * NodeContainer. This is an UndoableAction.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddFeatureHandler implements ActionEventListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>AddFeatureHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public AddFeatureHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is performed.
     * </p>
     * @param event
     *            the non null event has been performed
     * @param eventValidation
     *            the non null validation result
     * @throws IllegalArgumentException
     *             if event or eventValidation is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(eventValidation, "eventValidation");
        if (event.getSource() instanceof ClassNode) {
            updateNode((ClassNode) event.getSource());
        } else {
            //FIXME
            System.out.println("ERROR: The source should be a class node.");
        }
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is undone.
     * </p>
     * @param event
     *            the non null event has been undone
     * @param undoableAction
     *            the non null action which is undone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(undoableAction, "undoableAction");
        if (event.getSource() instanceof ClassNode) {
            updateNode((ClassNode) event.getSource());
        }
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is redone.
     * </p>
     * @param event
     *            the non null event which has been redone
     * @param undoableAction
     *            the non null action which is redone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(undoableAction, "undoableAction");
        if (event.getSource() instanceof ClassNode) {
            updateNode((ClassNode) event.getSource());
        }
    }

    /**
     * <p>
     * Updates the class node.
     * </p>
     * @param classNode
     *            the class node needs updating
     */
    private void updateNode(ClassNode classNode) {
        DeployHelper.notifyModelElementChange(DeployHelper.getElement(classNode), "Feature updated", mainFrame);
        mainFrame.getDocumentTree().updateTree();
    }
}
