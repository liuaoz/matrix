package com.matrix.action.activemq.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MQConsumer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context;
		context = new ClassPathXmlApplicationContext("classpath:spring/spring_root2.xml");
		context.start();
		System.out.println("context2 started ...");

	}

}
