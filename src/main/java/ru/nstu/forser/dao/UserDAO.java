package ru.nstu.forser.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import ru.nstu.forser.entities.User;
import ru.nstu.forser.utils.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDAO {

    public User findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
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
}