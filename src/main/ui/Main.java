package ui;


import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        JWindow window = new JWindow();
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
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        window.dispose();
        new DressMeApp();
    }
}
