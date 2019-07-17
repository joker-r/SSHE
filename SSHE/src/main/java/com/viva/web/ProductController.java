package com.viva.web;


import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ProductController {
    
	
	
	
	@RequestMapping(value = {"/", "Home"})
	public String displayHome() {
		
		return "Home";
	}
	
	


}
