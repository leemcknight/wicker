package org.mcknight.wicker.test.core;

public class Assert {
	public static void assertTrue(boolean condition) {
		if(!condition) {
			throw new AssertionFailureException("Assertion failed.  Condition was FALSE.");
		}
	}
	
	public static <T> void assertEquals(T expected, T actual) {
		if(expected == null  && actual == null) {
			return;
		}
		if(expected != null) {
			if(expected.equals(actual)) {
				return;
			}
		}
		throw new AssertionFailureException(
				"Assertion failed. \n Expected: " + 
				expected.toString() + " \n Actual: " + 
				actual.toString());
	}
	
	public static <T> void assertSame(T expected, T actual) {
		if(expected == null && actual == null) {
			return;
		}
		if(expected != null) {
			if(expected != actual) {
				throw new AssertionFailureException("Assertion failed.  Object references were different.");
			}
		}
	}
}
