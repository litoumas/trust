package com.trust.app.service;

import java.util.List;

import com.trust.app.model.LigneVente;

public interface LigneVenteService {


	
	public void addLigneVente(LigneVente c);
    public List<LigneVente> listLigneVentes();
    public void deleteLigneVente(LigneVente c);
    public void updateLigneVente(LigneVente c);
    public void testLog();


}
