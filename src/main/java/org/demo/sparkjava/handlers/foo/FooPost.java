package org.demo.sparkjava.handlers.foo;

import org.demo.sparkjava.util.Header;
import org.demo.sparkjava.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import spark.Request;
import spark.Response;
import spark.Route;

public class FooPost implements Route {

	@Override
	public Object handle(Request request, Response response) throws Exception {
		Util.log("--- Handler " + this.getClass().getSimpleName() );
		
		String requestBody = request.body();
		Util.log("REQUEST BODY : " + requestBody);
		
		String responseBody = "Foo-POST";
		if ( Util.isXmlContentType(request) ) {
			Util.log("REQUEST BODY IS XML " );
			Document dom = Util.parseXML(requestBody);
			Element docElement = dom.getDocumentElement();
			responseBody = responseBody + " root tag : " + docElement.getNodeName();
		}
		
		Header.setContentType(response, Header.TEXT_PLAIN_UTF8);
		Header.setContentLength(response, responseBody.length());
		return responseBody;
	}

	
}
