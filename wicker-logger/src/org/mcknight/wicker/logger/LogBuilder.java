package org.mcknight.wicker.logger;

import java.io.PrintStream;

public class LogBuilder {
	private Class<?> clazz;
	private PrintStream out;
	private PrintStream error;
	private LogLevel logLevel;
	private boolean useConfig;
	
	
	public LogBuilder forClass(Class<?> clazz) {
		this.clazz = clazz;
		return this;
	}
	
	public LogBuilder fromConfiguration() {
		useConfig = true;
		return this;
	}
	
	public LogBuilder withLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
		return this;
	}
	
	public LogBuilder toStandardOut() {
		out = System.out;
		return this;
	}
	
	public LogBuilder toStream(PrintStream stream) {
		out = stream;
		return this;
	}
	
	public LogBuilder toStandardError() {
		error = System.err;
		return this;
	}
	
	public LogBuilder toErrorStream(PrintStream errorStream) {
		error = errorStream;
		return this;
	}
	
	public Log build() {
		if(out == null) {
			out = System.out;
		} 
		if(error == null) {
			error = System.err;
		}
		
		Log log = DefaultLogImpl.create(clazz, out, error, logLevel);
		return log;
		
	}
}
