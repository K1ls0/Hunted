package main.de.Kilso.hunted.initialization.xml;

import main.de.Kilso.hunted.initialization.xml.exceptions.XMLHandler;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class XMLAdapter {
    private int indent = 0;

    private PrintWriter exceptionOut;

    private DocumentBuilder parser;




    private XMLAdapter() throws SAXException{
        try {
            exceptionOut = new PrintWriter(new OutputStreamWriter(System.err, "UTF-8"),
                    true);
            parser = setupParser();
        } catch (UnsupportedEncodingException uee) {
            exceptionOut.println("Error with the Charset");
            uee.printStackTrace();
        } catch (ParserConfigurationException pcE) {
            exceptionOut.println("XML Parser could not being set up correctly:");
            pcE.printStackTrace();
        }

    }
    public static XMLAdapter create() throws SAXException {
        return new XMLAdapter();
    }



    private DocumentBuilder setupParser() throws ParserConfigurationException {
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();

        fac.setCoalescing(true);
        fac.setIgnoringComments(true);

        fac.setNamespaceAware(true);
        fac.setValidating(true);

        DocumentBuilder db = fac.newDocumentBuilder();
        db.setErrorHandler(XMLHandler.create(exceptionOut));

        return db;
    }

    public Document parseFile(File f) throws SAXException, IOException {

        return parser.parse(f);
    }

    public void printTreeNode(Node n) {

        PrintStream output = System.out;
        int type = n.getNodeType();


        switch (type) {
            case Node.ATTRIBUTE_NODE:
                output.println("ATTRIBUTE:");
                printNode(n);
                break;
            case Node.CDATA_SECTION_NODE:
                output.println("CDATA:");
                printNode(n);
                break;
            case Node.COMMENT_NODE:
                output.print("COMMENT:");
                printNode(n);
                break;
            case Node.DOCUMENT_FRAGMENT_NODE:
                output.println("DOC_FRAG:");
                printNode(n);
                break;
            case Node.DOCUMENT_NODE:
                output.println("DOC:");
                printNode(n);
                break;
            case Node.DOCUMENT_TYPE_NODE:
                output.println("DOC_TYPE:");
                printNode(n);

                NamedNodeMap nodeMap = ((DocumentType)n).getEntities();
                indent += 2;
                for (int i = 0; i < nodeMap.getLength(); i++) {
                    printTreeNode(nodeMap.item(i));
                }
                indent -= 2;
                break;
            case Node.ELEMENT_NODE:
                output.println("ELEMENT:");
                printNode(n);

                indent += 2;
                NamedNodeMap atts = n.getAttributes();
                for (int i = 0; i < atts.getLength(); i++) {
                    printTreeNode(atts.item(i));
                }
                indent--;
                break;
            case Node.ENTITY_NODE:
                output.println("ENTITY:");
                printNode(n);
                break;
            case Node.ENTITY_REFERENCE_NODE:
                output.println("ENTITY_REF:");
                printNode(n);
                break;
            case Node.NOTATION_NODE:
                output.println("NOTATION:");
                printNode(n);
                break;
            case Node.PROCESSING_INSTRUCTION_NODE:
                output.println("PROC_INSTR:");
                printNode(n);
                break;
            case Node.TEXT_NODE:
                output.println("TEXT");
                printNode(n);
                break;
            default:
                output.println("UNSUPPORTED NODE:");
                printNode(n);
                break;
        }
        indent++;
        for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
            printTreeNode(child);
        }
        indent--;

    }

    public void printNode(Node n) {
        StringBuffer output = new StringBuffer();
        output.append("\n" + separator() + "Node: \"" + n.getNodeName() + "\"");
        indent++;
        if (n.getNamespaceURI() != null) {
            output.append("\n" + separator() + "uri: \"" + n.getNamespaceURI() + "\"");
        }

        if (n.getPrefix() != null) {
            output.append("\n" + separator() + "pre: \"" + n.getPrefix() + "\"");
        }

        if (n.getLocalName() != null) {
            output.append("\n" + separator() + "Local Name: \"" + n.getLocalName() + "\"");
        }

        if (n.getNodeValue() != null) {
            output.append("\n" + separator() + "NodeValue: \"" + (n.getNodeValue().trim().equals("") ? "[WS]" : n.getNodeValue()) + "\"");
        }
        indent--;
        System.out.println(output.toString());
    }

    private String separator() {
        StringBuffer returnBuffer = new StringBuffer();
        for (int i = 0; i < indent; i++) {
            returnBuffer.append("   ");
        }
        return returnBuffer.toString();
    }
}
