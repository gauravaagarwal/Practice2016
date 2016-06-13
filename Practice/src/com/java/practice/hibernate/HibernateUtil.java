package com.java.practice.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.practice.hibernate.entity.Account;
import com.java.practice.hibernate.entity.Employee;
import com.java.practice.hibernate.entity.Event;
import com.java.practice.hibernate.entity.FamilyMember;
 
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration cfg= new Configuration();
        	cfg.addAnnotatedClass(Event.class);
        	cfg.addAnnotatedClass(Employee.class);
        	cfg.addAnnotatedClass(Account.class);
        	cfg.addAnnotatedClass(FamilyMember.class);
            return cfg.configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

	public static void shutdown() {
		sessionFactory.close();
	}
 
}