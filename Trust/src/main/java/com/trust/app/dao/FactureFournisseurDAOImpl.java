package com.trust.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.FactureFournisseur;
/**
 * FactureFournisseur data access object interface implementation
 * */
@Repository
public class FactureFournisseurDAOImpl implements FactureFournisseurDAO {

	private static final Logger logger = LoggerFactory.getLogger(FactureFournisseurDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addFactureFournisseur(FactureFournisseur p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("FactureFournisseur saved successfully, FactureFournisseur Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<FactureFournisseur> listFactureFournisseurs() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<FactureFournisseur> FactureFournisseursList = session.createQuery("from FactureFournisseur").list();
	        for(FactureFournisseur c : FactureFournisseursList) {
	            logger.info("FactureFournisseur List::"+c);
	        }
	        return FactureFournisseursList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteFactureFournisseur(FactureFournisseur c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("FactureFournisseur deleted successfully, FactureFournisseur Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateFactureFournisseur(FactureFournisseur c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("FactureFournisseur updated successfully, FactureFournisseur Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

}
