package com.viva.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.viva.entity.cg_sshe_notify_url_master;
import com.viva.entity.cg_sshe_product_master;
import com.viva.entity.cg_sshe_vas_master;

public class cg_sshe_product_dao_Imp implements cg_sshe_product_dao {
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public int addProduct(cg_sshe_product_master product) {
		// TODO Auto-generated method stub
		em.persist(product);
		return 1;
	}


	@Override
	public int editProduct(cg_sshe_product_master product) {
		// TODO Auto-generated method stub
		em.merge(product);
		return 0;
	}


	@Override
	public List<cg_sshe_product_master> getProduct(cg_sshe_vas_master cp) {
		// TODO Auto-generated method stub
		String hql="select product_name.cg_sshe_product_master form cg_sshe_product_master inner join cg_sshe_vas_master on cg_sshe_vas_master.opcoid=cg_sshe_product_master.opcoid";
		Query qry=em.createQuery(hql);
		List<cg_sshe_product_master> lst=qry.getResultList();
		return lst;
	}


	@Override
	public cg_sshe_product_master getProductById(int product_id) {
		// TODO Auto-generated method stub
		String hql="from cg_sshe_product_master where product_id=:eproduct_id";
		Query qry=em.createQuery(hql);
		qry.setParameter("eproduct_id",product_id);
		List<cg_sshe_product_master> lst=qry.getResultList();
		cg_sshe_product_master product=lst.get(0);
		return product;
	}


	@Override
	public int addUrl(cg_sshe_notify_url_master notify_url) {
		// TODO Auto-generated method stub
		em.persist(notify_url);
		return 1;
	}

}
