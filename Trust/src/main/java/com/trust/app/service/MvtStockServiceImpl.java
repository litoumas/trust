package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.MvtStockDAO;
import com.trust.app.model.MvtStock;


@Service
@ManagedBean(name = "mvtStockService")
@SessionScoped
public class MvtStockServiceImpl implements MvtStockService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525098787267710537L;
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(MvtStockServiceImpl.class);
	private MvtStockDAO MvtStockDAO;

	public void setMvtStockDAO(MvtStockDAO MvtStockDAO) {
		this.MvtStockDAO = MvtStockDAO;
	}

	@Override
	@Transactional
	public void addMvtStock(MvtStock c) {
		this.MvtStockDAO.addMvtStock(c);
	}

	@Override
	@Transactional
	public List<MvtStock> listMvtStocks() {
		return this.MvtStockDAO.listMvtStocks();
	}

	@Override
	@Transactional
	public void deleteMvtStock(MvtStock c) {
		this.MvtStockDAO.deleteMvtStock(c);
	}

	@Override
	@Transactional
	public void updateMvtStock(MvtStock c) {
		this.MvtStockDAO.updateMvtStock(c);
	}

	@Override
	public void testLog() {
		
	}


}