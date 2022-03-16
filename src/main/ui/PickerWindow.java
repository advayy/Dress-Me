package ui;

import model.Colour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class PickerWindow extends DressMeApp implements ActionListener {
    JButton addItem;
    JButton removeItem;
    JButton openListingWindow;
    JButton addOutfit;
    JButton openOutfitWindow;

    public PickerWindow() {
    }

    @Override
    public void frameSetup() {
        addItem = new JButton();
        removeItem = new JButton();
        openListingWindow = new JButton();
        addOutfit = new JButton();
        openOutfitWindow = new JButton();
        JButton hatLeft = new JButton();
        JButton hatRight = new JButton();
        JButton upperLeft = new JButton();
        JButton upperRight = new JButton();
        JButton lowerLeft = new JButton();
        JButton lowerRight = new JButton();
        JButton bottomLeft = new JButton();
        JButton bottomRight = new JButton();

        frame.setSize(850, 500); // sets x and y dimensions of frame
        frame.setVisible(true);
        frame.setTitle("Dress.Me!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xdabaff));
        frame.setLayout(new GridBagLayout());
        GridBagConstraints setup = new GridBagConstraints();
        JPanel leftArrowPanel = new JPanel(new GridBagLayout());
        JPanel centrePanel = new JPanel(new GridBagLayout());
        JPanel rightArrowPanel = new JPanel(new GridBagLayout());
        JPanel optionsPanel = new JPanel(new GridBagLayout());
        JLayeredPane midPanelLayers = new JLayeredPane();

        GridBagConstraints arrowConstraints = new GridBagConstraints();
        GridBagConstraints midConstraints = new GridBagConstraints();
        GridBagConstraints optionsConstraints = new GridBagConstraints();
        optionsConstraints.insets = new Insets(20,0,20,0);

        centrePanel.add(midPanelLayers);
        arrowConstraints.insets = new Insets(30,0,30,0);
        arrowConstraints.gridy = 0;
        leftArrowPanel.add(hatLeft, arrowConstraints);
        rightArrowPanel.add(hatRight, arrowConstraints);
        arrowConstraints.gridy = 1;
        leftArrowPanel.add(upperLeft, arrowConstraints);
        rightArrowPanel.add(upperRight, arrowConstraints);
        arrowConstraints.gridy = 2;
        leftArrowPanel.add(lowerLeft, arrowConstraints);
        rightArrowPanel.add(lowerRight, arrowConstraints);
        arrowConstraints.gridy = 3;
        leftArrowPanel.add(bottomLeft, arrowConstraints);
        rightArrowPanel.add(bottomRight, arrowConstraints);

        addItem.setText("Add Item");
        removeItem.setText("Remove Item");
        openListingWindow.setText("See List View");
        addOutfit.setText("Add Outfit From Selected");
        openOutfitWindow.setText("See Outfits");
        optionsConstraints.gridy = 0;
        optionsPanel.add(addItem, optionsConstraints);
        optionsConstraints.gridy = 1;
        optionsPanel.add(removeItem, optionsConstraints);
        optionsConstraints.gridy = 2;
        optionsPanel.add(openListingWindow, optionsConstraints);
        optionsConstraints.gridy = 3;
        optionsPanel.add(addOutfit, optionsConstraints);
        optionsConstraints.gridy = 4;
        openOutfitWindow.addActionListener(this);
        optionsPanel.add(openOutfitWindow, optionsConstraints);

        setup.weightx = 1;
        frame.add(leftArrowPanel, setup);
        setup.weightx = 4;
        frame.add(centrePanel, setup);
        setup.weightx = 1;
        frame.add(rightArrowPanel, setup);
        setup.weightx = 2;
        frame.add(optionsPanel, setup);
        // Show up controllers below
        frame.revalidate();
        //frame.repaint();
        //frame.getContentPane();
        //frame.setResizable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openOutfitWindow) {
            OutfitWindow outfitWindow = new OutfitWindow();

        }

    }
}
