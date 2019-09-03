package org.demo.sparkjava.handlers.smi;

import org.demo.sparkjava.util.Header;
import org.demo.sparkjava.util.Util;

import spark.Request;
import spark.Response;
import spark.Route;

public class SmiTraitsGet implements Route {

	@Override
	public Object handle(Request request, Response response) throws Exception {
		Util.log("--- Handler " + this.getClass().getSimpleName() );

		Header.setContentType(response, Header.TEXT_XML_UTF8 );
		
		String nir = request.queryParams("nir");
		if ( nir == null || nir.isEmpty() ) {
			Util.log("no 'nir' parameter -> bad request " );
			return SmiUtil.responseBadRequest();
		}
		else {
			Util.log("searching '" + nir + "' " );
			return SmiUtil.find(nir);
		}
	}
}
