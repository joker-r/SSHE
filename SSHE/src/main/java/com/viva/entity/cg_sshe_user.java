package com.viva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cg_sshe_user")
public class cg_sshe_user {

	@Id
	@Column(name="id",columnDefinition="int(3)")
	private int id;
	@Column(name="username",length=32)
	private String username;
	@Column(name="password",length=32)
	private String password;
	@Column(name="usertype",columnDefinition="int(3)")
	private int usertype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	
}
