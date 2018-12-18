package com.trust.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.trust.app.model.Article;
import com.trust.app.model.Item;
import com.trust.app.model.Marque;
import com.trust.app.model.MvtStock;
import com.trust.app.model.User;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	private static final Logger logger = LoggerFactory.getLogger(ArticleDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Article> listArticles() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<Article> articleList = session.createQuery("from Article order by item_id").list();
			for (Article c : articleList) {
				logger.info("Article List::" + c);
			}
			return articleList;
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Article> researchArticles(String s) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria crit = session.createCriteria(Article.class);

			crit.add(Restrictions.or(Restrictions.like("description", "%" + s + "%")));
			// crit.add(Restrictions.or(Restrictions.like("code", "%"+s+"%")));

			List<Article> articleList = crit.list();

			// List<Article> articleList = session.createQuery("SELECT a FROM Article a
			// WHERE a.description = "+s).list();

			return articleList;
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
			return null;
		}
	}

//	@Override
	public Article getArticle(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Article.class);

		List<Article> articles = crit.add(Restrictions.like("id", id)).list();
		if (articles.isEmpty()) {
			return null;
		} else {
			return articles.get(0);
		}

	}

	@Override
	public Article findWithMarqueAndCode(Marque marque, Item item) {
		Session session = this.sessionFactory.openSession();
		String query="from Article WHERE marque_id="+marque.getId()+" AND item_id= "+item.getId()+"";
		System.out.println("=====> query"+query);
		List<Article> ArticleList = session.createQuery(query).list();
		System.out.println("=====> ArticleList"+ArticleList.size());
		
		session.close();
		if(ArticleList.size()!=0)
			return ArticleList.get(0);
		return null;
	}

	@Override
	public void addArticle(Article article) {
		try {
			Session session = this.sessionFactory.openSession();
			session.save(article);
			session.close();
			logger.info("Car saved successfully, Article Details=" + article);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}

	}

	@Override
	public void updateArticle(Article article) {
		try {
			Session session = this.sessionFactory.openSession();
			session.update(article);
			session.flush();;
			session.close();
			logger.info("article updated successfully, article Details=" + article);
		} catch (HibernateException e) {
			logger.error("Hibernate exception: " + e.getMessage());
		}
	}

}
