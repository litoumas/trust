package com.trust.app.service;

import java.util.List;

import com.trust.app.model.MarqueTracteur;

public interface MarqueTracteurService {
	
	public void addMarqueTracteur(MarqueTracteur c);
    public List<MarqueTracteur> listMarqueTracteurs();
    public void deleteMarqueTracteur(MarqueTracteur c);
    public void updateMarqueTracteur(MarqueTracteur c);
    public void testLog();
	public MarqueTracteur findWithDesig(String designiation);
}
