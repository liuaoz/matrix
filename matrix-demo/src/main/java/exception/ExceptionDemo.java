package exception;

public class ExceptionDemo {
	
	public static void main(String[] args) {
		isTrue(false);
		System.out.println("a");
		
	}
	
	
	public static boolean isTrue(boolean flag){
		if(flag){
			return flag;
		}else{
			throw new TestException();
		}
		
	}

}


class TestException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TestException() {
		
	}
	
	
}
