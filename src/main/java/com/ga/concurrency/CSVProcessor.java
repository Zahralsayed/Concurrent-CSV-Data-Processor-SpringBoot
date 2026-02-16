package com.ga.concurrency;

import com.ga.concurrency.model.Employee;
import com.ga.concurrency.model.Role;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class CSVProcessor {



    private Employee mapToEmployee(String line) {
        String[] parts = line.split(",");

        return new Employee(
                parts[1],
                Double.parseDouble(parts[2]),
                LocalDate.parse(parts[3]),
                Role.valueOf(parts[4].toUpperCase()),
                Double.parseDouble(parts[5])
        );
    }

}
