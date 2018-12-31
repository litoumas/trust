package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.GrandLivre;
/**
 * GrandLivre data access object interface
 * */
public interface GrandLivreDAO {
	
	public List<GrandLivre> listGrandLivres();

	public void addGrandLivre(GrandLivre u);

	public void deleteGrandLivre(GrandLivre u);

	public void updateGrandLivre(GrandLivre u);



}
