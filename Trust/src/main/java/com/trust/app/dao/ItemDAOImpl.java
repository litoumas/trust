package com.trust.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.trust.app.model.Item;


@Repository
public class ItemDAOImpl implements ItemDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ItemDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@Override
	public void addItem(Item p) {
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
	public List<Item> listItems() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Item> itemsList = session.createQuery("from Item").list();
	        for(Item c : itemsList) {
	            logger.info("Item List::"+c);
	        }
	        return itemsList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteItem(Item item) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(item);
	        logger.info("Car deleted successfully, Car Details="+item);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateItem(Item item) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(item);
	        logger.info("Car updated successfully, Car Details="+item);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

}
