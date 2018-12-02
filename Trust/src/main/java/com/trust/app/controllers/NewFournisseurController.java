package com.trust.app.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.trust.app.model.Fournisseur;
import com.trust.app.service.FournisseurService;

@ManagedBean(name = "NewFournisseurController")
@ViewScoped
public class NewFournisseurController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8029245018344059604L;
	
	@ManagedProperty("#{fournisseurService}")
	private FournisseurService fournisseurService;
	
	private String nom;

	
	public void Submit() {
		
		Fournisseur fournisseur=fournisseurService.findWithName(nom);
		if(fournisseur==null)
		{
			fournisseur=new Fournisseur();
			fournisseur.setNom(nom);
			fournisseurService.addFournisseur(fournisseur);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nouveau fournisseur ajouter avec succès"));
			nom=null;
		}else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Fournisseur déjà existante"));
		}
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public FournisseurService getFournisseurService() {
		return fournisseurService;
	}

	public void setFournisseurService(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	

}
