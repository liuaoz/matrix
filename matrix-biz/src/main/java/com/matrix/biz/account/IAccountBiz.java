package com.matrix.biz.account;

/**
 * 功能：转账业务层接口
 * 
 * @author matrix
 * @date 2015年9月20日
 * @since
 */
public interface IAccountBiz {

	/**
	 * 转账操作
	 * 
	 * @param out
	 *            转出账号
	 * @param in
	 *            转入账号
	 * @param money
	 *            转账金额
	 */
	void transfer(String out, String in, double money);

}
