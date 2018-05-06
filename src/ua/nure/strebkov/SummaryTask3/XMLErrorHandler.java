package ua.nure.strebkov.SummaryTask3;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.FileAppender;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;


import java.io.IOException;


public class XMLErrorHandler implements ErrorHandler {
    private Logger logger;
    private boolean isValid = true;

    public XMLErrorHandler(String log) throws IOException {
        logger = Logger.getLogger("error");
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public void warning(SAXParseException exception) {
        logger.warn(getLineAddress(exception) + "-" + exception.getMessage());
        isValid = false;
    }

    @Override
    public void error(SAXParseException exception)  {
        logger.error(getLineAddress(exception) + " - " + exception.getMessage());
        isValid = false;
    }

    @Override
    public void fatalError(SAXParseException exception) {
        logger.fatal(getLineAddress(exception) + " - " + exception.getMessage());
        isValid = false;
    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
