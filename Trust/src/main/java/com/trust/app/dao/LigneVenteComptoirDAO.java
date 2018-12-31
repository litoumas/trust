package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.LigneVenteComptoir;
import com.trust.app.model.User;
import com.trust.app.model.VenteComptoir;
/**
 * LigneVenteComptoir data access object interface
 * */
public interface LigneVenteComptoirDAO {
	
	public List<LigneVenteComptoir> listLigneVenteComptoirs();

	public void addLigneVenteComptoir(LigneVenteComptoir u);

	public void deleteLigneVenteComptoir(LigneVenteComptoir u);

	public void updateLigneVenteComptoir(LigneVenteComptoir u);

	public VenteComptoir getVenteComptoirOf(LigneVenteComptoir ligneVenteComptoirBlack);




}
