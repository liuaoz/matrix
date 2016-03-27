package com.matrix.action.activemq.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.matrix.bo.email.EmailBo;
import com.matrix.core.log.Log;

/**
 * 功能：消息生产者
 *
 * @author matrix
 * @version 1.0
 * @date 2016年3月26日
 */
@Service("mQProducer")
public class MQProducer {

	private static final Log log = Log.getLogger(MQProducer.class);

	@Autowired
	private JmsTemplate activeMqJmsTemplate;

	public void sendMessage(final EmailBo emailBo) {
		activeMqJmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				log.i("===MQProducer create message..." + emailBo.getTo());
				return session.createTextMessage(JSONObject.toJSONString(emailBo));
			}
		});
	}

}
