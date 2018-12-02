package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.Droit;
import com.trust.app.model.User;
/**
 * Droit data access object interface
 * */
public interface DroitDAO {
	
	public List<Droit> listDroits();

	public void addDroit(Droit u);

	public void deleteDroit(Droit u);

	public void updateDroit(Droit u);



}
