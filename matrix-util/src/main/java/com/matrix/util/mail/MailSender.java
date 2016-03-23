package com.matrix.util.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 功能：邮件服务类
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月23日
 */
public class MailSender {

	/**
	 * 默认服务器邮件发送人邮箱
	 */
	private static String ACCOUNT_OF_SENDER = "cxx534@163.com";
	/**
	 * 默认服务器邮件发送人密码
	 */
	private static String PASSWORD_OF_SENDER = "wangyi,nihao!";

	/**
	 * 配置发送邮件的环境属性
	 */
	private static Properties props = new Properties();

	static {
		// 表示SMTP发送邮件，需要进行身份验证
		props.put("mail.smtp.auth", "true");
		// 发件人服务器
		props.put("mail.smtp.host", "smtp.163.com");
		// 发件人的账号
		props.put("mail.user", ACCOUNT_OF_SENDER);
		// 访问SMTP服务时需要提供的密码
		props.put("mail.password", PASSWORD_OF_SENDER);

	}

	/**
	 * 初始化邮件发送服务器
	 * 
	 * @param isAuth
	 *            是否身份验证
	 * @param host
	 *            服务器地址
	 * @param username
	 *            发送邮件人姓名
	 * @param password
	 *            发送邮件人密码
	 */
	public static void initServer(boolean isAuth, String host, String username, String password) {
		// 表示SMTP发送邮件，需要进行身份验证
		props.put("mail.smtp.auth", isAuth);

		props.put("mail.smtp.host", host);
		// 发件人的账号
		props.put("mail.user", username);
		// 访问SMTP服务时需要提供的密码
		props.put("mail.password", password);
	}

	/**
	 * 发送邮件
	 * 
	 * @param recipient
	 *            收件人邮箱
	 * @param cc
	 *            抄送人邮箱
	 * @param bcc
	 *            密送人邮箱
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @throws MessagingException
	 */
	public static void send(String recipient, String cc, String bcc, String subject, String content)
			throws MessagingException {
		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消息
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
		message.setFrom(form);

		// 设置收件人
		InternetAddress to = new InternetAddress(recipient);
		message.setRecipient(RecipientType.TO, to);

		// 设置抄送
		if (null != cc) {
			InternetAddress cca = new InternetAddress(cc);
			message.setRecipient(RecipientType.CC, cca);
		}

		// 设置密送，其他的收件人不能看到密送的邮件地址
		if (null != bcc) {
			InternetAddress bcca = new InternetAddress(bcc);
			message.setRecipient(RecipientType.BCC, bcca);
		}

		// 设置邮件标题
		message.setSubject(subject);

		// 设置邮件的内容体
		message.setContent(content, "text/html;charset=UTF-8");

		// 发送邮件
		Transport.send(message);
	}

	public static void main(String[] args) throws MessagingException {
		send("576729125@qq.com", null, null, "subject aaa", "content and content");
	}

}
