package com.viva.entity;

import java.lang.annotation.Repeatable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="cg_sshe_vas_master")
public class cg_sshe_vas_master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",columnDefinition="int(4)")
	private int id;
	@Column(name="cpid",length=32)
	private String cpid;
	@Column(name="cpname",length=32)
	private String cpname;
	@Column(columnDefinition = "TINYINT(1)")
	private boolean cp_status = true;
	
	@Column(name="cp_list",columnDefinition = "TEXT")
	private String cp_list;
	@Column(name="password",length=32)
	private String password;
	@Column(name="last_modify_date",columnDefinition="timestamp")
	private String last_modify_date;
	@Column(name="opcoid",columnDefinition="int(3)")
	private int opcoid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpid() {
		return cpid;
	}
	public void setCpid(String cpid) {
		this.cpid = cpid;
	}
	public String getCpname() {
		return cpname;
	}
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}
	public boolean isCp_status() {
		return cp_status;
	}
	public void setCp_status(boolean cp_status) {
		this.cp_status = cp_status;
	}
	public String getCp_list() {
		return cp_list;
	}
	public void setCp_list(String cp_list) {
		this.cp_list = cp_list;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLast_modify_date() {
		return last_modify_date;
	}
	public void setLast_modify_date(String last_modify_date) {
		this.last_modify_date = last_modify_date;
	}
	public int getOpcoid() {
		return opcoid;
	}
	public void setOpcoid(int opcoid) {
		this.opcoid = opcoid;
	}
	
}
