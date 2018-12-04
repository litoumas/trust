package com.trust.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.LigneLivraison;

/**
 * LigneLivraison data access object interface implementation
 */
@Repository
public class LigneLivraisonDAOImpl implements LigneLivraisonDAO {

	private static final Logger logger = LoggerFactory.getLogger(LigneLivraisonDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneLivraison> listLigneLivraisons() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<LigneLivraison> LigneLivraisonsList = session.createQuery("from LigneLivraison").list();
			for (LigneLivraison u : LigneLivraisonsList) {
				logger.info("LigneLivraison List::" + u);
			}
			return LigneLivraisonsList;
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void addLigneLivraison(LigneLivraison u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(u);
			logger.info("LigneLivraison saved successfully, LigneLivraison Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void deleteLigneLivraison(LigneLivraison u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(u);
			logger.info("LigneLivraison deleted successfully, LigneLivraison Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void updateLigneLivraison(LigneLivraison u) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
			logger.info("LigneLivraison updated successfully, LigneLivraison Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}

	}

}