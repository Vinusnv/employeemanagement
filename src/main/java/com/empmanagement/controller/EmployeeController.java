package com.empmanagement.controller;

import com.empmanagement.model.Employee;
import com.empmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Value("${price}")
    private String price;

    @PostMapping("/createemployee")   //In this api we are creating employeedetails
    public ResponseEntity<Employee>  createEmployee(@RequestBody Employee employee){

        Employee employeeCreated = employeeService.createEmployee(employee);


//        return  new ResponseEntity<Employee>(employeeCreated, HttpStatus.CREATED)  ;
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeCreated);



    }

    @PutMapping("/updateemployee") // In this api we are updating the employeedetails
    public String  updateEmployee(@RequestBody Employee employee ,@RequestParam("empid") String empId ){

        String employeeUpdated = employeeService.updateEmployee(employee, empId);
        return  employeeUpdated + price;
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

//    @GetMapping("/fetchbysalary")  // In this method we are fetching employee salary
//    public List<Employee> fetchEmployeeBySalary(@RequestParam("salary") int salary){
//
//        List<Employee> empsalary = employeeService.fetchEmployeeBySalary(salary);
//        return  empsalary;
//
//
//    }



    @GetMapping("/fetchbysalary/{salary}")  // In this method we are fetching employee salary
    public List<Employee> fetchEmployeeBySalary(@PathVariable("salary") int salary){

        List<Employee> empsalary = employeeService.fetchEmployeeBySalary(salary);
        return  empsalary;


    }




    @GetMapping("/fetchallemployee") // In this method we are fetching all employee details
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
