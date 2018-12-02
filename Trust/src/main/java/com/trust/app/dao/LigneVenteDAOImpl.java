package com.trust.app.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.trust.app.model.LigneVente;
/**
 * LigneVente data access object interface implementation
 * */
@Repository
public class LigneVenteDAOImpl implements LigneVenteDAO {

	private static final Logger logger = LoggerFactory.getLogger(LigneVenteDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addLigneVente(LigneVente p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("LigneVente saved successfully, LigneVente Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<LigneVente> listLigneVentes() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<LigneVente> LigneVentesList = session.createQuery("from LigneVente").list();
	        for(LigneVente c : LigneVentesList) {
	            logger.info("LigneVente List::"+c);
	        }
	        return LigneVentesList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteLigneVente(LigneVente c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("LigneVente deleted successfully, LigneVente Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateLigneVente(LigneVente c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("LigneVente updated successfully, LigneVente Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}
}
