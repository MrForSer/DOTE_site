package ru.nstu.forser.bean;

import ru.nstu.forser.jdbc.entity.Employee;

import java.util.List;

public interface EmployeeBean {

    List<Employee> getEmployees();

}