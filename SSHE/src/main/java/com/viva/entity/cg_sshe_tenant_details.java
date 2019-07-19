package com.viva.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="cg_sshe_tenant_details")
@DynamicUpdate(true)
public class cg_sshe_tenant_details {

	
	@Id
	@Column(name="tenantid",columnDefinition="int(3)")
	private int tenantid;
	
	@Column(name="tenantname",length=50,unique=true)
	private String tenantname;
	@Column(name="country",length=50)
	private String country;
	@Column(name="timezone",length=50)
	private String timezone;
	@Column(name="operator",length=50)
	private String operator;
	@Column(name="circle",length=50)
	private String circle;
	@Column(name="status",columnDefinition="int(5) default '0'")
	private int status;
	public int getTenantid() {
		return tenantid;
	}
	public void setTenantid(int tenantid) {
		this.tenantid = tenantid;
	}
	public String getTenantname() {
		return tenantname;
	}
	public void setTenantname(String tenantname) {
		this.tenantname = tenantname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getMdn_min() {
		return mdn_min;
	}
	public void setMdn_min(int mdn_min) {
		this.mdn_min = mdn_min;
	}
	public int getMdn_max() {
		return mdn_max;
	}
	public void setMdn_max(int mdn_max) {
		this.mdn_max = mdn_max;
	}
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	@Column(name="mdn_min",columnDefinition="int(3) default '10'")
	private int mdn_min;
	@Column(name="mdn_max",columnDefinition="int(3) default '10'")
	private int mdn_max;
	@Column(name="countrycode",columnDefinition="int(5) default '91'")
	private int countrycode;
}
