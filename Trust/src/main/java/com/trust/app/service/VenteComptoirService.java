package com.trust.app.service;

import java.util.List;

import com.trust.app.model.VenteComptoir;

public interface VenteComptoirService {
	
	
	public void addVenteComptoir(VenteComptoir VenteComptoir);
	public List<VenteComptoir> listVenteComptoirs();
	public void deleteVenteComptoir(VenteComptoir d);
	public void updateVenteComptoir(VenteComptoir d);
	
}
