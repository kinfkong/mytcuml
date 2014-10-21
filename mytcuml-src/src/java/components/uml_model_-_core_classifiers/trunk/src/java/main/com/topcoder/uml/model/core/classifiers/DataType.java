/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.Classifier;


/**
 * <p>This interface extends Classifier interface. The Classifier interface comes form the Core
 * Requirements component. A data type is a type whose values have no identity (i.e., they are
 * pure values). Data types include primitive built-in types (such as integer and string) as
 * well as definable enumeration types (such as the predefined enumeration type boolean whose
 * literals are false and true). In the metamodel, a DataType defines a special kind of
 * Classifier in which Operations are all pure functions (i.e., they can return DataValues
 * but they cannot change DataValues, because they have no identity). For example, an ?add?
 * operation on a number with another number as an argument yields a third number as a result;
 * the target and argument are unchanged.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface DataType extends Classifier {
}
