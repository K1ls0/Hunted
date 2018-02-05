package main.de.d0rin.hunted.game;

import main.de.d0rin.hunted.frame.GameFrame;

public class InputHandler {

    private GameFrame readingInstance;

    private InputHandler(GameFrame frame) {
        readingInstance = frame;
    }

    public static InputHandler createByFrame(GameFrame frame) {
        return new InputHandler(frame);
    }
}