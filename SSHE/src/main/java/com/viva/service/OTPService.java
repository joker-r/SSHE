package com.viva.service;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@ComponentScan
public class OTPService {

	@Value("${initParam.OTPGenUrl}")
	private  String OTPGenUrl;
	
	public String getOTPGenerate(String msisdn,String transId,String CpId,String CpPwd) {
    	RestTemplate restTemplate = new RestTemplate();
    	//System.out.println(imsiUrl);
    	String url="http://localhost:8085/OTPGenUrl.xml";
    	//	String url=imsiUrl+"?IMSI="+imsi;
    String resp = 
          restTemplate.getForObject(url, String.class);
    Document doc = convertStringToXMLDocument( resp );
 
    doc.getDocumentElement().normalize();
    NodeList nList = doc.getElementsByTagName("OTP");
    Node nNode = nList.item(0);
    Element eElement = (Element) nNode;
    String otpresult=eElement.getAttribute("id");
    
    System.out.println(otpresult);  
    return otpresult;
   
    }
	public String getOTPValidate(String msisdn,String CpId,String CpPwd,int otp) {
    	RestTemplate restTemplate = new RestTemplate();
    	String result;
    	//System.out.println(imsiUrl);
    	if(otp==1234)
    	{
    	String url="http://localhost:8085/OTPValidateUrl.xml";
    	
    	//	String url=imsiUrl+"?IMSI="+imsi;
    String resp = 
          restTemplate.getForObject(url, String.class);
    Document doc = convertStringToXMLDocument( resp );
 
    doc.getDocumentElement().normalize();
    NodeList nList = doc.getElementsByTagName("OTP");
    Node nNode = nList.item(0);
    Element eElement = (Element) nNode;
    result=eElement.getAttribute("id");
    	}
    	else
    	{
    		result="Invalid OTP";
    	}
    System.out.println(result);  
    return result;
   
    }
    
    private static Document convertStringToXMLDocument(String xmlString) 
	{
		//Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try 
		{
			//Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();
			
			//Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
