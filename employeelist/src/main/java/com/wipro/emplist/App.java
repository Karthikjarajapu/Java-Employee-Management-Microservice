package com.wipro.emplist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.wipro.emplist.service.EmployeeService;
import java.util.Scanner;
import java.util.List;
import com.wipro.emplist.dto.Employee;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.wipro.*");
        ctx.refresh();
        EmployeeService employeeService = ctx.getBean(EmployeeService.class);
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            System.out.println("---Employee Management");
            System.out.println("1.Print All Employees");
            System.out.println("2.Search Employee by ID");
            System.out.println("3.Delete Employee by ID");
            System.out.println("9.Quit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    List<Employee> employees = employeeService.getAllEmployees();
//                    for (Employee employee : employees) {
                    System.out.println(employees);
//                    }
                    
                    break;
                case 2:
                    System.out.println("Enter Employee ID to search:");
                    try {
                        int searchId = Integer.parseInt(scanner.nextLine()); // Read integer input
                        Employee foundEmployee = employeeService.getEmployeeById(searchId);
                        if (foundEmployee != null) {
                            System.out.println(foundEmployee);
                        } else {
                            System.out.println("Employee not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid Employee ID.");
                    }
                    break;
                case 3:
                    System.out.println("Enter Employee ID to delete:");
                    try {
                        int deleteId = Integer.parseInt(scanner.nextLine()); // Read integer input
                        employeeService.deleteEmployeeById(deleteId);
                        System.out.println("Employee deleted successfully.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid Employee ID.");
                    }
                    break;
                case 9:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }

        scanner.close(); // Close scanner
        ctx.close(); // Close Spring context
    }
}
