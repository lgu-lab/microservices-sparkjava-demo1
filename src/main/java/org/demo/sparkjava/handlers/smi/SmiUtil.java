package org.demo.sparkjava.handlers.smi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.demo.sparkjava.util.Util;

public class SmiUtil {

	private static final String NOT_FOUND_FILE   = "NOT_FOUND.xml" ;
	private static final String BAD_REQUEST_FILE = "BAD_REQUEST.xml" ;
	
	public static final String responseBadRequest() {
		String content = loadXmlFile(BAD_REQUEST_FILE);
		if ( content == null || content.length() == 0 ) {
			return "<BadRequest/>" ;
		}
		else {
			return content ;
		}
	}

	public static final String responseNotFound() {
		String content = loadXmlFile(NOT_FOUND_FILE);
		if ( content == null || content.length() == 0 ) {
			return "<NotFound/>" ;
		}
		else {
			return content ;
		}
	}

	public static final String responseForId(String nir) {
		String response = find(nir);
		if ( response != null && response.length() > 0 ) {
			return response ;
		}
		return responseNotFound();
	}
	public static final String find(String nir) {
		String fileName = nir + ".xml" ;
		String content = loadXmlFile(fileName);
		if ( content == null || content.length() == 0 ) {
			return responseNotFound();
		}
		return content ;
	}
	
	public static final String loadXmlFile(String fileName) {
		// load XML file
		Util.log("loadXmlFile(" + fileName + ")");
		String dir = currentDirectory() ;
		Util.log("dir = " + dir );
		Path path = Paths.get(dir, "responses", fileName);
		Util.log("file path = " + path );
		String content ;
		try {
			content = new String (Files.readAllBytes(path)) ;
		} catch (IOException e) {
			Util.log("IOException " + e.getMessage() );
			return "" ; // Not found 
		}
		Util.log("return content loaded");
		return content ;
	}
	
	public static final String currentDirectory() {
		return System.getProperty("user.dir") ;
	}
}
