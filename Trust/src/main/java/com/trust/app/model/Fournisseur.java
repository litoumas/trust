package com.trust.app.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@ManagedBean(name = "fournisseur")
@Data
public class Fournisseur extends Contact {

	@Column(name = "numeroTVA")
	String numeroTVA;

}
