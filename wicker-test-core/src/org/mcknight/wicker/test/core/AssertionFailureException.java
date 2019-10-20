package org.mcknight.wicker.test.core;

public class AssertionFailureException extends RuntimeException {
	
	private static final long serialVersionUID = -1473470883522985066L;
	public AssertionFailureException() {
		
	}
	
	public AssertionFailureException(String message) {
		super(message);
	}

}
