package com.trust.app.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.trust.app.model.BonReception;
import com.trust.app.model.FactureFournisseur;
import com.trust.app.model.Fournisseur;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "NewFactureFournisseurController")
@SessionScoped
public class NewFactureFournisseurController {

	
	@Getter
	@Setter
	Fournisseur selectedFournisseur = new Fournisseur();
	
	@Getter
	@Setter
	boolean type=false;
	
	@Getter
	@Setter
	FactureFournisseur factureFournisseur=new FactureFournisseur();
	
	@Getter
	@Setter
	BonReception selectedbonReception= new BonReception();
	
	
	public void submit() {

	
	}
}
