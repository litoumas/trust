package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.MarqueTracteur;


public interface MarqueTracteurDAO {
	public void addMarqueTracteur(MarqueTracteur m);
    public List<MarqueTracteur> listMarqueTracteurs();
    public void deleteMarqueTracteur(MarqueTracteur m);
    public void updateMarqueTracteur(MarqueTracteur m);
	public MarqueTracteur findWithDesig(String designiation);

}
