package org.demo.sparkjava.handlers.smi;

import org.demo.sparkjava.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import spark.Request;
import spark.Response;
import spark.Route;

public class SmiTraitsPost implements Route {

	@Override
	public Object handle(Request request, Response response) throws Exception {
		Util.log("--- Handler " + this.getClass().getSimpleName() );

		response.header("Content-Type", "text/plain;charset=utf-8" );
		
		String requestBody = request.body();
		Util.log("REQUEST BODY : " + requestBody);
		
		Util.log("Parsing XML " );
		Document dom = Util.parseXML(requestBody);
		Element docElement = dom.getDocumentElement();
		NodeList nodeList = docElement.getElementsByTagName("nir");
		if ( nodeList.getLength() != 1 ) {
			Util.log("'nir' tag not found" );
			return SmiUtil.responseBadRequest();
		}
		
		Node node = nodeList.item(0);
		String nir = node.getNodeValue();
		Util.log("nir = '" + nir + "'" );
		if ( nir == null || nir.trim().isEmpty() ) {
			Util.log("'nir' is void or blank" );
			return SmiUtil.responseBadRequest();
		}
		
		Util.log("searching '" + nir + "' " );
		return SmiUtil.find(nir);
	}
}
