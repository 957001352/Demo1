package com.woniu.web.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private Integer id; 
	private String name;
	private Date brithday; 
	private Double money; 
	private String photo;
	public User() {
		super();
	}
	public User(Integer id, String name, Date brithday, Double money, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.brithday = brithday;
		this.money = money;
		this.photo = photo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", brithday=" + brithday + ", money=" + money + ", photo=" + photo
				+ "]";
	}
	
}
