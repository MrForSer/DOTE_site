package ru.nstu.forser.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.nstu.forser.entities.Employee;
import ru.nstu.forser.utils.HibernateSessionFactory;

import javax.persistence.NoResultException;
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
    public List<Employee> findAllEmployees() {
        return (List<Employee>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Employee ORDER BY lastName")
                .list();
    }

    public Employee findEmployee(String lastName) {
        Employee employee = null;
        try {
            employee = (Employee) HibernateSessionFactory
                    .getSessionFactory()
                    .openSession()
                    .createQuery("FROM Employee WHERE lastName = :lastName")
                    .setParameter("lastName", lastName)
                    .getSingleResult();
        } catch (NoResultException ignore) {
        }
        return employee;
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