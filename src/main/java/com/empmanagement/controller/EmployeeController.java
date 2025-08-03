package com.empmanagement.controller;

import com.empmanagement.model.Employee;
import com.empmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createemployee")   //In this api we are creating employeedetails
    public Employee createEmployee(@RequestBody Employee employee){

        Employee employeeCreated = employeeService.createEmployee(employee);
        return employeeCreated;

    }

    @PutMapping("/updateemployee")
    public String  updateEmployee(@RequestBody Employee employee ,@RequestParam("empid") String empId ){

        String employeeUpdated = employeeService.updateEmployee(employee, empId);
        return  employeeUpdated;
    }

    @GetMapping("/fetchbyid")
    public Employee fetchSingleEmployeeById(@RequestParam("empid") String empId){

        Employee employeeDetails = employeeService.fetchSingleEmployeeById(empId);
        return  employeeDetails;

    }

    @GetMapping("/fetchbyusername")
    public Employee fetchSingleEmployeeByUsername(@RequestParam("empUsername") String empUsername){

        Employee employeeDetails = employeeService.fetchSingleEmployeeByUsername(empUsername);
        return employeeDetails;

    }

    @GetMapping("/fetchbysalary")
    public List<Employee> fetchEmployeeBySalary(@RequestParam("salary") int salary){

        List<Employee> empsalary = employeeService.fetchEmployeeBySalary(salary);
        return  empsalary;


    }

    @GetMapping("/fetchallemployee")
    public List<Employee>  fetchAllEmployees(){

        List<Employee> allEmployee = employeeService.fetchAllEmployees();
        return allEmployee;


    }

    @DeleteMapping("/deleteemployee")
    public String deleteEmployee(@RequestParam("empId") String empId){

        String employeeDeleted = employeeService.deleteEmployee(empId);
        return employeeDeleted;

    }
}
