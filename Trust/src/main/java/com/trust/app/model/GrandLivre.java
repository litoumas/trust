package com.trust.app.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "GRANDLIVRE")
@ManagedBean(name = "GrandLivre")
@Data
public class GrandLivre {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "date")
	private Date date;
	@Column(name = "Sens")
	int sens; // 1 = Recu | 2 = sortie
	@Column(name = "montant")
	float montant ; 
	
	@Column(name = "black")
	boolean black ; 
	
	@OneToOne
	Facture facture;

	
	
}
