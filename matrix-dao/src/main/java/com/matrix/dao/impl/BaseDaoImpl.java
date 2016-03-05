package com.matrix.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BaseDaoImpl {
	
	
	private static Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	@Autowired(required=true)
	SqlSessionFactory sqlSessionFactory;
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		if (this.sqlSessionTemplate == null)
		{
			this.sqlSessionTemplate = new SqlSessionTemplate(this.sqlSessionFactory);
		}
		return this.sqlSessionTemplate;
	}
	
	public Object queryForObjectBySql(String statement, Object parameter) {
		long l1 = System.currentTimeMillis();
		Object bean = this.getSqlSessionTemplate().selectOne(statement, parameter);
		long l2 = System.currentTimeMillis();
		logger.debug("Execute queryForObjectBySql time:" + (l2 - l1) + "ms");
		return bean;
	}


}
