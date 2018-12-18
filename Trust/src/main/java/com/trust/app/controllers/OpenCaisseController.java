package com.trust.app.controllers;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.trust.app.manager.PathManager;
import com.trust.app.manager.RedirectManager;
import com.trust.app.model.Caisse;
import com.trust.app.service.CaisseService;
import com.trust.app.service.DroitService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "OpenCaisseController")
@ViewScoped
public class OpenCaisseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8413286354670059890L;

	@ManagedProperty("#{caisseService}")
	@Getter
	@Setter
	private CaisseService caisseService;

	@Getter
	@Setter
	Date heurOuverture;

//	@Getter
	@Setter
	float argentDepart;

	@Getter
	@Setter
	float argentCloture;

	// Initiation part
	@PostConstruct
	public void init() {
		heurOuverture = new Date();
	//	argentDepart=6644;
	}

	public void submit() {

		Caisse caisse = new Caisse();

		caisse.setHeurOuverture(heurOuverture);
		caisse.setArgentDepart(argentDepart);
		caisseService.addCaisse(caisse);
		RedirectManager.redirect(PathManager.PATH_LIVECAISSE_PAGE);

	}
	
	public float getArgentDepart()
	{
		Caisse caisse=caisseService.getLastOne(); 
		
		if(caisse==null)
			return 0;
		
		return caisse.getArgentCloture();
		
	}

}
