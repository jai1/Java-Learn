package com.newslive.actions.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDao {
	private SessionFactory sessionFactory;

	protected BaseDao() {
		try {
			this.sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	protected Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	protected Session openSession() {
		try {
			return sessionFactory.openSession();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
