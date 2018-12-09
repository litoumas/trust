package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.Caisse;
import com.trust.app.model.User;
/**
 * Caisse data access object interface
 * */
public interface CaisseDAO {
	
	public List<Caisse> listCaisses();

	public void addCaisse(Caisse u);

	public void deleteCaisse(Caisse u);

	public void updateCaisse(Caisse u);

	public Caisse getLastOne();



}