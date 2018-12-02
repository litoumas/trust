package com.trust.app.model;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="FactureFournisseur")
@ManagedBean(name="FactureFournisseur")
@Data
public class FactureFournisseur {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@Column(name="numero")
    private String numero;
	
	
	@OneToOne
	Fournisseur fournisseur;
	
	
	
	@Column(name="datefacture")
	Date dateFacture;

	@Column(name="isblack")
	boolean black;
	
	@Column(name="type")
	boolean type;
	
	@Column(name="Total_brute")
	float total_brute;
	
	@Column(name="total_remise")
	float total_remise;
	
	@Column(name="total_htva")
	float total_htva;
	
	@Column(name="total_tva")
	float total_tva;

	@Column(name="timbre")
	float timbre;
	
	@Column(name="total_ttc")
	float total_ttc;
	
	@OneToMany
	private List<BonReception> receptions;

	
	
}
