package com.trust.app.model;


import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="MARQUE")
@ManagedBean(name="Maque")
@Data
public class Marque {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="designation")
	private String designation;

	
	
}
