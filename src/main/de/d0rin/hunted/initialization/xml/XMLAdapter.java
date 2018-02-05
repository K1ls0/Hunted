package main.de.d0rin.hunted.initialization.xml;

import main.de.d0rin.hunted.initialization.xml.exceptions.SAXHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class XMLAdapter {

    private SAXHandler handler;

    private SAXParser parser;


    private XMLAdapter() throws SAXException{
        handler = SAXHandler.create();
        parser = setupParser();
    }
    public static XMLAdapter create() {
        return new XMLAdapter();
    }

    public void parseFile(File f) throws SAXException, ParserConfigurationException {

        XMLReader fileReader = parser.getXMLReader();
    }

    private SAXParser setupParser() throws SAXException, ParserConfigurationException {
        SAXParserFactory fac = SAXParserFactory.newInstance();
        fac.setNamespaceAware(true);
        fac.setValidating(true);
        return fac.newSAXParser();
    }

}
