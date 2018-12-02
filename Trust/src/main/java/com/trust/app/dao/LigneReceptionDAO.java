package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.LigneReception;


public interface LigneReceptionDAO {
	
	public void addLigneReception(LigneReception p);
    public List<LigneReception> listLigneReceptions();
    public void deleteLigneReception(LigneReception p);
    public void updateLigneReception(LigneReception p);

}
