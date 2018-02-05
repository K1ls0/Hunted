package main.de.d0rin.hunted.frame;

import main.de.d0rin.hunted.game.misc.ButtonStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class JGameToggleButton extends JToggleButton {

    private ButtonStatus buttonStatus;

    private BufferedImage buttonImage,
    buttonImagePressed,
    buttonImageSel;


    private JGameToggleButton(BufferedImage image, BufferedImage imageSel, BufferedImage imagePressed) {
        buttonImage = image;
        buttonImageSel = imageSel;
        buttonImagePressed = imagePressed;

        addMouseListener(new MouseButtonPressedListener(this));
    }

    public static JGameToggleButton createJGameButtonWithImagesPressed(BufferedImage image, BufferedImage buttonImageSel, BufferedImage imagePressed){
        return new JGameToggleButton(image, buttonImageSel, imagePressed);
    }

    public void paintComponent(Graphics g) {
        if (buttonStatus == ButtonStatus.Press) {
            g.drawImage(buttonImagePressed.getScaledInstance(getWidth(), getHeight(), BufferedImage.SCALE_DEFAULT), 0, 0, null);
        } else if(buttonStatus == ButtonStatus.Selected) {
            g.drawImage(buttonImageSel.getScaledInstance(getWidth(), getHeight(), BufferedImage.SCALE_DEFAULT), 0, 0, null);
        } else {
            g.drawImage(buttonImage.getScaledInstance(getHeight(), getHeight(), BufferedImage.SCALE_DEFAULT), 0, 0, null);
        }
    }

    private class MouseButtonPressedListener extends MouseAdapter {

        private JGameToggleButton buttonInstance;

        private MouseButtonPressedListener(JGameToggleButton b) {
            buttonInstance = b;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (buttonStatus != ButtonStatus.Press && !buttonInstance.isSelected()) {
                setPressed(ButtonStatus.Press);
                buttonInstance.setSelected(true);
            }
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (buttonStatus != ButtonStatus.Press && !buttonInstance.isSelected()) {
                setPressed(ButtonStatus.Selected);
                buttonInstance.setSelected(true);
            }
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (buttonStatus != ButtonStatus.Press && !buttonInstance.isSelected()) {
                setPressed(ButtonStatus.Selected);
            }
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (buttonStatus != ButtonStatus.Press && !buttonInstance.isSelected()) {
                setPressed(ButtonStatus.Free);
            }
            repaint();
        }
    }

    private void setPressed(ButtonStatus pressed) {
        this.buttonStatus = pressed;
    }
}
