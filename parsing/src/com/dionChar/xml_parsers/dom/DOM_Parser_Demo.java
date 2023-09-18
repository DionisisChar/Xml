package com.dionChar.xml_parsers.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.dionChar.xml_parsers.dto.Address;
import com.dionChar.xml_parsers.dto.DriversLicense;

public class DOM_Parser_Demo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"));
		DriversLicense license = new DriversLicense();

		// Access to the list of nodes of root element By Tag Name//
		NodeList numberList = document.getElementsByTagName("Number");
		// Access to the specific node (in our case there is only one) item(0) //
		Node numberItem = numberList.item(0);
		//set the text value of the node to license object -- we use parse Int 
				// because we convert an Integer value to String type//
		license.setNumber(Integer.parseInt(numberItem.getTextContent()));

		NodeList lastNameList = document.getElementsByTagName("LastName");
		Node lastNameItem = lastNameList.item(0);
		license.setLastName(lastNameItem.getTextContent());

		NodeList firstNameList = document.getElementsByTagName("FirstName");
		Node firstNameItem = firstNameList.item(0);
		license.setFirstName(firstNameItem.getTextContent());

		// Root element access - attribute of root element
		Element documentElement = document.getDocumentElement();
		license.setStatus(documentElement.getAttribute("status"));

		NodeList addressList = document.getElementsByTagName("Address");
		Node addressNode = addressList.item(0);
		
		// Access to the child elements list of the choosen node//
		NodeList addressChildNodes = addressNode.getChildNodes();
		Address address = new Address();
		license.setAddress(address);

		for (int i = 0; i < addressChildNodes.getLength(); i++) {
			// Access to the nodes of the list one by one//
			Node item = addressChildNodes.item(i);

			if (item instanceof Element) {

				switch (item.getNodeName()) {

				case "street":
					address.setStreet(item.getTextContent());
					break;
				case "city":
					address.setCity(item.getTextContent());
					break;
				case "state":
					address.setState(item.getTextContent());
					break;
				case "country":
					address.setCountry(item.getTextContent());
					break;
				case "zipcode":
					address.setZipcode(item.getTextContent());
					break;
				}
			}
		}

		System.out.println(license.getNumber());
		System.out.println(license.getLastName());
		System.out.println(license.getFirstName());
		System.out.println(license.getAddress().getCountry());
		System.out.println(address.getCity());
		System.out.println(license.getStatus());

	}
}
