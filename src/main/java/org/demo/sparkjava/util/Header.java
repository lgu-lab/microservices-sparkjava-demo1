package org.demo.sparkjava.util;

import spark.Response;

public class Header {

	public static final String TEXT_HTML_UTF8  = "text/html;charset=utf-8";
	public static final String TEXT_PLAIN_UTF8 = "text/plain;charset=utf-8";
	public static final String TEXT_XML_UTF8   = "text/xml;charset=utf-8";
			
	private Header() {}
	
	public static void setContentType(Response response, String value) {
		response.header("Content-Type", value);
	}

	public static void setContentLength(Response response, long value) {
		response.header("Content-Length", Long.toString(value));
	}
}
