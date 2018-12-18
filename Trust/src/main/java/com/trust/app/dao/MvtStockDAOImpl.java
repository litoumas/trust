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

import com.trust.app.model.Article;
import com.trust.app.model.MvtStock;
/**
 * MvtStock data access object interface implementation
 * */
@Repository
public class MvtStockDAOImpl implements MvtStockDAO {

	private static final Logger logger = LoggerFactory.getLogger(MvtStockDAOImpl.class);
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
	@Override
	public void addMvtStock(MvtStock p) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.save(p);
	        logger.info("MvtStock saved successfully, MvtStock Details="+p);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public List<MvtStock> listMvtStocks() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<MvtStock> MvtStocksList = session.createQuery("from MvtStock").list();
	        for(MvtStock c : MvtStocksList) {
	            logger.info("MvtStock List::"+c);
	        }
	        return MvtStocksList;
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteMvtStock(MvtStock c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(c);
	        logger.info("MvtStock deleted successfully, MvtStock Details="+c);
		}
		catch(HibernateException e) {
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public void updateMvtStock(MvtStock c) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(c);
	        logger.info("MvtStock updated successfully, MvtStock Details="+c);
		}
		catch(HibernateException e)
		{
			logger.error("Hibernate exception: "+e.getMessage());
		}
	}

	@Override
	public Double getStockTotal(Article article) {
		
		Double in=(double) 0;
		Double out=(double) 0;
		Session session = this.sessionFactory.getCurrentSession();
		List<Double> lintInt = session.createQuery("SELECT sum(m.qte) from MvtStock m WHERE  article_id="+article.getId()+" AND sens=1" ).list();
		if(lintInt.size()!=0)
		{
			in=lintInt.get(0);
			if(in==null)
				in=(double) 0;
		}
			
		
		List<Double> lintOut = session.createQuery("SELECT sum(m.qte) from MvtStock m WHERE  article_id="+article.getId()+" AND sens=2" ).list();
		if(lintOut.size()!=0)
		{
			out=lintOut.get(0);
			if(out==null)
				out=(double) 0;
		}
			
		
		return (in-out);
	}
	
	
	@Override
	public Double getStockBlack(Article article) {
		
		Double in=(double) 0;
		Double out=(double) 0;
		Session session = this.sessionFactory.getCurrentSession();
		List<Double> lintInt = session.createQuery("SELECT sum(m.qte) from MvtStock m WHERE  article_id="+article.getId()+" AND sens=1 AND isblack= true AND valider=true" ).list();
		if(lintInt.size()!=0)
		{
			in=lintInt.get(0);
			if(in==null)
				in=(double) 0;
		}
			
		
		List<Double> lintOut = session.createQuery("SELECT sum(m.qte) from MvtStock m WHERE  article_id="+article.getId()+" AND sens=2  AND isblack= true AND valider=true" ).list();
		if(lintOut.size()!=0)
		{
			out=lintOut.get(0);
			if(out==null)
				out=(double) 0;
		}
			
		
		return (in-out);
	}

	@Override
	public Double getStockDeclarer(Article article) {
		
		Double in=(double) 0;
		Double out=(double) 0;
		Session session = this.sessionFactory.getCurrentSession();
		List<Double> lintInt = session.createQuery("SELECT sum(m.qte) from MvtStock m WHERE  article_id="+article.getId()+" AND sens=1 AND isblack= false AND valider=true" ).list();
		if(lintInt.size()!=0)
		{
			in=lintInt.get(0);
			if(in==null)
				in=(double) 0;
		}
			
		
		List<Double> lintOut = session.createQuery("SELECT sum(m.qte) from MvtStock m WHERE  article_id="+article.getId()+" AND sens=2  AND isblack= false AND valider=true" ).list();
		if(lintOut.size()!=0)
		{
			out=lintOut.get(0);
			if(out==null)
				out=(double) 0;
		}
			
		
		return (in-out);
	}

}
