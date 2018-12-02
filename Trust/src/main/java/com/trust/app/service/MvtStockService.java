package com.trust.app.service;

import java.util.List;

import com.trust.app.model.MvtStock;

public interface MvtStockService {
	
	public void addMvtStock(MvtStock m);
    public List<MvtStock> listMvtStocks();
    public void deleteMvtStock(MvtStock m);
    public void updateMvtStock(MvtStock m);
    public void testLog();
}
