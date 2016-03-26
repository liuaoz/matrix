package com.matrix.util.activemq.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * 功能：消息生产者
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月26日
 */
@Service
public class MQProducer {

	@Autowired
	private JmsTemplate activeMqJmsTemplate;

	public void sendMessage(final MailParam mail) {
		activeMqJmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSONObject.toJSONString(mail));
			}
		});
	}

}
