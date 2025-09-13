package com.empmanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//@Data It is the combination of @Getter @Setter @NoArgsConstructor @AllArgsConstructor


public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private String empId;


    @Column(name = "empUsername")
    private String empUsername;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @Column(name = "departmentName")
    private String departmentName;
}
