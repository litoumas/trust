package com.trust.app.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.trust.app.model.Marque;
import com.trust.app.service.MarqueService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "MarqueBean")
@ViewScoped
public class MarqueBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5857597382250528846L;
	
	
	@ManagedProperty("#{marqueService}")
	@Getter
	@Setter
	private MarqueService marqueService;
	
	public List<Marque> getListMarque() {
		return marqueService.listMarques();
		
	}
}
