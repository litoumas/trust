package com.trust.app.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import lombok.Data;

@AnyMetaDef(name = "DocumentMetaDef", metaType = "string", idType = "long", metaValues = {
		@MetaValue(value = "BR", targetEntity = com.trust.app.model.BonReception.class),
		// @MetaValue(value = "G", targetEntity = Girl.class)
})

@Entity
@Table(name = "MVTSTOCK")
@ManagedBean(name = "mvtStock")
@Data
public class MvtStock {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@OneToOne(cascade = CascadeType.ALL)
	Article article;

	@Column(name = "qte")
	private float qte;

	@Column(name = "date")
	private Date date;

	@Column(name = "isblack")
	boolean black;
	
	
	@Column(name = "Sens")
	int sens; // 1 = reception | 2 = sortie
	

}
