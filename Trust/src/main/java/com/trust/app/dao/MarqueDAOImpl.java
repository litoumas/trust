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

import com.trust.app.model.Marque;
import com.trust.app.model.MarqueTracteur;

@Repository
public class MarqueDAOImpl implements MarqueDAO{

	private static final Logger logger = LoggerFactory.getLogger(MarqueDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addMarque(Marque m) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(m);
	        logger.info("Marque saved successfully, Marque Details="+m);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<Marque> listMarques() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Marque> MarquesList = session.createQuery("from Marque").list();
	        for(Marque c : MarquesList) {
	            logger.info("Marque List::"+c);
	        }
	        return MarquesList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteMarque(Marque m) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(m);
	        logger.info("Marque deleted successfully, Marque Details="+m);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateMarque(Marque m) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(m);
	        logger.info("Marque updated successfully, Marque Details="+m);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public Marque findWithDesig(String m) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Marque.class);
	 crit.add(Restrictions.eq("designation", m));
		if(crit!=null&&crit.list().size()!=0)
		{
			return (Marque) (crit.list()).get(0);
			
			
		}
		return null;
		
	}
	


}
