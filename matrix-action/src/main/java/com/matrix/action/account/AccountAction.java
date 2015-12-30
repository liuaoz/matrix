package com.matrix.action.account;

import org.springframework.beans.factory.annotation.Autowired;

import com.matrix.biz.account.IAccountBiz;

import junit.framework.TestCase;

/**
 * 功能：转账控制器
 * 
 * @author matrix
 * @date 2015年9月20日
 * @since
 */

public class AccountAction extends TestCase {

	@Autowired
	IAccountBiz iAccountBiz;

	public void transfer(String out, String in, double money) {
		iAccountBiz.transfer(out, in, money);
	}

}
