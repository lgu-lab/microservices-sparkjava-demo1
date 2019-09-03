package org.demo.sparkjava.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import spark.Request;

public class Util {

	public static void log(String msg) {
		System.out.println("[LOG] " + msg);
	}

	public static boolean isXmlContentType(Request request) {
		String contentType = request.contentType() ;
		return contentType != null && contentType.startsWith("application/xml") ;
		
	}
	public static Document parseXML(String xml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return builder.parse(is);
	}

	public static String buildXml(String xmlContent) {
		return "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>" + xmlContent ;
	}
	
}
