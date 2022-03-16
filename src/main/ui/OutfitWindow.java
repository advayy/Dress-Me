package ui;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class OutfitWindow extends DressMeApp {
    JFrame OutfitFrame = new JFrame();

    public OutfitWindow() {
    }

    @Override
    void frameSetup() {
        this.OutfitFrame.setSize(800, 500); // sets x and y dimensions of OutfitFrame
        this.OutfitFrame.setVisible(true);
        this.OutfitFrame.setTitle("Listing Window");
        this.OutfitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.OutfitFrame.getContentPane().setBackground(new Color(0xdabaff));
        this.OutfitFrame.setLayout(new GridBagLayout());
    }
}
