package com.trust.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author
 *
 */
@Entity
@Table(name = "USERS")
@ManagedBean(name = "user")
@Data
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "login")
	private String login;

	@Column(name = "passhash")
	private String passhash;

	@ManyToMany
	private List<Droit> droits = new ArrayList<Droit>();
	
	@Column(name = "seeBlack")
	private boolean seeBlack;

	public void addDroit(Droit droit) {
		droits.add(droit);

	}

	public boolean hasPermissionToVisit(String url) {
		
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		url=url.replaceAll(externalContext.getApplicationContextPath(), "");
		for (int i = 0; i <= droits.size() - 1; i++) {
			if (url.equals(droits.get(i).getPath())) {
				
				return true;
			}
		}
		
		return false;
	}
}