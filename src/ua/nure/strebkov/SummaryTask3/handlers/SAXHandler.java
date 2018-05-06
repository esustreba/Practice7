package ua.nure.strebkov.SummaryTask3.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.strebkov.SummaryTask3.constants.Constants;
import ua.nure.strebkov.SummaryTask3.constants.XML;
import ua.nure.strebkov.SummaryTask3.entity.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXHandler extends DefaultHandler {
    private TouristVouchers touristVouchers;
    private TouristVousher touristVousher;
    private Cost cost;

    private String currentElement;
    private String fileName;

    public SAXHandler(String fileName) {
        this.fileName = fileName;
    }

    public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true);
        if (validate) {
            saxParserFactory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
            saxParserFactory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(fileName, this);
    }

    public TouristVousher getTouristVousher() {
        return touristVousher;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = localName;

        if (XML.TOURISTSVOUCHERS.value().equals(currentElement)) {
            touristVouchers = new TouristVouchers();
            return;
        }
        if (XML.TOURISTSVOUCHER.value().equals(currentElement)) {
            touristVouchers = new TouristVouchers();
            return;
        }
        if (XML.COST.value().equals(currentElement)) {
            cost = new Cost();
            return;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String element = new String(ch, start, length).trim();

        if (element.isEmpty()) {
            return;
        }

        if (XML.TYPE.value().equals(currentElement)) {
            touristVousher.setType(element);

        }
        if (XML.TRANSPORT.value().equals(currentElement)) {
            touristVousher.setTransport(element);

        }
        if (XML.MEALS.value().equals(currentElement)) {
            touristVousher.setMeals(element);

        }
        if (XML.ROOM.value().equals(currentElement)) {
            touristVousher.setRooms(element);

        }
        if (XML.COST.value().equals(currentElement)) {
            touristVousher.setCoast(element);
            return;
        }


        }



    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (XML.TOURISTSVOUCHER.value().equals(localName)) {
            touristVouchers.getTouristVoucher().add(touristVousher);
            return;
        }

        if (XML.COST.value().equals(localName)) {
            touristVousher.setCoast(cost);
            cost = null;
            return;
        }
    }


}
