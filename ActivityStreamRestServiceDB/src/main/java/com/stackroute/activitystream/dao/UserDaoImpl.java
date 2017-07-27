package com.stackroute.activitystream.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.stackroute.activitystream.model.User;
@Repository(value="userDao")
@Component
@Service
public class UserDaoImpl implements UserDao {

	static List<User> users=new ArrayList<>();
    private static final AtomicInteger counter = new AtomicInteger();

	public boolean registerUser(User user) {
		user.setUid(counter.incrementAndGet());
		users.add(user);
		if(!users.isEmpty()){
			return true;
		}
		return false;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public boolean update(User user){
		int index=users.indexOf(user);
		users.set(index, user);
		return true;
	}
	public void delete(int id) {
        User user = findById(id);
        users.remove(user);
    }
	
	    public User findById(int id) {
	        for (User user : users){
	            if (user.getUid() == id){
	                return user;
	            }
	        }
	        return null;
	    }

}
