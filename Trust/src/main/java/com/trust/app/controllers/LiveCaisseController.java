package com.trust.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.trust.app.model.Article;
import com.trust.app.model.BonLivraison;
import com.trust.app.model.LigneLivraison;
import com.trust.app.model.LigneReception;
import com.trust.app.service.ArticleService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "LiveCaisseController")
@SessionScoped
public class LiveCaisseController {

	@Getter
	@Setter
	Article selectedArticle;

	@Getter
	@Setter
	LigneLivraison selectedLigneVente;

	@Getter
	@Setter
	BonLivraison bonLivraison = new BonLivraison();


	@ManagedProperty("#{articleService}")
	@Getter
	@Setter
	private ArticleService articleService;

	@Getter
	@Setter
	float qteToAdd = 1;
	
	@Getter
	float total;
	
	

	public void onRowSelectArticle(SelectEvent event) {

		if ((Article) event.getObject() != null) {
		//	this.selectedArticle = (Article) event.getObject();
		}
	}

	public void onRowUnselectArticle(UnselectEvent event) {

	}

	public void onRowSelectLignevente(SelectEvent event) {

		if ((LigneLivraison) event.getObject() != null) {
			this.selectedArticle = selectedLigneVente.getArticle();

		}
	}

	public void onRowUnselectLignevente(UnselectEvent event) {

	}

	public void addLigneToPanier(LigneLivraison ligneVente) {
		addLigneToPanier(ligneVente.getArticle());
	}

	public void addLigneToPanier(Article Article) {
		if (bonLivraison.getLigneLivraisons() == null) {
			bonLivraison.setLigneLivraisons(new ArrayList<LigneLivraison>());
		}

		// On verifie si l'aricle existe dans le panier et on l'incremente
		boolean verif = false;

		for (int i = 0; i <= bonLivraison.getLigneLivraisons().size() - 1; i++) {
			if (bonLivraison.getLigneLivraisons().get(i).getArticle().getId() == Article.getId()) {
				verif = true;
				float qte = bonLivraison.getLigneLivraisons().get(i).getQte();
				bonLivraison.getLigneLivraisons().get(i).setQte(qte + qteToAdd);
				bonLivraison.getLigneLivraisons().get(i).setPrix_ttc(Article.getPrixvente());
				
			}
		}  

		if (verif == false) {
			LigneLivraison ligneVente = new LigneLivraison();
			ligneVente.setArticle(Article);
			ligneVente.setPrix_ttc(Article.getPrixvente());
			ligneVente.setPrix_brute(Article.getPrixvente());
			ligneVente.setPrix_declaree(Article.getPrixVenteDeclare());
			ligneVente.setQte(qteToAdd);

			bonLivraison.addLigne(ligneVente);

		}
		qteToAdd = 1;
	}

	public void removeLigneFromPanier(LigneLivraison ligneVente) {
		removeLigneFromPanier(ligneVente.getArticle());
	}

	public void removeLigneFromPanier(Article Article) {
		for (int i = 0; i <= bonLivraison.getLigneLivraisons().size() - 1; i++) {
			if (bonLivraison.getLigneLivraisons().get(i).getArticle().getId() == Article.getId()) {
				float qte = bonLivraison.getLigneLivraisons().get(i).getQte();
				qte = qte - qteToAdd;
				if (qte > 0) {
					bonLivraison.getLigneLivraisons().get(i).setQte(qte);
				} else {
					bonLivraison.getLigneLivraisons().remove(i);
				}

			}
		}

		qteToAdd = 1;
	}
}
