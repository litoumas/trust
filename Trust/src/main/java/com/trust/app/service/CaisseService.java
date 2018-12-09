package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Caisse;

public interface CaisseService {
	
	
	public void addCaisse(Caisse Caisse);
	public List<Caisse> listCaisses();
	public void deleteCaisse(Caisse d);
	public void updateCaisse(Caisse d);
	public Caisse getLastOne();
	
}
