package main.de.Kilso.hunted.game;

import main.de.Kilso.hunted.frame.GameFrame;

public class InputHandler {

    private GameFrame readingInstance;

    private InputHandler(GameFrame frame) {
        readingInstance = frame;
    }

    public static InputHandler createByFrame(GameFrame frame) {
        return new InputHandler(frame);
    }
}