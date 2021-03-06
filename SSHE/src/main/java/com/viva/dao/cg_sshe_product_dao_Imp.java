package com.viva.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viva.entity.cg_sshe_notify_url_master;
import com.viva.entity.cg_sshe_product_master;
import com.viva.entity.cg_sshe_vas_master;
@Repository("cgproductdao")
@Transactional
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
	public List<cg_sshe_product_master> getProductById(String product_id) {
		// TODO Auto-generated method stub
		String hql="from cg_sshe_product_master where product_id=:eproduct_id";
		Query qry=em.createQuery(hql);
		qry.setParameter("eproduct_id",product_id);
		List<cg_sshe_product_master> lst=qry.getResultList();
		
		return lst;
	}


	@Override
	public int addUrl(cg_sshe_notify_url_master notify_url) {
		// TODO Auto-generated method stub
		em.persist(notify_url);
		return 1;
	}


	@Override
	public List<String> getProductIDByOpcoId(int opcoId) {
		String hql = "from cg_sshe_product_master where opcoid=:eopcoid";
		Query qry = em.createQuery(hql);
		qry.setParameter("eopcoid", opcoId);
		List<cg_sshe_product_master> lst = qry.getResultList();
		List<String> productlist=new ArrayList<String>();
		for(int i=0;i<lst.size();i++)
		{
			productlist.add(lst.get(i).getProduct_id());
		}
		return productlist;
	}



}
