package org.mcknight.wicker.shell.commands;

public class ListFilesCommand extends ShellCommand {

    public ListFilesCommand(String commandName) {
        super(commandName);
        addAlias("ls");
    }

    @Override
    protected void executeCore() {

    }
}
