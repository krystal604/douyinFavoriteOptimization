package com.example.PersistenceStrategy;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableDubbo
@EnableAsync
@EnableAspectJAutoProxy
public class PersistenceStrategyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistenceStrategyApplication.class, args);
	}

}
