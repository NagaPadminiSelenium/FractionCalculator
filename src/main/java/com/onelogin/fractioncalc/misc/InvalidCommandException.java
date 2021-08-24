package com.onelogin.fractioncalc.misc;

public class InvalidCommandException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidCommandException() {
		
	}

	public InvalidCommandException(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
