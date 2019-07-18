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
	@Column(name="mdn_min",columnDefinition="int(3) default '10'")
	private int mdn_min;
	@Column(name="mdn_max",columnDefinition="int(3) default '10'")
	private int mdn_max;
	@Column(name="countrycode",columnDefinition="int(5) default '91'")
	private int countrycode;
}
