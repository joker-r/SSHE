package com.viva.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viva.entity.cg_sshe_notify_url_master;
import com.viva.entity.cg_sshe_product_master;
import com.viva.entity.cg_sshe_vas_master;
@Repository("cgnotifydao")
@Transactional
public class cg_sshe_notify_url_dao_Imp implements cg_sshe_notify_url_dao{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int addNotifyUrl(cg_sshe_notify_url_master notify) {
		em.persist(notify);
		return 1;
	}

	@Override
	public String callBackUrl(String productid, String cpid, int opcoid) {
		// TODO Auto-generated method stub
		String hql="from cg_sshe_vas_master where cpid=:ecpid and opcoid=:eopcoid";
		Query qry=em.createQuery(hql);
		qry.setParameter("ecpid", cpid);
		qry.setParameter("eopcoid",opcoid);
		List<cg_sshe_vas_master> lst=qry.getResultList();
		cg_sshe_vas_master obj=lst.get(0);
		int vasid=obj.getId();
		
		String hql1="from cg_sshe_product_master where product_id=:eproductid and opcoid=:eopcoid";
		Query qry1=em.createQuery(hql1);
		qry1.setParameter("eproductid",productid);
		qry1.setParameter("eopcoid", opcoid);
		List<cg_sshe_product_master> lst1=qry1.getResultList();
		cg_sshe_product_master obj1=lst1.get(0);
		int prodid=obj1.getId();
		String hql3="from cg_sshe_notify_url_master where product_id=:eproductid1 and cpid=:ecpid1";
		Query qry2=em.createQuery(hql3);
		qry2.setParameter("eproductid1",prodid);
		qry2.setParameter("ecpid1", vasid);
		
		List<cg_sshe_notify_url_master> lst2=qry2.getResultList();
		cg_sshe_notify_url_master obj2=lst2.get(0);
		String url=obj2.getNotify_url();
		
		return url;
	}

}
