package com.trust.app.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "LIGNEVENTECOMPTOIR")
@ManagedBean(name = "LigneVenteComptoir")
@Data
public class LigneVenteComptoir extends MvtStock {

	@Column(name = "prix_ttc")
	float prix_ttc;

	@Column(name = "prix_ht")
	float prix_brute;
	
	@Column(name = "prix_declaree")
	float prix_declaree;
	
	
	
	public float getTotalPrixTTC() {
		return arrondir(getQte()*prix_ttc);
	}
	
	public float getTotalPrixBrut() {
		return arrondir(getQte()*prix_brute);
	}
	
	public float getTotalPrixDeclaree() {
		return arrondir(getQte()*prix_declaree);
	}
	public float getTotalPrixMini() {
		if(getArticle()==null)
			return 0;
			
		return arrondir(getQte()*getArticle().getPrixmini());
	}
	
	
	private float arrondir(float nombre) {
		return (float) ((float) ((int) (nombre * Math.pow(10, 3) + .5)) / Math.pow(10, 3));
	}
	
}