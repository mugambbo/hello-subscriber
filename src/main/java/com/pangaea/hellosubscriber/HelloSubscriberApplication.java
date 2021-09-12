package com.pangaea.hellosubscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HelloSubscriberApplication {

	public final static String MESSAGE_QUEUE = "message-queue";

	public static void main(String[] args) {
		SpringApplication.run(HelloSubscriberApplication.class, args);
	}

	@Bean
	public WebClient client() {
		return WebClient.create();
	}

}
