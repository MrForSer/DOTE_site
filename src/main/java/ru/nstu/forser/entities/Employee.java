package ru.nstu.forser.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String department;
    private int salary;
    private int rank;

    // необходимо для useBean, не удалять
    public Employee() {
        this.lastName = null;
    }

    public Employee(int id, String lastName, String department, int salary, int rank) {
        this.id = id;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.rank = rank;
    }

    public String getEmployeeData() {
        return  "Фамилия: " + lastName + " Цех: " + department + " Зарплата: " + salary + " Разряд: " + rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
