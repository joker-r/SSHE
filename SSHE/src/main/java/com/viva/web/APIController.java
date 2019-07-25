package com.viva.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.viva.dao.cg_sshe_notify_url_dao;
import com.viva.dao.cg_sshe_tenant_dao;
import com.viva.dao.cg_sshe_vas_dao;
import com.viva.service.ImsiService;
import com.viva.service.OTPService;




@Controller
public class APIController {
    
	@Autowired
	private cg_sshe_vas_dao vasdao;
	
	@Autowired
	private cg_sshe_tenant_dao tenantdao;
	
	@Autowired
	private cg_sshe_notify_url_dao notifydao;

	@Autowired
	private HttpServletRequest request;

	    @Autowired
	    public void setRequest(HttpServletRequest request) {
	        this.request = request;
	    }

	
	@RequestMapping(value ="getHE",method = RequestMethod.GET)
	public String displayHome(@RequestParam("productId") String productID,
			@RequestParam("pName") String pName,
			@RequestParam("CpId") String CpId,
			@RequestParam("CpPwd") String CpPwd,
			@RequestParam("CpName") String CpName,
			@RequestParam("transID") String transID,
			@RequestParam("opcoId") int opcoId,
			@RequestParam("imsi") String imsi,
			Model model,
			RedirectAttributes redirectAttributes
			) {
	
		int cpvalidation_result=vasdao.cpValidation(CpId, CpPwd);
		String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
                System.out.println(remoteAddr);
            }
        }
        
        int ipvalidation_result=vasdao.ipValidation(CpId,remoteAddr);

		if(cpvalidation_result==0||ipvalidation_result==0)
		{
			model.addAttribute("CP Invalid");
			return "ErrorPage";
		}
		else
		{
			
			if(imsi.equalsIgnoreCase(null)||imsi.equalsIgnoreCase(""))
			{
				redirectAttributes.addFlashAttribute("opcoId",opcoId);
				redirectAttributes.addFlashAttribute("CpId",CpId);
				redirectAttributes.addFlashAttribute("CpPwd",CpPwd);
				redirectAttributes.addFlashAttribute("transID",transID);
				redirectAttributes.addFlashAttribute("productId",productID);
				return "redirect:/wifipage";
			}
			else
			{
				redirectAttributes.addFlashAttribute("opcoId",opcoId);
				redirectAttributes.addFlashAttribute("CpId",CpId);
				redirectAttributes.addFlashAttribute("CpPwd",CpPwd);
				redirectAttributes.addFlashAttribute("transID",transID);
				redirectAttributes.addFlashAttribute("productId",productID);
				redirectAttributes.addFlashAttribute("imsi",imsi);
				return "redirect:/mobileflow";
			}
			
		}
	
	}
	
	@RequestMapping(value ="/wifipage",method = RequestMethod.GET)
	public String displayWifi(HttpServletRequest request,Model model,HttpSession session)
	{
		int opcoid = (int)model.asMap().get("opcoId");
		int countrycode=tenantdao.getCountryCode(opcoid);
		request.setAttribute("countrycode",countrycode);
	   session.setAttribute("transID", (String)model.asMap().get("transID"));
	   session.setAttribute("CpId", (String)model.asMap().get("CpId"));
	   session.setAttribute("CpPwd", (String)model.asMap().get("CpPwd"));
	   session.setAttribute("productId", (String)model.asMap().get("productId"));
	   session.setAttribute("opcoId",opcoid);
		return "Subscription";
	}
	
	@RequestMapping(value ="/OTPPage",method = RequestMethod.GET)
	public String displayOTP(@RequestParam("msisdn") String msisdn,
			HttpServletRequest request,Model model,HttpSession session)
	{
		
		String transID=(session.getAttribute("transID").toString());
		String CpId=(session.getAttribute("CpId").toString());
		String CpPwd=(session.getAttribute("CpPwd").toString());
		System.out.println(transID);
		OTPService otpservice=new OTPService();
		String otpresult=otpservice.getOTPGenerate(msisdn, transID,CpId,CpPwd);
		session.setAttribute("otpresult",otpresult);
		session.setAttribute("msisdn", msisdn);
		
		
		return "OTP";
	}
	@RequestMapping(value ="/OTPValidate",method = RequestMethod.GET)
	public String validateOTP(@RequestParam("otp") int otp,
			HttpServletRequest request,Model model,HttpSession session)
	{
		
		String CpId=(session.getAttribute("CpId").toString());
		String CpPwd=(session.getAttribute("CpPwd").toString());
		String msisdn=(session.getAttribute("msisdn").toString());
		String productId=(session.getAttribute("productId").toString());
		int opcoId=Integer.parseInt((session.getAttribute("opcoId").toString()));
		
		OTPService otpservice=new OTPService();
		String result=otpservice.getOTPValidate(msisdn,CpId,CpPwd,otp);
		
		if(result.equalsIgnoreCase("SUCCESS"))
		{
			String callbackurl=notifydao.callBackUrl(productId, CpId, opcoId);
			callbackurl =callbackurl+"msisdn="+msisdn;
			session.setAttribute("callbackurl", callbackurl);
			System.out.println(callbackurl);
	        return "redirect:/callback";
		}
		else
		{
			return "ErrorPage";
		}
		
		
		
	}
	
	
	@RequestMapping(value ="/callback",method = RequestMethod.GET)
	public RedirectView callback(HttpServletRequest request,Model model,HttpSession session)
	{
	
		String callbackurl=(session.getAttribute("callbackurl").toString());
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(callbackurl);
	    return redirectView;
	}
	
	
	@RequestMapping(value ="/mobileflow",method = RequestMethod.GET)
	public RedirectView mobileFlow(HttpServletRequest request,Model model)
	{
		ImsiService service=new ImsiService();
		String  productid = (String)model.asMap().get("productId");
		String  cpid = (String)model.asMap().get("CpId");
		int  opcoid = (int)model.asMap().get("opcoId");
		
		String msisdn=service.getImsiMsisdn((String)model.asMap().get("imsi"));
		String callbackurl=notifydao.callBackUrl(productid, cpid, opcoid);
		callbackurl =callbackurl+"msisdn="+msisdn;
		System.out.println(callbackurl);
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(callbackurl);
	    return redirectView;
	}
}
	
	



