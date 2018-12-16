package com.trust.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.Article;
import com.trust.app.model.BonReception;
import com.trust.app.model.Parametre;


@Repository
public class ParametreDAOImpl implements ParametreDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ParametreDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@Override
	public void addParametre(Parametre p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("Car saved successfully, Car Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<Parametre> listParametres() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Parametre> ParametresList = session.createQuery("from Parametre").list();
	        for(Parametre c : ParametresList) {
	            logger.info("Parametre List::"+c);
	        }
	        return ParametresList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteParametre(Parametre Parametre) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(Parametre);
	        logger.info("Car deleted successfully, Car Details="+Parametre);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateParametre(Parametre Parametre) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(Parametre);
	        logger.info("Car updated successfully, Car Details="+Parametre);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}
	@Override
	public Parametre getParametre(String nomParametre) {
		if((nomParametre==null)||(nomParametre==""))
			return null;
		
		

		Session session = this.sessionFactory.getCurrentSession();
		String Query = "from Parametre where identifiant ='" + nomParametre+"'";

		List<Parametre> parametres = session.createQuery(Query).list();


		
		if(parametres.size()!=0)
		return parametres.get(0);
		
		return null;
	}

}
