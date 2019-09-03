package org.demo.sparkjava;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;
import static spark.Spark.put;

import org.demo.sparkjava.handlers.foo.FooGet;
import org.demo.sparkjava.handlers.foo.FooPost;
import org.demo.sparkjava.handlers.smi.SmiTraitsGet;
import org.demo.sparkjava.handlers.smi.SmiTraitsPost;

public class WebApp {

	public static void main(String[] args) {

		// The server is automatically started when you do something that requires the
		// server to be started
		// (i.e. declaring a route or setting the port).
		// You can also manually start the server by calling init().

		// Default port is 4567

		// Test with : http://localhost:4567/hello
		get("/hello", (request, response) -> "Hello World");

//---------------------------------------------------------------
//        Routes
//---------------------------------------------------------------
//        The main building block of a Spark application is a set of routes. A route is made up of three simple pieces:
//
//        	A verb (get, post, put, delete, head, trace, connect, options)
//        	A path (/hello, /users/:name)
//        	A callback (request, response) -> { }
//        	Routes are matched in the order they are defined. The first route that matches the request is invoked.
//        	Always statically import Spark methods to ensure good readability:
//---------------------------------------------------------------

		// Http response : Content-Type by default : "text/html;charset=utf-8"

		get("/", (request, response) -> {
			// Show something
			return "Response for GET on '/'";
		});

		post("/", (request, response) -> {
			// Create something
			return "";
		});

		put("/", (request, response) -> {
			// Update something
			return "";
		});

		delete("/", (request, response) -> {
			// Annihilate something
			return "";
		});

		options("/", (request, response) -> {
			// Appease something
			return "";
		});

		
		get("/foo", new FooGet());
		post("/foo", new FooPost());
		
		//--- FAKE SMI
		get("/smi/traits", new SmiTraitsGet());
		post("/smi/traits", new SmiTraitsPost());
		
	}
}
