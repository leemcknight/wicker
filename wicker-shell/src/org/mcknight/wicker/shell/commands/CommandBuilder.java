package org.mcknight.wicker.shell.commands;

import java.util.List;

public class CommandBuilder {
    private String name;
    private List<CommandFlag> flags;
    private List<CommandOption> options;

    public CommandBuilder withCommandLine(String commandLine) {
        parse(commandLine);
        return this;
    }

    public CommandBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CommandBuilder withOption(String optionString) {
        options.add(parseOption(optionString));
        return this;
    }

    public CommandBuilder withFlag(CommandFlag flag) {
        flags.add(flag);
        return this;
    }


    public ShellCommand build() {
        return null;
    }

    private void parse(String commandLine) {

    }

    private CommandOption parseOption(String optionString) {
        return null;
    }
}
