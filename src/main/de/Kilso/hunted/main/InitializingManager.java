package main.de.Kilso.hunted.main;

import main.de.Kilso.hunted.initialization.png.MapInterpreter;
import main.de.Kilso.hunted.initialization.xml.MapPropInterpreter;
import main.de.Kilso.hunted.initialization.xml.XMLAdapter;

public class InitializingManager {

    private XMLAdapter xmlFunctions;

    private MapPropInterpreter propInterprete;
    private MapInterpreter mapInterprete;

    private InitializingManager() {
        xmlFunctions = XMLAdapter.create();
        propInterprete = MapPropInterpreter.create();
        mapInterprete = MapInterpreter.createMapInterpreterByImage();
    }
    public static InitializingManager create() {
        return new InitializingManager();
    }


}
