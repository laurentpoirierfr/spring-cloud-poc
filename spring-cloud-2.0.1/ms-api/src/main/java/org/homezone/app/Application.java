package org.homezone.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.homezone.app")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
