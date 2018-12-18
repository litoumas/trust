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

import com.trust.app.model.VenteComptoir;
import com.trust.app.model.User;

/**
 * VenteComptoir data access object interface implementation
 * */
@Repository
public class VenteComptoirDAOImpl implements VenteComptoirDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(VenteComptoirDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<VenteComptoir> listVenteComptoirs() {
    	try {
    		Session session = this.sessionFactory.getCurrentSession();
            List<VenteComptoir> VenteComptoirsList = session.createQuery("from VenteComptoir").list();
            for(VenteComptoir u : VenteComptoirsList){
                logger.info("VenteComptoir List::"+u);
            }
            return VenteComptoirsList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
    }

	@Override
	public void addVenteComptoir(VenteComptoir u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(u);
	        logger.info("VenteComptoir saved successfully, VenteComptoir Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void deleteVenteComptoir(VenteComptoir u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(u);
	        logger.info("VenteComptoir deleted successfully, VenteComptoir Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateVenteComptoir(VenteComptoir u) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
	        logger.info("VenteComptoir updated successfully, VenteComptoir Details="+u);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	
	
	}

	
	
	
 
}