package com.anytest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateInterface {
	
	final static Configuration CONFIGURATION = new Configuration().configure();
	final static SessionFactory SESSION_FACTORY = CONFIGURATION.buildSessionFactory();
	static
	{
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(SESSION_FACTORY!=null && !SESSION_FACTORY.isClosed())
				{
					SESSION_FACTORY.close();
				}
				
			}
		}));
	}
	
	public static void saveEntities(final Object entity)
	{
		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();	
		}
	}


	@SuppressWarnings("unchecked")
	public static List<Object> getRecordsOfType(final Class<?> classObject)
	{
		final Session session = SESSION_FACTORY.openSession();
		try {
			 List<Object> resultList = session.createCriteria(classObject).list();
			 resultList.toString();
			 return resultList;
		}
		finally{
			session.close();	
		}
	}
	
	public static int exectueQuery(final String hqlQuery)
	{
		int effectedRecords=0;
		final Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		try {
			effectedRecords=session.createQuery(hqlQuery).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
		return effectedRecords;
	}
}
