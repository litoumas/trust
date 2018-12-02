package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.Marque;

public interface MarqueDAO {
	public void addMarque(Marque m);
    public List<Marque> listMarques();
    public void deleteMarque(Marque m);
    public void updateMarque(Marque m);
	public Marque findWithDesig(String m);
}
