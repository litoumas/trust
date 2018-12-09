package com.trust.app.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.CaisseDAO;
import com.trust.app.model.Caisse;

import lombok.Setter;

@Service
@ManagedBean(name = "caisseService")
@SessionScoped
public class CaisseServiceImpl implements CaisseService {

	@Setter
	private CaisseDAO caisseDAO;


	@Override
	@Transactional
	public List<Caisse> listCaisses() {
		return this.caisseDAO.listCaisses();
	}

	@Override
	@Transactional
	public void addCaisse(Caisse u) {
		this.caisseDAO.addCaisse(u);

	}

	@Override
	@Transactional
	public void deleteCaisse(Caisse u) {
		this.caisseDAO.deleteCaisse(u);

	}

	@Override
	@Transactional
	public void updateCaisse(Caisse u) {
		this.caisseDAO.updateCaisse(u);

	}

	@Override
	public Caisse getLastOne() {
		// TODO Auto-generated method stub
		return this.caisseDAO.getLastOne();
	}


}