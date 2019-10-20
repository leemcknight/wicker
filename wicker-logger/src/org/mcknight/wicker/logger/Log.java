package org.mcknight.wicker.logger;

public interface Log {	
	void debug(String message);
	void info(String message);
	void trace(String message);
	void warn(String message);
	void error(String message);
}
