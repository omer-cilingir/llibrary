package com.call.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.call.application.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = { StorageProperties.class })
public class CallAppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CallAppApplication.class, args);
	}
}
