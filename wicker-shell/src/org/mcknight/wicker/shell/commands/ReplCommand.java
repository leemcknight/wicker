package org.mcknight.wicker.shell.commands;

import org.mcknight.wicker.commons.patterns.Command;

public class ReplCommand extends ShellCommand {

    public ReplCommand(String commandName) {
        super(commandName);
    }

    @Override
    protected void executeCore() {
        boolean active = true;
        while(active) {
            output("wicker-repl:");
            String command = System.console().readLine();
            if(command.trim().equals("exit")) {
                active = false;
            } else {
                Command cmd = new CommandBuilder().withName(command).build();
                if(cmd != null) {
                    cmd.execute();
                } else {
                    error("Unknown command: " + command);
                }
            }
        }
    }
}
