package com.trust.app.service;

import java.util.List;

import com.trust.app.model.User;




public interface UserService {
	
	
	public void addUser(User User);
	public List<User> listUsers();
	public void deleteUser(User u);
	public void updateUser(User u);
	public User researchUsers(String login,String passhash);
	
  
}
