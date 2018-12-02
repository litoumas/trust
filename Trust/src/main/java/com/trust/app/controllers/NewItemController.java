package com.trust.app.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.trust.app.model.Item;
import com.trust.app.model.Tracteur;
import com.trust.app.service.ItemService;
import com.trust.app.service.TracteurService;

@ManagedBean(name = "NewItemController")
@ViewScoped
public class NewItemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6784046118219128609L;

	@ManagedProperty("#{itemService}")
	private ItemService itemService;

	@ManagedProperty("#{tracteurService}")
	private TracteurService tracteurService;

	private String code;
	private String designiation;
	
	

	private List<Tracteur> suppotedtracteurs = new ArrayList<Tracteur>();
	private Tracteur selectedTracteur;

	public void onRowSelectTracteur(SelectEvent eventc) {
		if ((Tracteur) eventc.getObject() != null) {
			this.selectedTracteur = (Tracteur) eventc.getObject();
			suppotedtracteurs.add(this.selectedTracteur);
		}
	}

	public void onRowUnselectMarqueTracteur(UnselectEvent event) {
		// TODO Auto-generated method stub

	}

	public void Submit() {

		Item item = new Item();
		item.setCode(code);
		item.setDesignation(designiation);
		item.setTracteurs(suppotedtracteurs);
		itemService.addItem(item);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Nouveau fournisseur ajouter avec succès"));

		code = null;
		designiation = null;
		suppotedtracteurs = new ArrayList<Tracteur>();
	}

	public List<Tracteur> getAllTracteur() {

		return tracteurService.listTracteurs();
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesigniation() {
		return designiation;
	}

	public void setDesigniation(String designiation) {
		this.designiation = designiation;
	}

	public TracteurService getTracteurService() {
		return tracteurService;
	}

	public void setTracteurService(TracteurService tracteurService) {
		this.tracteurService = tracteurService;
	}

	public Tracteur getSelectedTracteur() {
		return selectedTracteur;
	}

	public void setSelectedTracteur(Tracteur selectedTracteur) {
		this.selectedTracteur = selectedTracteur;
	}

	public List<Tracteur> getSuppotedtracteurs() {
		return suppotedtracteurs;
	}

	public void setSuppotedtracteurs(List<Tracteur> suppotedtracteurs) {
		this.suppotedtracteurs = suppotedtracteurs;
	}


	
	
	
}
