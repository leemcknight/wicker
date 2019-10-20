package org.mcknight.wicker.logger;

public enum LogLevel {
	TRACE(1),
	DEBUG(2),
	INFO(3),
	WARN(4),
	ERROR(5);
	
	private int level;	
	
	LogLevel(int level) {
		this.level = level;
	}
	
	public int value() {
		return level;
	}
		
}
