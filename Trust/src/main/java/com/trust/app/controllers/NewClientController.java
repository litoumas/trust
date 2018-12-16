package com.trust.app.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.trust.app.model.Client;
import com.trust.app.model.Parametre;
import com.trust.app.service.ClientService;
import com.trust.app.service.ParametreService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "NewClientController")
@ViewScoped
public class NewClientController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8029245018344059604L;
	
	@ManagedProperty("#{clientService}")
	private ClientService clientService;
	
	@ManagedProperty("#{parametreService}")
	@Getter
	@Setter
	private ParametreService parametreService;
	
	
	private String nom;

	
	public void Submit() {
		
		Client client=clientService.findWithName(nom);
		if(client==null)
		{
			client=new Client();
			client.setNom(nom);
			client.setCode(getNextNumber(Parametre.CODECLIENT));
			clientService.addClient(client);
			Parametre par = parametreService.getParametre(Parametre.CODECLIENT);
			par.setValeur(""+(Integer.parseInt(par.getValeur())+1));
			parametreService.updateParametre(par);
			
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nouveau Client ajouter avec succès"));
			nom=null;
		}else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Client déjà existante"));
		}
		

	}
	
	
	public String getNextNumber(String parametre) {

		int nbr0 = Integer.parseInt(parametreService.getParametre("nbr0_" + parametre).getValeur()); // nombre de chifre
																										// que comporte
																										// le numero
		String prefix = parametreService.getParametre("prefix_" + parametre).getValeur(); // prefix du nemero
		String suffixe = parametreService.getParametre("suffixe_" + parametre).getValeur(); // suffixe du nemero

		String numero = prefix;

		Parametre para = parametreService.getParametre(parametre);
		int num = Integer.parseInt(para.getValeur());
		num++;
		int nbr = String.valueOf(num).length(); // ici on utilise le ID a la place de nemero

		for (int i = 0; i <= (nbr0 - nbr) - 1; i++) // on ajoute les 0 manquant
		{
			numero += "0";
		}
		numero += num + suffixe; // ici on utilise le ID a la place de nemero

		para.setValeur("" + num);
		return numero;
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
