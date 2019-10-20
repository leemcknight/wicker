package org.mcknight.wicker.shell.commands;

import org.mcknight.wicker.shell.InvalidFlagException;

/**
 * Command Flags are always optional, and are always "false" by default.
 * They do not have to be explictly set to true on the command line
 * (e.g. --verboxe=true), instead the existence of the flag itself
 * sets it to true (e.g. --verbose)
 */
public class CommandFlag {
    private String flag;
    private String value;

    private CommandFlag() {

    }

    public static CommandFlag create(String flagText) throws InvalidFlagException {
        return parse(flagText);
    }

    public String getValue() {
        return value;
    }

    public String getFlag() {
        return flag;
    }

    private static CommandFlag parse(String flagText) throws InvalidFlagException {
        String[] parts = flagText.split("=");
        if(parts.length <= 1) {
            throw new InvalidFlagException();
        }

        String flag = null;
        String value = null;
        boolean foundFlag = false;
        boolean foundValue = false;
        for(String part : parts) {
            if(part.trim().length() > 0) {
                if(foundFlag) {
                    value = part;
                    foundValue = true;
                } else {
                    flag = value;
                    foundFlag = true;
                }
            }
        }
        if(foundFlag && foundValue) {
            CommandFlag commandFlag = new CommandFlag();
            commandFlag.flag = flag;
            commandFlag.value = value;
            return commandFlag;
        }
        throw new InvalidFlagException(flag);
    }

}
