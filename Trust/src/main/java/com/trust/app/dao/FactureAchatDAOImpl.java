package com.trust.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.FactureAchat;
/**
 * FactureAchat data access object interface implementation
 * */
@Repository
public class FactureAchatDAOImpl implements FactureAchatDAO {

	private static final Logger logger = LoggerFactory.getLogger(FactureAchatDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addFactureAchat(FactureAchat p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("FactureAchat saved successfully, FactureAchat Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<FactureAchat> listFactureAchats() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<FactureAchat> FactureAchatsList = session.createQuery("from FactureAchat").list();
	        for(FactureAchat c : FactureAchatsList) {
	            logger.info("FactureAchat List::"+c);
	        }
	        return FactureAchatsList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteFactureAchat(FactureAchat c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("FactureAchat deleted successfully, FactureAchat Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateFactureAchat(FactureAchat c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("FactureAchat updated successfully, FactureAchat Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

}
