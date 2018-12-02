package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.User;
/**
 * User data access object interface
 * */
public interface UserDAO {
	
	public List<User> listUsers();

	public void addUser(User u);

	public void deleteCar(User u);

	public void updateCar(User u);

	public User researchUsers(String login, String passhash);

}
