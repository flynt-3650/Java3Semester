/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package exceptionalthrow.itin;

class InvalidITINException extends Exception {
    public InvalidITINException() {
    }

    public InvalidITINException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidITINException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidITINException(Throwable cause) {
        super(cause);
    }

    public InvalidITINException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
