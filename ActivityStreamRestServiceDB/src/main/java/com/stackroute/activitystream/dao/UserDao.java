package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.User;

public interface UserDao {
	public boolean registerUser(User user);
	public List<User> getUsers();
	public boolean update(User user);
	public void delete(int id);
    public User findById(int id);
}
