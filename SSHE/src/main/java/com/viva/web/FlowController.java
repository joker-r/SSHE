package com.viva.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.viva.dao.cg_sshe_user_dao;
import com.viva.entity.cg_sshe_user;

@Controller
public class FlowController {
	@Autowired
	private cg_sshe_user_dao dao;
	
	@RequestMapping(value = {"/", "Home"})
	public String displayHome() {
		
		return "Login";
}
	
	@RequestMapping(value="AddUser",method=RequestMethod.POST)
	public String addUser(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("usertype") int usertype,Model model)
	{
		cg_sshe_user user=dao.getUser(username);
		cg_sshe_user adduser= new cg_sshe_user();
		if(user!=null)
		{
			model.addAttribute("Username is not available");
			return "AddUser";
		}
		else
		{
			adduser.setUsername(username);
			adduser.setPassword(password);
			adduser.setUsertype(usertype);
			dao.addUser(adduser);
			model.addAttribute("User Added Successfully");
		}
		
		return "AdminHome";
	}
	
	
	@RequestMapping(value="Login",method=RequestMethod.POST)
	public String loginUser(@RequestParam("username") String username,@RequestParam("password") String password,Model model)
	{
		cg_sshe_user user=dao.getUser(username);
		String page;
		if(user==null)
		{
			model.addAttribute("Invalid Username");
			return "Login";
		}
		else
		{
			if(user.getPassword().equals(password))
			{
				int usertype=user.getUsertype();
				if(usertype==0)
				{
					page="AdminHome";
				}
				else if(usertype==1)
				{
					page="TechOps";
				}
				else
				{
					page="Business";
				}
			}
			else
			{
				model.addAttribute("Invalid Password");
				return "Login";
			}
		}
	    
		
		
	
		return page;
	}
}