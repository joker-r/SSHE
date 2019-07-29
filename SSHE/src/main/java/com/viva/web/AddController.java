package com.viva.web;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.viva.dao.cg_sshe_notify_url_dao;
import com.viva.dao.cg_sshe_product_dao;
import com.viva.dao.cg_sshe_tenant_dao;
import com.viva.dao.cg_sshe_user_dao;
import com.viva.dao.cg_sshe_vas_dao;
import com.viva.entity.cg_sshe_notify_url_master;
import com.viva.entity.cg_sshe_product_master;
import com.viva.entity.cg_sshe_user;
import com.viva.entity.cg_sshe_vas_master;

@Controller
public class AddController {
	
	@Autowired
	private cg_sshe_vas_dao dao;
	@Autowired
	private cg_sshe_tenant_dao dao1;
	@Autowired
	private cg_sshe_product_dao dao2;
	
	@Autowired
	private cg_sshe_notify_url_dao dao3;
	
	@Autowired
	private cg_sshe_user_dao dao4;
	
 @RequestMapping(value="addform")
 public String displayAddCp() {
	 return "AddCp";
 }
 
 @RequestMapping(value="adduser",method=RequestMethod.POST)
 public String addCp(
		 @RequestParam(value="username")String username,
		 @RequestParam(value="password")String password,
		 @RequestParam(value="usertype")String usertype,
		 Model model,HttpSession session) {
	 if(session.getAttribute("username")==null)
	 {
		 model.addAttribute("msg","Invalid Request.Please Login");
		 return "Login";
	 }
	 cg_sshe_user user1=dao4.getUser(username);
	 if(user1!=null)
	 {
		 model.addAttribute("msg","Username Already Exists/Must Be Unique");
		 return "ErrorPage";
	 }
	 cg_sshe_user user=new cg_sshe_user();
	 int utype=0;
	 if(usertype.equalsIgnoreCase("Techops"))
	 {
		 utype=1;
	 }
	 user.setUsername(username);
	 user.setPassword(password);
	user.setUsertype(utype);
	dao4.addUser(user);
	model.addAttribute("msg","User Added Successfully");
	
	 return "success";
 }
 
 @RequestMapping(value="addCp",method=RequestMethod.POST)
 public String addCp(
		 @RequestParam(value="txtcpid")String cpid,
		 @RequestParam(value="txtcpname")String cpname,
		 @RequestParam(value="txtcpstatus")boolean cp_status,
		 @RequestParam(value="txtiplist")String ip_list,
		 @RequestParam(value="txtpassword")String password,
		 @RequestParam(value="txtcountry")String country,
		 @RequestParam(value="txtoperator")String operator,
		 @RequestParam(value="txtcircle")String circle,
		 Model model,HttpSession session) {
	 if(session.getAttribute("username")==null)
	 {
		 model.addAttribute("msg","Invalid Request.Please Login");
		 return "Login";
	 }
	  List<cg_sshe_vas_master> cg=dao.getCpById(cpid);
	  if(cg.size()>=1)
	  {
		  model.addAttribute("msg","CPID Already Exists");
		  return "ErrorPage";
	  }
	 
	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	 cg_sshe_vas_master cp=new cg_sshe_vas_master();
	 String tenantname=country+"_"+operator+"_"+circle;
	 int opcoid=dao1.getTenantId(tenantname);
	 cg_sshe_vas_master cg1=dao.getCpBOpcoId(opcoid);
	 if(cg1!=null)
	  {
		  model.addAttribute("msg","CP Already Exists In OPCOID");
		  return "ErrorPage";
	  }
	 cp.setOpcoid(opcoid);
	 cp.setCpid(cpid);
	 cp.setCpname(cpname);
	 cp.setCp_status(cp_status);
	 cp.setPassword(password);
	 cp.setLast_modify_date((timestamp).toString());
	 cp.setIp_list(ip_list);
	 dao.addCp(cp);
	 cg_sshe_user user=new cg_sshe_user();
	 user.setUsername(cpid);
	 user.setPassword(password);
	 user.setUsertype(2);
	 dao4.addUser(user);
	 model.addAttribute("msg","CP/SP added successfully");
	 return "success";
 }
 @RequestMapping(value="editbuser",method=RequestMethod.POST)
 public String editCp(
		 @RequestParam(value="txtcpid")String cpid,
		 @RequestParam(value="txtcpstatus")boolean cp_status,
		 @RequestParam(value="txtcountry")String country,
		 @RequestParam(value="txtoperator")String operator,
		 @RequestParam(value="txtcircle")String circle,
		 Model model,HttpSession session) {
	 if(session.getAttribute("username")==null)
	 {
		 model.addAttribute("msg","Invalid Request.Please Login");
		 return "Login";
	 }
	  List<cg_sshe_vas_master> cg=dao.getCpById(cpid);
	  cg_sshe_vas_master vas1=cg.get(0);
	 cg_sshe_vas_master cp=new cg_sshe_vas_master();
	 String tenantname=country+"_"+operator+"_"+circle;
	 int opcoid=dao1.getTenantId(tenantname);
	 cp.setId(vas1.getId());
	 cp.setOpcoid(opcoid);
	 cp.setCpid(cpid);
	 cp.setCp_status(cp_status);
	 cp.setCpname(vas1.getCpname());
	 cp.setPassword(vas1.getPassword());
	 cp.setIp_list(vas1.getIp_list());
	 dao.editCp(cp);
	 model.addAttribute("msg","CP/SP updated successfully");
	 return "success";
 }
 
 @RequestMapping(value="addProduct",method=RequestMethod.POST)
 public String addProduct(
		 @RequestParam(value="txtproductid") String productid,
		 @RequestParam(value="txtproductname") String productname,
		 @RequestParam(value="txtcountry") String pcountry,
		 @RequestParam(value="txtoperator") String poperator,
		 @RequestParam(value="txtcircle") String circle,
		 @RequestParam(value="txturl") String url,
		 Model model,HttpSession session) {
	 if(session.getAttribute("username")==null)
	 {
		 model.addAttribute("msg","Invalid Request.Please Login");
		 return "Login";
	 }
	 List<cg_sshe_product_master> prod=dao2.getProductById(productid);
	 if(prod.size()>=1)
	 {
		 model.addAttribute("msg","Product ID Already Exists");
		  return "ErrorPage";
	 }
	     Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	     String Opcoidvalue=pcountry+"_"+poperator+"_"+circle;
	     int opcoid=dao1.getTenantId(Opcoidvalue);
	     cg_sshe_product_master product=new cg_sshe_product_master();
	     cg_sshe_notify_url_master notify=new cg_sshe_notify_url_master();
	     product.setProduct_id(productid);
	     product.setProduct_name(productname);
	     product.setLast_modify_date(timestamp.toString());
	     product.setOpcoid(opcoid);
	     dao2.addProduct(product);
	     int id_product=(dao2.getProductById(productid)).get(0).getId();
	     int id_vas=dao.getCpBOpcoId(opcoid).getId();
	     notify.setCpid(id_vas);
	     notify.setProduct_id(id_product);
	     notify.setNotify_url(url);
	     notify.setLAST_MODIFY_DATE(timestamp.toString());
	     notify.setAPPEND_QUEST_FLAG(1);
	     notify.setOpcoid(opcoid);
	     dao3.addNotifyUrl(notify);
	     model.addAttribute("msg","Product Added Successfully");
	     
	     return "success";
 }
}
