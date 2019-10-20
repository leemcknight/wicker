package org.mcknight.wicker.commons.fs;

import java.io.File;

public abstract class WickerFile {
	private String currentLine;
	private String path;
	private String filter;
	private String recordDelimeter;
	private String fieldDelimeter;
	private File file;
	private long limit;
	private Schema schema;

	
	public static WickerFile fromPath(String path) {
		WickerFile wickerFile = new WickerFile();
		wickerFile.file = new File(path);		
		return wickerFile;
	}
	
	public WickerFile withFilter(String filter) {
		this.filter = filter;
		return this;
	}
	
	public WickerFile withLimit(long limit) {
		this.limit = limit;
		return this;
	}
	
	public WickerFile withRecordDelimeter(String recordDelimeter) {
		this.recordDelimeter = recordDelimeter;
		return this;
	}
	
	public WickerFile withFieldDelimeter(String fieldDelimeter) {
		this.fieldDelimeter = fieldDelimeter;
		return this;
	}
	
	public WickerFile writeTo(String path) {
		return this;
	}
	
	public String nextLine() {	
		return "";
	}

	public WickerRecordSet read() {
		return null;
	}
		
}
