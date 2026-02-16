package com.ga.concurrency.service;

import com.ga.concurrency.CSVProcessor;
import com.ga.concurrency.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    private final CSVProcessor csvProcessor;

    @Autowired
    public EmployeeService(CSVProcessor csvProcessor) {
        this.csvProcessor = csvProcessor;
    }

    public List<Employee> processEmployeeCSV(String filePath) throws IOException, InterruptedException {
        return csvProcessor.processAndReturnEmployees(filePath);
    }
}
