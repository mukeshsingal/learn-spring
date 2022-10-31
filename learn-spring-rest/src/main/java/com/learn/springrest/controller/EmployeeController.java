package com.learn.springrest.controller;

import com.learn.springrest.EmployeeCollection;
import com.learn.springrest.entity.Employee;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee")
@Tag(name = "Employee Resource APIs")
public class EmployeeController {

    int counter = 5;

    @Autowired
    EmployeeCollection collection;



    @GetMapping(value = "", name = "Get all employees")
    List<Employee> getAllEmployees() {
        return collection.getEmployees();
    }


    @GetMapping(value = "/byName", name = "Get employee by employee name")
    List<Employee> getByName(@RequestParam(required = true, name = "name") String name) {
        List<Employee> employees = collection.getEmployees()
                .stream()
                .filter(empName -> empName.getFistName().equals(name))
                .collect(Collectors.toList());
        return employees;
    }

    @GetMapping(value = "/{id}", name = "Get employee by employee id")
    ResponseEntity getById(@PathVariable int id) {
        Optional<Employee> employee = collection.getEmployees()
                .stream()
                .filter(empName -> empName.getId() == id)
                .findAny();

        if(employee.isPresent()) {
            return  new ResponseEntity(employee.get(), HttpStatus.BAD_REQUEST);
        }
        else {
            return  new ResponseEntity("Invalid input.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "", name = "Create employee")
    ResponseEntity createEmployee(@RequestBody Employee employee) {

        if(employee.getFistName() == null || employee.getFistName().equals("")) {
            return  new ResponseEntity("First name cannot be null.", HttpStatus.BAD_REQUEST);
        }
        if(employee.getLastName() == null || employee.getLastName().equals("")) {
            return  new ResponseEntity("Last name cannot be null.", HttpStatus.BAD_REQUEST);
        }
        if(employee.getGender() == null || employee.getGender().equals("")) {
            return  new ResponseEntity("Gender cannot be null.", HttpStatus.BAD_REQUEST);
        }

        employee.setId(counter++);
        collection.getEmployees().add(employee);

        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", name = "Update employee")
    ResponseEntity updateEmployee(@RequestBody Employee employee, @PathVariable int id) {

        Optional<Employee> checkEmployee = collection.getEmployees()
                        .stream().filter(emp -> emp.getId() == id)
                        .findFirst();

        if(checkEmployee.isPresent()) {
            Employee existingEmployee = checkEmployee.get();

            existingEmployee.setFistName(employee.getFistName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setGender(employee.getGender());

            return new ResponseEntity(existingEmployee, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Failed to find the employee with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(value = "/{id}", name = "Patch employee")
    ResponseEntity patchEmployee(@RequestBody Employee employee, @PathVariable int id) {

        Optional<Employee> checkEmployee = collection.getEmployees()
                .stream().filter(emp -> emp.getId() == id)
                .findFirst();

        if(checkEmployee.isPresent()) {
            Employee existingEmployee = checkEmployee.get();

            if(employee.getFistName() != null) {
                existingEmployee.setFistName(employee.getFistName());
            }

            if(employee.getLastName() != null) {
                existingEmployee.setLastName(employee.getLastName());
            }

            if(employee.getGender() != null) {
                existingEmployee.setGender(employee.getGender());
            }
            return new ResponseEntity(existingEmployee, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Failed to find the employee with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", name = "Delete employee")
    ResponseEntity patchEmployee(@PathVariable int id) {

        Optional<Employee> checkEmployee = collection.getEmployees()
                .stream().filter(emp -> emp.getId() == id)
                .findFirst();

        if(checkEmployee.isPresent()) {
            Employee existingEmployee = checkEmployee.get();

           collection.getEmployees().remove(existingEmployee);

            return new ResponseEntity("Deleted the employee with id " + id, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Failed to find the employee with id " + id, HttpStatus.NOT_FOUND);
        }
    }

}
