package com.ga.concurrency.controller;

import com.ga.concurrency.CSVProcessor;
import com.ga.concurrency.model.Employee;
import com.ga.concurrency.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/process")
    public List<Employee> processCSV(@RequestParam String filePath) {
        try {
            return employeeService.processEmployeeCSV(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Processing interrupted");
        }
    }
}
