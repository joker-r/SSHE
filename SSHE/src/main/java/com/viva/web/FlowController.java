package com.viva.web;


import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@RequestMapping(value = { "/", "Home" })
	public String displayHome() {

		return "Login";
	}
	@RequestMapping(value = "Logout")
	public String logoutUser(HttpSession session,Model model) {
	session.invalidate();
		model.addAttribute("msg","Logout Successful");
		return "Login";
	}

	@RequestMapping(value = "Login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session,Model model) {
		cg_sshe_user user = dao.getUser(username);
		String page;
		if (user == null) {
			model.addAttribute("msg","Invalid Username");
			return "Login";
			
		} else {
			if (user.getPassword().equals(password)) {
				session.setAttribute("username",username);
				int usertype = user.getUsertype();
				if (usertype == 0) {
					page = "AdminHome";
				} else if (usertype == 1) {
					page = "TechOpsHome";
				} else {
					page = "BusinessHome";
				        model.addAttribute("username", username);
				}
				
			} else {
				model.addAttribute("msg","Invalid Password");
				return "Login";
			}
		}

		return page;
	}
	
	
	
}