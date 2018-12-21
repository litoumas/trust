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

import com.trust.app.model.Caisse;
import com.trust.app.model.User;

/**
 * Caisse data access object interface implementation
 */
@Repository
public class CaisseDAOImpl implements CaisseDAO {

	private static final Logger logger = LoggerFactory.getLogger(CaisseDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caisse> listCaisses() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<Caisse> CaissesList = session.createQuery("from Caisse").list();
			for (Caisse u : CaissesList) {
				logger.info("Caisse List::" + u);
			}
			return CaissesList;
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void addCaisse(Caisse u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(u);
			logger.info("Caisse saved successfully, Caisse Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void deleteCaisse(Caisse u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(u);
			logger.info("Caisse deleted successfully, Caisse Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void updateCaisse(Caisse u) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
			logger.info("Caisse updated successfully, Caisse Details=" + u);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}

	}

	@Override
	public Caisse getLastOne() {

		try {
			Session session = this.sessionFactory.openSession();

			List<Caisse> CaissesList = session.createQuery("from Caisse").list();
			for (Caisse u : CaissesList) {
				logger.info("Caisse List::" + u);
			}
			session.close();
			if (CaissesList.size() == 0)
				return null;

			return CaissesList.get(CaissesList.size() - 1);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return null;
		}
	}

}