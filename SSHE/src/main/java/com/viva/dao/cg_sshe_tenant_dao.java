package com.viva.dao;

import java.util.List;

import com.viva.entity.cg_sshe_tenant_details;


public interface cg_sshe_tenant_dao {
	public List<cg_sshe_tenant_details> getCountry();
	public List<cg_sshe_tenant_details> getOperator(String country);
	public List<cg_sshe_tenant_details> getCircle(String country,String operator);
	public int getTenantId(String tenantname);
	public int getCountryCode(int tenantid);
	public int getStatus(int tenantid);
	
}
