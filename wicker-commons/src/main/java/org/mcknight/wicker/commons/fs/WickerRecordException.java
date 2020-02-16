package org.mcknight.wicker.commons.fs;

public class WickerRecordException extends RuntimeException {

    public WickerRecordException() {

    }

    public WickerRecordException(String message) {
        super(message);
    }

    public WickerRecordException(String message, Exception innerException) {
        super(message, innerException);
    }
    
}