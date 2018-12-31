package com.trust.app.controllers;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.trust.app.model.FactureAchat;
import com.trust.app.model.Fournisseur;
import com.trust.app.model.GrandLivre;
import com.trust.app.service.BonReceptionService;
import com.trust.app.service.FactureAchatService;
import com.trust.app.service.GrandLivreService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "NewFactureFournisseurController")
@SessionScoped
public class NewFactureFournisseurController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3765019244778399054L;

	@Getter
	@Setter
	@ManagedProperty("#{factureAchatService}")
	private FactureAchatService factureAchatService;

	@Getter
	@Setter
	@ManagedProperty("#{bonReceptionService}")
	private BonReceptionService bonReceptionService;
	
	
	@Getter
	@Setter
	@ManagedProperty("#{grandLivreService}")
	private GrandLivreService grandLivreService;
	

	@Getter
	@Setter
	Fournisseur selectedFournisseur = new Fournisseur();

	@Getter
	@Setter
	FactureAchat factureAchat = new FactureAchat();

	public void submit() {

		factureAchat.setContact(selectedFournisseur);

		factureAchatService.addFactureAchat(factureAchat);

		
		GrandLivre grandLivre=new GrandLivre();
		grandLivre.setBlack(factureAchat.isBlack());
		grandLivre.setFacture(factureAchat);
		grandLivre.setMontant(factureAchat.getTotal_ttc());
		grandLivre.setSens(2);
		grandLivre.setDate(new Date());
		grandLivreService.addGrandLivre(grandLivre);
		
		selectedFournisseur = new Fournisseur();
		factureAchat = new FactureAchat();

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Facture enregistrée avec succès"));

	}
}
