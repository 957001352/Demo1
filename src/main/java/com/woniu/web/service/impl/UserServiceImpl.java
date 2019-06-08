package com.woniu.web.service.impl;

import java.util.List;

import com.woniu.web.bean.Page;
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
	@Override
	public Page findPageData(int p, int size) {
		int rowCount = ud.getRowCount();
		Page page = new Page(p,rowCount,size);
		List<User> list = ud.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
