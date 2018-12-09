package com.trust.app.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.DroitDAO;
import com.trust.app.model.Droit;

@Service
@ManagedBean(name = "droitService")
@SessionScoped
public class DroitServiceImpl implements DroitService {

	private DroitDAO DroitDAO;

	public void setDroitDAO(DroitDAO DroitDAO) {
		this.DroitDAO = DroitDAO;
	}

	@Override
	@Transactional
	public List<Droit> listDroits() {
		return this.DroitDAO.listDroits();
	}

	@Override
	@Transactional
	public void addDroit(Droit u) {
		this.DroitDAO.addDroit(u);

	}

	@Override
	@Transactional
	public void deleteDroit(Droit u) {
		this.DroitDAO.deleteDroit(u);

	}

	@Override
	@Transactional
	public void updateDroit(Droit u) {
		this.DroitDAO.updateDroit(u);

	}


}