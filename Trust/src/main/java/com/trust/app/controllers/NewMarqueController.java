package com.trust.app.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.trust.app.model.Marque;
import com.trust.app.service.MarqueService;

@ManagedBean(name = "NewMarqueController")
@SessionScoped
public class NewMarqueController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5383734647639981295L;
	
	
	private String designiation;
	
	@ManagedProperty("#{marqueService}")
	private MarqueService marqueService;

	
	public void Submit() {
		
		Marque Marque=marqueService.findWithDesig(designiation);
		if(Marque==null)
		{
			Marque=new Marque();
			Marque.setDesignation(designiation);
			marqueService.addMarque(Marque);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nouvelle marque ajouter avec succès"));
			designiation=null;
		}else
		{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Marque déjà existante"));
			
		}
		

	}
	
	
	public String getDesigniation() {
		return designiation;
	}

	public void setDesigniation(String designiation) {
		this.designiation = designiation;
	}


	public MarqueService getMarqueService() {
		return marqueService;
	}


	public void setMarqueService(MarqueService marqueService) {
		this.marqueService = marqueService;
	}

	
	
	
}
