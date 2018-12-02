package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.BonReception;
import com.trust.app.model.Fournisseur;

public interface BonReceptionDAO {
	
	public void addBonReception(BonReception p);
    public List<BonReception> listBonReceptions();
    public void deleteBonReception(BonReception p);
    public void updateBonReception(BonReception p);
	public List<BonReception> listBonReceptions(Fournisseur fournisseur);
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack);
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack, boolean hasInvoice);

}
