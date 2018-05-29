package ua.nure.strebkov.SummaryTask3.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import ua.nure.strebkov.SummaryTask3.constants.Constants;
import ua.nure.strebkov.SummaryTask3.constants.XML;
import ua.nure.strebkov.SummaryTask3.entity.*;
import ua.nure.strebkov.SummaryTask3.entity.Hotel;

public class SAXController extends DefaultHandler {

	private String currentElement;
	private String xmlFileName;

	// main container
	private Tourist_vouchers tourist_vouchers;
	private Hotel hotel;
	private List<Hotel> hotels = new ArrayList();
	private Cost cost;
	boolean isStars;
	boolean isDays;
	boolean isTransport;
	boolean isMeal;

	public SAXController(String xmlFileName) {

		this.xmlFileName = xmlFileName;
	}

	public static void main(String[] args) throws Exception {

		SAXController saxController = new SAXController(Constants.VALID_XML_FILE);
		saxController.parse(true);
		Hotel myHotel = saxController.getHotel();
		System.out.println("=====================================");
		System.out.println(myHotel.getStars());
		System.out.println(myHotel.getDays());
		System.out.println(myHotel.getTransport());
		System.out.println(myHotel.getMeal());
		System.out.println("==============Total "+saxController.getHotels().size()+"=======================");
	}

	Hotel getHotel() {
		return hotel;
	}
	List<Hotel>getHotels() {
		return hotels;
	}

	/**
	 * Parses XML document.
	 *
	 * @param validate
	 *            If true validate XML document against its XML schema. With this
	 *            parameter it is possible make parser validating.
	 */
	public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {

		// obtain Practice7 parser factory
		SAXParserFactory factory = SAXParserFactory.newInstance();

		// XML document contains namespaces
		factory.setNamespaceAware(true);

		// set validation
		if (validate) {
			factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
			factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
		}
		javax.xml.parsers.SAXParser parser;
		parser = factory.newSAXParser();
		parser.parse(xmlFileName, this);
	}

	public Tourist_vouchers getTourist_vouchers() {
		return tourist_vouchers;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print(qName);
		currentElement = localName;

		if (XML.TOURISTSVOUCHERS.value().equals(currentElement)) {
			tourist_vouchers = new Tourist_vouchers();
			return;
		}
		if (XML.HOTEL.value().equals(currentElement)) {
			hotel = new Hotel();
			return;
		}

		if (XML.COST.value().equals(currentElement)) {
			cost = new Cost();
		}
		isStars = XML.STARS.value().equals(localName);
		isDays = XML.DAYS.value().equals(localName);
		isTransport = XML.TRANSPORT.value().equals(localName);
		isMeal = XML.MEAL.value().equals(localName);

	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		System.out.println("Value: " + new String(ch, start, length));
		if (hotel != null && isStars) {
			hotel.setStars(new String(ch, start, length));
		}
		if (hotel != null && isDays) {
			hotel.setDays(new String(ch, start, length));
		}
		if (hotel != null && isTransport) {
			hotel.setTransport(new String(ch, start, length));
		}
		if (hotel != null && isMeal) {
			hotel.setMeal(new String(ch, start, length));
		}

	}

	@Override
	public void error(org.xml.sax.SAXParseException e) throws SAXException {
		// if XML document not valid just throw exception
		throw e;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (XML.HOTEL.value().equals(localName)) {
			hotels.add(hotel);
			return;
		}
	}

}
