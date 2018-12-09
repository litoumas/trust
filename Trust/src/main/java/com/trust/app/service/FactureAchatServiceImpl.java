package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.FactureAchatDAO;
import com.trust.app.model.FactureAchat;


@Service
@ManagedBean(name = "factureAchatService")
@SessionScoped
public class FactureAchatServiceImpl implements FactureAchatService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525098787267710537L;
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(FactureAchatServiceImpl.class);
	private FactureAchatDAO FactureAchatDAO;

	public void setFactureAchatDAO(FactureAchatDAO FactureAchatDAO) {
		this.FactureAchatDAO = FactureAchatDAO;
	}

	@Override
	@Transactional
	public void addFactureAchat(FactureAchat c) {
		this.FactureAchatDAO.addFactureAchat(c);
	}

	@Override
	@Transactional
	public List<FactureAchat> listFactureAchats() {
		return this.FactureAchatDAO.listFactureAchats();
	}

	@Override
	@Transactional
	public void deleteFactureAchat(FactureAchat c) {
		this.FactureAchatDAO.deleteFactureAchat(c);
	}

	@Override
	@Transactional
	public void updateFactureAchat(FactureAchat c) {
		this.FactureAchatDAO.updateFactureAchat(c);
	}

	@Override
	public void testLog() {
		
	}


}