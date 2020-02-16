package org.mcknight.wicker.commons.fs;

import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WickerRecord {
	private Map<String, Object> map;
	
	public WickerRecord() {
		map = new HashMap<String, Object>();
	}

	public List<String> fields() {
		return Collections.unmodifiableList(map.keySet().stream().collect(Collectors.toList()));
	}

	public void add(String fieldName, Object data) {
		map.put(fieldName, data);
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
