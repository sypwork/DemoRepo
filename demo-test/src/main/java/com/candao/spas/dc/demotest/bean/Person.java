package com.candao.spas.dc.demotest.bean;

import lombok.Data;

/**
 * @author Nicholas
 * @title: Person
 * @projectName demo-test
 * @description: TODO
 * @date 2021-02-02 17:38
 */
@Data
public class Person {
    private String firstName;
    private String lastName;
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}