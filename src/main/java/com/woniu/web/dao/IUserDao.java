package com.woniu.web.dao;

import java.util.List;

import com.woniu.web.bean.User;

public interface IUserDao {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	User find(Integer id);
	List<User> find();
	
	int getRowCount();
	List<User> find(int startLine,int size);
	
	
}
