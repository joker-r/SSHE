package com.viva.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.viva.dao.cg_sshe_report_dao;
import com.viva.dao.cg_sshe_tenant_dao;
import com.viva.dao.cg_sshe_user_dao;
import com.viva.dao.cg_sshe_vas_dao;
import com.viva.entity.cg_sshe_report;
import com.viva.entity.cg_sshe_tenant_details;
import com.viva.entity.cg_sshe_vas_master;


@Controller
public class iFrameController {
	@Autowired
	private cg_sshe_user_dao dao;
	
	@Autowired
	private cg_sshe_tenant_dao tenantdao;
	
	@Autowired
	private cg_sshe_vas_dao vasdao;
	
	@Autowired
	private cg_sshe_report_dao reportdao;
	
	
	
	 @RequestMapping(value="getcpid")
	 @ResponseBody
	 public String getCPIDList(@RequestParam("country") String country,
			 @RequestParam("operator") String operator,
			 @RequestParam("circle") String circle,
			 Model model) {
		 
		 String tenantname=country+"_"+operator+"_"+circle;
		 int opcoid=tenantdao.getTenantId(tenantname);
		 cg_sshe_vas_master vas= vasdao.getCpBOpcoId(opcoid);
		
		StringBuilder sb = new StringBuilder();
         String cpid=vas.getCpid();
		/*
		 * for(int i=0;i<lst.size();i++) { if(i<(lst.size()-2)) {
		 * sb.append(lst.get(i).getOperator()); sb.append(","); } else
		 * if(i<(lst.size()-1)) { sb.append(lst.get(i).getOperator()); } else
		 * if(i<(lst.size())) { sb.append(lst.get(i).getOperator()); }
		 * 
		 * }
		 */
	
		 return cpid;
	 }
	@RequestMapping(value="getcountry")
	 public String getCountryList(Model model) {
		 
		 model.addAttribute("clist",tenantdao.getCountry());
		 return "AddBusinessUser";
	 }
	
	 @RequestMapping(value="getoperator")
	 @ResponseBody
	 public String getOperatorList(@RequestParam("country") String country,Model model) {
		 
		
		List<cg_sshe_tenant_details> lst=tenantdao.getOperator(country);
		
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<lst.size();i++)
		{
			if(i<(lst.size()-2))
					{
			sb.append(lst.get(i).getOperator());
			sb.append(",");
					}
			else if(i<(lst.size()-1))
			{
				sb.append(lst.get(i).getOperator());
			}
			else if(i<(lst.size()))
			{
				sb.append(lst.get(i).getOperator());
			}
			
		}
	
		String ids = sb.toString();

		 model.addAttribute("olist",lst);
		 return ids;
	 }
	
	 @RequestMapping(value="getcircle")
	 @ResponseBody
	 public String getCircleList(@RequestParam("country") String country,@RequestParam("operator") String operator) {
		 
		List<cg_sshe_tenant_details> lst=tenantdao.getCircle(country, operator);
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<lst.size();i++)
		{
			if(i<(lst.size()-2))
					{
			sb.append(lst.get(i).getCircle());
			sb.append(",");
					}
			else if(i<(lst.size()-1))
			{
				sb.append(lst.get(i).getCircle());
			}
			else if(i<(lst.size()))
			{
				sb.append(lst.get(i).getCircle());
			}
			
		}
		String ids = sb.toString();

		 return ids;
	 }
	 
	 @RequestMapping(value="getadduser")
	 public String displayAdduser(Model model,HttpSession session) {
		 if(session.getAttribute("username")==null)
		 {
			 model.addAttribute("msg","Invalid Request.Please Login");
			 return "Login";
		 }
		 return "adduser";
	 }
	 
	 
	 @RequestMapping(value="EditBusinessUser")
	 public String displayEditbusinessuser(Model model,HttpSession session) {
		 if(session.getAttribute("username")==null)
		 {
			 model.addAttribute("msg","Invalid Request.Please Login");
			 return "Login";
		 }
		List<cg_sshe_tenant_details> clist=tenantdao.getCountry();
		model.addAttribute("clist", clist);
		 return "EditBusinessUser";
	 }
	 
	 @RequestMapping(value="getaddbusinessuser")
	 public String displayAddbusinessuser(Model model,HttpSession session) {
		 if(session.getAttribute("username")==null)
		 {
			 model.addAttribute("msg","Invalid Request.Please Login");
			 return "Login";
		 }
		List<cg_sshe_tenant_details> clist=tenantdao.getCountry();
		model.addAttribute("clist", clist);
		 return "AddBusinessUser";
	 }
	 
	 @RequestMapping(value="getaddproduct")
	 public String displayAddproduct(Model model,HttpSession session) {
		 if(session.getAttribute("username")==null)
		 {
			 model.addAttribute("msg","Invalid Request.Please Login");
			 return "Login";
		 }
		List<cg_sshe_tenant_details> clist=tenantdao.getCountry();
		model.addAttribute("clist", clist);
		 return "AddProduct";
	 }

  
	 @RequestMapping(value="getviewuser")
	    public String displayviewuser(Model model,HttpSession session) {
		 if(session.getAttribute("username")==null)
		 {
			 model.addAttribute("msg","Invalid Request.Please Login");
			 return "Login";
		 }
			model.addAttribute("ulist", dao.getUser());
		 return "ViewUser";
		}
	 @RequestMapping(value="ViewReport")
	    public String displayReport(Model model,HttpSession session) {
		 if(session.getAttribute("username")==null)
		 {
			 model.addAttribute("msg","Invalid Request.Please Login");
			 return "Login";
		 }
		List<cg_sshe_report> reports= reportdao.generateReport(session.getAttribute("username").toString());
		model.addAttribute("username", session.getAttribute("username").toString());
		 model.addAttribute("rlist",reports);
		/*
		 * For Success and  fail reports
		 * List<cg_sshe_report> successreports=
		 * reportdao.generateSuccessReport(session.getAttribute("username").toString());
		 * List<cg_sshe_report> failreports=
		 * reportdao.generateFailReport(session.getAttribute("username").toString());
		 * System.out.println(reports.get(0).getProduct_id());
		 * System.out.println(""+reports.get(0).getStatus());
		 * model.addAttribute("slist",successreports);
		 * model.addAttribute("flist",failreports);
		 */
		 return "ViewReport";
		}
	}
