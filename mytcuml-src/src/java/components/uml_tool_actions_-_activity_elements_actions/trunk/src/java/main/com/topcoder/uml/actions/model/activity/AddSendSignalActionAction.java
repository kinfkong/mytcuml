/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * AddSendSignalActionAction class extends AddStateNodeAbstractAction abstract class,
 * and this action is specifically used to add SimpleState with a tag definition
 * attached (TagDefinition("SendSignalAction").value="True") in activity graph.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base class is
 * not thread-safe, so it is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class AddSendSignalActionAction extends AddStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Send Signal Action";

    /**
     * <p>
     * Construct an AddSendSignalActionAction with the SimpleState,
     * activity graph and manager specified.
     * </p>
     *
     * <p>
     * Note, it checks its tagged values with a tag definition
     * attached (TagDefinition("SendSignalAction").value="True").
     * </p>
     *
     * @param state the state node to add into activity graph
     * @param activityGraph the ActivityGraph object to add the state node
     * @param manager the UMLModelManager object to apply initial formatting
     *
     * @throws IllegalArgumentException if any argument is null, or state doesn't
     * have the tag definition (TagDefinition("SendSignalAction").value="True")
     */
    public AddSendSignalActionAction(SimpleState state, ActivityGraph activityGraph, UMLModelManager manager) {
        super(PRESENTATION_NAME, state, activityGraph, manager);

        if (!Util.checkTagDefinition(state, "SendSignalAction", "True")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [SendSignalAction](The data value should be True).");
        }
    }
}
