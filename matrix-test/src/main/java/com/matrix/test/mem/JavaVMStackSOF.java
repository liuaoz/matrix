package com.matrix.test.mem;

/**
 * VM Args:-XSS128k
 * 
 * @author matrix
 *
 * @date 2015Äê11ÔÂ8ÈÕ
 * 
 */
public class JavaVMStackSOF {

	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		
		oom.stackLeak();
	}
/*
Exception in thread "main" java.lang.StackOverflowError
	at com.matrix.test.mem.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:17)
	at com.matrix.test.mem.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:17)
	at com.matrix.test.mem.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:17)
	at com.matrix.test.mem.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:17)

*/
}
