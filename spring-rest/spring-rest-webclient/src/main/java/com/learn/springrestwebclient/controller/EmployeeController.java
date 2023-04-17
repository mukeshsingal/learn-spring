package com.learn.springrestwebclient.controller;

import com.learn.springrestwebclient.constants.RestConstants;
import com.learn.springrestwebclient.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

@Component
@Slf4j
public class EmployeeController {

    @Autowired
    WebClient client;


    public List<Employee> getAllEmployee() {

        return client.get()
                .uri(RestConstants.EMPLOYEE_ROOT)
                .retrieve()
                .bodyToFlux(Employee.class)
                .collectList()
                .block();
    }

    public Employee getById(int id) {

        return client.get()
                .uri(RestConstants.EMPLOYEE_BY_ID, id)
                .retrieve()
                .bodyToMono(Employee.class)
                .block();
    }

    public Employee getByName(String name) {

        return client.get()
                .uri(RestConstants.EMPLOYEE_BY_NAME, name)
                .retrieve()
                .bodyToMono(Employee.class)
                .block();
    }

}
