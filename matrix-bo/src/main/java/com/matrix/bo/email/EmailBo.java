package com.matrix.bo.email;

/**
 * 功能：邮件参数
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月26日
 */
public class EmailBo {

	private String from;

	private String to;

	private String subject;

	private String content;

	public EmailBo() {
	}

	public EmailBo(String to, String subject, String content) {
		super();
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
