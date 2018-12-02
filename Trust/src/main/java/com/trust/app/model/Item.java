package com.trust.app.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ITEM")
@ManagedBean(name="item")
@Data
public class Item {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="designation")
	private String designation;
	
	@OneToMany
	private List<Tracteur> tracteurs;

	
}
