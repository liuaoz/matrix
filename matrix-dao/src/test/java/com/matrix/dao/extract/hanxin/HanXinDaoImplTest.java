package com.matrix.dao.extract.hanxin;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.matrix.entry.extract.hanxin.HanxinNameCidEntry;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:/spring/spring_root.xml"}) 
public class HanXinDaoImplTest extends TestCase {
	
	@Resource(name="hanXinDaoImpl")  
    private HanXinDaoImpl hanxin;

	@Test
	public void testSelectByCidName() {
		HanxinNameCidEntry entry = hanxin.selectByCidName();
		System.out.println(entry.getName());
		System.out.println(entry.getCid());
	}

}
