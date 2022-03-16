package ui;

import jdk.nashorn.internal.scripts.JO;
import model.FootWear;
import model.HeadWear;
import model.LowerWear;
import model.UpperWear;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIRunner implements ActionListener {
    JButton addItem;
    JButton removeItem;
    JButton openListingWindow;
    JButton addOutfit;
    JButton openOutfitWindow;
    JFrame frame;
    ImageIcon logo = new ImageIcon("./assets/demoImage1.png");
    ImageIcon randClothing = new ImageIcon("./assets/randomImage.png");
    DressMeApp backUI;

    public UIRunner(DressMeApp dressMeApp) {
        pickerFrameSetup();
        this.backUI = dressMeApp;
    }

    public void pickerFrameSetup() {
        frame = new JFrame(); // creates a outfitFrame
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
        hatLeft.setText("<-");
        upperLeft.setText("<-");
        lowerLeft.setText("<-");
        bottomLeft.setText("<-");
        hatRight.setText("->");
        upperRight.setText("->");
        lowerRight.setText("->");
        bottomRight.setText("->");


        this.frame.setSize(850, 500); // sets x and y dimensions of outfitFrame
        this.frame.setVisible(true);
        this.frame.setTitle("Dress.Me!");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(0xdabaff));
        this.frame.setLayout(new GridBagLayout());
        GridBagConstraints setup = new GridBagConstraints();
        JPanel leftArrowPanel = new JPanel(new GridBagLayout());
        JPanel centrePanel = new JPanel(new GridBagLayout());
        JPanel rightArrowPanel = new JPanel(new GridBagLayout());
        JPanel optionsPanel = new JPanel(new GridBagLayout());
        JLayeredPane midPanelLayers = new JLayeredPane();

        GridBagConstraints arrowConstraints = new GridBagConstraints();
        GridBagConstraints midConstraints = new GridBagConstraints();
        GridBagConstraints optionsConstraints = new GridBagConstraints();
        optionsConstraints.insets = new Insets(10,0,10,0);

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
        addItem.addActionListener(this);
        optionsPanel.add(addItem, optionsConstraints);
        optionsConstraints.gridy = 1;
        removeItem.addActionListener(this);
        optionsPanel.add(removeItem, optionsConstraints);
        optionsConstraints.gridy = 2;
        openListingWindow.addActionListener(this);
        optionsPanel.add(openListingWindow, optionsConstraints);
        optionsConstraints.gridy = 3;
        addOutfit.addActionListener(this);
        optionsPanel.add(addOutfit, optionsConstraints);
        optionsConstraints.gridy = 4;
        openOutfitWindow.addActionListener(this);
        optionsPanel.add(openOutfitWindow, optionsConstraints);

        JLabel clothingObj = new JLabel();
        clothingObj.setText("Index X Name X");
        clothingObj.setVerticalTextPosition(SwingConstants.TOP);
        clothingObj.setHorizontalTextPosition(SwingConstants.CENTER);
        ImageIcon scaledImage = new ImageIcon(
                randClothing.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        clothingObj.setIcon(scaledImage);
        clothingObj.setMaximumSize(new Dimension(10, 10));
        centrePanel.add(clothingObj);

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
        //outfitFrame.repaint();
        //outfitFrame.getContentPane();
        //outfitFrame.setResizable(false);
    }

    void outfitFrameSetup() {
        frame = new JFrame();
        frame.setSize(850, 500); // sets x and y dimensions of outfitFrame
        frame.setVisible(true);
        frame.setTitle("Outfit Window");
        frame.getContentPane().setBackground(new Color(0x9dd4d4));
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel x = new JLabel();
        x.setText("Outfit Window");
        frame.add(x);

        // Show up controllers below
        frame.revalidate();
        frame.repaint();
        frame.getContentPane();
        frame.setResizable(false);
    }


    void listingFrameSetup() {
        frame = new JFrame();
        frame.setSize(850, 500); // sets x and y dimensions of outfitFrame
        frame.setVisible(true);
        frame.setTitle("Listing Window");
        frame.getContentPane().setBackground(new Color(0xCBCBCB));
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel x = new JLabel();
        x.setText("Listing Window");
        frame.add(x);

        // Show up controllers below
        frame.revalidate();
        frame.repaint();
        frame.getContentPane();
        frame.setResizable(false);
    }

    // Stuff for add
    JComboBox superTypeSelect;
    JFrame addFrame;
    JTextField nameField;
    JTextField formalityField;
    GridBagConstraints addConstraints;

    void launchAdditionWindow() {
        addFrame = new JFrame();
        addFrame.setSize(200, 500);
        JLabel wtText = new JLabel("Enter Wear Type");
        JLabel nText = new JLabel("Enter Clothing Name below");
        JLabel fText = new JLabel("Enter Clothing formality");
        String[] wearTypes = {"Head Wear", "Upper Wear", "Lower Wear", "Footwear"};
        superTypeSelect = new JComboBox(wearTypes);
        superTypeSelect.addActionListener(this);
        nameField = new JTextField("Name");
        formalityField = new JTextField("Formality");

        addFrame.setVisible(true);
        addFrame.setLayout(new FlowLayout());
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.add(wtText);
        addFrame.add(superTypeSelect);
        addFrame.add(nText);
        addFrame.add(nameField);
        addFrame.add(fText);
        addFrame.add(formalityField);

        // Kind should be determines beforehand
        // Colour should be a color
        addFrame.revalidate();
    }

    void launchRemoveWindow() {
        String answer = JOptionPane.showInputDialog("What Index would you like to remove?");
        int index;
        if (answer != null) {
            try {
                index = Integer.parseInt(answer);
                Boolean flag = backUI.userWardrobe.removeItemByIndex(index);
                if (flag) {
                    JOptionPane.showMessageDialog(null,
                            "Index " + index + " removed successfully",
                            "Operation Successful", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Index " + index + " not found",
                            "Operation Unsuccessful", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Please only enter a number", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void addOutfitFromSelected() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openOutfitWindow) {
            frame.dispose();
            outfitFrameSetup();
        } else if (e.getSource() == openListingWindow) {
            frame.dispose();
            listingFrameSetup();
        } else if (e.getSource() == addItem) {
            launchAdditionWindow();
        } else if (e.getSource() == removeItem) {
            launchRemoveWindow();
        } else if (e.getSource() == addOutfit) {
            addOutfitFromSelected();
        } else if (e.getSource() == superTypeSelect) {
            int selIndex = superTypeSelect.getSelectedIndex();
            String[] acceptableItems;
            if (selIndex == 0) {
                acceptableItems = model.HeadWear.getAcceptableItems();
            } else if (selIndex == 1) {
                acceptableItems = model.UpperWear.getAcceptableItems();
            } else if (selIndex == 2) {
                acceptableItems = model.LowerWear.getAcceptableItems();
            } else {
                acceptableItems = model.FootWear.getAcceptableItems();
            }
            if (selIndex == 0) {

            } else if (selIndex == 1) {

            } else if (selIndex == 2) {

            } else if (selIndex == 3) {

            }
        }
    }
}
