package com.matrix.dao.account;

/**
 * 转账管理dao层接口
 * 
 * @author matrix
 * @date 2015年9月20日
 * @since 1.0
 */
public interface IAccountDao {

	/**
	 * 转入账号 加钱操作
	 * 
	 * @param id
	 *            转入账号
	 * @param money
	 *            转账金额
	 */
	void inMoney(String id, double money);

	/**
	 * 转出账号 减钱操作
	 * 
	 * @param id
	 *            转出账号
	 * @param money
	 *            转账金额
	 */
	void outMoney(String id, double money);
}
