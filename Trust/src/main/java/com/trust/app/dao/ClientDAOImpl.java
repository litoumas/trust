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

import com.trust.app.model.Client;
/**
 * Client data access object interface implementation
 * */
@Repository
public class ClientDAOImpl implements ClientDAO {

	private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addClient(Client p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("Client saved successfully, Client Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<Client> listClients() {
		
		
		
		
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Client> ClientsList = session.createQuery("from Client").list();
	        for(Client c : ClientsList) {
	            logger.info("Client List::"+c);
	        }
	        return ClientsList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteClient(Client c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("Client deleted successfully, Client Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateClient(Client c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("Client updated successfully, Client Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public Client findWithName(String nom) {

		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Client.class);
	 crit.add(Restrictions.eq("nom", nom));
		if(crit!=null&&crit.list().size()!=0)
		{
			return (Client) (crit.list()).get(0);
			
			
		}
		return null;
		
	}
}
