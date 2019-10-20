package org.mcknight.wicker.json;

import java.util.List;
import java.util.stream.Stream;

public class WickerJson {
	public static String toJson(Object obj) {
		if(obj == null) {
			return "";
		}
		return "";
	}
	
	public static <T> T fromJson(String json, Class<T> type) {
		if(json == null) { 
			return null;
		}

		char[] tokens = json.toCharArray();
		List currentList = null;
		for(char token : tokens) {
			switch(token) {
			case '{':
				break;
			case '[':
				break;
			case '}':
				break;
			case ']':
				break;
			case ':':
				break;
			case ',':
				break;
			case '\"':
				break;
			default:
				break;
			}
								
		}
		return null;
	}
	
	private Object streamObject(Stream stream) {
		return null;
	}
}
