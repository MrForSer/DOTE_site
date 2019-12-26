package ru.nstu.forser.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.nstu.forser.entities.Employee;
import ru.nstu.forser.utils.HibernateSessionFactory;

import java.util.List;

public class EmployeeDAO {

    public void save(Employee employee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployments() {
        return (List<Employee>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Employee ORDER BY lastName")
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmpByName(String lastName) {
        return (List<Employee>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Employee WHERE lastName = :lastName ORDER BY lastName")
                .setParameter("lastName", lastName)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmpByDepartment(String department) {
        return (List<Employee>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Employee WHERE department = :department ORDER BY lastName")
                .setParameter("department", department)
                .list();
    }

    public List<?> getSalaryByDepartment() {
        Session session = HibernateSessionFactory
                .getSessionFactory()
                .openSession();

        String hql = "select e.department, SUM(e.salary) from Employee e group by e.department";

        List<?> list = session.createQuery(hql).list();
        session.close();
        return list;
    }

    public Employee findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Employee.class, id);
    }

    public void update(Employee employee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();
    }

    public void delete(Employee employee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }
}