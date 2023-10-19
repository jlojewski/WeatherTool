package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import dal.entities.User;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        StandardServiceRegistry standardRegistry
                = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        MetadataSources sources = new MetadataSources(standardRegistry);
        sources.addAnnotatedClass(User.class);
        Metadata metadata = sources.buildMetadata();


        SessionFactory sessionFactory = metadata.buildSessionFactory();

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
