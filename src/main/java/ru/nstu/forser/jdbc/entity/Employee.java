package ru.nstu.forser.jdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Employee {
    public int getEmployee_Id() {
        return Employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        Employee_Id = employee_Id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getJob_Id() {
        return Job_Id;
    }

    public void setJob_Id(String job_Id) {
        Job_Id = job_Id;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    private int Employee_Id;
    private String First_Name;
    private String Last_Name;
    private String Email;
    private String Phone_Number;
    private String Job_Id;
    private int Salary;

    public Employee(ResultSet resultSet) throws SQLException {
        this.Employee_Id = resultSet.getInt(1);
        this.First_Name = resultSet.getString(2);
        this.Last_Name = resultSet.getString(3);
        this.Email = resultSet.getString(4);
        this.Phone_Number = resultSet.getString(5);
        this.Job_Id = resultSet.getString(6);
        this.Salary = resultSet.getInt(7);
    }


}
