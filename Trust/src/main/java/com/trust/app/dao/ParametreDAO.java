package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.Parametre;

public interface ParametreDAO {
	public void addParametre(Parametre p);
    public List<Parametre> listParametres();
    public void deleteParametre(Parametre Parametre);
    public void updateParametre(Parametre Parametre);
	public Parametre getParametre(String nomParametre);
}
