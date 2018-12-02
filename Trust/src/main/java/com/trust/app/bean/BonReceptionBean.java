package com.trust.app.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.trust.app.model.BonReception;
import com.trust.app.model.Fournisseur;
import com.trust.app.service.BonReceptionService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "BonReceptionBean")
@ViewScoped
public class BonReceptionBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6161796467967765783L;
	
	
	@ManagedProperty("#{bonReceptionService}")
	@Getter
	@Setter
	private BonReceptionService bonreceptionService;
	
	
	
	
	public List<BonReception> getListBonReceptions() {
		List<BonReception> dd=bonreceptionService.listBonReceptions();
		
		return dd;
		
	}
	
	
	public List<BonReception> getListBonReceptions(Fournisseur fournisseur ){
		return bonreceptionService.listBonReceptions(fournisseur);
	}
	
	public List<BonReception> getListBonReceptions(Fournisseur fournisseur, boolean isblack){
		return bonreceptionService.listBonReceptions(fournisseur, isblack);
	}
	
	public List<BonReception> getListBonReceptions(Fournisseur fournisseur, boolean isblack, boolean hasInvoice){
		return bonreceptionService.listBonReceptions(fournisseur,isblack,hasInvoice);
	}
}
