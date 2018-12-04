package com.trust.app.service;

import java.util.List;

import com.trust.app.model.BonLivraison;

public interface BonLivraisonService {
	
	
	public void addBonLivraison(BonLivraison BonLivraison);
	public List<BonLivraison> listBonLivraisons();
	public void deleteBonLivraison(BonLivraison d);
	public void updateBonLivraison(BonLivraison d);
	
}
