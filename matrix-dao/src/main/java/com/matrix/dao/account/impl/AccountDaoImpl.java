package com.matrix.dao.account.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.matrix.dao.account.IAccountDao;

/**
 * 转账管理dao层实现类
 * 
 * @author matrix
 * @date 2015年9月20日
 * @since 1.0
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

	public AccountDaoImpl() {
		System.out.println("=================");
		this.getJdbcTemplate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.matrix.dao.account.IAccountDao#inMoney(java.lang.String, double)
	 */
	public void inMoney(String id, double money) {
		String sql = "update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(sql, money, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.matrix.dao.account.IAccountDao#outMoney(java.lang.String,
	 * double)
	 */
	public void outMoney(String id, double money) {
		String sql = "update account set money = money - ? where name = ?";
		this.getJdbcTemplate().update(sql, money, id);
	}

}
