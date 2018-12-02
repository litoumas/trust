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

import com.trust.app.model.MarqueTracteur;
import com.trust.app.model.Tracteur;
/**
 * Tracteur data access object interface implementation
 * */
@Repository
public class TracteurDAOImpl implements TracteurDAO {

	private static final Logger logger = LoggerFactory.getLogger(TracteurDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addTracteur(Tracteur p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("Tracteur saved successfully, Tracteur Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<Tracteur> listTracteurs() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Tracteur> TracteursList = session.createQuery("from Tracteur").list();
	        for(Tracteur c : TracteursList) {
	            logger.info("Tracteur List::"+c);
	        }
	        return TracteursList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteTracteur(Tracteur c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("Tracteur deleted successfully, Tracteur Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateTracteur(Tracteur c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("Tracteur updated successfully, Tracteur Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public Tracteur find(String designation, MarqueTracteur selectedMarqueTracteur) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Tracteur.class);
	 crit.add(Restrictions.eq("designation", designation));
	 crit.add(Restrictions.eq("marqueTracteurs", selectedMarqueTracteur));
		if(crit!=null&&crit.list().size()!=0)
		{
			return (Tracteur) (crit.list()).get(0);
			
			
		}
		return null;
		
	}
}
