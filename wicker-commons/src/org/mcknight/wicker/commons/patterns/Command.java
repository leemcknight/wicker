package org.mcknight.wicker.commons.patterns;

public abstract class Command {
	private String commandName;
	
	public Command() {
		
	}
	
	public Command (String commandName) {
		this.commandName = commandName;
	}
	
	public void execute() {
		beforeExecute();
		executeCore();
		afterExecute();
	}
	
	public String getCommandName() {
		return commandName;
	}
	
	protected abstract void executeCore();
	
	protected void beforeExecute() {
		
	}
	
	protected void afterExecute() {
		
	}
}
