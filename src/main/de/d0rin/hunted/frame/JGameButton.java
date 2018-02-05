package main.de.d0rin.hunted.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class JGameButton extends JButton {
    private boolean mouseEntered;

    private BufferedImage buttonImage,
            buttonImagePressed;


    private JGameButton(BufferedImage image, BufferedImage imagePressed) {
        buttonImage = image;
        buttonImagePressed = imagePressed;

        addMouseListener(new JGameButton.MouseButtonPressedListener());
    }

    public static JGameButton createJGameButtonWithImageAndPressed(BufferedImage image, BufferedImage imagePressed) {
        return new JGameButton(image, imagePressed);
    }

    public void paintComponent(Graphics g) {
        if (mouseEntered) {
            g.drawImage(buttonImagePressed.getScaledInstance(getWidth(), getHeight(), BufferedImage.SCALE_DEFAULT), 0, 0, null);
        } else {
            g.drawImage(buttonImage.getScaledInstance(getWidth(), getHeight(), BufferedImage.SCALE_DEFAULT), 0, 0, null);
        }
    }

    private class MouseButtonPressedListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mouseEntered(e);
            setMousePressed(true);
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseExited(e);
            setMousePressed(false);
            repaint();
        }
    }

    private void setMousePressed(boolean mousePressed) {
        this.mouseEntered = mousePressed;
    }
}
