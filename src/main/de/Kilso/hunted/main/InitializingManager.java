package main.de.Kilso.hunted.main;

import main.de.Kilso.hunted.initialization.png.MapInterpreter;
import main.de.Kilso.hunted.initialization.xml.XMLAdapter;
import main.de.Kilso.hunted.initialization.xml.XMLInterpreter;
import main.de.Kilso.hunted.main.config.FilePaths;
import org.xml.sax.SAXException;

import java.awt.image.BufferedImage;

public class InitializingManager {

    private XMLAdapter xmlFunctions;
    private XMLInterpreter xmlMapInterpreter;
    private MapInterpreter mapInterpreter;

    private InitializingManager() {
        //TODO
        try {
            xmlFunctions = XMLAdapter.create();
            xmlMapInterpreter = XMLInterpreter.createByMapIndexPath(FilePaths.MAP_INDEX);
            loadXMLFiles();
            //mapInterpreter = MapInterpreter.createMapInterpreterByImage(); --> for every Map Image in
        } catch (SAXException e) {
            System.err.println("couldn't interprete XML Files:");
            e.printStackTrace();

        }
    }

    private void loadXMLFiles() {

    }

    public static InitializingManager create() {
        return new InitializingManager();
    }


}
