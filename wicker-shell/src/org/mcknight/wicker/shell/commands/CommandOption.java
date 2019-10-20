package org.mcknight.wicker.shell.commands;

import org.mcknight.wicker.shell.InvalidFlagException;

public class CommandOption {
    private String optionName;
    private String optionArgument;

    public String getOptionName() {
        return optionName;
    }

    public String getOptionArgument() {
        return optionArgument;
    }

    private static CommandOption parse(String optionText) throws InvalidFlagException {
        String[] parts = optionText.split(" ");

        String option = null;
        String arg = null;
        boolean foundFlag = false;
        for(String part : parts) {
            if(part.trim().length() > 0) {
                if(foundFlag) {
                    arg = part;
                } else {
                    option = part;
                    foundFlag = true;
                }
            }
        }
        CommandOption commandOption = new CommandOption();
        commandOption.optionName = option;
        commandOption.optionArgument = arg;
        return commandOption;
    }
}
