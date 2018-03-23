package main.de.Kilso.hunted.initialization.xml;

import main.de.Kilso.hunted.initialization.xml.exceptions.XMLHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class XMLAdapter {

    private XMLHandler handler;

    private DocumentBuilder parser;


    private XMLAdapter() throws SAXException{
        handler = XMLHandler.create();
        try {
            parser = setupParser();
        } catch (ParserConfigurationException pcE) {
            System.out.println("XML Parser could not being set up correctly:");
            pcE.printStackTrace();
        }

    }
    public static XMLAdapter create() throws SAXException {
        return new XMLAdapter();
    }



    private DocumentBuilder setupParser() throws SAXException, ParserConfigurationException {
        try {
            DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();

            fac.setCoalescing(true);
            fac.setIgnoringComments(true);

            fac.setNamespaceAware(true);
            fac.setValidating(true);

            DocumentBuilder db = fac.newDocumentBuilder();
            db.setErrorHandler(XMLHandler.create(new PrintWriter(new OutputStreamWriter(System.err, "UTF-8"),
                    true)));

            return db;
        } catch (UnsupportedEncodingException uee) {
            throw new ParserConfigurationException("Error with the Charset");
        }
    }

    public Document parseFile(File f) throws SAXException, IOException {
        Document parsedFile = parser.parse(f);

        return ;
    }


    public static void printNode(Node n) {
        StringBuffer output = new StringBuffer();
        output.append("Node: \"" + n.getNodeName() + "\"" + separator());

        if (n.getNamespaceURI() != null) {
            output.append("uri: \"" + n.getNamespaceURI() + "\"" + separator());
        }

        if (n.getPrefix() != null) {
            output.append("pre: \"" + n.getPrefix() + "\"" + separator());
        }

        if (n.getLocalName() != null) {
            output.append("Local Name: \"" + n.getLocalName() + "\"" + separator());
        }

        if (n.getNodeValue() != null) {
            output.append("NodeValue: \"" + (n.getNodeValue().trim().equals("") ? "[WS]" : n.getNodeValue()) + "\"" + separator());
        }
        System.out.println(output.toString());
    }

    private static String separator() {
        return "\n  ";
    }
}
