package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Droit;
import com.trust.app.model.User;

public interface DroitService {
	
	
	public void addDroit(Droit Droit);
	public List<Droit> listDroits();
	public void deleteDroit(Droit d);
	public void updateDroit(Droit d);
	
}
