# Concurrent CSV Data Processor

### Project Overview

The Concurrent CSV Data Processor is a Java Spring Boot application that processes employee data stored in CSV files concurrently. It applies salary increments based on project completion, years worked, and role, while demonstrating advanced concurrency control techniques such as thread pooling, locks, semaphores, and atomic counters.

---------------------------------------------------------

### Project Objectives

- Read employee data from a CSV file.
- Process data concurrently using CSVProcessor.
- Apply salary increments based on:
  - Project completion ≥ 60%
  - Years worked (2% per year if ≥ 1 year)
  - Role-based increase:
    - Director: 5%
    - Manager: 2%
    - Employee: 1%
- Ensure thread safety using locks, semaphores, and atomic counters.
- Demonstrate proper concurrency handling.
- Provide a REST API to read CSV from a file path and return processed employee data.

-------------------------------------------------------

### Project Structure 

The project follows standard Spring Boot conventions with clear separation of concerns:

- **controller** – Handles REST API endpoints.  
- **service** – Contains business logic.  
- **model** – Defines data structures:
  - `Employee` → stores employee info and salary updates  
  - `Role` → enum for role-based salary increments  
- **processor** – Core logic for reading CSV files, calculating salary increases, and applying concurrency controls:
  - Thread pool (ExecutorService)
  - Semaphore (limits concurrent threads)
  - ReentrantLock (thread-safe salary update)
  - AtomicInteger (tracks processed employees)

