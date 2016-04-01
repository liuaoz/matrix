package com.matrix.action.activemq.listener;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSONObject;
import com.matrix.biz.email.IEmailBiz;
import com.matrix.bo.email.EmailBo;
import com.matrix.core.log.Log;

/**
 * 功能：监听器
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月26日
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<Message> {

	private static final Log log = Log.getLogger(ConsumerSessionAwareMessageListener.class);

	@Autowired
	private JmsTemplate activeMqJmsTemplate;

	@Autowired
	private Destination sessionAwareQueue;

	@Autowired
	private IEmailBiz mailBiz;

	public synchronized void onMessage(Message message, Session session) {

		try {
			ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
			final String ms = msg.getText();
			log.i("##receive message is ====>" + ms);
			EmailBo mail = JSONObject.parseObject(ms, EmailBo.class);
			if (null == mail) {
				return;
			}

			try {
				mailBiz.sendEmail(mail);
			} catch (Exception e) {
				activeMqJmsTemplate.send(sessionAwareQueue, new MessageCreator() {

					@Override
					public Message createMessage(Session session) throws JMSException {
						return session.createTextMessage(ms);
					}
				});

				log.e("===>mail exception:" + e);

			}

		} catch (Exception e) {
			log.e("===>:" + e);

		}

	}

}
