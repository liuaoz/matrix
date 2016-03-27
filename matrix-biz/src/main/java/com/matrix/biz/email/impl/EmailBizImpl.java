package com.matrix.biz.email.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.matrix.biz.email.IEmailBiz;
import com.matrix.bo.email.EmailBo;
import com.matrix.core.log.Log;

/**
 * 功能：邮件操作实现类
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月26日
 */
@Service("mailBiz")
public class EmailBizImpl implements IEmailBiz {

	private static final Log log = Log.getLogger(EmailBizImpl.class);

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SimpleMailMessage simpleMailMessage;

	@Autowired
	private ThreadPoolTaskExecutor threadPool;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.matrix.biz.email.IEmailBiz#sendEmail(com.matrix.bo.email.EmailBo)
	 */
	@Override
	public void sendEmail(final EmailBo emailBo) {

		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("===========3=============");
					log.i("===EmailBizImpl sendEmail...");
					simpleMailMessage.setFrom(emailBo.getFrom());
					simpleMailMessage.setTo(emailBo.getTo());
					simpleMailMessage.setSubject(emailBo.getSubject());
					simpleMailMessage.setText(emailBo.getContent());
					mailSender.send(simpleMailMessage);
				} catch (MailException e) {
					log.e("==>" + e);
					throw e;
				}
			}
		});

	}

}
