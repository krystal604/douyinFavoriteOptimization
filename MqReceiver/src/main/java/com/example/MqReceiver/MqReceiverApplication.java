package com.example.MqReceiver;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MqReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqReceiverApplication.class, args);
	}

}
