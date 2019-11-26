package ru.nstu.forser.jdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int salary;

    public Employee(ResultSet resultSet) throws SQLException {
        this.employeeId = resultSet.getInt(1);
        this.firstName = resultSet.getString(2);
        this.lastName = resultSet.getString(3);
        this.email = resultSet.getString(4);
        this.phoneNumber = resultSet.getString(5);
        this.salary = resultSet.getInt(6);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}
