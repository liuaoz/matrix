package com.matrix.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * dao层抽象父类
 * 
 * @author matrix
 * @date 2015年9月20日
 * @since 1.0
 */
public abstract class BaseDao {
	/**
	 * 日志器
	 */
	final protected Logger logger = LoggerFactory.getLogger(this.getClass());

	// SqlMap sqlMap;

	/**
	 * 无参构造函数
	 */
	protected BaseDao() {
		super();
	}

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		if (null == this.sqlSessionTemplate) {
			return this.sqlSessionTemplate = new SqlSessionTemplate(this.sqlSessionFactory);
		} else
			return this.sqlSessionTemplate;
	}
	
	
	
	
}
