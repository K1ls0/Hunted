package main.de.d0rin.hunted.initialization.xml.exceptions;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;

public class SAXHandler extends DefaultHandler {

    private Hashtable<String, Integer> exceptionTags;

    public static SAXHandler create() {
        return new SAXHandler();
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
            System.out.println("local Name |" +
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
}