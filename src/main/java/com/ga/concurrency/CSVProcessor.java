package com.ga.concurrency;

import com.ga.concurrency.model.Employee;
import com.ga.concurrency.model.Role;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class CSVProcessor {

    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    private final Lock lock = new ReentrantLock();
    private final Semaphore semaphore = new Semaphore(3);

    private List<Employee> readCSV(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .map(this::mapToEmployee)
                .toList();
    }

    private Employee mapToEmployee(String line) {
        String[] parts = line.split(",");

        return new Employee(
                Long.parseLong(parts[0]),
                parts[1],
                Double.parseDouble(parts[2]),
                LocalDate.parse(parts[3]),
                Role.valueOf(parts[4].toUpperCase()),
                Double.parseDouble(parts[5])
        );
    }

    private double calculateIncrement(Employee employee) {

        if (employee.getProjectCompletionPercentage() < 0.6) {
            return 0;
        }

        long yearsWorked = ChronoUnit.YEARS.between(
                employee.getJoinedDate(),
                LocalDate.now()
        );

        if (yearsWorked < 1) {
            return 0;
        }

        double yearIncrease = yearsWorked * 0.02;
        double roleIncrease = getRoleIncrease(employee.getRole());

        return yearIncrease + roleIncrease;
    }

    private double getRoleIncrease(Role role) {
        return switch (role) {
            case DIRECTOR -> 0.05;
            case MANAGER -> 0.02;
            case EMPLOYEE -> 0.01;
        };
    }

}
