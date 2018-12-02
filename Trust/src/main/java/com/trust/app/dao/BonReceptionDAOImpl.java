package com.trust.app.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.BonReception;
import com.trust.app.model.Fournisseur;
import com.trust.app.model.User;

/**
 * Reception data access object interface implementation
 */
@Repository
public class BonReceptionDAOImpl implements BonReceptionDAO {

	private static final Logger logger = LoggerFactory.getLogger(BonReceptionDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addBonReception(BonReception p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(p);
			logger.info("Reception saved successfully, Reception Details=" + p);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void deleteBonReception(BonReception c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
			logger.info("Reception deleted successfully, Reception Details=" + c);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public void updateBonReception(BonReception c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
			logger.info("Reception updated successfully, Reception Details=" + c);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

	@Override
	public List<BonReception> listBonReceptions() {

		Session session = this.sessionFactory.getCurrentSession();

		Criteria cr = session.createCriteria(BonReception.class);
		
		
		List<BonReception> listBonReception = session.createQuery("from BonReception").list();
		//https://www.jmdoudoux.fr/java/dej/chap-hibernate.htm
		
		
		
		return listBonReception;
		
	}

	@Override
	public List<BonReception> listBonReceptions(Fournisseur fournisseur) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(BonReception.class);
		Criterion c_Fournisseur = Restrictions.eq("fournisseur", fournisseur);
		cr.add(c_Fournisseur);
		List<BonReception> listBonReception = cr.list();
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return listBonReception;
	}

	@Override
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack, boolean hasInvoice) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(BonReception.class);
		Criterion c_Fournisseur = Restrictions.eq("fournisseur", fournisseur);
		Criterion c_isblack = Restrictions.eq("isblack", fournisseur);
		Criterion c_hasInvoice = Restrictions.eq("fournisseur_id", fournisseur.getId());

		cr.add(c_Fournisseur);
		cr.add(c_isblack);
		cr.add(c_hasInvoice);
		List<BonReception> listBonReception = cr.list();
	
		// TODO Auto-generated method stub
		return listBonReception;
	}
}
