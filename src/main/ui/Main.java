package ui;

import javax.swing.*;
import java.awt.*;

// Launches app and displays splash screen
public class Main {
    public static void main(String[] args) {
        int userComputerHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        int userComputerWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
        int width = 600;
        int height = 500;
        int locationX = userComputerWidth / 2 - width / 2;
        int locationY = userComputerHeight / 2 - height / 2;
        JWindow splashScreen = new JWindow();
        splashScreen.setLocation(locationX, locationY);
        splashScreen.setSize(new Dimension(width, height));
        JLabel splashGifLabel = new JLabel();
        splashGifLabel.setIcon(new ImageIcon("./assets/Clueless_Splash_Screen.gif"));
        splashScreen.add(splashGifLabel);
        splashScreen.setVisible(true);
        splashScreen.repaint();
        splashScreen.revalidate();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splashScreen.setVisible(false);
        splashScreen.dispose();
        new DressMeApp();
    }
}
