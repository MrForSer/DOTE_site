package ru.nstu.forser.jdbc;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.nstu.forser.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User findUser(String login, String password) {
        return null;
    }

    @Override
    public void insertNewUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.getTransaction().commit();
    }

    @Override
    public List<String> getAllUserNames() {
        return em.createQuery("Select t from " + User.class.getSimpleName() + " t").getResultList();
    }
}