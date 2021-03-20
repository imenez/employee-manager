package com.imenez.employeemanager.controller;


import com.imenez.employeemanager.model.Employee;
import com.imenez.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> getAllEmployees(){

        return ResponseEntity.ok(employeeService.findAllEmployee());
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id){

        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }


    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){

        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){

        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }


    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){

        employeeService.deleteEmployee(id);
    }


}
