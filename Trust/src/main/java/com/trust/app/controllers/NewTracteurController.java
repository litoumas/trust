package com.trust.app.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.trust.app.model.MarqueTracteur;
import com.trust.app.model.Tracteur;
import com.trust.app.service.MarqueTracteurService;
import com.trust.app.service.TracteurService;

@ManagedBean(name = "NewTracteurController")
@ViewScoped
public class NewTracteurController implements Serializable {

	private static final long serialVersionUID = 8767135948167761166L;
	
	
	
	@ManagedProperty("#{marqueTracteurService}")
	private MarqueTracteurService marqueTracteurService;
	
	@ManagedProperty("#{tracteurService}")
	private TracteurService tracteurService;

	private String designation;
	private MarqueTracteur selectedMarqueTracteur;

	public List<MarqueTracteur> getListMarqueTracteurs() {
		
		return marqueTracteurService.listMarqueTracteurs();
		
	}

	public MarqueTracteurService getMarqueTracteurService() {
		return marqueTracteurService;
	}

	
	
	public TracteurService getTracteurService() {
		return tracteurService;
	}

	public void setTracteurService(TracteurService tracteurService) {
		this.tracteurService = tracteurService;
	}

	public void setMarqueTracteurService(MarqueTracteurService MarqueTracteurService) {
		this.marqueTracteurService = MarqueTracteurService;
	}

	public MarqueTracteur getSelectedMarqueTracteur() {
		return selectedMarqueTracteur;
	}

	public void setSelectedMarqueTracteur(MarqueTracteur selectedMarqueTracteur) {

		this.selectedMarqueTracteur = selectedMarqueTracteur;

	}

	public void onRowSelectMarqueTracteur(SelectEvent event) {
		
		if ((MarqueTracteur) event.getObject() != null) {
			this.selectedMarqueTracteur = (MarqueTracteur) event.getObject();
		}
	}

	public void onRowUnselectMarqueTracteur(UnselectEvent event) {
		
		
	}
	
	
	public void Submit()
	{
		if(tracteurService.find(designation,selectedMarqueTracteur)==null)
		{
		Tracteur tracteur=new Tracteur();
		tracteur.setDesignation(designation);
		tracteur.setMarqueTracteurs(selectedMarqueTracteur);
		tracteurService.addTracteur(tracteur);
		
		designation="";
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Model de Tracteur ajouter avec succès"));
		
		}else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Model de Tracteur déjà existante"));
		}
	}
	

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	

}
