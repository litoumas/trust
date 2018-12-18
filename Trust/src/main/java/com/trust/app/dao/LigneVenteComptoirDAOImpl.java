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

import com.trust.app.model.LigneVenteComptoir;
import com.trust.app.model.User;

/**
 * LigneVenteComptoir data access object interface implementation
 * */
@Repository
public class LigneVenteComptoirDAOImpl implements LigneVenteComptoirDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(LigneVenteComptoirDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<LigneVenteComptoir> listLigneVenteComptoirs() {
    	try {
    		Session session = this.sessionFactory.getCurrentSession();
            List<LigneVenteComptoir> LigneVenteComptoirsList = session.createQuery("from LigneVenteComptoir").list();
            for(LigneVenteComptoir u : LigneVenteComptoirsList){
                logger.info("LigneVenteComptoir List::"+u);
            }
            return LigneVenteComptoirsList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
    }

	@Override
	public void addLigneVenteComptoir(LigneVenteComptoir u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(u);
	        logger.info("LigneVenteComptoir saved successfully, LigneVenteComptoir Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void deleteLigneVenteComptoir(LigneVenteComptoir u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(u);
	        logger.info("LigneVenteComptoir deleted successfully, LigneVenteComptoir Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateLigneVenteComptoir(LigneVenteComptoir u) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
	        logger.info("LigneVenteComptoir updated successfully, LigneVenteComptoir Details="+u);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	
	
	}

	
	
	
 
}