package com.dionChar.xml_parsers.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxParserDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		SAXParser parser = saxFactory.newSAXParser();

		SAXHandler handler = new SAXHandler();
		parser.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLIcense.xml"), handler);

		System.out.println(handler.getDriversLicense().getFirstName());
		System.out.println(handler.getDriversLicense().getLastName());
		System.out.println(handler.getDriversLicense().getNumber());

	}

}
