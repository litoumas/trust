package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.BonLivraison;
/**
 * BonLivraison data access object interface
 * */
public interface BonLivraisonDAO {
	
	public List<BonLivraison> listBonLivraisons();

	public void addBonLivraison(BonLivraison b);

	public void deleteBonLivraison(BonLivraison b);

	public void updateBonLivraison(BonLivraison b);



}
