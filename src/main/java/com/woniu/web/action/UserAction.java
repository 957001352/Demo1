package com.woniu.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.woniu.web.bean.Page;
import com.woniu.web.bean.User;
import com.woniu.web.service.IUserService;
import com.woniu.web.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private IUserService service = new UserServiceImpl();
	private int p = 1;
	
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	
	public String save() {
		service.save(user);
		return "find";
	}
	public String find() {
		
		Page page = service.findPageData(p,7);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "findUI";
	}
	public String delete() {
		service.delete(user.getId());
		return "find";
	}
	public String updateUI() {
		user = service.find(user.getId());
		ServletActionContext.getRequest().setAttribute("user", user);
		return "updateUI";
	}
	public String update() {
		service.update(user);
		return "find";
	}
	
	//******@Override必须写
	@Override
	public User getModel() {
		return user;
	}
}
