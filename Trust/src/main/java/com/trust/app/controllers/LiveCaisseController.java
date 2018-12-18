package com.trust.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.trust.app.model.Article;
import com.trust.app.model.Caisse;
import com.trust.app.model.LigneLivraison;
import com.trust.app.model.LigneVenteComptoir;
import com.trust.app.model.VenteComptoir;
import com.trust.app.service.ArticleService;
import com.trust.app.service.CaisseService;
import com.trust.app.service.ClientService;
import com.trust.app.service.LigneVenteComptoirService;
import com.trust.app.service.MvtStockService;
import com.trust.app.service.VenteComptoirService;

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
	LigneVenteComptoir selectedLigneVente;

	@Getter
	@Setter
	VenteComptoir venteComptoir = new VenteComptoir();

	@Getter
	@Setter
	@ManagedProperty("#{articleService}")
	private ArticleService articleService;

	@Getter
	@Setter
	@ManagedProperty("#{clientService}")
	private ClientService clientService;

	@Getter
	@Setter
	@ManagedProperty("#{mvtStockService}")
	private MvtStockService mvtStockService;
	
	@Getter
	@Setter
	@ManagedProperty("#{venteComptoirService}")
	private VenteComptoirService venteComptoirService;
	
	@Getter
	@Setter
	@ManagedProperty("#{ligneVenteComptoirService}")
	private LigneVenteComptoirService ligneVenteComptoirService;

	@Getter
	@Setter
	@ManagedProperty("#{caisseService}")
	private CaisseService caisseService;
	
	

	@Getter
	@Setter
	float qteToAdd = 1;

	@Getter
	@Setter
	double argent;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void onRowSelectArticle(SelectEvent event) {

		if ((Article) event.getObject() != null) {
			// this.selectedArticle = (Article) event.getObject();
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
		if (venteComptoir.getListeligneVenteComptoir() == null) {
			venteComptoir.setListeligneVenteComptoir(new ArrayList<LigneVenteComptoir>());
		}

		// On verifie si l'aricle existe dans le panier et on l'incremente
		boolean verif = false;

		for (int i = 0; i <= venteComptoir.getListeligneVenteComptoir().size() - 1; i++) {
			if (venteComptoir.getListeligneVenteComptoir().get(i).getArticle().getId() == Article.getId()) {
				verif = true;
				float qte = venteComptoir.getListeligneVenteComptoir().get(i).getQte();
				venteComptoir.getListeligneVenteComptoir().get(i).setQte(qte + qteToAdd);
				venteComptoir.getListeligneVenteComptoir().get(i).setPrix_ttc(Article.getPrixvente());

			}
		}

		if (verif == false) {
			LigneVenteComptoir ligneVente = new LigneVenteComptoir();
			ligneVente.setArticle(Article);
			ligneVente.setPrix_ttc(Article.getPrixvente());
			ligneVente.setPrix_brute(Article.getPrixvente());
			ligneVente.setPrix_declaree(Article.getPrixVenteDeclare());
			ligneVente.setQte(qteToAdd);

			venteComptoir.addLigne(ligneVente);

		}

		for (int i = 0; i <= venteComptoir.getListeligneVenteComptoir().size() - 1; i++) {

			venteComptoir.getListeligneVenteComptoir().get(i)
					.setPrix_ttc(venteComptoir.getListeligneVenteComptoir().get(i).getArticle().getPrixvente());

		}

		qteToAdd = 1;
	}

	public void removeLigneFromPanier(LigneLivraison ligneVente) {
		removeLigneFromPanier(ligneVente.getArticle());
	}

	public void removeLigneFromPanier(Article Article) {
		for (int i = 0; i <= venteComptoir.getListeligneVenteComptoir().size() - 1; i++) {
			if (venteComptoir.getListeligneVenteComptoir().get(i).getArticle().getId() == Article.getId()) {
				float qte = venteComptoir.getListeligneVenteComptoir().get(i).getQte();
				qte = qte - qteToAdd;
				if (qte > 0) {
					venteComptoir.getListeligneVenteComptoir().get(i).setQte(qte);
				} else {
					venteComptoir.getListeligneVenteComptoir().remove(i);
				}

			}
		}

		qteToAdd = 1;
	}

	public void reset() {
		venteComptoir = new VenteComptoir();
		selectedLigneVente = null;
		selectedArticle = null;

	}

	public void submit() {

		if (venteComptoir.getListeligneVenteComptoir() != null) {

			//venteComptoir.setClient(clientService.getClientPassager());

			Iterator<LigneVenteComptoir> iterator = venteComptoir.getListeligneVenteComptoir().iterator();
			while (iterator.hasNext()) {
				LigneVenteComptoir lbl = iterator.next();
				boolean valider = false;
				boolean isblack = false;
				double stock_D = mvtStockService.getStockDeclarer(lbl.getArticle());
				double stock_B = mvtStockService.getStockBlack(lbl.getArticle());
				if (stock_D == 0) {
					valider = true;
					isblack = true;
				}else if ((stock_B==0)&&((stock_D-lbl.getQte())>=0)) {
					valider = true;
					isblack = false;
				}
				
				lbl.setBlack(isblack);
				lbl.setValider(valider);
				lbl.setSens(2);
				lbl.setDate(new Date());
				
				
						
				ligneVenteComptoirService.addLigneVenteComptoir(lbl);
			}

			
			venteComptoir.setPayee(true);
			venteComptoir.setHeur(new Date());
			venteComptoirService.addVenteComptoir(venteComptoir);
			
			Caisse caisse=caisseService.getLastOne();
			caisse.addVente(venteComptoir);
			caisseService.updateCaisse(caisse);
			
			reset();
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "le panier est vide !"));
		}

	}

	public double getMonnaie() {

		return arrondir(argent - venteComptoir.getTotalPrixTTC());

	}

	private double arrondir(double d) {
		return (double) ((double) ((int) (d * Math.pow(10, 3) + .5)) / Math.pow(10, 3));
	}


}
