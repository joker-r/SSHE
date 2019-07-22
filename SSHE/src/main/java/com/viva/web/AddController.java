package com.viva.web;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.viva.dao.cg_sshe_notify_url_dao;
import com.viva.dao.cg_sshe_product_dao;
import com.viva.dao.cg_sshe_tenant_dao;
import com.viva.dao.cg_sshe_vas_dao;
import com.viva.entity.cg_sshe_notify_url_master;
import com.viva.entity.cg_sshe_product_master;
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
 @RequestMapping(value="addform")
 public String displayAddCp() {
	 return "AddCp";
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
		 Model model) {
	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	 cg_sshe_vas_master cp=new cg_sshe_vas_master();
	 String tenantname=country+"_"+operator+"_"+circle;
	 int opcoid=dao1.getTenantId(tenantname);
	 cp.setOpcoid(opcoid);
	 cp.setCpid(cpid);
	 cp.setCpname(cpname);
	 cp.setCp_status(cp_status);
	 cp.setPassword(password);
	 cp.setLast_modify_date((timestamp).toString());
	 cp.setIp_list(ip_list);
	 dao.addCp(cp);
	 model.addAttribute("CP/SP added successfully");
	 return "Techophome";
 }
 @RequestMapping(value="addProduct",method=RequestMethod.POST)
 public String addProduct(
		 @RequestParam(value="txtproductid") String productid,
		 @RequestParam(value="txtproductname") String productname,
		 @RequestParam(value="txtcountry") String pcountry,
		 @RequestParam(value="txtoperator") String poperator,
		 @RequestParam(value="txtcircle") String circle,
		 @RequestParam(value="txturl") String url,
		 Model model) {
	     Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	     String Opcoidvalue=pcountry+"_"+poperator+"_"+circle;
	     int opcoid=dao1.getTenantId(Opcoidvalue);
	     cg_sshe_product_master product=new cg_sshe_product_master();
	     cg_sshe_notify_url_master notify=new cg_sshe_notify_url_master();
	     product.setProduct_id(productid);
	     product.setProduct_name(productname);
	     product.setLast_modify_date(timestamp.toString());
	     dao2.addProduct(product);
	     int id_product=dao2.getProductById(productid).getId();
	     int id_vas=dao.getCpBOpcoId(opcoid).getId();
	     notify.setCpid(id_vas);
	     notify.setProduct_id(id_product);
	     notify.setNotify_url(url);
	     notify.setLAST_MODIFY_DATE(timestamp.toString());
	     notify.setAPPEND_QUEST_FLAG(1);
	     notify.setOpcoid(opcoid);
	     dao3.addNotifyUrl(notify);
	     model.addAttribute("Product Added Successfully");
	     
	     return "Techophome";
 }
}
