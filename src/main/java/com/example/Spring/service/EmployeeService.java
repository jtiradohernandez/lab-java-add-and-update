package com.example.Spring.service;


import com.example.Spring.EmployeeStatus;
import com.example.Spring.model.Employee;
import com.example.Spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeId(int ID) {
        return employeeRepository.findByEmployeeId(ID);
    }

    public List<Employee> getEmployeesByStatus(Optional<EmployeeStatus> status) {
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getEmployeesByDepartment(Optional<String> department) {
        return employeeRepository.findAllByDepartment(department);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateStatus(int id, EmployeeStatus status){
        Employee employee = employeeRepository.findByEmployeeId(id).get();
        employee.setStatus(status);
        employeeRepository.save(employee);
    }

    public void updateDepartment(int id, String department) {
        Employee employee = employeeRepository.findByEmployeeId(id).get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }
}
