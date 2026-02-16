package com.ga.concurrency.model;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private LocalDate joinedDate;
    private Role role;
    private double projectCompletionPercentage;

    public Employee(String name, double salary, LocalDate joinedDate, Role role, double projectCompletionPercentage) {
        this.name = name;
        this.salary = salary;
        this.joinedDate = joinedDate;
        this.role = role;
        this.projectCompletionPercentage = projectCompletionPercentage;
    }
}
