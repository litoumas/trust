package com.trust.app.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.trust.app.model.FactureFournisseur;
import com.trust.app.model.Fournisseur;
import com.trust.app.service.BonReceptionService;
import com.trust.app.service.FactureFournisseurService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "NewFactureFournisseurController")
@SessionScoped
public class NewFactureFournisseurController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3765019244778399054L;

	@Getter
	@Setter
	@ManagedProperty("#{factureFournisseurService}")
	private FactureFournisseurService factureFournisseurService;
	
	
	@Getter
	@Setter
	@ManagedProperty("#{bonReceptionService}")
	private BonReceptionService bonReceptionService;
	
	

	@Getter
	@Setter
	Fournisseur selectedFournisseur = new Fournisseur();
	
	
	@Getter
	@Setter
	FactureFournisseur factureFournisseur=new FactureFournisseur();
	
	
	
	public void submit() {

		factureFournisseur.setFournisseur(selectedFournisseur);
		
		System.out.println("=====================================================================================================================");
		System.out.println("=====================================================================================================================");
	
		
		factureFournisseurService.addFactureFournisseur(factureFournisseur);
		
			
		
		 selectedFournisseur = new Fournisseur();
		 factureFournisseur=new FactureFournisseur();
		 
		 
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Facture enregistrée avec succès"));
		 
	
	}
}
