package com.trust.app.Manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import lombok.Getter;

@ManagedBean(name = "PathManager")
@ViewScoped
public class PathManager implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2267467993146231487L;
	
	public static String PATH_ERREURSECURITY_PAGE="/views/pages/erreursecurity.xhtml";
	public static String PATH_HOME_PAGE="/views/pages/home.xhtml";
	public static String PATH_NEWCLIENT_PAGE="/views/pages/newclient.xhtml";
	public static String PATH_NEWFOURNISEUR_PAGE="/views/pages/newfournisseur.xhtml";
	public static String PATH_NEWFACTUREFOURNISEUR_PAGE="/views/pages/newfacturefournisseur.xhtml";
	public static String PATH_NEWITEM_PAGE="/views/pages/newitem.xhtml";
	public static String PATH_NEWMARQUE_PAGE="/views/pages/newmarque.xhtml";
	public static String PATH_NEWMARQUETRACTEUR_PAGE="/views/pages/newmarquetracteur.xhtml";
	public static String PATH_NEWRECEPTION_PAGE="/views/pages/newreception.xhtml";
	public static String PATH_TRACTEUR_PAGE="/views/pages/newtracteur.xhtml";
	public static String PATH_NEWUSER_PAGE="/views/pages/newuser.xhtml";
	
	
	
	public static String PATH_LOGIN_PAGE="/views/login.xhtml";
	
	
	
	
	
	
	
	
	public static List<String> getPathListe() {
		
		List<String> pathList=new ArrayList<String>();
		
		pathList.add(PATH_ERREURSECURITY_PAGE);
		pathList.add(PATH_HOME_PAGE);
		pathList.add(PATH_NEWFOURNISEUR_PAGE);
		pathList.add(PATH_NEWCLIENT_PAGE);
		pathList.add(PATH_NEWFACTUREFOURNISEUR_PAGE);
		pathList.add(PATH_NEWITEM_PAGE);
		pathList.add(PATH_NEWMARQUE_PAGE);
		pathList.add(PATH_NEWMARQUETRACTEUR_PAGE);
		pathList.add(PATH_NEWRECEPTION_PAGE);
		pathList.add(PATH_TRACTEUR_PAGE);
		pathList.add(PATH_NEWUSER_PAGE);
		
		
		return pathList;
	}
	
	public String getPath_erreursecurity_page() {
		return PATH_ERREURSECURITY_PAGE;
	}
	public String getPath_home_page() {
		return PATH_HOME_PAGE;
	}
	public String getPath_newclient_page() {
		return PATH_HOME_PAGE;
	}
	public String getPath_newfacturefourniseur_page() {
		return PATH_NEWFACTUREFOURNISEUR_PAGE;
	}
	public String getPath_newitem_page() {
		return PATH_NEWITEM_PAGE;
	}
	public String getPath_newmarque_page() {
		return PATH_NEWMARQUE_PAGE;
	}
	public String getPath_newmarquetracteur_page() {
		return PATH_NEWMARQUETRACTEUR_PAGE;
	}
	public String getPath_newreception_page() {
		return PATH_NEWRECEPTION_PAGE;
	}
	public String getPath_tracteur_page() {
		return PATH_TRACTEUR_PAGE;
	}
	public String getPath_newuser_page() {
		return PATH_NEWUSER_PAGE;
	}

	public String getPath_newfourniseur_page() {
		return PATH_NEWFOURNISEUR_PAGE;
	}


	
	
	
	
	
	
}
