package com.matrix.test.mem;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * @author matrix
 *
 * @date 2015Äê11ÔÂ8ÈÕ
 * 
 */
public class JavaMethodAreaOOM {

	static class OOObject{}
	
	public static void main(String[] args) {
		while(true){
			
			Enhancer enhancer = new Enhancer();
			
			enhancer.setSuperclass(OOObject.class);
			enhancer.setUseCache(false);
			
			enhancer.setCallback(new MethodInterceptor() {
				
				public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
					// TODO Auto-generated method stub
					return arg3.invokeSuper(arg0, arg2);
				}
			});
			
			enhancer.create();
		}
	}
	
	
/*
Exception in thread "main" org.springframework.cglib.core.CodeGenerationException: java.lang.reflect.InvocationTargetException-->null
	at org.springframework.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:237)
	at org.springframework.cglib.proxy.Enhancer.createHelper(Enhancer.java:377)
	at org.springframework.cglib.proxy.Enhancer.create(Enhancer.java:285)
	at com.matrix.test.mem.JavaMethodAreaOOM.main(JavaMethodAreaOOM.java:37)
Caused by: java.lang.reflect.InvocationTargetException
	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:384)
	at org.springframework.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:219)
	... 3 more
Caused by: java.lang.OutOfMemoryError: PermGen space
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:800)
	... 8 more


*/
}
