package com.viva.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.viva.entity.cg_sshe_user;

@Repository("cguserdao")
@Transactional
public class cg_sshe_user_dao_Imp implements cg_sshe_user_dao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public int addUser(cg_sshe_user user) {
		em.persist(user);
		return 1;
	}
	
	@Override
	@Transactional(readOnly=true)
	public cg_sshe_user getUser(String username) {
		cg_sshe_user user=em.find(cg_sshe_user.class,username);
		return user;
		
	}
	
	@Override
	public int editUser(cg_sshe_user user) {
		em.merge(user);
		return 1;
		
	}
	
	@Override
	public List<cg_sshe_user> getUser() {
		String hql="from cg_sshe_user";
		Query qry=em.createQuery(hql);
	
		List<cg_sshe_user> lst=qry.getResultList();
		return lst;
	}

	@Override
	public int getUserType(String username) {
		String hql="from cg_sshe_user where username=:eusername";
		Query qry=em.createQuery(hql);
		qry.setParameter("eusername", username);
		List<cg_sshe_user> lst=qry.getResultList();
		int usertype=(lst.get(0)).getUsertype();
		return usertype;
	}

	
}
