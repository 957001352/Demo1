package com.woniu.web.service;

import java.util.List;

import com.woniu.web.bean.Page;
import com.woniu.web.bean.User;

public interface IUserService {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	User find(Integer id);
	List<User> find();
	Page findPageData(int p, int i);
}
