package com.woniu.test;

import java.util.List;

import org.junit.Test;

import com.woniu.web.bean.User;
import com.woniu.web.dao.IUserDao;
import com.woniu.web.dao.impl.UserDaoImpl;

public class AppTest {
	@Test
	public void test1() throws Exception {
		IUserDao ud = new UserDaoImpl();
//		User user = new User();
//		user.setName("娇娇");
//		Date date = new Date(2019-1900,7-1,27);
//		user.setBrithday(date);
//		user.setMoney(200.0);
//		user.setPhoto("123");
//		user.setId(184);
		
//		ud.update(user);
//		ud.save(user);
//		ud.delete(185);
		
		List<User> list = ud.find();
		for (User user : list) {
			System.out.println(user);
		}
	}
}
