package spring.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings(value = { "deprecation" })
public class BeanFactoryTest {

	@Test
	public void testSimpleLoad() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring/beanFactoryTest.xml"));

		MyTestBean bean = (MyTestBean) bf.getBean(MyTestBean.class);// myTestBean

		System.out.println(bean.getTestStr());
	}

}
