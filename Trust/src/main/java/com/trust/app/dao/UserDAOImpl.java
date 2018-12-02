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

import com.trust.app.model.User;

/**
 * User data access object interface implementation
 * */
@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers() {
    	try {
    		Session session = this.sessionFactory.getCurrentSession();
            List<User> usersList = session.createQuery("from User").list();
            for(User u : usersList){
                logger.info("User List::"+u);
            }
            return usersList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
    }

	@Override
	public void addUser(User u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(u);
	        logger.info("User saved successfully, User Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void deleteCar(User u) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(u);
	        logger.info("Car deleted successfully, Car Details="+u);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateCar(User u) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(u);
	        logger.info("Car updated successfully, Car Details="+u);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	
	
	}

	@Override
	public User researchUsers(String login, String passhash) {

		Session session = this.sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		 Criterion c_login = Restrictions.eq("login", login);

		 Criterion c_passhash = Restrictions.eq("passhash", passhash);
		
		LogicalExpression andExp = Restrictions.and(c_login, c_passhash);
		cr.add(andExp);

		List<User> userList = cr.list();

		session.close();
		
		
		if (userList.size() != 0) {
			return userList.get(0);
		}

		return null;
	}

	
	
	
 
}