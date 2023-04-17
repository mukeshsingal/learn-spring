package com.learn.springrestwebclient;

import com.learn.springrestwebclient.controller.EmployeeController;
import com.learn.springrestwebclient.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringRestWebclientApplication implements CommandLineRunner {

	@Autowired
	EmployeeController restClient;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestWebclientApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		List<Employee> employees = restClient.getAllEmployee();
		employees.forEach(System.out::println);
	}
}
