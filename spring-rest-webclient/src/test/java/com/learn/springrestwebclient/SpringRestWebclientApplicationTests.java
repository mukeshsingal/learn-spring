package com.learn.springrestwebclient;

import com.learn.springrestwebclient.controller.EmployeeController;
import com.learn.springrestwebclient.dto.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class SpringRestWebclientApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	EmployeeController controller;

	@Test
	public void testGetAll() {
		List<Employee> list = controller.getAllEmployee();

		assertNotNull(list);
		assertEquals(4, list.size());
	}

	@Test
	public void testGetById() {
		Employee employee = controller.getById(1);

		assertNotNull(employee);
		assertEquals(1, employee.getId());
	}

}
