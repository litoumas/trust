package com.trust.app.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.trust.app.model.Client;
import com.trust.app.service.ClientService;

@ManagedBean(name = "NewClientController")
@ViewScoped
public class NewClientController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8029245018344059604L;
	
	@ManagedProperty("#{clientService}")
	private ClientService clientService;
	
	private String nom;

	
	public void Submit() {
		
		Client client=clientService.findWithName(nom);
		if(client==null)
		{
			client=new Client();
			client.setNom(nom);
			clientService.addClient(client);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nouveau Client ajouter avec succès"));
			nom=null;
		}else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Client déjà existante"));
		}
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService ClientService) {
		this.clientService = ClientService;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	

}
