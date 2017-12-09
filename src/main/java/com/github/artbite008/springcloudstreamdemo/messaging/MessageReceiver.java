package com.github.artbite008.springcloudstreamdemo.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiver {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MessagingChannel messagingChannel;

	@StreamListener("message-in-test")
	public void test(String str) {
		logger.info("got message from message-in-test, {}", str);
	}

	@StreamListener("message-in")
	public void handle(String str) {
		logger.info("got message from message-in, {}", str);

		Message<String> msg = MessageBuilder.withPayload(str.toUpperCase()).build();

		messagingChannel.output().send(msg);
	}

}
