package com.trust.app.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.ArticleDAO;
import com.trust.app.model.Article;
import com.trust.app.model.Item;
import com.trust.app.model.Marque;


@Service
@ManagedBean(name = "articleServiceImpl")
@SessionScoped
public class ArticleServiceImpl implements ArticleService,Serializable {

	
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
	private ArticleDAO articleDAO;
	
    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }
	@Override
	@Transactional
	public List<Article> listArticles() {
		return this.articleDAO.listArticles();
	}
	@Override
	@Transactional
	public List<Article> researchArticles(String s) {
		return this.articleDAO.researchArticles(s);
	}
	@Override
	@Transactional
	public Article getArticle(String code) {
		return this.articleDAO.getArticle(code);
	}
	@Override
	public Article findWithMarqueAndCode(Marque marque, Item item) {
		return this.articleDAO.findWithMarqueAndCode(marque, item);
	}
	@Override
	public void addArticle(Article article) {
		this.articleDAO.addArticle(article);
	}

	
	
	
}
