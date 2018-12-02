package com.trust.app.model;

import java.util.List;

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
@Table(name="TRACTEUR")
@ManagedBean(name="Tracteur")
@Data
public class Tracteur {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="designation")
	private String designation;
	
	@OneToOne
	MarqueTracteur marqueTracteurs;

	
	
}
