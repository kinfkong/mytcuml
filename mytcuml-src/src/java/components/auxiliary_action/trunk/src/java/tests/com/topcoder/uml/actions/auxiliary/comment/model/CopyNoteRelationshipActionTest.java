/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Unit tests on class <code>CopyNoteRelationshipAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CopyNoteRelationshipActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CopyNoteRelationshipAction</code> used in this test.
     * </p>
     */
    private CopyNoteRelationshipAction action;
    /**
     * <p>
     * Instance of <code>Comment</code> used in this test.
     * </p>
     */
    private Comment comment;
    /**
     * <p>
     * Clipboard.
     * </p>
     */
    private Clipboard clipboard;
    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.comment = new CommentImpl();
        this.clipboard = new Clipboard("CopyNoteRelationshipActionTest");
        this.action = new CopyNoteRelationshipAction(this.comment, this.clipboard);
    }

    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        UnitTestHelper.clearConfig();
    }

    /**
     * <p>
     * Test constructor <code>CopyNoteRelationshipAction(Comment comment, Clipboard clipboard)
     * </code> for failure with null comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullComment() {
        try {
            new CopyNoteRelationshipAction(null, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CopyNoteRelationshipAction(Comment comment, Clipboard clipboard)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy1() {
        assertNotNull("Failed to create the action!",
                new CopyNoteRelationshipAction(this.comment, null));
    }
    /**
     * <p>
     * Test constructor <code>CopyNoteRelationshipAction(Comment comment, Clipboard clipboard)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy2() {
        assertNotNull("Failed to create the action!",
                new CopyNoteRelationshipAction(this.comment, Toolkit.getDefaultToolkit().getSystemClipboard()));
    }
    /**
     * <p>
     * Test method <code>execute()</code> for accuracy.
     * </p>
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        // execute the action
        this.action.execute();
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP);
        assertNotNull("Failed to execute the action!", obj);
        assertTrue("Failed to execute the action!", obj instanceof Comment);
        UnitTestHelper.assertEquals(this.comment, (Comment) obj, "Failed to execute the action!");
    }
}
