package com.trust.app.service;

import java.util.List;

import com.trust.app.model.GrandLivre;

public interface GrandLivreService {
	
	
	public void addGrandLivre(GrandLivre GrandLivre);
	public List<GrandLivre> listGrandLivres();
	public void deleteGrandLivre(GrandLivre d);
	public void updateGrandLivre(GrandLivre d);
	
}
