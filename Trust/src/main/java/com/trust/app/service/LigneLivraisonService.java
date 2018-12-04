package com.trust.app.service;

import java.util.List;

import com.trust.app.model.LigneLivraison;

public interface LigneLivraisonService {
	
	
	public void addLigneLivraison(LigneLivraison LigneLivraison);
	public List<LigneLivraison> listLigneLivraisons();
	public void deleteLigneLivraison(LigneLivraison d);
	public void updateLigneLivraison(LigneLivraison d);
	
}
