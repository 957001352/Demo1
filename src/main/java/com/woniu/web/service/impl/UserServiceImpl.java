package com.woniu.web.service.impl;

import java.util.List;

import com.woniu.web.bean.User;
import com.woniu.web.dao.IUserDao;
import com.woniu.web.dao.impl.UserDaoImpl;
import com.woniu.web.service.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao ud = new UserDaoImpl();
	public void save(User user) {
		ud.save(user);
	}
	public void delete(Integer id) {
		ud.delete(id);
	}
	public void update(User user) {
		ud.update(user);
	}
	public User find(Integer id) {
		return ud.find(id);
	}
	public List<User> find() {
		return ud.find();
	}

}
