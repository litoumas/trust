package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.MarqueDAO;
import com.trust.app.model.Marque;


@Service
@ManagedBean(name = "marqueService")
@SessionScoped
public class MarqueServiceImpl implements MarqueService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(MarqueServiceImpl.class);
	private MarqueDAO marqueDAO;

	public void setMarqueDAO(MarqueDAO marqueDAO) {
		this.marqueDAO = marqueDAO;
	}

	public MarqueDAO getMarqueDAO() {
		return marqueDAO;
	}

	@Override
	@Transactional
	public void addMarque(Marque c) {
		this.marqueDAO.addMarque(c);
	}

	@Override
	@Transactional
	public List<Marque> listMarques() {
		return this.marqueDAO.listMarques();
	}

	@Override
	@Transactional
	public void deleteMarque(Marque c) {
		this.marqueDAO.deleteMarque(c);
	}

	@Override
	@Transactional
	public void updateMarque(Marque c) {
		this.marqueDAO.updateMarque(c);
	}

	@Override
	public void testLog() {
		
	}

	@Override
	@Transactional
	public Marque findWithDesig(String m) {
		// TODO Auto-generated method stub
		return this.marqueDAO.findWithDesig(m);
	}

}