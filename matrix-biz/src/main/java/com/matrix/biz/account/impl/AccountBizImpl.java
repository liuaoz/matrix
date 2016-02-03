package com.matrix.biz.account.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.matrix.biz.account.IAccountBiz;
import com.matrix.dao.account.IAccountDao;

public class AccountBizImpl implements IAccountBiz {

	@Autowired
	private IAccountDao accountDao;

	public void transfer(String out, String in, double money) {
		accountDao.outMoney(out, money);
		accountDao.inMoney(in, money);
	}

	public IAccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
