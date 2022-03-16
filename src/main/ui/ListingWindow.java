package ui;

import javax.swing.*;
import java.awt.*;

public class ListingWindow extends DressMeApp {

    JFrame listingFrame; // creates a outfitFrame

    public ListingWindow() {
    }

    void frameSetup() {
        listingFrame = new JFrame();
        listingFrame.setSize(800, 500); // sets x and y dimensions of outfitFrame
        listingFrame.setVisible(true);
        listingFrame.setTitle("Listing Window");
        listingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listingFrame.getContentPane().setBackground(new Color(0xdabaff));
        listingFrame.setLayout(new GridBagLayout());


        // Show up controllers below
        listingFrame.revalidate();
        //listingFrame.repaint();
        //listingFrame.getContentPane();
        //listingFrame.setResizable(false);
    }
}
