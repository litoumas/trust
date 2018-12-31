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
@Table(name = "FACTURE")
@ManagedBean(name = "venteComptoir")
@Data
public class Facture {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@Column(name="numero")
    private String numero;
	
	@OneToOne
	Contact contact;
	
	@Column(name="date")
	Date date;
	
	
	@Column(name="isblack")
	boolean black;
	
	@Column(name="timbre")
	float timbre;
	
	@Column(name="total_htva")
	float total_htva;

	@Column(name="Payee")
	boolean Payee;
	
	@Column(name="total_ttc")
	float total_ttc;
	
	@Column(name="note")
	String note;
	
}

