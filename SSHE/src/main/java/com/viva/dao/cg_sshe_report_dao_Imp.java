package com.viva.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	

}
