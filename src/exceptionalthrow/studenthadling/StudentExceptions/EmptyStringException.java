/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package exceptionalthrow.studenthadling.StudentExceptions;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
    }

    public EmptyStringException(String message) {
        super(message);
    }

    public EmptyStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStringException(Throwable cause) {
        super(cause);
    }

    public EmptyStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
