package com.viva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=" cg_sshe_report")
public class cg_sshe_report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",columnDefinition="int(11)")
	private int id;
	@Column(name="trans_id",length=48)
	private String trans_id;
	@Column(name="cpid",length=32)
	private String cpid;
	@Column(name="product_id",length=32)
	private String product_id;
	@Column(name="response",length=50)
	private String response;
	@Column(name="status",columnDefinition="int(3)")
	private int status;
	@Column(name="ip",length=20)
	private String ip;
	@Column(name="request_datetime",length=25)
	private String request_datetime;
	@Column(name="opcoid",columnDefinition="int(3)")
	private int opcoid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}
	public String getCpid() {
		return cpid;
	}
	public void setCpid(String cpid) {
		this.cpid = cpid;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRequest_datetime() {
		return request_datetime;
	}
	public void setRequest_datetime(String request_datetime) {
		this.request_datetime = request_datetime;
	}
	public int getOpcoid() {
		return opcoid;
	}
	public void setOpcoid(int opcoid) {
		this.opcoid = opcoid;
	}
	

}
