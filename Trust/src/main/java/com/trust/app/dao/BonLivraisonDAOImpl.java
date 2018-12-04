package com.trust.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.BonLivraison;

/**
 * BonLivraison data access object interface implementation
 */
@Repository
public class BonLivraisonDAOImpl implements BonLivraisonDAO {

	private static final Logger logger = LoggerFactory.getLogger(BonLivraisonDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BonLivraison> listBonLivraisons() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<BonLivraison> BonLivraisonsList = session.createQuery("from BonLivraison").list();
			for (BonLivraison u : BonLivraisonsList) {
				logger.info("BonLivraison List::" + u);
			}
			return BonLivraisonsList;
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void addBonLivraison(BonLivraison u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(u);
			logger.info("BonLivraison saved successfully, BonLivraison Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void deleteBonLivraison(BonLivraison u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(u);
			logger.info("BonLivraison deleted successfully, BonLivraison Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void updateBonLivraison(BonLivraison u) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
			logger.info("BonLivraison updated successfully, BonLivraison Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}

	}

}