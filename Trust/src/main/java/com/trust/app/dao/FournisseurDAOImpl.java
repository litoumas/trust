package com.trust.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.Fournisseur;
/**
 * Fournisseur data access object interface implementation
 * */
@Repository
public class FournisseurDAOImpl implements FournisseurDAO {

	private static final Logger logger = LoggerFactory.getLogger(FournisseurDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addFournisseur(Fournisseur p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("Fournisseur saved successfully, Fournisseur Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<Fournisseur> listFournisseurs() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Fournisseur> FournisseursList = session.createQuery("from Fournisseur").list();
	        for(Fournisseur c : FournisseursList) {
	            logger.info("Fournisseur List::"+c);
	        }
	        return FournisseursList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteFournisseur(Fournisseur c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("Fournisseur deleted successfully, Fournisseur Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateFournisseur(Fournisseur c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("Fournisseur updated successfully, Fournisseur Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public Fournisseur findWithName(String nom) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Fournisseur.class);
	 crit.add(Restrictions.eq("nom", nom));
		if(crit!=null&&crit.list().size()!=0)
		{
			return (Fournisseur) (crit.list()).get(0);
			
			
		}
		return null;
		
	}
	
}
