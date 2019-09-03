package org.demo.sparkjava.debug;

import org.demo.sparkjava.util.Util;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestXml {

	public static void main(String[] args) throws Exception {
		
		Document dom = Util.parseXML("<root>aa</root>");
		Element e = dom.getDocumentElement();
		System.out.println("node name = " + e.getNodeName() );
	}

}
