package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.User;
/**
 * User data access object interface
 * */
public interface UserDAO {
	
	public List<User> listUsers();

	public void addUser(User u);

	public void deleteUser(User u);

	public void updateUser(User u);

	public User researchUsers(String login, String passhash);

}
