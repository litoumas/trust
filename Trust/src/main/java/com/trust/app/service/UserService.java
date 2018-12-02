package com.trust.app.service;

import java.util.List;

import com.trust.app.model.User;




public interface UserService {
	
	
	public void addUser(User User);
	public List<User> listUsers();
	public void deleteCar(User u);
	public void updateCar(User u);
	public User researchUsers(String login,String passhash);
	
  
}
