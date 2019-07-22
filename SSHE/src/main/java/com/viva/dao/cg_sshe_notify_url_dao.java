package com.viva.dao;

import com.viva.entity.cg_sshe_notify_url_master;

public interface cg_sshe_notify_url_dao {
	public int addNotifyUrl(cg_sshe_notify_url_master notify); 
	public String callBackUrl(String productid,String cpid,int opcoid);
}
