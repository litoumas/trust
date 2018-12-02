package com.trust.app.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.UserDAO;
import com.trust.app.model.User;

@Service
@ManagedBean(name = "userService")
@SessionScoped
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public void addUser(User u) {
		this.userDAO.addUser(u);

	}

	@Override
	@Transactional
	public void deleteCar(User u) {
		this.userDAO.deleteCar(u);

	}

	@Override
	@Transactional
	public void updateCar(User u) {
		this.userDAO.updateCar(u);

	}

	@Override
	@Transactional
	public User researchUsers(String login, String passhash) {
		// TODO Auto-generated method stub
		return this.userDAO.researchUsers(login, passhash);
	}
}