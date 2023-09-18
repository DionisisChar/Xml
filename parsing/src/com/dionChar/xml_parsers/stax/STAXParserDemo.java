package com.dionChar.xml_parsers.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import com.dionChar.xml_parsers.dto.DriversLicense;

public class STAXParserDemo {

	public static void main(String[] args) throws XMLStreamException {

		XMLInputFactory staxFactory = XMLInputFactory.newInstance();
		XMLStreamReader xmlStreamReader = staxFactory
				.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"));

		String content = null;
		DriversLicense driversLicense = null;

		while (xmlStreamReader.hasNext()) {
			int event = xmlStreamReader.next();

			switch (event) {

			case XMLStreamConstants.START_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("DriversLicense")) {
					driversLicense = new DriversLicense();
					driversLicense.setStatus(xmlStreamReader.getAttributeValue(0));
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				content = xmlStreamReader.getText().trim();
				break;

			case XMLStreamConstants.END_ELEMENT:
				switch (xmlStreamReader.getLocalName()) {
				case "Number":
					driversLicense.setNumber(Integer.parseInt(content));
				case "FirstName":
					driversLicense.setFirstName(content);
				case "LastName":
					driversLicense.setLastName(content);
				}

			}

		}

		System.out.println(driversLicense.getFirstName());
		System.out.println(driversLicense.getLastName());
		System.out.println(driversLicense.getNumber());
		System.out.println(driversLicense.getStatus());
	}

}
