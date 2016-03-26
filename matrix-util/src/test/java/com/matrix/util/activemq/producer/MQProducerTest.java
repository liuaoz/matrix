package com.matrix.util.activemq.producer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MQProducerTest {

	@Before
	public void init() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring_root.xml");
		System.out.println("aaa");
	}

	@Test
	public void testSendMessage() {
		fail("Not yet implemented");
	}

}
