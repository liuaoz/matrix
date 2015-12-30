package com.matrix.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class BaseTest extends TestCase {

	protected static ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:/spring/spring_root.xml");

}
