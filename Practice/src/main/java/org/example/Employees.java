package org.example;
import java.util.ArrayList;
import java.util.List;

public class Employees {

    private List<Employee> employees;

    public Employees() {
        employees = new ArrayList<>();
        // Hard code some sample employees
        employees.add(new Employee("1", "John", "Doe", "john@example.com", "Manager"));
        employees.add(new Employee("2", "Jane", "Smith", "jane@example.com", "Developer"));
        // Add more employees as needed
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
