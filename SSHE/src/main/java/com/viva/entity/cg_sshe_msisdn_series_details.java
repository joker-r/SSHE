package com.viva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity @IdClass(key.class)
@Table(name="cg_sshe_msisdn_series_details")

public class cg_sshe_msisdn_series_details {
	@Id 
	@Column(name="MSISDN_LEN_WITHOUT_CC",columnDefinition="int(11)")
	private int MSISDN_LEN_WITHOUT_CC;
	@Id 
	@Column(name="MSISDN_START_DIGITS",length=5)
	private String MSISDN_START_DIGITS;
	@Id 
	@Column(name="opcoid",columnDefinition="int(3)")
	private int opcoid;
	public int getMSISDN_LEN_WITHOUT_CC() {
		return MSISDN_LEN_WITHOUT_CC;
	}
	public void setMSISDN_LEN_WITHOUT_CC(int mSISDN_LEN_WITHOUT_CC) {
		MSISDN_LEN_WITHOUT_CC = mSISDN_LEN_WITHOUT_CC;
	}
	public String getMSISDN_START_DIGITS() {
		return MSISDN_START_DIGITS;
	}
	public void setMSISDN_START_DIGITS(String mSISDN_START_DIGITS) {
		MSISDN_START_DIGITS = mSISDN_START_DIGITS;
	}
	public int getOpcoid() {
		return opcoid;
	}
	public void setOpcoid(int opcoid) {
		this.opcoid = opcoid;
	}
	
	
}
class key implements Serializable{
	int MSISDN_LEN_WITHOUT_CC;
	String MSISDN_START_DIGITS;
	int opcoid; 
}