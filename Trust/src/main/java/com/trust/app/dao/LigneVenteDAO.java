package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.LigneVente;


public interface LigneVenteDAO {
	
	public void addLigneVente(LigneVente p);
    public List<LigneVente> listLigneVentes();
    public void deleteLigneVente(LigneVente p);
    public void updateLigneVente(LigneVente p);

}
