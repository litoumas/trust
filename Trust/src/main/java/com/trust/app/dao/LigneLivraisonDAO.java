package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.LigneLivraison;

public interface LigneLivraisonDAO {

	public List<LigneLivraison> listLigneLivraisons();

	public void addLigneLivraison(LigneLivraison u);

	public void deleteLigneLivraison(LigneLivraison u);

	public void updateLigneLivraison(LigneLivraison u);

	
	
}
