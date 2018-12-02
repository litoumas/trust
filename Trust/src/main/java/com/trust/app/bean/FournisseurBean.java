package com.trust.app.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.trust.app.model.Fournisseur;
import com.trust.app.service.FournisseurService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "FournisseurBean")
@ViewScoped
public class FournisseurBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5872818398315071209L;
	
	
	@ManagedProperty("#{fournisseurService}")
	@Getter
	@Setter
	private FournisseurService fournisseurService;
	
	
	
	
	public List<Fournisseur> getListFournisseurs() {
		return fournisseurService.listFournisseurs();
		
	}
	
}
