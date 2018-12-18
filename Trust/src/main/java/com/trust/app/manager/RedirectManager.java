package com.trust.app.manager;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class RedirectManager  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5520083361653368332L;

	public static void redirect(String url) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect(externalContext.getApplicationContextPath() + url);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
