package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.Article;
import com.trust.app.model.Item;
import com.trust.app.model.Marque;;

public interface ArticleDAO {

    public List<Article> listArticles();

	public List<Article> researchArticles(String s);

	public Article getArticle(String code);

	public Article findWithMarqueAndCode(Marque marque, Item item);

	public void addArticle(Article article);
	
}
