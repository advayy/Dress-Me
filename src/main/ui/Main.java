package ui;


import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        JWindow window = new JWindow();
        int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
        int locationX = width / 2 - 400;
        int locationY = height / 2 - 250;
        window.setLocation(locationX, locationY);
        window.setSize(new Dimension(800, 500));
        ImageIcon gif = new ImageIcon("./assets/Clueless_Splash_Screen.gif");
        JLabel gifL = new JLabel();
        gifL.setIcon(gif);
        window.add(gifL);
        //window.getContentPane().add();
        window.setVisible(true);
        window.repaint();
        window.revalidate();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        window.dispose();
        new DressMeApp();
    }
}
