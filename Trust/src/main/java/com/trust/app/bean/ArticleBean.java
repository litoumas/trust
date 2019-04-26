package com.trust.app.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.trust.app.model.Article;
import com.trust.app.service.ArticleService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "ArticleBean")
@ViewScoped
public class ArticleBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6113719938798509182L;

	@ManagedProperty("#{articleService}")
	@Getter
	@Setter
	private ArticleService articleService;
	
	List<Article> listeArticle;
	
	public List<Article> getListArticles() {
		
		if(listeArticle==null)
			listeArticle=articleService.listArticles();
		return listeArticle;
	}
	
	
	
	
	
	
	
}
