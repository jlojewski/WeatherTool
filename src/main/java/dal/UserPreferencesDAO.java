package dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dal.entities.UserPreferences;
import util.HibernateUtil;

public class UserPreferencesDAO {

    SessionFactory sessionFactory;

    public UserPreferencesDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void updateUserPreferences(UserPreferences userPreferences) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        UserPreferences userPreferencesDatabase = session.get(UserPreferences.class,userPreferences.getId());

        userPreferencesDatabase.setDefaultCity(userPreferences.getDefaultCity());
        userPreferencesDatabase.setDefaultNumberOfDays(userPreferences.getDefaultNumberOfDays());

        session.save(userPreferencesDatabase);
        session.getTransaction().commit();
        session.close();


    }
}
