package com.learn.springrest;

import com.learn.springrest.entity.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class EmployeeCollection {

    List<Employee> employees;

    public EmployeeCollection() {
        employees = new ArrayList<>();

        employees.add(new Employee(1, "mukesh", "singal", "male"));
        employees.add(new Employee(2, "rinku", "patel", "male"));
        employees.add(new Employee(3, "dev", "kumar", "male"));
        employees.add(new Employee(4, "manjeet", "nindania", "male"));
    }


}
