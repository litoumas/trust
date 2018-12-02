package com.trust.app.service;

import java.util.List;

import com.trust.app.model.BonReception;
import com.trust.app.model.Fournisseur;

public interface BonReceptionService {
	
	public void addBonReception(BonReception c);
    public List<BonReception> listBonReceptions();
    public void deleteBonReception(BonReception c);
    public void updateBonReception(BonReception c);
    public void testLog();
	public List<BonReception> listBonReceptions(Fournisseur fournisseur);
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack);
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack, boolean hasInvoice);
}
