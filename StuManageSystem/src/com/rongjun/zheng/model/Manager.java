package com.rongjun.zheng.model;

public class Manager {
	private int id;
	private String user;
	private String password;
	private String Email;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String user, String password, String email) {
		super();
		this.user = user;
		this.password = password;
		Email = email;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

}
