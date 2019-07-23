package com.viva.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.viva.dao.cg_sshe_tenant_dao;
import com.viva.dao.cg_sshe_user_dao;
import com.viva.entity.cg_sshe_tenant_details;


@Controller
public class iFrameController {
	@Autowired
	private cg_sshe_user_dao dao;
	
	@Autowired
	private cg_sshe_tenant_dao tenantdao;
	
	
	@RequestMapping(value="getcountry")
	 public String getCountryList(Model model) {
		 
		 model.addAttribute("clist",tenantdao.getCountry());
		 return "AddBusinessUser";
	 }
	
	 @RequestMapping(value="getoperator")
	 public List<cg_sshe_tenant_details> getOperatorList(String country) {
		 
		List<cg_sshe_tenant_details> lst=tenantdao.getCountry();
		 
		 return lst;
	 }
	
	 @RequestMapping(value="getadduser")
	 public String displayAdduser() {
		 return "adduser";
	 }
	 
	 
	 @RequestMapping(value="getaddbusinessuser")
	 public String displayAddbusinessuser() {
		 return "AddBusinessUser";
	 }

  
	 @RequestMapping(value="getviewuser")
	    public String displayviewuser(Model model) {
			model.addAttribute("ulist", dao.getUser());
		 return "ViewUser";
		}
	}
