package com.example.RestFul_Web_Service_Part1.Controller;


import com.example.RestFul_Web_Service_Part1.Model.Employee;
import com.example.RestFul_Web_Service_Part1.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class EmployeeController {

    @GetMapping("/")
    public  String test(){
        return "Welcome to spring boot";
    }
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getall")
    public List<Employee> getAllUser() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> adduser(@Valid @RequestBody Employee employee) {
        Employee employee1= employeeService.addEmployee(employee);

        return  new ResponseEntity<>(employee1,HttpStatus.CREATED);

       // return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);

    }

    @RequestMapping("/user/{id}")
    public ResponseEntity<Employee> getUser(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteuser(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "User Deleted Successfully";
    }

    @PutMapping("/{id}")
    public Employee updateUser(@PathVariable int id,@RequestBody Employee employee){
      return   employeeService.updateEmployee(id,employee);

    }

    @PatchMapping("//{id}")
    public Employee updateSpecificDetail(@PathVariable int id,@RequestBody Employee employee){
         return  employeeService.updateSpecificEmployee(id,employee);

    }
}
