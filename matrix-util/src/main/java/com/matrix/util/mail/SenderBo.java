package com.matrix.util.mail;

/**
 * 功能：发件人信息
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月23日
 */
public class SenderBo {

	/**
	 * 邮件发送人姓名
	 */
	private String username;

	/**
	 * 邮件发送人邮箱地址
	 */
	private String email;

	/**
	 * 邮件发送人密码
	 */
	private String password;

	public SenderBo() {
	}

	public SenderBo(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
