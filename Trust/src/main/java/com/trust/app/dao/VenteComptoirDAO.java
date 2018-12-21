package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.VenteComptoir;
import com.trust.app.model.LigneVenteComptoir;
import com.trust.app.model.User;
/**
 * VenteComptoir data access object interface
 * */
public interface VenteComptoirDAO {
	
	public List<VenteComptoir> listVenteComptoirs();

	public void addVenteComptoir(VenteComptoir u);

	public void deleteVenteComptoir(VenteComptoir u);

	public void updateVenteComptoir(VenteComptoir u);




}
