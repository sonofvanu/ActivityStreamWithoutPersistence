package com.stackroute.activitystream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.dao.UserDaoImpl;
import com.stackroute.activitystream.model.User;

@RestController
@RequestMapping("/users")
public class MyController {
	@Autowired
	UserDao userDao;
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public ResponseEntity<List<User>> getCustomers() {
		List<User> users=userDao.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	    
	  @RequestMapping(value="/signup",method= RequestMethod.POST)
	  public ResponseEntity<String> registerUser(@RequestBody User user){
		if(userDao.registerUser(user)){
		return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);

		
	  }
	  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
	  public ResponseEntity<String> updateUser(@PathVariable int id,@RequestBody User user){
			User usr=userDao.findById(id);
			   if (usr == null){
		           
		            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		        }
			   usr.setUid(user.getUid());
			   usr.setUname(user.getUname());
			   usr.setUpass(user.getUpass());
			   usr.setEmailid(user.getEmailid());
			   usr.setUnum(user.getUnum());
			   
		if(userDao.update(user)){
		return new ResponseEntity<String>(HttpStatus.CREATED);}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);

		
	  }
	  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> delete(@PathVariable("id") int id){

	        User user = userDao.findById(id);

	        if (user == null){
	            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	        }

	        userDao.delete(id);
	        return new ResponseEntity<Void>(HttpStatus.OK);
	    }
}
