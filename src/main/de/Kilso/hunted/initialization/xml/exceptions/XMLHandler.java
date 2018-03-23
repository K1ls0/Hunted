package main.de.Kilso.hunted.initialization.xml.exceptions;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

public class XMLHandler extends DefaultHandler {

    private Hashtable<String, Integer> exceptionTags;
    PrintWriter out;

    private XMLHandler(PrintWriter out) {
        this.out = out;
    }

    public static XMLHandler create(PrintWriter out) {
        return new XMLHandler(out);
    }

    public void startDocument() throws SAXException {
        exceptionTags = new Hashtable<>();
    }

    public void startElement(String uri, String tag, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, tag, qName, attributes);

        if (exceptionTags.get(tag) != null) {
            exceptionTags.put(tag, exceptionTags.get(tag) + 1);
        } else {
            exceptionTags.put(tag, 1);
        }
    }

    public void endDocument() throws SAXException{
        Enumeration<String> e = exceptionTags.keys();
        while (e.hasMoreElements()) {
            String currentTag = e.nextElement();
            out.println("local Name |" +
                            currentTag + "| Got Exception " +
                            exceptionTags.get(currentTag) + "times"
                    );
        }
    }

    private static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }

    public void warning(SAXParseException spe) {
        out.println("Warning: " + getParseExceptionInfo(spe));
    }

    public void error(SAXParseException spe) throws SAXException {
        throw new SAXException("Error: " + getParseExceptionInfo(spe));
    }

    public void fatalError(SAXParseException spe) throws SAXException {
        throw new SAXException("Fatal Error: " + getParseExceptionInfo(spe));
    }

    private String getParseExceptionInfo(SAXParseException spe) {
        return "URI: " + (spe.getSystemId() == null ? "null" : spe.getSystemId()) + "  Line: " + spe.getLineNumber() + "\nMessage: " + spe.getMessage();
    }
}