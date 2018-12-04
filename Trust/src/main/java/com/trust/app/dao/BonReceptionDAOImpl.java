package com.trust.app.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

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
import com.trust.app.model.Client;
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

		// on utilise le id comme numero en attendent de devlopper la classe
		// parametreManager

		int nbr0 = 5; // nombre de chifre que comporte le numero
		String prefix = "BR-19/"; // prefix du nemero
		String suffixe = ""; // suffixe du nemero

		String numero = prefix;

		int nbr = String.valueOf(p.getId()).length(); // ici on utilise le ID a la place de nemero

		for (int i = 0; i <= (nbr0 - nbr) - 1; i++) // on ajoute les 0 manquant
		{
			numero += "0";
		}
		numero += p.getId() + suffixe; // ici on utilise le ID a la place de nemero
		p.setNumero(numero);
		updateBonReception(p); // on update le bon de reception
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

		String Query = "from BonReception " ;

		List<BonReception> listBonReception = session.createQuery(Query).list();

		// TODO Auto-generated method stub
		return listBonReception;
	}

	@Override
	public List<BonReception> listBonReceptions(Fournisseur fournisseur) {
		Session session = this.sessionFactory.getCurrentSession();

		String Query = "from BonReception where fournisseur_id=" + fournisseur.getId();

		List<BonReception> listBonReception = session.createQuery(Query).list();

		// TODO Auto-generated method stub
		return listBonReception;
	}

	@Override
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack) {

		Session session = this.sessionFactory.getCurrentSession();

		String Query = "from BonReception where fournisseur_id=" + fournisseur.getId() + " AND isblack= "+isblack;

		List<BonReception> listBonReception = session.createQuery(Query).list();

		// TODO Auto-generated method stub
		return listBonReception;
	}

	@Override
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack, boolean hasInvoice) {

		Session session = this.sessionFactory.getCurrentSession();

		String Query = "from BonReception where fournisseur_id=" + fournisseur.getId() + " AND isblack= "+isblack +" AND factureFournisseur_id=null";

		List<BonReception> listBonReception = session.createQuery(Query).list();

		// TODO Auto-generated method stub
		return listBonReception;
	}

}
