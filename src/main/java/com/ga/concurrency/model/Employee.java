package com.ga.concurrency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private double salary;
    private LocalDate joinedDate;
    private Role role;
    private double projectCompletionPercentage;


    public void applySalaryIncrease(double percentage) {
        this.salary = this.salary * (1 + percentage);
    }
}
