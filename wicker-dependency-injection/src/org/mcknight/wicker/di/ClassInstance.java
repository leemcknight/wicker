package org.mcknight.wicker.di;

import java.util.HashMap;
import java.util.Map;

public class ClassInstance {
	private String className;
	private Map<String, String> attributes;
	
	public ClassInstance() {
		attributes = new HashMap<>();
	}
	
	
	public void addAttribute(String attributeName, String attributeValue) {
		attributes.put(attributeName, attributeValue);
	}
}
