package com.trust.app.service;

import java.util.List;

import com.trust.app.model.LigneReception;

public interface LigneReceptionService {


	
	public void addLigneReception(LigneReception c);
    public List<LigneReception> listLigneReceptions();
    public void deleteLigneReception(LigneReception c);
    public void updateLigneReception(LigneReception c);
    public void testLog();


}
