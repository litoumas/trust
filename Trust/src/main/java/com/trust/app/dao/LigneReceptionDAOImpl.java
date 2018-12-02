package com.trust.app.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.trust.app.model.LigneReception;
/**
 * LigneReception data access object interface implementation
 * */
@Repository
public class LigneReceptionDAOImpl implements LigneReceptionDAO {

	private static final Logger logger = LoggerFactory.getLogger(LigneReceptionDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addLigneReception(LigneReception p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("LigneReception saved successfully, LigneReception Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<LigneReception> listLigneReceptions() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<LigneReception> LigneReceptionsList = session.createQuery("from LigneReception").list();
	        for(LigneReception c : LigneReceptionsList) {
	            logger.info("LigneReception List::"+c);
	        }
	        return LigneReceptionsList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteLigneReception(LigneReception c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("LigneReception deleted successfully, LigneReception Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateLigneReception(LigneReception c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("LigneReception updated successfully, LigneReception Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}
}
