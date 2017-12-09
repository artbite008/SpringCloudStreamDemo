package com.github.artbite008.springcloudstreamdemo.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessagingChannel {
	
	@Input("message-in")
    SubscribableChannel input();


    @Input("message-in-test")
    SubscribableChannel test();

    @Output("message-out")
    org.springframework.messaging.MessageChannel output();


}
