package com.trust.app.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "LIGNELIVRAISON")
@ManagedBean(name = "LigneLivraison")
@Data
public class LigneLivraison extends MvtStock {

	@Column(name = "prix_ttc")
	float prix_ttc;

	@Column(name = "prix_brute")
	float prix_brute;
	
	@Column(name = "prix_declaree")
	float prix_declaree;
}
