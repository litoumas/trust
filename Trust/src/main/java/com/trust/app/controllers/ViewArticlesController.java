package com.trust.app.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import com.trust.app.model.Article;
import com.trust.app.service.ArticleService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "ViewArticlesController")
@SessionScoped
public class ViewArticlesController {

	@ManagedProperty("#{articleService}")
	@Getter
	@Setter
	private ArticleService articleService;
	
	
	@Getter
	@Setter
	Article selectedArticle;
	
	@Getter
	@Setter
	float prixVente;
	
	@Getter
	@Setter
	float prixVenteDeclare;
	
	@Getter
	@Setter
	float prixMini;
	
	@Getter
	@Setter
	String position;
	
	
	public void editprixvente() {
		selectedArticle.setPrixvente(prixVente);
		articleService.updateArticle(selectedArticle);
	}
	public void editprixmini() {
		selectedArticle.setPrixmini(prixMini);
		articleService.updateArticle(selectedArticle);
	}
	public void editPosition() {
		selectedArticle.setPosition(position);
		articleService.updateArticle(selectedArticle);
	}
	public void editprixventeDeclarer() {
		selectedArticle.setPrixVenteDeclare(prixVenteDeclare);
		articleService.updateArticle(selectedArticle);
	}
	
	
	public void onRowSelect(SelectEvent event) {
		if ((Article) event.getObject() != null) {
			Article article = (Article) event.getObject();
			
			prixVente=article.getPrixvente();
			prixMini=article.getPrixmini();
			position=article.getPosition();
		}
	}
	
	
}
