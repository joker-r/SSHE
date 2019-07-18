package com.viva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cg_sshe_product_master")
public class cg_sshe_product_master {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="product_id",length=32)
	private String product_id;
	@Column(name="product_name",length=32)
	private String product_name;
	@Column(name="last_modify_date",columnDefinition="TIMESTAMP")
	private String last_modify_date;
	@Column(name="opcoid",columnDefinition="int(3)")
	private int opcoid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
