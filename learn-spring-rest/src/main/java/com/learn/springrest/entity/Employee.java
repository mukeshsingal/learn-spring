package com.learn.springrest.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int id;
    private String fistName;
    private String lastName;
    private String gender;

}
