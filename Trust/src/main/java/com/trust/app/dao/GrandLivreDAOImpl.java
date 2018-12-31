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

import com.trust.app.model.GrandLivre;
import com.trust.app.model.User;

/**
 * GrandLivre data access object interface implementation
 * */
@Repository
public class GrandLivreDAOImpl implements GrandLivreDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(GrandLivreDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<GrandLivre> listGrandLivres() {
    	try {
    		Session session = this.sessionFactory.getCurrentSession();
            List<GrandLivre> GrandLivresList = session.createQuery("from GrandLivre").list();
            for(GrandLivre u : GrandLivresList){
                logger.info("GrandLivre List::"+u);
            }
            return GrandLivresList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
    }

	@Override
	public void addGrandLivre(GrandLivre u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(u);
	        logger.info("GrandLivre saved successfully, GrandLivre Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void deleteGrandLivre(GrandLivre u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(u);
	        logger.info("GrandLivre deleted successfully, GrandLivre Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateGrandLivre(GrandLivre u) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
	        logger.info("GrandLivre updated successfully, GrandLivre Details="+u);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	
	
	}

	
	
	
 
}