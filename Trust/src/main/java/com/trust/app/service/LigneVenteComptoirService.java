package com.trust.app.service;

import java.util.List;

import com.trust.app.model.LigneVenteComptoir;

public interface LigneVenteComptoirService {
	
	
	public void addLigneVenteComptoir(LigneVenteComptoir LigneVenteComptoir);
	public List<LigneVenteComptoir> listLigneVenteComptoirs();
	public void deleteLigneVenteComptoir(LigneVenteComptoir d);
	public void updateLigneVenteComptoir(LigneVenteComptoir d);
	
}