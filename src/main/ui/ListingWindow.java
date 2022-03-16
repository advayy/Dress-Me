package ui;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class ListingWindow extends DressMeApp {
    JFrame frame = new JFrame();

    public ListingWindow() {
    }

    @Override
    void frameSetup() {
        this.frame.setSize(800, 500); // sets x and y dimensions of frame
        this.frame.setVisible(true);
        this.frame.setTitle("Listing Window");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(0xdabaff));
        this.frame.setLayout(new GridBagLayout());

    }
}
