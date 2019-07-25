package com.viva.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


import java.io.StringReader;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@ComponentScan
public class ImsiService {

	@Value("${initParam.imsiUrl}")
	private  String imsiUrl;
	  
	    public String getImsiMsisdn(String imsi) {
	    	RestTemplate restTemplate = new RestTemplate();
	    	//System.out.println(imsiUrl);
	    	String url="http://localhost:8085/IMSITemplate.xml";
	    	//	String url=imsiUrl+"?IMSI="+imsi;
	    String resp = 
	          restTemplate.getForObject(url, String.class);
	    Document doc = convertStringToXMLDocument( resp );
     
	    doc.getDocumentElement().normalize();
	    NodeList nList = doc.getElementsByTagName("Subscriber");
	    Node nNode = nList.item(0);
	    Element eElement = (Element) nNode;
	    String msisdn=eElement.getAttribute("id");
	    
	    System.out.println(msisdn);  
	    return msisdn;
	   
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
