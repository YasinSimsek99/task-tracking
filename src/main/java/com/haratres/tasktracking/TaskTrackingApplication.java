package com.haratres.tasktracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Yasin
 *
 */
@SpringBootApplication
public class TaskTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackingApplication.class, args);
	}

}
