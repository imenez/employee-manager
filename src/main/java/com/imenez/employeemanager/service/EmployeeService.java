package com.imenez.employeemanager.service;

import com.imenez.employeemanager.exceptions.UserNotFoundException;
import com.imenez.employeemanager.model.Employee;
import com.imenez.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());


        employeeRepository.save(employee);
        return employee;
    }


    public List<Employee> findAllEmployee(){

        return employeeRepository.findAll();
    }

    @Transactional
    public void deleteEmployee(Long id){

        employeeRepository.deleteEmployeeById(id);
    }


    public Employee updateEmployee(Employee employee){


        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){


        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found" ));
    }
}
