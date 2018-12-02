package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Marque;

public interface MarqueService {
	
	public void addMarque(Marque c);
    public List<Marque> listMarques();
    public void deleteMarque(Marque c);
    public void updateMarque(Marque c);
    public void testLog();
    public Marque findWithDesig(String m);
}
