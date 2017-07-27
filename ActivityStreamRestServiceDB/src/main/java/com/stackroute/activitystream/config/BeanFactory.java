package com.stackroute.activitystream.config;

import org.springframework.context.annotation.Bean;

import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.dao.UserDaoImpl;

public class BeanFactory {
	@Bean(name="userDao")
	public UserDao getUserDao()
	{
		return new UserDaoImpl();
	}
}
