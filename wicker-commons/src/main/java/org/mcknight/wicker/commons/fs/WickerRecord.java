package org.mcknight.wicker.commons.fs;

import java.util.Map;

public class WickerRecord {
	private Map<String, Object> map;
	
	public WickerRecord() {
		
	}

	public void add(String fieldName, Object data) {

	}
		
	public String getString(String fieldName) {
		return map.get(fieldName).toString();
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
