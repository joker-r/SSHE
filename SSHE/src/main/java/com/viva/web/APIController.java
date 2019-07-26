package com.viva.web;

import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.viva.dao.cg_sshe_notify_url_dao;
import com.viva.dao.cg_sshe_product_dao;
import com.viva.dao.cg_sshe_report_dao;
import com.viva.dao.cg_sshe_tenant_dao;
import com.viva.dao.cg_sshe_user_dao;
import com.viva.dao.cg_sshe_vas_dao;
import com.viva.entity.cg_sshe_report;
import com.viva.entity.cg_sshe_tenant_details;
import com.viva.service.ImsiService;

@Controller
public class APIController {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	cg_sshe_product_dao productdao;

	@Autowired
	private cg_sshe_vas_dao vasdao;

	@Autowired
	private cg_sshe_tenant_dao tenantdao;

	@Autowired
	private cg_sshe_notify_url_dao notifydao;
	
	
	  @Autowired
	  private cg_sshe_report_dao reportdao;
	 
	 
	private HttpServletRequest request;

	@Autowired
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@RequestMapping(value = "getHE", method = RequestMethod.POST)
	public String displayHome(@RequestParam("productId") String productID, @RequestParam("pName") String pName,
			@RequestParam("CpId") String CpId, @RequestParam("CpPwd") String CpPwd,
			@RequestParam("CpName") String CpName, @RequestParam("transID") String transID,
			@RequestParam("opcoId") int opcoId, @RequestParam("imsi") String imsi,

			Model model, RedirectAttributes redirectAttributes) {
		List<String> lst = productdao.getProductIDByOpcoId(opcoId);
		System.out.println(lst);

		Timestamp request_datetime = new Timestamp(System.currentTimeMillis());
		int status1;
		int cpvalidation_result = vasdao.cpValidation(CpId, CpPwd);
		String remoteAddr = "";

		if (request != null) {
			remoteAddr = request.getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();
				System.out.println(remoteAddr);
			}
		}

		int ipvalidation_result = vasdao.ipValidation(CpId, remoteAddr);
		if (!imsi.equals(""))
			status1 = 0;
		else
			status1 = 1;
		if (transID.equals(""))
			status1 = 3;
		if (productID.equals("")) {
			status1 = 4;
		} else {
			System.out.println("upper");
			List<String> lst1 = productdao.getProductIDByOpcoId(opcoId);
			System.out.println("lower");
			if (lst1.contains(productID))
				status1 = 5;
		}
		if (CpId.equals(""))
			status1 = 6;
		if (CpPwd.equals(""))
			status1 = 7;
		int cpvalid = vasdao.cpValidation(CpId, CpPwd);
		if (cpvalid == 0)
			status1 = 8;
		int ipvalid = vasdao.ipValidation(CpId, CpPwd);
		if (ipvalid == 0)
			status1 = 9;
		
		cg_sshe_report report=new cg_sshe_report();
		report.setProduct_id(productID);
		report.setIp(remoteAddr);
		report.setRequest_datetime(request_datetime);
		report.setStatus(status1);
		report.setCpid(CpId);
		report.setTrans_id(transID);
		System.out.println("inside report adding");
		report.setOpcoid(opcoId);
		

		if (cpvalidation_result == 0 || ipvalidation_result == 0) {
			model.addAttribute("CP Invalid");
				report.setResponse(null);
				reportdao.add_request_received_for_HE_by_CP(report);
			   return "ErrorPage";
			
		} else {

			if (imsi.equalsIgnoreCase(null) || imsi.equalsIgnoreCase("")) {
				redirectAttributes.addFlashAttribute("opcoId", opcoId);
				redirectAttributes.addFlashAttribute("CpId", CpId);
				redirectAttributes.addFlashAttribute("CpPwd", CpPwd);
				redirectAttributes.addFlashAttribute("transID", transID);
				redirectAttributes.addFlashAttribute("productId", productID);
				report.setResponse("wifi");
				return "redirect:/wifipage";
			} else {
				redirectAttributes.addFlashAttribute("opcoId", opcoId);
				redirectAttributes.addFlashAttribute("CpId", CpId);
				redirectAttributes.addFlashAttribute("CpPwd", CpPwd);
				redirectAttributes.addFlashAttribute("transID", transID);
				redirectAttributes.addFlashAttribute("productId", productID);
				redirectAttributes.addFlashAttribute("imsi", imsi);
				report.setResponse(imsi);
				return "redirect:/mobileflow";
			}

		}

	}

	@RequestMapping(value = "/wifipage", method = RequestMethod.GET)
	public String displayWifi(HttpServletRequest request, Model model) {
		int opcoid = (int) model.asMap().get("opcoId");
		int countrycode = tenantdao.getCountryCode(opcoid);
		request.setAttribute("countrycode", countrycode);
		return "wifipage";
	}

	@RequestMapping(value = "/mobileflow", method = RequestMethod.GET)
	public RedirectView mobileFlow(HttpServletRequest request, Model model) {
		ImsiService service = new ImsiService();
		String productid = (String) model.asMap().get("productId");
		String cpid = (String) model.asMap().get("CpId");
		int opcoid = (int) model.asMap().get("opcoId");

		String msisdn = service.getImsiMsisdn((String) model.asMap().get("imsi"));
		String callbackurl = notifydao.callBackUrl(productid, cpid, opcoid);
		callbackurl = callbackurl + "msisdn=" + msisdn;
		System.out.println(callbackurl);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(callbackurl);
		return redirectView;
	}

}
