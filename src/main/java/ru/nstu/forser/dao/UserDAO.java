package ru.nstu.forser.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.nstu.forser.entities.User;
import ru.nstu.forser.utils.HibernateSessionFactory;

import javax.persistence.NoResultException;
import java.util.List;

public class UserDAO {

    public void save(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        return (List<User>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("FROM User")
                .list();
    }

    public User findUser(String login, String password) {
        User user = null;
        try {
            user = (User) HibernateSessionFactory
                    .getSessionFactory()
                    .openSession()
                    .createQuery("FROM User WHERE login = :login AND password = :password")
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException ignore) {
        }
        return user;
    }

    public User findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(User.class, id);
    }

    public void update(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}