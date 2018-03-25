package main.de.Kilso.hunted.initialization.xml;

import main.de.Kilso.hunted.game.field.FieldData;
import main.de.Kilso.hunted.main.config.FilePaths;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class XMLInterpreter {
    XMLAdapter adapter;

    String mapIndexPath;
    List<FieldData> maps;
    List<String> mapImages;

    private XMLInterpreter(String mapIndexPath) {
        try {
            adapter = XMLAdapter.create();
        } catch(SAXException saxe) {
            System.out.println("Error while initializing the Adapter");
        }

        this.mapIndexPath = mapIndexPath;
        this.maps = new LinkedList<>();
    }

    public static XMLInterpreter createByMapIndexPath(String mapIndexPath) {
        return new XMLInterpreter(mapIndexPath);
    }


    public List<FieldData> interpreteMapXML() throws IOException, SAXException {

        List<FieldData> returnMap = new LinkedList<>();
        List<String> mapPaths = interpretMapPaths(mapIndexPath);
        for (Iterator<String> it = mapPaths.iterator(); it.hasNext(); ) {
            returnMap.add(interpreteMapData(it.next()));
        }
        return returnMap;
    }
    //TODO interprete Maps(to FieldObjects) + MapIndex(to List<String> (Paths of Map XML Files)) using XMLAdapter (files to Structures)
    private List<String> interpretMapPaths(String mapIndexpath) throws IOException, SAXException {//TODO
        Document parsedMapindex = adapter.parseFile(new File(mapIndexpath));
        Element e = parsedMapindex.getDocumentElement();
        adapter.printTreeNode(e);
    }

    private FieldData interpreteMapData(String MapPath) {
        //TODO
    }


    public List<String> getMapImages() {
        return mapImages;
    }
}