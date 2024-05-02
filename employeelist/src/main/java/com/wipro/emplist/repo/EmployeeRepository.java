package com.wipro.emplist.repo;

import org.springframework.stereotype.Component;
import com.wipro.emplist.dto.Employee;
import java.util.List;
import java.util.ArrayList;

@Component
public class EmployeeRepository {
    private List<Employee> employeeList;

    public EmployeeRepository() {
        super();
        employeeList = new ArrayList<>();
        Employee emp1 = new Employee(1, "Karthik", "Hyd", "E999");
        Employee emp2 = new Employee(2, "John Wick", "Bglr", "E777");
        Employee emp3 = new Employee(3, "Anil", "Hyd", "E88838");
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void deleteEmployeeById(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }


    }

