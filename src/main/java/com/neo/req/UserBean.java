package com.neo.req;

import java.io.Serializable;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 3263266252842248137L;
	private String userName;
	private String password;
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
