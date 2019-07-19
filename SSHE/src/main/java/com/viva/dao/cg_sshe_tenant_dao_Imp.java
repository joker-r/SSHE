package com.viva.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viva.entity.cg_sshe_tenant_details;

@Repository("cgtenantdao")
@Transactional
public class cg_sshe_tenant_dao_Imp implements cg_sshe_tenant_dao{

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<cg_sshe_tenant_details> getCountry() {
		String hql="from cg_sshe_tenant_details";
		Query qry=em.createQuery(hql);
	
		List<cg_sshe_tenant_details> lst=qry.getResultList();
		return lst;
	}

	@Override
	public List<cg_sshe_tenant_details> getOperator(String country) {
		String hql="from cg_sshe_tenant_details where country=:ecountry";
		Query qry=em.createQuery(hql);
		qry.setParameter("ecountry", country);
		List<cg_sshe_tenant_details> lst=qry.getResultList();
		return lst;
	}

	@Override
	public List<cg_sshe_tenant_details> getCircle(String country, String operator) {
		String hql="from cg_sshe_tenant_details where country=:ecountry and operator=:eoperator";
		Query qry=em.createQuery(hql);
		qry.setParameter("ecountry", country);
		qry.setParameter("eoperator", operator);
		List<cg_sshe_tenant_details> lst=qry.getResultList();
		return lst;
	}

	@Override
	public int getTenantId(String tenantname) {
		String hql="from cg_sshe_tenant_details where tenantname=:etenantname";
		Query qry=em.createQuery(hql);
		qry.setParameter("etenantname", tenantname);
		List<cg_sshe_tenant_details> lst=qry.getResultList();
		int opcoid=(lst.get(0)).getTenantid();
		return opcoid;
	}

	@Override
	public int getCountryCode(int tenantid) {
		String hql="from cg_sshe_tenant_details where tenantid=:etenantid";
		Query qry=em.createQuery(hql);
		qry.setParameter("etenantid", tenantid);
		List<cg_sshe_tenant_details> lst=qry.getResultList();
		int countrycode=(lst.get(0)).getCountrycode();
		return countrycode;
	}

	@Override
	public int getStatus(int tenantid) {
		String hql="from cg_sshe_tenant_details where tenantid=:etenantid";
		Query qry=em.createQuery(hql);
		qry.setParameter("etenantid", tenantid);
		List<cg_sshe_tenant_details> lst=qry.getResultList();
		int status=(lst.get(0)).getStatus();
		return status;
	}

}
