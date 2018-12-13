package com.vtyc.sendmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.vtyc.sendmail.dao.*")
@EnableScheduling
public class SendmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendmailApplication.class, args);
	}
}
