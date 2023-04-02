package com.example.RestFul_Web_Service_Part1.Service;

import com.example.RestFul_Web_Service_Part1.ExceptionHandling.ResourceNotFoundException;
import com.example.RestFul_Web_Service_Part1.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {

        return employees;
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("user not found"));
    }

    public Employee addEmployee(Employee employee) {

         employees.add(employee);
         return (getEmployeeById(employee.getId()));
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            emp.setName(employee.getName());
            emp.setAge(employee.getAge());
        }
        return emp;
    }

    public Employee updateSpecificEmployee(int id, Employee employee) {
        Employee emp = getEmployeeById(id);
        if (employee.getAge() != 0) {
            emp.setAge(employee.getAge());
        }
        if (employee.getName() != null) {
            emp.setName(employee.getName());
        }
        return emp;
    }

    public void deleteEmployee(int id) {

        employees.removeIf(employee -> employee.getId() == id);
    }
}