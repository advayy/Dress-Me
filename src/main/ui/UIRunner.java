package ui;

import model.*;

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

    JLabel wtText;
    JLabel nameText;
    JLabel formalityText;

    JPanel leftArrowPanel;
    JPanel rightArrowPanel;
    JPanel centrePanel;
    JPanel optionsPanel;
    ImageIcon headWearIcon;
    ImageIcon upperWearIcon;
    ImageIcon lowerWearIcon;
    ImageIcon footwearIcon;
    JButton hatLeft;
    JButton hatRight;
    JButton upperLeft;
    JButton upperRight;
    JButton lowerLeft;
    JButton lowerRight;
    JButton bottomLeft;
    JButton bottomRight;
    JLabel upperLabel;
    JLabel upperText;
    JLabel headLabel;
    JLabel headText;
    JLabel lowerLabel;
    JLabel lowerText;
    JLabel bottomLabel;
    JLabel bottomText;
    int currH = 0;
    int currU = 0;
    int currL = 0;
    int currF = 0;
    DressMeApp backUI;

    int userScreenHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
    int userScreenWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
    int locationX = userScreenWidth / 2 - 400;
    int locationY = userScreenHeight / 2 - 250;


    // Stuff for add
    JComboBox superTypeSelect;
    JFrame addFrame;
    JTextField nameField;
    JTextField formalityField;
    ButtonGroup subType;
    JRadioButton b1;
    JRadioButton b2;
    JRadioButton b3;
    JRadioButton b4;
    JLabel subtypeText;
    JButton getColour;
    JButton confirmation;
    Color selectedOutfitColour;

    public UIRunner(DressMeApp dressMeApp) {
        this.backUI = dressMeApp;
        pickerFrameSetup();
        b1 = new JRadioButton();
        b2 = new JRadioButton();
        b3 = new JRadioButton();
        b4 = new JRadioButton();
    }

    public void pickerFrameSetup() {
        frame = new JFrame(); // creates a outfitFrame
        frame.setLocation(locationX, locationY);
        frame.setSize(850, 500); // sets x and y dimensions of outfitFrame
        frame.setVisible(true);
        frame.setTitle("Dress.Me!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xdabaff));
        frame.setLayout(new GridBagLayout());
        setArrowButtons();
        addArrowButtonsIn();
        setupOptionsPanel();
        setupCentrePanel();
        GridBagConstraints setup = new GridBagConstraints();
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
        // outfitFrame.repaint();
        // outfitFrame.getContentPane();
        // outfitFrame.setResizable(false);
        // frame.pack();
    }

    void setArrowButtons() {
        hatLeft = new JButton("<-");
        hatRight = new JButton("->");
        upperLeft = new JButton("<-");
        upperRight = new JButton("->");
        lowerLeft = new JButton("<-");
        lowerRight = new JButton("->");
        bottomLeft = new JButton("<-");
        bottomRight = new JButton("->");
        hatLeft.addActionListener(this);
        upperLeft.addActionListener(this);
        lowerLeft.addActionListener(this);
        bottomLeft.addActionListener(this);
        hatRight.addActionListener(this);
        upperRight.addActionListener(this);
        lowerRight.addActionListener(this);
        bottomRight.addActionListener(this);
    }

    void addArrowButtonsIn() {
        leftArrowPanel = new JPanel(new GridBagLayout());
        rightArrowPanel = new JPanel(new GridBagLayout());
        GridBagConstraints arrowConstraints = new GridBagConstraints();
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
    }

    void setupOptionsPanel() {
        setupOptionsPanelButtons();
        GridBagConstraints optionsConstraints = new GridBagConstraints();
        optionsConstraints.insets = new Insets(10,0,10,0);
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
    }

    void setupOptionsPanelButtons() {
        optionsPanel = new JPanel(new GridBagLayout());
        addItem = new JButton();
        removeItem = new JButton();
        openListingWindow = new JButton();
        addOutfit = new JButton();
        openOutfitWindow = new JButton();
        addItem.setText("Add Item");
        removeItem.setText("Remove Item");
        openListingWindow.setText("See List View");
        addOutfit.setText("Add Outfit From Selected");
        openOutfitWindow.setText("See Outfits");
    }

    void setupCentrePanel() {
        centrePanel = new JPanel(new GridBagLayout());
        upperWearIcon = new ImageIcon();
        headWearIcon = new ImageIcon();
        lowerWearIcon = new ImageIcon();
        footwearIcon = new ImageIcon();
        setupHeadWearAndText();
        setupUpperWearAndText();
        setupLowerWearAndText();
        setupFootwearAndText();
        addAllToCentrePanel();
    }

    void addAllToCentrePanel() {
        GridBagConstraints midConstraints = new GridBagConstraints();
        midConstraints.gridy = 0;
        centrePanel.add(headText, midConstraints);
        midConstraints.gridy = 1;
        centrePanel.add(headLabel, midConstraints);
        midConstraints.gridy = 2;
        centrePanel.add(upperText, midConstraints);
        midConstraints.gridy = 3;
        centrePanel.add(upperLabel, midConstraints);
        midConstraints.gridy = 4;
        centrePanel.add(lowerText, midConstraints);
        midConstraints.gridy = 5;
        centrePanel.add(lowerLabel, midConstraints);
        midConstraints.gridy = 6;
        centrePanel.add(bottomText, midConstraints);
        midConstraints.gridy = 7;
        centrePanel.add(bottomLabel, midConstraints);
    }


    void setupUpperWearAndText() {
        String sub = this.backUI.userWardrobe.getAllUpperWear().get(currU).getPieceSubtype();
        upperWearIcon = this.backUI.userWardrobe.getAllUpperWear().get(currU).getImage(sub);
        ImageIcon scaleUpper = new ImageIcon(
                upperWearIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        int index = backUI.userWardrobe.getAllUpperWear().get(currU).getIndexNo();
        String name = backUI.userWardrobe.getAllUpperWear().get(currU).getPieceName();
        String title = "ID: " + index + ", " + name;
        Color c = getColorFromColour(backUI.userWardrobe.getAllUpperWear().get(currU).getPieceColour());
        upperLabel = new JLabel();
        upperText = new JLabel(title);
        upperLabel.setSize(100, 100);
        upperLabel.setIcon(scaleUpper);
        upperLabel.setBackground(c);
        upperLabel.setOpaque(true);
        upperText.setOpaque(false);
    }

    void setupHeadWearAndText() {
        String sub = this.backUI.userWardrobe.getAllHeadWear().get(currH).getPieceSubtype();
        headWearIcon = this.backUI.userWardrobe.getAllHeadWear().get(currH).getImage(sub);
        ImageIcon scaleHead = new ImageIcon(
                headWearIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        int index = this.backUI.userWardrobe.getAllHeadWear().get(currH).getIndexNo();
        String name = this.backUI.userWardrobe.getAllHeadWear().get(currH).getPieceName();
        String title = "ID: " + index + ", " + name;
        Color c = getColorFromColour(this.backUI.userWardrobe.getAllHeadWear().get(currH).getPieceColour());
        headLabel = new JLabel();
        headText = new JLabel(title);
        headLabel.setSize(100, 100);
        headLabel.setIcon(scaleHead);
        headLabel.setBackground(c);
        headLabel.setOpaque(true);
        headText.setOpaque(false);
    }


    void setupLowerWearAndText() {
        String sub = this.backUI.userWardrobe.getAllLowerWear().get(currL).getPieceSubtype();
        lowerWearIcon = this.backUI.userWardrobe.getAllLowerWear().get(currL).getImage(sub);
        ImageIcon scaleLower = new ImageIcon(
                lowerWearIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        int index = this.backUI.userWardrobe.getAllLowerWear().get(currL).getIndexNo();
        String name = this.backUI.userWardrobe.getAllLowerWear().get(currL).getPieceName();
        String title = "ID: " + index + ", " + name;
        Color c = getColorFromColour(this.backUI.userWardrobe.getAllLowerWear().get(currL).getPieceColour());
        lowerLabel = new JLabel();
        lowerText = new JLabel(title);
        lowerLabel.setSize(100, 100);
        lowerLabel.setIcon(scaleLower);
        lowerLabel.setBackground(c);
        lowerLabel.setOpaque(true);
        lowerText.setOpaque(false);
    }


    void setupFootwearAndText() {
        String sub = this.backUI.userWardrobe.getAllFootwear().get(currF).getPieceSubtype();
        footwearIcon = this.backUI.userWardrobe.getAllFootwear().get(currF).getImage(sub);
        ImageIcon scaleBottom = new ImageIcon(
                footwearIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        int index = this.backUI.userWardrobe.getAllFootwear().get(currF).getIndexNo();
        String name = this.backUI.userWardrobe.getAllFootwear().get(currF).getPieceName();
        String title = "ID: " + index + ", " + name;
        Color c = getColorFromColour(this.backUI.userWardrobe.getAllFootwear().get(currF).getPieceColour());
        bottomLabel = new JLabel();
        bottomText = new JLabel(title);
        bottomLabel.setSize(100, 100);
        bottomLabel.setIcon(scaleBottom);
        bottomLabel.setBackground(c);
        bottomLabel.setOpaque(true);
        bottomText.setOpaque(false);
    }

    void updateWearAndText() {
        setupHeadWearAndText();
        setupUpperWearAndText();
        setupLowerWearAndText();
        setupFootwearAndText();
        updateCentrePanel();
        frame.revalidate();
        frame.repaint();
    }

    void updateCentrePanel() {
        centrePanel.removeAll();
        addAllToCentrePanel();
    }


    public Color getColorFromColour(Colour c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        return new Color(r, g, b);
    }


    void outfitFrameSetup() {
        frame = new JFrame();
        frame.setLocation(locationX, locationY);
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
        frame.setLocation(locationX, locationY);
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

    void launchAdditionWindow(Component parent) {
        setupAdditionWindowButtons();
        addFrame.setLocationRelativeTo(parent);
        addFrame.setVisible(true);
        addFrame.setLayout(new FlowLayout());
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.add(wtText);
        addFrame.add(superTypeSelect);
        addFrame.add(nameText);
        addFrame.add(nameField);
        addFrame.add(formalityText);
        addFrame.add(formalityField);
        addFrame.add(subtypeText);
        addFrame.revalidate();
    }

    void setupAdditionWindowButtons() {
        selectedOutfitColour = Color.BLUE;
        addFrame = new JFrame();
        addFrame.setSize(200, 500);
        wtText = new JLabel("Enter Wear Type");
        nameText = new JLabel("Enter Clothing Name below");
        formalityText = new JLabel("Enter Clothing formality");
        subtypeText = new JLabel("Enter Clothing Sub Type");
        subtypeText.setVisible(false);
        String[] wearTypes = {"Head Wear", "Upper Wear", "Lower Wear", "Footwear"};
        superTypeSelect = new JComboBox(wearTypes);
        superTypeSelect.addActionListener(this);
        nameField = new JTextField("Name");
        formalityField = new JTextField("Formality");
        subType = new ButtonGroup();
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    void launchRemoveWindow() {
        String answer = JOptionPane.showInputDialog("What ID number would you like to remove?");
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

    void setupRadioButtonsHeadLowerWear(String[] acceptableItems) {
        b1.setText(acceptableItems[0]);
        b2.setText(acceptableItems[1]);
        b3.setText(acceptableItems[2]);
        subType.add(b1);
        subType.add(b2);
        subType.add(b3);
        b3.setVisible(true);
        b4.setVisible(false);
    }

    void setupRadioButtonsUpperWear(String[] acceptableItems) {
        b1.setText(acceptableItems[0]);
        b2.setText(acceptableItems[1]);
        b3.setText(acceptableItems[2]);
        b4.setText(acceptableItems[3]);
        subType.add(b1);
        subType.add(b2);
        subType.add(b3);
        subType.add(b4);
        b3.setVisible(true);
        b4.setVisible(true);
    }

    void runSuperTypeSelectSequence() {
        int selIndex = superTypeSelect.getSelectedIndex();
        String[] acceptableItems = getAcceptableItemsFromCode(selIndex);
        if (selIndex == 0) {
            setupRadioButtonsHeadLowerWear(acceptableItems);
        } else if (selIndex == 1) {
            setupRadioButtonsUpperWear(acceptableItems);
        } else if (selIndex == 2) {
            setupRadioButtonsHeadLowerWear(acceptableItems);
        } else if (selIndex == 3) {
            b1.setText(acceptableItems[0]);
            b2.setText(acceptableItems[1]);
            subType.add(b1);
            subType.add(b2);
            b3.setVisible(false);
            b4.setVisible(false);
        }
        subtypeText.setVisible(true);
        addFrame.add(b1);
        addFrame.add(b2);
        addFrame.add(b3);
        addFrame.add(b4);
        addFrame.revalidate();
    }
    
    public String[] getAcceptableItemsFromCode(int code) {
        if (code == 0) {
            return HeadWear.getAcceptableItems();
        } else if (code == 1) {
            return UpperWear.getAcceptableItems();
        } else if (code == 2) {
            return LowerWear.getAcceptableItems();
        } else {
            return FootWear.getAcceptableItems();
        }
    }

    void runCreateColourSequence() {
        if (getColour != null) {
            addFrame.remove(getColour);
        }
        getColour = new JButton("Pick a Colour");
        getColour.addActionListener(this);
        confirmation = new JButton("Add Clothing");
        confirmation.addActionListener(this);
        addFrame.add(getColour);
        addFrame.add(confirmation);
        confirmation.setVisible(false);
    }

    void setupConfirmationButton() {
        JColorChooser colourPicker = new JColorChooser();
        selectedOutfitColour = JColorChooser.showDialog(null, "Select Outfit Colour", Color.BLUE);
        getColour.setBackground(selectedOutfitColour);
        getColour.setOpaque(true);
        confirmation.setVisible(true);
    }

    void addClothing() {
        int subtypeCode;
        if (b1.isSelected()) {
            subtypeCode = 0;
        } else if (b2.isSelected()) {
            subtypeCode = 1;
        } else if (b3.isSelected()) {
            subtypeCode = 2;
        } else { // (b4.isSelected())
            subtypeCode = 3;
        }
        String name = nameField.getText();
        String genre = formalityField.getText();
        int superCode = superTypeSelect.getSelectedIndex();
        int red = selectedOutfitColour.getRed();
        int green = selectedOutfitColour.getGreen();
        int blue = selectedOutfitColour.getBlue();
        Colour c = new Colour(red, green, blue);

        backUI.addToWardrobe(superCode, subtypeCode, name, genre, c);
        addFrame.dispose();
    }

    void hatGoRight() {
        int size = backUI.userWardrobe.getAllHeadWear().size();
        int newIndex = (currH + 1) % size;
        currH = newIndex;
        updateWearAndText();
    }

    void upGoRight() {
        int size = backUI.userWardrobe.getAllUpperWear().size();
        int newIndex = (currU + 1) % size;
        currU = newIndex;
        updateWearAndText();
    }

    void lowGoRight() {
        int size = backUI.userWardrobe.getAllLowerWear().size();
        int newIndex = (currL + 1) % size;
        currL = newIndex;
        updateWearAndText();
    }

    void footGoRight() {
        int size = backUI.userWardrobe.getAllFootwear().size();
        int newIndex = (currF + 1) % size;
        currF = newIndex;
        updateWearAndText();
    }

    void hatGoLeft() {
        int size = backUI.userWardrobe.getAllHeadWear().size();
        if (currH == 0) {
            currH = size - 1;
        } else {
            currH--;
        }
        updateWearAndText();
    }

    void upGoLeft() {
        int size = backUI.userWardrobe.getAllUpperWear().size();
        if (currU == 0) {
            currU = size - 1;
        } else {
            currU--;
        }
        updateWearAndText();
    }

    void lowGoLeft() {
        int size = backUI.userWardrobe.getAllLowerWear().size();
        if (currL == 0) {
            currL = size - 1;
        } else {
            currL--;
        }
        updateWearAndText();
    }

    void footGoLeft() {
        int size = backUI.userWardrobe.getAllFootwear().size();
        if (currF == 0) {
            currF = size - 1;
        } else {
            currF--;
        }
        updateWearAndText();
    }

    @Override
    @SuppressWarnings("methodlength")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openOutfitWindow) {
            frame.dispose();
            outfitFrameSetup();
            backUI.saveWardrobe();
        } else if (e.getSource() == openListingWindow) {
            frame.dispose();
            listingFrameSetup();
            backUI.saveWardrobe();
        } else if (e.getSource() == addItem) {
            launchAdditionWindow(addItem);
            backUI.saveWardrobe();
        } else if (e.getSource() == removeItem) {
            launchRemoveWindow();
            backUI.saveWardrobe();
        } else if (e.getSource() == addOutfit) {
            addOutfitFromSelected();
            backUI.saveWardrobe();
        } else if (e.getSource() == superTypeSelect) {
            runSuperTypeSelectSequence();
        } else if (e.getSource() == b1 || e.getSource() ==  b2 || e.getSource() ==  b3  || e.getSource() ==  b4) {
            runCreateColourSequence();
        } else if (e.getSource() == superTypeSelect && b1.isSelected() || b2.isSelected() || b3.isSelected()
                || b4.isSelected()) {
            addFrame.dispose();
            launchAdditionWindow(addItem);
            runSuperTypeSelectSequence();
        } else if (e.getSource() == getColour) {
            setupConfirmationButton();
        } else if (e.getSource() == confirmation) {
            addClothing();
        } else if (e.getSource() == hatRight) {
            hatGoRight();
        } else if (e.getSource() == upperRight) {
            upGoRight();
        } else if (e.getSource() == lowerRight) {
            lowGoRight();
        } else if (e.getSource() == bottomRight) {
            footGoRight();
        } else if (e.getSource() == hatLeft) {
            hatGoLeft();
        } else if (e.getSource() == upperLeft) {
            upGoLeft();
        } else if (e.getSource() == lowerLeft) {
            lowGoLeft();
        } else if (e.getSource() == bottomLeft) {
            footGoLeft();
        }
    }
}
