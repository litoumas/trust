package com.trust.app.dao;

import java.util.List;
import com.trust.app.model.Fournisseur;
/**
 * Fournisseur data access object interface
 * */

public interface FournisseurDAO {
	
	public void addFournisseur(Fournisseur p);
    public List<Fournisseur> listFournisseurs();
    public void deleteFournisseur(Fournisseur p);
    public void updateFournisseur(Fournisseur p);
	public Fournisseur findWithName(String nom);

}
