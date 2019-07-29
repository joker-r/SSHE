package com.viva.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.viva.entity.cg_sshe_report;
@Repository("reportdao")
@Transactional
public class cg_sshe_report_dao_Imp implements cg_sshe_report_dao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int add_request_received_for_HE_by_CP(cg_sshe_report kpi) {
		// TODO Auto-generated method stub
		em.persist(kpi);
		return 0;
	}

	@Override
	public List<cg_sshe_report> generateReport(String cpid) {
		System.out.println(cpid);
		// TODO Auto-generated method stub
		String hql="select distinct(product_id),count(status) from cg_sshe_report where cpid=:ecpid group by product_id";
		Query qry=em.createQuery(hql);
		qry.setParameter("ecpid", cpid);
		
		List<cg_sshe_report> lst=(List<cg_sshe_report>) qry.getResultList();
		List<cg_sshe_report> result=new ArrayList<cg_sshe_report>();
		Iterator itr = lst.iterator();
		while(itr.hasNext()){
			cg_sshe_report check=new cg_sshe_report();
			   Object[] obj = (Object[]) itr.next();
			   String productid = String.valueOf(obj[0]);
			check.setProduct_id(productid);   
			   Integer status = Integer.parseInt(String.valueOf(obj[1])); 
			   check.setStatus(status);
			   result.add(check);
		}

		return result;
	}

	@Override
	public List<cg_sshe_report> generateSuccessReport(String cpid) {
		
		String hql="select distinct(product_id),count(status) from cg_sshe_report where cpid=:ecpid and status in(0,1) group by product_id";
		Query qry=em.createQuery(hql);
		qry.setParameter("ecpid", cpid);
		List<cg_sshe_report> lst=qry.getResultList();
		List<cg_sshe_report> result=new ArrayList<cg_sshe_report>();
		Iterator itr = lst.iterator();
		while(itr.hasNext()){
			cg_sshe_report check=new cg_sshe_report();
			   Object[] obj = (Object[]) itr.next();
			   String productid = String.valueOf(obj[0]);
			check.setProduct_id(productid);   
			   Integer status = Integer.parseInt(String.valueOf(obj[1])); 
			   check.setStatus(status);
			   result.add(check);
		}

		return result;
	}

	@Override
	public List<cg_sshe_report> generateFailReport(String cpid) {
		String hql="select distinct(product_id),count(status) from cg_sshe_report where cpid=:ecpid and status not in(0,1) group by product_id";
		Query qry=em.createQuery(hql);
		qry.setParameter("ecpid", cpid);
		List<cg_sshe_report> lst=qry.getResultList();
		List<cg_sshe_report> result=new ArrayList<cg_sshe_report>();
		Iterator itr = lst.iterator();
		while(itr.hasNext()){
			cg_sshe_report check=new cg_sshe_report();
			   Object[] obj = (Object[]) itr.next();
			   String productid = String.valueOf(obj[0]);
			check.setProduct_id(productid);   
			   Integer status = Integer.parseInt(String.valueOf(obj[1])); 
			   check.setStatus(status);
			   result.add(check);
		}

		return result;
	}

	
}
