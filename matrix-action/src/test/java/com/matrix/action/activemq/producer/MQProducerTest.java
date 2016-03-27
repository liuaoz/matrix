package com.matrix.action.activemq.producer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.matrix.bo.email.EmailBo;

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
		MQProducer producer = (MQProducer) context.getBean("mQProducer");
		EmailBo emailBo = new EmailBo();
		emailBo.setFrom("cxx534@163.com");
		emailBo.setContent("this is the email content.");
		emailBo.setSubject("this is the email subject.");
		emailBo.setTo("1040197493@qq.com");
		for (int i = 0; i < 10; i++) {
			producer.sendMessage(emailBo);
		}
	}

	@After
	public void last() {
		System.out.println("context closing ...");
		// context.close();
	}

}
