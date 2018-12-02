package com.trust.app.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.trust.app.model.Article;
/**
 * Car data access object interface implementation
 * */
@Repository
public class CarDAOImpl implements CarDAO {

	private static final Logger logger = LoggerFactory.getLogger(CarDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addCar(Article p) {
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
	public List<Article> listCars() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Article> carsList = session.createQuery("from Car").list();
	        for(Article c : carsList) {
	            logger.info("Car List::"+c);
	        }
	        return carsList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteCar(Article c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("Car deleted successfully, Car Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateCar(Article c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("Car updated successfully, Car Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}
}
