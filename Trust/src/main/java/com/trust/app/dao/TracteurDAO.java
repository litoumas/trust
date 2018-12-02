package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.MarqueTracteur;
import com.trust.app.model.Tracteur;

public interface TracteurDAO {
	
	public void addTracteur(Tracteur p);
    public List<Tracteur> listTracteurs();
    public void deleteTracteur(Tracteur p);
    public void updateTracteur(Tracteur p);
	public Tracteur find(String designation, MarqueTracteur selectedMarqueTracteur);

}
