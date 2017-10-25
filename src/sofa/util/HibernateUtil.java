package sofa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;


	static {
		 try {
			Configuration configuration = new Configuration();
			 configuration.configure();
			//sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		             configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		 } catch (Throwable ex) {
			 System.err.println("Initial SessionFactory creation failed." + ex);
			 throw new ExceptionInInitializerError(ex);
		 }
	}

	public static Session openSession() {
		 return sessionFactory.openSession();
	}


}
