package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Article;
import com.trust.app.model.Item;
import com.trust.app.model.Marque;

public interface ArticleService {
	public List<Article> listArticles();
	public List<Article> researchArticles(String s);
	public Article getArticle(int id);
	public Article findWithMarqueAndCode(Marque marque, Item sitem);
	public void addArticle(Article article);
	public void updateArticle(Article article);
}
