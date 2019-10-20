package org.mcknight.wicker.shell;

public class InvalidFlagException extends Exception {
    private String flagName;

    public InvalidFlagException() {

    }

    public InvalidFlagException(String flagName) {
        this.flagName = flagName;
    }
}
