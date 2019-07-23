package com.viva.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import com.viva.dao.cg_sshe_user_dao;


@Controller
public class iFrameController {
	@Autowired
	private cg_sshe_user_dao dao;
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
