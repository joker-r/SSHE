package com.viva.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
	 public ModelAndView getOperatorList(@RequestParam("country") String country,Model model) {
		 
		
		List<cg_sshe_tenant_details> lst=tenantdao.getOperator(country);
		 model.addAttribute("olist",lst);
		 return new ModelAndView( "getoperator" );
	 }
	
	 @RequestMapping(value="getcircle")
	 public List<cg_sshe_tenant_details> getCircleList(String country,String operator) {
		 
		List<cg_sshe_tenant_details> lst=tenantdao.getCircle(country, operator);
		 
		 return lst;
	 }
	 
	 @RequestMapping(value="getadduser")
	 public String displayAdduser() {
		 return "adduser";
	 }
	 
	 
	 @RequestMapping(value="getaddbusinessuser")
	 public String displayAddbusinessuser(Model model) {
		List<cg_sshe_tenant_details> clist=tenantdao.getCountry();
		model.addAttribute("clist", clist);
		 return "AddBusinessUser";
	 }

  
	 @RequestMapping(value="getviewuser")
	    public String displayviewuser(Model model) {
			model.addAttribute("ulist", dao.getUser());
		 return "ViewUser";
		}
	}
