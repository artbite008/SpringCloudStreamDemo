package com.github.artbite008.springcloudstreamdemo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import com.github.artbite008.springcloudstreamdemo.messaging.MessagingChannel;

@Configuration
@EnableBinding(MessagingChannel.class)
public class MessagingConfig {

}
