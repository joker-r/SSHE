package com.viva.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.viva.entity.cg_sshe_notify_url_master;
import com.viva.entity.cg_sshe_product_master;
import com.viva.entity.cg_sshe_user;
import com.viva.entity.cg_sshe_vas_master;

@Repository("techopdao")
@Transactional
public class cg_sshe_vas_dao_Imp implements cg_sshe_vas_dao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	 public int addCp(cg_sshe_vas_master cp)
	 {
		em.persist(cp);
		return 1;
	 }


	@Override
	public int editCp(cg_sshe_vas_master cp) {
		// TODO Auto-generated method stub
		em.merge(cp);
		return 0;
	}


	@Override
	public cg_sshe_vas_master getCpById(int cpid) {
		// TODO Auto-generated method stub
		String hql="from cg_sshe_vas_master where cpid=:ecpid";
		Query qry=em.createQuery(hql);
		qry.setParameter("ecpid", cpid);
		List<cg_sshe_vas_master> lst=qry.getResultList();
		cg_sshe_vas_master cp=lst.get(0);
		return cp;
	}


	@Override
	public List<cg_sshe_vas_master> getCp() {
		// TODO Auto-generated method stub
		String hql="from cg_sshe_vas_master";
		Query qry=em.createQuery(hql);
		List<cg_sshe_vas_master> lst=qry.getResultList();
		return lst;
	}


	

	@Override
	public int cpValidation(String cpid, String cppassword) {
		// TODO Auto-generated method stub
		int status;
		String hql="from cg_sshe_vas_master where cpid=:ecpid and password=:epassword";
		Query qry=em.createQuery(hql);
		qry.setParameter("ecpid", cpid);
		qry.setParameter("epassword", cppassword);
		List<cg_sshe_vas_master> cp=qry.getResultList();
		if(cp.get(0)==null)
				status=0;
		else
			status=1;
	    
		return status;
	}


	@Override
	public int ipValidation(String cpid, String ip) {
		// TODO Auto-generated method stub
		return 0;
	}


}
