package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Fournisseur;

public interface FournisseurService {
	
	public void addFournisseur(Fournisseur c);
    public List<Fournisseur> listFournisseurs();
    public void deleteFournisseur(Fournisseur c);
    public void updateFournisseur(Fournisseur c);
    public void testLog();
	public Fournisseur findWithName(String nom);
}
