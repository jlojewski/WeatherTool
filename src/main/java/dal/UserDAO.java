package dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import dal.entities.User;
import dal.entities.UserPreferences;
import util.HibernateUtil;

import java.util.Optional;

public class UserDAO {

    SessionFactory sessionFactory;

    public UserDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void addNewUser(String login, String password, String defaultCity, Integer defaultDays) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User newUser = new User();
        newUser.setLogin(login);
        newUser.setPassword(password);
        UserPreferences newUserPreferences = new UserPreferences();
        newUserPreferences.setDefaultCity(defaultCity);
        newUserPreferences.setDefaultNumberOfDays(defaultDays);

        session.save(newUser);
        session.getTransaction().commit();

        session.close();

    }

    public Optional<User> findUser(String login) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Query loginQuery = session.createQuery(From Users )
        Query loginQuery = session.createQuery("FROM User WHERE login = :login", User.class);
        loginQuery.setParameter("login", login);

        User foundUser = (User) loginQuery.getSingleResult();

        return Optional.of(foundUser);
    }

}
