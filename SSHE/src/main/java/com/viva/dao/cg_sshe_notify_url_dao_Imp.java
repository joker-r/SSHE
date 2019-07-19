package com.viva.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.viva.entity.cg_sshe_notify_url_master;

public class cg_sshe_notify_url_dao_Imp implements cg_sshe_notify_url_dao{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int addNotifyUrl(cg_sshe_notify_url_master notify) {
		em.persist(notify);
		return 1;
	}

}
