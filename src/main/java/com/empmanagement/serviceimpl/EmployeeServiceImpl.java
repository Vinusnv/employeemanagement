package com.empmanagement.serviceimpl;

import com.empmanagement.Exception.EmployeeFoundException;
import com.empmanagement.Exception.EmployeeNotFoundException;
import com.empmanagement.model.Employee;
import com.empmanagement.repository.EmployeeRepo;
import com.empmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;



    @Override
    public Employee createEmployee(Employee employee) {

        Employee foundEmployee = employeeRepo.findByEmpUsername(employee.getEmpUsername());

        if(foundEmployee!=null)
        {
           throw new EmployeeFoundException("Employee found with the given UserName");
        }
        else{

            Employee employeeCreated = employeeRepo.save(employee);

            return  employeeCreated;
        }

    }

    @Override
    public String updateEmployee(Employee employee, String empId) {

        Employee employeeFound = employeeRepo.findById(empId).get();

        if(employeeFound!=null){

            employeeFound.setAge(employee.getAge());
            employeeFound.setFirstName(employee.getFirstName());
            employeeFound.setLastName(employee.getLastName());
            employeeFound.setSalary(employee.getSalary());
            employeeFound.setDepartmentName(employee.getDepartmentName());

            employeeRepo.save(employeeFound);

            return "Employee " + employeeFound.getEmpUsername()+" updated successfully";
        }
       throw new EmployeeNotFoundException("Employee " + employeeFound.getEmpUsername()+" Not Found So we cannot perform update operation");
    }

    @Override
    public Employee fetchSingleEmployeeById(String empId) {

        Employee employeeFound = employeeRepo.findById(empId).get();

        if(employeeFound!=null){
            return employeeFound;
        }
        throw  new EmployeeNotFoundException("Employee with given "+ empId +" Not Found");
    }

    @Override
    public Employee fetchSingleEmployeeByUsername(String empUsername) {

        Employee employeeFound = employeeRepo.findByEmpUsername(empUsername);

        if(employeeFound!=null){
            return employeeFound;
        }
        throw  new EmployeeNotFoundException("Employee with given "+ empUsername +" Not Found");

    }

    @Override
    public List<Employee> fetchEmployeeBySalary(int salary) {

        List<Employee> employeeSalaries = employeeRepo.findBySalary(salary);

        return employeeSalaries;
    }

    @Override
    public List<Employee> fetchAllEmployees() {

        List<Employee> allTheEmployeeDetails = employeeRepo.findAll();

        return allTheEmployeeDetails;
    }

    @Override
    public String deleteEmployee(String empId) {

        Employee employeeFound = employeeRepo.findById(empId).get();

        if(employeeFound!=null){

            employeeRepo.delete(employeeFound);
            return " Employee with given "+ empId +" deleted Successfully";
        }

        throw new EmployeeNotFoundException(" Employee with given id "+empId+" is not found");


    }
}
