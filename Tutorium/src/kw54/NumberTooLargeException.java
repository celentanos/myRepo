package kw54;

public class NumberTooLargeException extends Exception {

	public NumberTooLargeException() {
		System.err.println("Ich bin eine eigene Ausnahme");
	}

	public NumberTooLargeException(String message) {
		super("Ich bin eine eigeb´ne Ausnahme\n" + message);
	}



}
