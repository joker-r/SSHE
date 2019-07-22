package com.viva.web;

import java.awt.PageAttributes.MediaType;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

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

	@RequestMapping(value = "Login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		cg_sshe_user user = dao.getUser(username);
		String page;
		if (user == null) {
			return "Login";
		} else {
			if (user.getPassword().equals(password)) {
				int usertype = user.getUsertype();
				if (usertype == 0) {
					page = "AdminHome";
				} else if (usertype == 1) {
					page = "TechOps";
				} else {
					page = "Business";
				}
			} else {
				return "Login";
			}
		}

		return page;
	}
	
	@RequestMapping(value="imsi", method = RequestMethod.POST)
	public String imsiValidation(@RequestHeader("IMSI") String imsi) {
		if(null!=imsi)
		{
			
			final String uri="http://localhost:8086/login?username=admin&password=admin";
			RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		     
		    System.out.println(result);
			
			
			return "";
		}
		else
			return "msisdnPage";
			
	}
	
}