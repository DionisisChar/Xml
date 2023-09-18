package com.dionChar.xml_parsers.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.dionChar.xml_parsers.dto.DriversLicense;

public class SAXHandler extends DefaultHandler {

	private DriversLicense driversLicense;
	private String content;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("DriversLicense"))
			driversLicense = new DriversLicense();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (qName) {

		case "Number":
			driversLicense.setNumber(Integer.parseInt(content));
			break;
		case "FirstName":
			driversLicense.setFirstName(content);
			break;
		case "LastName":
			driversLicense.setLastName(content);
			break;
		}

	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();

	}

	public DriversLicense getDriversLicense() {
		return driversLicense;
	}

}
