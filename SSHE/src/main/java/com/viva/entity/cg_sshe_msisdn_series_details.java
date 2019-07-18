package com.viva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity @IdClass(key.class)
@Table(name="cg_sshe_msisdn_series_details")

public class cg_sshe_msisdn_series_details {
	@Id int MSISDN_LEN_WITHOUT_CC;
	@Column(name="MSISDN_LEN_WITHOUT_CC",columnDefinition="int(11)")
	private int MSISDN_LEN_WITHOUT_CC1;
	@Id String MSISDN_START_DIGITS;
	@Column(name="MSISDN_START_DIGITS",length=5)
	private String MSISDN_START_DIGITS1;
	@Id int opcoid;
	@Column(name="opcoid",columnDefinition="int(3)")
	private String Opcoid;
}
class key{
	int MSISDN_LEN_WITHOUT_CC;
	String MSISDN_START_DIGITS;
	int opcoid; 
}