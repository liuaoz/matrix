package com.matrix.action.activemq.producer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MQProducerTest {
	ClassPathXmlApplicationContext context;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("classpath:spring/spring_root.xml");
		System.out.println("context starting ...");
		context.start();
	}

	@Test
	public void testSendMessage() {
		System.out.println("success....");
	}

	@After
	public void last() {
		System.out.println("context closing ...");
//		context.close();
	}

}
