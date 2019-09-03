package org.demo.sparkjava.handlers.foo;

import spark.Request;
import spark.Response;
import spark.Route;

public class FooGet implements Route {

	@Override
	public Object handle(Request request, Response response) throws Exception {
		String body = "FooGet";
		response.header("Content-Type", "text/plain;charset=utf-8" );		
		response.header("Content-Length", ""+body.length());
		return body;
	}

}
