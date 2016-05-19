package exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		m2();
	}

	public static void m1() {
		throw new RunException("aaa");
	}

	public static void m2() {
		m1();
	}

}

class RunException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RunException() {

	}

	public RunException(String message) {
		super(message);
	}

}

class CheckException extends Exception {

	private static final long serialVersionUID = 1L;

	public CheckException() {
	}

}
