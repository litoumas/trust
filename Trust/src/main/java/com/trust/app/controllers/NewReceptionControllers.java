package com.trust.app.controllers;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.trust.app.model.Article;
import com.trust.app.model.Fournisseur;
import com.trust.app.model.LigneReception;
import com.trust.app.model.Marque;
import com.trust.app.model.BonReception;

import com.trust.app.service.ArticleService;
import com.trust.app.service.FactureFournisseurService;
import com.trust.app.service.FournisseurService;
import com.trust.app.service.ItemService;
import com.trust.app.service.LigneReceptionService;
import com.trust.app.service.MarqueService;
import com.trust.app.service.BonReceptionService;
import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "NewReceptionControllers")
@SessionScoped
public class NewReceptionControllers implements Serializable {

	@Getter
	@Setter
	@ManagedProperty("#{fournisseurService}")
	private FournisseurService fournisseurService;

	@Getter
	@Setter
	@ManagedProperty("#{marqueService}")
	private MarqueService marqueService;

	@Getter
	@Setter
	@ManagedProperty("#{itemService}")
	private ItemService itemService;

	@Getter
	@Setter
	@ManagedProperty("#{articleService}")
	private ArticleService articleService;

	@Getter
	@Setter
	@ManagedProperty("#{bonReceptionService}")
	private BonReceptionService bonreceptionService;

	@Getter
	@Setter
	@ManagedProperty("#{ligneReceptionService}")
	private LigneReceptionService ligneReceptionService;

	@Getter
	@Setter
	@ManagedProperty("#{factureFournisseurService}")
	private FactureFournisseurService factureFournisseurService;

	@Getter
	@Setter
	Fournisseur selectedFournisseur = new Fournisseur();

	@Getter
	@Setter
	BonReception bonreception = new BonReception();

	@Getter
	@Setter
	LigneReception ligneReception = new LigneReception();

	@Getter
	@Setter
	Article selectedArticle = new Article();

	@Getter
	@Setter
	private List<LigneReception> listeLigneReceptions = new ArrayList<LigneReception>();

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void submit() {

		boolean verif = true;
		if (selectedFournisseur.getId() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vous devez sélectionner un fournisseur. ", null));
			verif = false;
		}
		if (bonreception.getNumero_bl() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Vous devez indiquer le numero du Bon de livraison. ", null));
			verif = false;
		}
		if (bonreception.getDate_bl() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Vous devez indiquer la date du Bon de livraison. ", null));
			verif = false;
		}
		if (bonreception.getDateReception() == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Vous devez indiquer la date de la réception. ", null));
			verif = false;
		}
		if (listeLigneReceptions.size() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "La liste de réception est vide. ", null));
			verif = false;
		}

		if (verif == true) {
			for (int i = 0; i <= listeLigneReceptions.size() - 1; i++) {
				listeLigneReceptions.get(i).setDate(bonreception.getDateReception());
				listeLigneReceptions.get(i).setBlack(bonreception.isBlack());
				ligneReceptionService.addLigneReception(listeLigneReceptions.get(i));
			}
			bonreception.setFournisseur(selectedFournisseur);
			bonreception.setLigneReceptions(listeLigneReceptions);
			bonreceptionService.addBonReception(bonreception);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Bon de réception ajouter avec succès.", null));
		
			selectedFournisseur=new Fournisseur();
			bonreception=new BonReception();
			ligneReception = new LigneReception();
			listeLigneReceptions = new ArrayList<LigneReception>();
		}

	}

	public void addligne() {
		if ((selectedArticle.getMarque() != null) && (selectedArticle.getItem() != null)) {
			if (ligneReception.getPrix_total_ttc() != 0) // si le valeur total de la ligne est defirent de 0
			{
				if (articleService.findWithMarqueAndCode(selectedArticle.getMarque(),
						selectedArticle.getItem()) == null) // on verifie si l'article existe
					articleService.addArticle(selectedArticle); // si non on l'ajoute a la BD

				ligneReception.setArticle(selectedArticle);
				listeLigneReceptions.add(ligneReception);

				// on remet tout a zero
			int tva=ligneReception.getTva();
			int remise=ligneReception.getRemise();
				ligneReception = new LigneReception();
				ligneReception.setTva(tva);
				ligneReception.setRemise(remise);
				
				
				Marque marque=selectedArticle.getMarque();
				selectedArticle = new Article();
				selectedArticle.setMarque(marque);
				
			}
		}
	}

	public float getTotalHTVA() {
		if (listeLigneReceptions == null)
			return 0;
		float totalHTVA = 0;
		for (int i = 0; i <= listeLigneReceptions.size() - 1; i++) {
			totalHTVA += listeLigneReceptions.get(i).getPrix_total_HTVA();
		}
		return totalHTVA;
	}

	public float getTotalTTC() {
		if (listeLigneReceptions == null)
			return 0;
		float totalTTC = 0;
		for (int i = 0; i <= listeLigneReceptions.size() - 1; i++) {
			totalTTC += listeLigneReceptions.get(i).getPrix_total_ttc();
		}
		return totalTTC;
	}

}