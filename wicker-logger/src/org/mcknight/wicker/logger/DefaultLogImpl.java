package org.mcknight.wicker.logger;

import java.io.PrintStream;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DefaultLogImpl implements Log {	
	private Class<?> clazz;
	private PrintStream out;
	private PrintStream error;
	private LogLevel logLevel;
	
	private DefaultLogImpl() {
		
	}
	
	static Log create(Class<?> clazz, PrintStream out, PrintStream err, LogLevel logLevel) {
		DefaultLogImpl impl = new DefaultLogImpl();
		impl.clazz = clazz;
		impl.out = out;
		impl.error = err;
		impl.logLevel = logLevel;
		return impl;
	}
	
	@Override
	public void debug(String message) {
		if(logLevel.value() >= LogLevel.DEBUG.value()) {
			outCore(message, "DEBUG");
		}
	}

	@Override
	public void info(String message) {
		if(logLevel.value() >= LogLevel.INFO.value()) {
			outCore(message, "INFO");
		}
		
	}

	@Override
	public void trace(String message) {
		if(logLevel.value() >= LogLevel.TRACE.value()) {
			outCore(message, "TRACE");
		}
		
	}

	@Override
	public void warn(String message) {
		if(logLevel.value() >= LogLevel.WARN.value()) {
			outCore(message, "WARN");
		}
		
	}

	@Override
	public void error(String message) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateString = df.format(new Date());
		error.printf("%s: %s: %s: %s", dateString, clazz.getName(), "ERROR", message);
		
	}
	
	private void outCore(String message, String logType) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateString = df.format(new Date());
		out.printf("%s: %s: %s: %s", dateString, clazz.getName(), logType, message);
	}
	
}
