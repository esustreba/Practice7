package ua.nure.strebkov.SummaryTask3.handlers;
import java.io.IOException;

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
    private Cost cost;




    public SAXController(String xmlFileName) {

        this.xmlFileName = xmlFileName;
    }

    /**
     * Parses XML document.
     *
     * @param validate
     *            If true validate XML document against its XML schema. With
     *            this parameter it is possible make parser validating.
     */
    public void parse(boolean validate)
            throws ParserConfigurationException, SAXException, IOException {

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
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = localName;

        if(XML.TOURISTSVOUCHERS.value().equals(currentElement)) {
            tourist_vouchers = new Tourist_vouchers();
            return;
        }
        if(XML.HOTEL.value().equals(currentElement)) {
           hotel = new Hotel();
           return;
        }
        if(XML.COST.value().equals(currentElement)) {
            cost = new Cost();
        }


    }

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
        // if XML document not valid just throw exception
        throw e;
    }






    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {


    }

    public static void main(String[] args) throws Exception {

       SAXController saxController = new SAXController(Constants.VALID_XML_FILE);
       saxController.parse(true);

    }
}
