package com.trust.app.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.trust.app.Manager.PathManager;
import com.trust.app.Manager.RedirectManager;
import com.trust.app.model.Caisse;
import com.trust.app.service.CaisseService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "CaisseBean")
@ViewScoped
public class CaisseBean   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2450881375189716300L;
	
	@ManagedProperty("#{caisseService}")
	@Getter
	@Setter
	private CaisseService caisseService;
	
	
	public String getThereIsOpened() {
		Caisse caisse=caisseService.getLastOne();
		if(caisse!=null)
		{
			if(caisse.getHeurCloture()!=null)
				RedirectManager.redirect(PathManager.PATH_OPENCAISSE_PAGE);
		}else
		{
			RedirectManager.redirect(PathManager.PATH_OPENCAISSE_PAGE);
		}
		
		
		return "";
	}
	

}
