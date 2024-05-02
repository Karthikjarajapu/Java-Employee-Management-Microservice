package com.wipro.emplist.dto;

public class Employee {
    private int id;
    private String name;
    private String address;
    private String employeeId;

    public Employee(int id, String name, String address, String employeeId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", employeeId=" + employeeId + "]";
    }
}
