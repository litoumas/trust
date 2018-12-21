package com.trust.app.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;

import com.trust.app.model.Caisse;
import com.trust.app.model.LigneCloseCaisse;
import com.trust.app.model.LigneVenteComptoir;
import com.trust.app.model.VenteComptoir;
import com.trust.app.service.CaisseService;
import com.trust.app.service.LigneVenteComptoirService;
import com.trust.app.service.VenteComptoirService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "CloseCaisseController")
@SessionScoped
public class CloseCaisseController {

	@Getter
	@Setter
	@ManagedProperty("#{caisseService}")
	private CaisseService caisseService;
	
	@Getter
	@Setter
	@ManagedProperty("#{ligneVenteComptoirService}")
	private LigneVenteComptoirService ligneVenteComptoirService;
	
	
	@Getter
	@Setter
	@ManagedProperty("#{venteComptoirService}")
	private VenteComptoirService venteComptoirService;
	
	

	@Getter
	@Setter
	List<LigneCloseCaisse> listeLigneCloseCaisses = new ArrayList<LigneCloseCaisse>();
	
	@Getter
	@Setter
	List<LigneVenteComptoir> listLigneVenteComptoirs;
	

	public void prepereColse() {
		listeLigneCloseCaisses = new ArrayList<LigneCloseCaisse>();

		Caisse caisse = caisseService.getLastOne();

		Iterator<LigneVenteComptoir> iterator = caisse.getLigneVenteSuspens().iterator();
		while (iterator.hasNext()) {
			LigneVenteComptoir lignevente = iterator.next();

			LigneCloseCaisse ligneCloseCaisse = new LigneCloseCaisse(lignevente);
			listeLigneCloseCaisses.add(ligneCloseCaisse);
		}
	}

	public void onCellEdit(CellEditEvent event) {
		float newValue = (float) event.getNewValue();

		int rowIndex = event.getRowIndex();
		float qteTT = listeLigneCloseCaisses.get(rowIndex).getLigneVenteComptoir().getQte();

		listeLigneCloseCaisses.get(rowIndex).setQteNoir(qteTT-newValue);
	}

	public void submit() {
		Caisse caisse = caisseService.getLastOne();
		listLigneVenteComptoirs= new ArrayList<LigneVenteComptoir>();
		Iterator<LigneCloseCaisse> iterator = listeLigneCloseCaisses.iterator();
		while (iterator.hasNext()) {
			LigneCloseCaisse ligneCloseCaisse = iterator.next();
			LigneVenteComptoir ligneVenteComptoir=ligneCloseCaisse.getLigneVenteComptoir();
			float qteT=ligneVenteComptoir.getQte();
			float qteN=ligneCloseCaisse.getQteNoir();
			float qteD=ligneCloseCaisse.getQteDeclarer();
			
			ligneVenteComptoir.setBlack(false);
			ligneVenteComptoir.setQte(qteD);
			ligneVenteComptoir.setValider(true);
			ligneVenteComptoirService.updateLigneVenteComptoir(ligneVenteComptoir);
			
			LigneVenteComptoir ligneVenteComptoirBlack=new LigneVenteComptoir();
			ligneVenteComptoirBlack.setArticle(ligneVenteComptoir.getArticle());
			ligneVenteComptoirBlack.setBlack(true);
			ligneVenteComptoirBlack.setDate(ligneVenteComptoir.getDate());
			ligneVenteComptoirBlack.setPrix_brute(ligneVenteComptoir.getPrix_brute());
			ligneVenteComptoirBlack.setPrix_declaree(ligneVenteComptoirBlack.getPrix_declaree());
			ligneVenteComptoirBlack.setPrix_ttc(ligneVenteComptoirBlack.getPrix_ttc());
			ligneVenteComptoirBlack.setQte(qteN);
			ligneVenteComptoirBlack.setSens(2);
			ligneVenteComptoirBlack.setValider(true);
		//	ligneVenteComptoirBlack.setVenteComptoir(ligneVenteComptoir.getVenteComptoir());
		//	ligneVenteComptoirService.addLigneVenteComptoir(ligneVenteComptoirBlack);
		
		//	VenteComptoir venteComptoir=ligneVenteComptoirService.getVenteComptoir(ligneVenteComptoir );
		
		}

	}

}
