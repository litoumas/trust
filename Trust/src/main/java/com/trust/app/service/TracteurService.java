package com.trust.app.service;

import java.util.List;

import com.trust.app.model.MarqueTracteur;
import com.trust.app.model.Tracteur;

public interface TracteurService {
	
	public void addTracteur(Tracteur c);
    public List<Tracteur> listTracteurs();
    public void deleteTracteur(Tracteur c);
    public void updateTracteur(Tracteur c);
    public void testLog();
	public Tracteur find(String designation, MarqueTracteur selectedMarqueTracteur);
}
