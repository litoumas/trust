package com.trust.app.service;

import java.util.List;

import com.trust.app.model.FactureVente;

public interface FactureVenteService {
	
	
	public void addFactureVente(FactureVente FactureVente);
	public List<FactureVente> listFactureVentes();
	public void deleteFactureVente(FactureVente d);
	public void updateFactureVente(FactureVente d);
	
}
