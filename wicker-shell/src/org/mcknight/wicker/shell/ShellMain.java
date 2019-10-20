package org.mcknight.wicker.shell;

import org.mcknight.wicker.shell.commands.ReadFileCommand;
import org.mcknight.wicker.shell.commands.ReplCommand;
import org.mcknight.wicker.shell.commands.ShellCommand;

import java.util.ArrayList;
import java.util.List;

public class ShellMain {

	private List<ShellCommand> shellCommands;

	private ShellMain() {
		shellCommands = new ArrayList<>();
		shellCommands.add(new ReadFileCommand("read"));
		shellCommands.add((new ReplCommand("repl")));
	}

	public static void main(String[] args) {
		System.out.println("Starting Wicker shell.");
		if(args.length == 0) {
			printUsage();
			return;
		}

		new ShellMain().executeCommand(args);
	}

	public void executeCommand(String[] args) {
		for(ShellCommand shellCommand : shellCommands) {
			if(shellCommand.matches(args[0])) {
				System.out.println("running " + shellCommand.getCommandName());
				shellCommand.execute();
			} else {
				System.out.println(args[0] + " doesn't match " + shellCommand.getCommandName());
			}
		}
	}
	
	private static void printUsage() {
		System.out.println("Wicker Shell");
		System.out.println("Usage: wicker [command] [args]");
		System.out.print("commands");
		System.out.println("fs (File System command");
	}

}
