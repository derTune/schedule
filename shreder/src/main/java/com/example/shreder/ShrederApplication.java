package com.example.shreder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class ShrederApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShrederApplication.class, args);
	}

	@Bean
	public TaskScheduler taskScheduler() {
		final ThreadPoolTaskScheduler thread = new ThreadPoolTaskScheduler();
		thread.setPoolSize(10);
		return thread;
	}

	@Scheduled(cron = "1/3 * * * * ?")
	public void currentDate() {
		System.err.println("Started " + new Date());
		System.out.println(Thread.currentThread().getName() + "\n");
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		System.err.println("Current date = " + new Date());
	}
}
