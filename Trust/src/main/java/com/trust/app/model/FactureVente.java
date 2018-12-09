package com.trust.app.model;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="factureVente")
@ManagedBean(name="factureVente")
@Data
public class FactureVente {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@OneToOne
	Fournisseur fournisseur;
	
	@Column(name="datefacture")
	Date dateFacture;

	@Column(name="isblack")
	boolean black;
	
	@Column(name="timbre")
	float timbre;
	
	@Column(name="total_ttc")
	float total_ttc;
	
	@Column(name="Payee")
	boolean Payee;

	@Column(name="note")
	String note;
	
	
	@OneToMany(fetch=FetchType.EAGER) 
	@JoinColumn(name = "factureClient_id")
	private List<BonLivraison> bonLivraison;
	
	
}
