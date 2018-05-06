package ua.nure.strebkov.SummaryTask3;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;


public class XMLValidator {
    public static boolean isValidXml(String filename) {
        DOMParser parser = new DOMParser();
        try {
            XMLErrorHandler errorHandler = new XMLErrorHandler("log.txt");
            parser.setErrorHandler(errorHandler);
            parser.setFeature("http://xml.org/sax/features/validation", true);
            parser.setFeature("http://apache.org/xml/features/validation/schema", true);
            parser.parse(filename);
            return errorHandler.isValid();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
