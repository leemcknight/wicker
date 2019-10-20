package org.mcknight.wicker.commons.fs;

import java.util.Map;

public class WickerRecord {
	private Map<String, String> map;
	
	public WickerRecord() {
		
	}
	public WickerRecord withSchema(Schema schema) {
		return this;
	}
	
	public WickerRecord withData(String data) {
		return this;
	}
	
	public String getString(String fieldName) {
		return map.get(fieldName);
	}
	
	public long getLong(String fieldName) {
		return Long.parseLong(getString(fieldName));
	}
	
	public short getShort(String fieldName) {
		return Short.parseShort(getString(fieldName));		
	}
	
	public int getInt(String fieldName) {
		return Integer.parseInt(getString(fieldName));
	}
	
	public float getFloat(String fieldName) {
		return Float.parseFloat(getString(fieldName));
	}
	
	public double getDouble(String fieldName) {
		return Double.parseDouble(getString(fieldName));
	}
}
