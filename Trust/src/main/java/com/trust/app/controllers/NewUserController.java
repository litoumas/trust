package com.trust.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import com.trust.app.Manager.PathManager;
import com.trust.app.Manager.RedirectManager;
import com.trust.app.model.Droit;
import com.trust.app.model.User;
import com.trust.app.service.DroitService;
import com.trust.app.service.UserService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "NewUserController")
@ViewScoped
public class NewUserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3357153185536957756L;

	@ManagedProperty("#{userService}")
	@Getter
	@Setter
	private UserService userService;

	@ManagedProperty("#{droitService}")
	@Getter
	@Setter
	private DroitService droitService;

	@Getter
	@Setter
	private String loginUser;

	@Getter
	@Setter
	private String nameUser;
	
	@Getter
	@Setter
	private String passUser;

	public void submit() {
		String generatedHash = DigestUtils.md5Hex(passUser);
		if (userService.researchUsers(loginUser, generatedHash) == null) {
			User user = new User();
			user.setLogin(loginUser);
			user.setName(nameUser);
			user.setPasshash(generatedHash);
			user.setSeeBlack(true);
			List<Droit> droits=droitService.listDroits();
			
			for (int i = 0; i <= droits.size() - 1; i++) {

				user.addDroit(droits.get(i));
			}

			userService.addUser(user);
			loginUser = null;
			nameUser = null;
			passUser = null;

			RedirectManager.redirect(PathManager.PATH_LOGIN_PAGE);

		} else {

		}

	}

}
