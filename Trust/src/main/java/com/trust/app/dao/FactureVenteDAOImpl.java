package com.trust.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.FactureVente;

/**
 * FactureVente data access object interface implementation
 */
@Repository
public class FactureVenteDAOImpl implements FactureVenteDAO {

	private static final Logger logger = LoggerFactory.getLogger(FactureVenteDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FactureVente> listFactureVentes() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<FactureVente> FactureVentesList = session.createQuery("from FactureVente").list();
			for (FactureVente u : FactureVentesList) {
				logger.info("FactureVente List::" + u);
			}
			return FactureVentesList;
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void addFactureVente(FactureVente u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(u);
			logger.info("FactureVente saved successfully, FactureVente Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void deleteFactureVente(FactureVente u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(u);
			logger.info("FactureVente deleted successfully, FactureVente Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void updateFactureVente(FactureVente u) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
			logger.info("FactureVente updated successfully, FactureVente Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}

	}

}