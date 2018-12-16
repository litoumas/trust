package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Parametre;

public interface ParametreService {
	
	public void addParametre(Parametre c);
    public List<Parametre> listParametres();
    public void deleteParametre(Parametre c);
    public void updateParametre(Parametre c);
    public void testLog();
	public Parametre getParametre(String nomParametre);
}
