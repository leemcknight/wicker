package org.mcknight.wicker.shell.commands;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.mcknight.wicker.commons.patterns.Command;

public abstract class ShellCommand extends Command {
	
	private List<String> aliases = new ArrayList<>();
	private List<CommandFlag> flags = new ArrayList<>();
	private List<CommandOption> options = new ArrayList<>();
	private PrintStream out;
	private PrintStream err;

	public ShellCommand(String commandName) {
		super(commandName);
		out = new PrintStream(System.out);
		err = new PrintStream(System.err);
	}
	
	public boolean matches(String command) {
		if(getCommandName().equals(command)) {
			return true;
		}
		
		for(String alias : aliases) {
			if(alias.equals(command)) {
				return true;
			}
		}
		return false;
	}

	public boolean validate(List<CommandFlag> flags, List<CommandOption> options) {
		return true;
	}

	public void addFlag(CommandFlag flag) {
		flags.add(flag);
	}

	public void addFlag(String name, String value) {

	}

	protected void addAlias(String alias) {
		aliases.add(alias);
	}

	protected void output(String output) {
		out.print(output);
		out.flush();
	}

	protected void error(String output) {
		err.print(output + "\n");
		err.flush();
	}
	

}
