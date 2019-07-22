package com.viva.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class iFrameController {
	 @RequestMapping(value="getadduser")
	 public String displayAdduser() {
		 return "adduser";
	 }
}
