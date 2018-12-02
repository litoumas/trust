package com.trust.app.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.Droit;
import com.trust.app.model.User;

/**
 * Droit data access object interface implementation
 * */
@Repository
public class DroitDAOImpl implements DroitDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(DroitDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Droit> listDroits() {
    	try {
    		Session session = this.sessionFactory.getCurrentSession();
            List<Droit> DroitsList = session.createQuery("from Droit").list();
            for(Droit u : DroitsList){
                logger.info("Droit List::"+u);
            }
            return DroitsList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
    }

	@Override
	public void addDroit(Droit u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(u);
	        logger.info("Droit saved successfully, Droit Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void deleteDroit(Droit u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(u);
	        logger.info("Droit deleted successfully, Droit Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateDroit(Droit u) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
	        logger.info("Droit updated successfully, Droit Details="+u);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	
	
	}

	
	
	
 
}