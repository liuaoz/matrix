package javase.reflect;

import java.lang.reflect.Method;

public class DumpMethod {

	public static void main(String[] args) throws ClassNotFoundException {
		String name = "java.util.Stack";

		Class<?> clazz = Class.forName(name);

		Method[] methods = clazz.getMethods();

		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].toString());
		}
	}

}
