package ua.nure.strebkov.SummaryTask3.handlers;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.strebkov.SummaryTask3.constants.Constants;
import ua.nure.strebkov.SummaryTask3.entity.*;


public class SAXHandler extends DefaultHandler {

    private String xmlFileName;

    // current element name holder
    private String currentElement;

    // main container


    public SAXHandler(String xmlFileName) {
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

        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlFileName, this);
    }

    // ///////////////////////////////////////////////////////////
    // ERROR HANDLER IMPLEMENTATION
    // ///////////////////////////////////////////////////////////

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
        // if XML document not valid just throw exception
        throw e;
    }




    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = localName;


    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        String elementText = new String(ch, start, length).trim();

        // return if content is empty
        if (elementText.isEmpty()) {
            return;
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {


    }

    public static void main(String[] args) throws Exception {

        // try to parse valid XML file (success)
        SAXHandler saxContr = new SAXHandler(Constants.VALID_XML_FILE);

        // do parse with validation on (success)
        saxContr.parse(true);


        // we have Test object at this point:
        System.out.println("====================================");
        //System.out.print("Here is the test: \n" + test);
        System.out.println("====================================");

        // now try to parse NOT valid XML (failed)
        saxContr = new SAXHandler(Constants.INVALID_XML_FILE);
        try {
            // do parse with validation on (failed)
            saxContr.parse(true);
        } catch (Exception ex) {
            System.err.println("====================================");
            System.err.println("Validation is failed:\n" + ex.getMessage());
            //System.err.println("Try to print test object:" + saxContr.getTest());
            System.err.println("====================================");
        }

        // and now try to parse NOT valid XML with validation off (success)
        saxContr.parse(false);

        // we have Test object at this point:
        System.out.println("====================================");
        //System.out.print("Here is the test: \n" + saxContr.getTest());
        System.out.println("====================================");
    }
}
