package org.demo.sparkjava.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import spark.Request;

public class Util {

	public static final String currentDirectory() {
		return System.getProperty("user.dir") ;
	}

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
	
    public static Properties loadProperties() {
    	String filePath = currentDirectory() + "/config.properties" ;
    	log("Configuration file : " + filePath);
        try (InputStream input = new FileInputStream(filePath)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop ;
        } catch (IOException ex) {
        	log("Cannot read configuration file, IOException " + ex.getMessage() );
            return null;
        }
    }
}
