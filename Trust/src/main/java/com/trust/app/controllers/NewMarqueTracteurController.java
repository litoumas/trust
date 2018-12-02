package com.trust.app.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.trust.app.model.MarqueTracteur;
import com.trust.app.service.MarqueTracteurService;

@ManagedBean(name = "NewMarqueTracteurController")
@ViewScoped
public class NewMarqueTracteurController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5383734647639981295L;
	
	
	private String designiation;
	
	@ManagedProperty("#{marqueTracteurService}")
	private MarqueTracteurService marqueTracteurService;

	
	public void Submit() {
		
		MarqueTracteur marqueTracteur=marqueTracteurService.findWithDesig(designiation);
		if(marqueTracteur==null)
		{
			marqueTracteur=new MarqueTracteur();
			marqueTracteur.setDesignation(designiation);
			marqueTracteurService.addMarqueTracteur(marqueTracteur);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Marque de Tracteur ajouter avec succès"));
			designiation=null;
		}else
		{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Marque de Tracteur déjà existante"));
			
		}
		

	}
	
	
	public String getDesigniation() {
		return designiation;
	}

	public void setDesigniation(String designiation) {
		this.designiation = designiation;
	}


	public MarqueTracteurService getMarqueTracteurService() {
		return marqueTracteurService;
	}

	public void setMarqueTracteurService(MarqueTracteurService marqueTracteurService) {
		this.marqueTracteurService = marqueTracteurService;
	}
	
	
	
}
