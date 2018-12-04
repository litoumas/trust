package com.trust.app.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "LIGNELIVRAISON")
@ManagedBean(name = "LigneLivraison")
@Data
public class LigneLivraison extends MvtStock {

}
