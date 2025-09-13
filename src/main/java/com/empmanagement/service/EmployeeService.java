package com.empmanagement.service;

import com.empmanagement.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(Employee employee);

    public String  updateEmployee(Employee employee ,String empId );

    public Employee fetchSingleEmployeeById(String empId);

    public Employee fetchSingleEmployeeByUsername(String empUsername);

    public List<Employee>  fetchEmployeeBySalary(int salary);

    public List<Employee>  fetchAllEmployees();

    public String deleteEmployee(String empId);

    public List<Integer> fetchallEmployeeAges();
}
