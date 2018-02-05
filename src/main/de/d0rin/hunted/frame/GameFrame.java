package main.de.d0rin.hunted.frame;

import main.de.d0rin.hunted.game.misc.GUIPart;
import main.de.d0rin.hunted.game.exceptions.IllegalKeyException;
import main.de.d0rin.hunted.initialization.GraphicData;
import main.de.d0rin.hunted.main.config.Constants;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GraphicData frameData;

    private Container gameFrameContainer;
    private JGamePanel gamePanel;
    private JGameToggleButton[] directionButtons; //around the clock, starting in upper direction
    private JRadioButton[] actionButtons;
    private ButtonGroup directionGroup, actionGroup;
    private JGameButton startRound;

    private char currentActionAmount = 0;

    private GraphicData builder;

    public static GameFrame createGameFrameFromGraphicLoader(GraphicData builder) {
        return new GameFrame(builder);
    }


    private GameFrame(GraphicData builder) {
        frameData = builder;

        gameFrameContainer = getContentPane();

        setupGamePanel();

        setupDirectionButtons();

        setupActionButtons();

        setupStartRoundButton();

        setupFrameSettings();
    }

    private void setupGamePanel() {
        gamePanel = JGamePanel.createFromGraphicLoader(builder);

        addToContainer(gamePanel);
    }

    private void setupDirectionButtons() {
        directionButtons = new JGameToggleButton[4];
        try {
            directionButtons[0] = JGameToggleButton.createJGameButtonWithImagesPressed(
                    frameData.getImageByKey(GUIPart.NorthButton),
                    frameData.getImageByKey(GUIPart.NorthButtonSel),
                    frameData.getImageByKey(GUIPart.NorthButtonPressed));
            directionButtons[1] = JGameToggleButton.createJGameButtonWithImagesPressed(
                    frameData.getImageByKey(GUIPart.EastButton),
                    frameData.getImageByKey(GUIPart.EastButtonSel),
                    frameData.getImageByKey(GUIPart.EastButtonPressed));
            directionButtons[2] = JGameToggleButton.createJGameButtonWithImagesPressed(
                    frameData.getImageByKey(GUIPart.SouthButton),
                    frameData.getImageByKey(GUIPart.SouthButtonSel),
                    frameData.getImageByKey(GUIPart.SouthButtonPressed));
            directionButtons[3] = JGameToggleButton.createJGameButtonWithImagesPressed(
                    frameData.getImageByKey(GUIPart.WestButton),
                    frameData.getImageByKey(GUIPart.WestButtonSel),
                    frameData.getImageByKey(GUIPart.WestButtonPressed));


            for (JToggleButton currentButton: directionButtons) {
                addToContainer(currentButton);
            }
        } catch (IllegalKeyException ike) {
            System.out.println("directionButtons could not been initialized");
            ike.printStackTrace();
        }
    }

    private void setupActionButtons() {
        actionButtons = new JRadioButton[Constants.MAX_ACTION_AMOUNT];

        for (char i = 0; i < actionButtons.length; i++) {
            actionButtons[i] = new JRadioButton();
            actionButtons[i].setVisible(false);
            addToContainer(actionButtons[i]);
        }
    }

    private void setupStartRoundButton() {

        addToContainer(startRound);
    }

    private void setupFrameSettings() {
        setTitle(Constants.GAMENAME + "  Version: " + Constants.VERSION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Constants.FRAMEDIMENSION);
        setVisible(true);
    }


    public void reloadActionButtons(int actionAmount) {
        for (char i = 0; i < actionAmount; i++) {
            actionButtons[i].setVisible(true);
            actionButtons[i].repaint();
            doisgpzz
        }
    }


    private void addToContainer(Component c) {
        gameFrameContainer.add(c);
    }
}