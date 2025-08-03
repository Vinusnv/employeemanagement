package com.empmanagement.repository;

import com.empmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,String> {

    public Employee findByEmpUsername(String empUsername);

    public List<Employee>  findByAge(int age);     //Internally it forms query in such a way that select * from employee where emp age

    public List<Employee>  findBySalary(int salary);
}
