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

@Repository
public class MarqueTracteurDAOImpl implements MarqueTracteurDAO {

	private static final Logger logger = LoggerFactory.getLogger(MarqueTracteurDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addMarqueTracteur(MarqueTracteur p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(p);
			logger.info("Car saved successfully, Car Details=" + p);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public List<MarqueTracteur> listMarqueTracteurs() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<MarqueTracteur> MarqueTracteursList = session.createQuery("from MarqueTracteur").list();
			for (MarqueTracteur c : MarqueTracteursList) {
				logger.info("MarqueTracteur List::" + c);
			}
			return MarqueTracteursList;
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteMarqueTracteur(MarqueTracteur MarqueTracteur) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(MarqueTracteur);
			logger.info("Car deleted successfully, Car Details=" + MarqueTracteur);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void updateMarqueTracteur(MarqueTracteur marqueTracteur) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(marqueTracteur);
			logger.info("Car updated successfully, Car Details=" + marqueTracteur);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public MarqueTracteur findWithDesig(String designiation) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(MarqueTracteur.class);
	 crit.add(Restrictions.eq("designation", designiation));
		if(crit!=null&&crit.list().size()!=0)
		{
			return (MarqueTracteur) (crit.list()).get(0);
			
			
		}
		return null;
		
	}

}
