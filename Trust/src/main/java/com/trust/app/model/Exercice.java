package com.trust.app.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EXERCICE")
@ManagedBean(name="exercice")
@Data
public class Exercice {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="designation")
    private String designation;
	
	@Column(name="date_debut")
	Date date_debut;

	Date date_fin;
	
	
	
}
