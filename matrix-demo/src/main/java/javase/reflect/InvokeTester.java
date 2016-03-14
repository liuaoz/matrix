package javase.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTester {

	public int add(int param1, int param2) {
		return param1 + param2;
	}

	public String echo(String msg) {
		return "echo:" + msg;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {

		Class<?> classType = InvokeTester.class;

		Method echoMethod = classType.getDeclaredMethod("echo", String.class);

		Object result = echoMethod.invoke(classType.newInstance(), new Object[] { "hello" });

		System.out.println(result);

	}

}
