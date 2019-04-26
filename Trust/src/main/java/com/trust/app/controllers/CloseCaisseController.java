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
import com.trust.app.model.GrandLivre;
import com.trust.app.model.LigneCloseCaisse;
import com.trust.app.model.LigneVenteComptoir;
import com.trust.app.model.VenteComptoir;
import com.trust.app.service.CaisseService;
import com.trust.app.service.GrandLivreService;
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
	@ManagedProperty("#{grandLivreService}")
	private GrandLivreService grandLivreService;

	@Getter
	@Setter
	List<LigneCloseCaisse> listeLigneCloseCaisses = new ArrayList<LigneCloseCaisse>();

	@Getter
	@Setter
	List<LigneVenteComptoir> listLigneVenteComptoirs;

	public void prepereColse() {
		listeLigneCloseCaisses = new ArrayList<LigneCloseCaisse>();

		Caisse caisse = caisseService.getLastOne();
		Iterator<VenteComptoir> iteratorV = caisse.getListeventeComptoirs().iterator();
		while (iteratorV.hasNext()) {
			VenteComptoir venteComptoir = iteratorV.next();

			Iterator<LigneVenteComptoir> iteratorL = venteComptoir.getListeligneVenteComptoirSuspens().iterator();
			while (iteratorL.hasNext()) {
				LigneVenteComptoir ligneVenteComptoir = iteratorL.next();

				LigneCloseCaisse ligneCloseCaisse = new LigneCloseCaisse(ligneVenteComptoir);
				ligneCloseCaisse.setVenteComptoir(venteComptoir);
				listeLigneCloseCaisses.add(ligneCloseCaisse);
			}

		}
	}

	public void onCellEdit(CellEditEvent event) {
		float newValue = (float) event.getNewValue();

		int rowIndex = event.getRowIndex();
		float qteTT = listeLigneCloseCaisses.get(rowIndex).getLigneVenteComptoir().getQte();

		listeLigneCloseCaisses.get(rowIndex).setQteNoir(qteTT - newValue);
	}

	public void submit() {
		
		

		
		
		/**
		 
		 
		 
		Caisse caisse = caisseService.getLastOne();
		listLigneVenteComptoirs = new ArrayList<LigneVenteComptoir>();
		Iterator<LigneCloseCaisse> iterator = listeLigneCloseCaisses.iterator();
		
		VenteComptoir venteComptoirBlack = null;
		
		while (iterator.hasNext()) {
			LigneCloseCaisse ligneCloseCaisse = iterator.next();
			LigneVenteComptoir ligneVenteComptoir = ligneCloseCaisse.getLigneVenteComptoir();
			float qteT = ligneVenteComptoir.getQte();
			float qteN = ligneCloseCaisse.getQteNoir();
			float qteD = ligneCloseCaisse.getQteDeclarer();

			ligneVenteComptoir.setBlack(false);
			ligneVenteComptoir.setQte(qteD);
			ligneVenteComptoir.setValider(true);
			ligneVenteComptoirService.updateLigneVenteComptoir(ligneVenteComptoir);

			GrandLivre grandLivre=new GrandLivre();
			grandLivre.setBlack(false);
			grandLivre.setFacture(ligneCloseCaisse.getVenteComptoir());
			grandLivre.setMontant(ligneVenteComptoir.getTotalPrixDeclaree());
			grandLivre.setSens(1);
			grandLivreService.addGrandLivre(grandLivre);
			
			GrandLivre grandLivre2=new GrandLivre();
			grandLivre2.setBlack(false);
			grandLivre2.setFacture(ligneCloseCaisse.getVenteComptoir());
			grandLivre2.setMontant(ligneVenteComptoir.getTotalPrixTTC()-ligneVenteComptoir.getTotalPrixDeclaree());
			grandLivre2.setSens(1);
			grandLivreService.addGrandLivre(grandLivre2);
			
			LigneVenteComptoir ligneVenteComptoirBlack = new LigneVenteComptoir();
			ligneVenteComptoirBlack.setArticle(ligneVenteComptoir.getArticle());
			ligneVenteComptoirBlack.setBlack(true);
			ligneVenteComptoirBlack.setDate(ligneVenteComptoir.getDate());
			ligneVenteComptoirBlack.setPrix_brute(ligneVenteComptoir.getPrix_brute());
			ligneVenteComptoirBlack.setPrix_declaree(0);
			ligneVenteComptoirBlack.setPrix_ttc(ligneVenteComptoir.getPrix_ttc());
			ligneVenteComptoirBlack.setQte(qteN);
			ligneVenteComptoirBlack.setSens(2);
			ligneVenteComptoirBlack.setValider(true);
			ligneVenteComptoirService.addLigneVenteComptoir(ligneVenteComptoirBlack);

			if(venteComptoirBlack==null)
			{
				venteComptoirBlack=new VenteComptoir();
				venteComptoirBlack.setBlack(true);
				caisse.addVente(venteComptoirBlack);
				venteComptoirService.addVenteComptoir(venteComptoirBlack);
				caisseService.updateCaisse(caisse);
			}
			
			venteComptoirBlack.addLigne(ligneVenteComptoirBlack);

			
			
			GrandLivre grandLivreBlack=new GrandLivre();
			grandLivreBlack.setBlack(true);
			grandLivreBlack.setFacture(ligneCloseCaisse.getVenteComptoir());;
			grandLivreBlack.setMontant(ligneVenteComptoirBlack.getTotalPrixTTC());
			grandLivreBlack.setSens(1);
			grandLivreService.addGrandLivre(grandLivreBlack);
			
			ligneCloseCaisse.getVenteComptoir().setBlack(false);;
			venteComptoirService.updateVenteComptoir(ligneCloseCaisse.getVenteComptoir());
			venteComptoirService.updateVenteComptoir(venteComptoirBlack);

		}
*/
	}

}
