package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.FactureFournisseur;

public interface FactureFournisseurDAO {

	public void addFactureFournisseur(FactureFournisseur p);
    public List<FactureFournisseur> listFactureFournisseurs();
    public void deleteFactureFournisseur(FactureFournisseur p);
    public void updateFactureFournisseur(FactureFournisseur p);

	
}
