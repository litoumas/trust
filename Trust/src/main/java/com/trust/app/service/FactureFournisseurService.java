package com.trust.app.service;

import java.util.List;

import com.trust.app.model.FactureFournisseur;

public interface FactureFournisseurService {
	
	public void addFactureFournisseur(FactureFournisseur c);
    public List<FactureFournisseur> listFactureFournisseurs();
    public void deleteFactureFournisseur(FactureFournisseur c);
    public void updateFactureFournisseur(FactureFournisseur c);
    public void testLog();
}
