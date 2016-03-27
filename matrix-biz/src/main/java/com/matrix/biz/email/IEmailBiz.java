package com.matrix.biz.email;

import com.matrix.bo.email.EmailBo;

/**
 * 功能：邮件操作接口
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月26日
 */
public interface IEmailBiz {

	/**
	 * 发送模板邮件
	 * 
	 * @param mailBo
	 */
	public void sendEmail(final EmailBo emailBo);

}
