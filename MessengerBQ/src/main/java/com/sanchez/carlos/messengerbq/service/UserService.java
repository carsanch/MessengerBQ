package com.sanchez.carlos.messengerbq.service;

import java.util.List;

import com.sanchez.carlos.messengerbq.entity.User;

public interface UserService
{

	void addUser(User user);

	User getUser(String id);

	List<User> getUserList();
}
