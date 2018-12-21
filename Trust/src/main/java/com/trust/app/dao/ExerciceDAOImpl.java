package com.trust.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.Caisse;
import com.trust.app.model.Exercice;


@Repository
public class ExerciceDAOImpl implements ExerciceDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ExerciceDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@Override
	public void addExercice(Exercice p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("Car saved successfully, Car Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<Exercice> listExercices() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Exercice> ExercicesList = session.createQuery("from Exercice").list();
	        for(Exercice c : ExercicesList) {
	            logger.info("Exercice List::"+c);
	        }
	        return ExercicesList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteExercice(Exercice Exercice) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(Exercice);
	        logger.info("Car deleted successfully, Car Details="+Exercice);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateExercice(Exercice Exercice) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(Exercice);
	        logger.info("Car updated successfully, Car Details="+Exercice);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}
	@Override
	public Exercice getLastOne() {

		try {
			Session session = this.sessionFactory.openSession();

			List<Exercice> exerciceList = session.createQuery("from Exercice").list();
			for (Exercice u : exerciceList) {
				logger.info("Exercice List::" + u);
			}
			session.close();
			if (exerciceList.size() == 0)
				return null;

			return exerciceList.get(exerciceList.size() - 1);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return null;
		}
	}

}
