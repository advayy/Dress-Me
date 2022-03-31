package ui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Class that creates all the UI elements and windows during run
public class UIRunner implements ActionListener, MouseListener {
    int width = 600;
    int height = 500;
    JButton addItem;
    JButton removeItem;
//    JButton openListingWindow;
//    JButton addOutfit;
//    JButton openOutfitWindow;
    JFrame frame;
    ImageIcon nullSquare = new ImageIcon("./assets/null.png");
    ImageIcon logo = new ImageIcon("./assets/dressmeicon.png");
    ImageIcon dressMeLogo = new ImageIcon(logo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
    Color backGroundColour = new Color(0xdabaff);
    JLabel wtText;
    JLabel nameText;
    JLabel formalityText;
    JPanel centrePanel = new JPanel(new GridBagLayout());
    ImageIcon upperWearIcon = new ImageIcon();
    ImageIcon headWearIcon = new ImageIcon();
    ImageIcon lowerWearIcon = new ImageIcon();
    ImageIcon footwearIcon = new ImageIcon();
    JPanel leftArrowPanel;
    JPanel rightArrowPanel;
    JPanel optionsPanel;
    JButton save;
    JButton load;
    JButton name;

    ImageIcon left = new ImageIcon("./assets/leftArrow.png");
    ImageIcon right = new ImageIcon("./assets/rightArrow.png");
    ImageIcon leftPressed = new ImageIcon("./assets/leftArrowPressed.png");
    ImageIcon rightPressed = new ImageIcon("./assets/rightArrowPressed.png");
    JLabel hatLeft;
    JLabel hatRight;
    JLabel upperLeft;
    JLabel upperRight;
    JLabel lowerLeft;
    JLabel lowerRight;
    JLabel bottomLeft;
    JLabel bottomRight;

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
    int locationX = userScreenWidth / 2 - width / 2;
    int locationY = userScreenHeight / 2 - height / 2;

    // Labels and elements  for add
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

    // Effects: Initiates the layout for the Ui
    public UIRunner(DressMeApp dressMeApp) {
        this.backUI = dressMeApp;
        frame = new MainJFrame(this.backUI); // creates a outfitFrame
        pickerFrameSetup();
        b1 = new JRadioButton();
        b2 = new JRadioButton();
        b3 = new JRadioButton();
        b4 = new JRadioButton();
    }

    // Effects: Sets up the picker frame
    public void pickerFrameSetup() {
        frame.setIconImage(dressMeLogo.getImage());
        frame.setLocation(locationX, locationY);
        frame.setSize(width, height); // sets x and y dimensions of outfitFrame
        frame.setVisible(true);
        frame.setTitle("Dress Me!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(backGroundColour);
        frame.setLayout(new GridBagLayout());
        setArrowButtons();
        addArrowButtonsIn();
        setupOptionsPanel();
        setupCentrePanel();
        colorAllPanels(backGroundColour);
        GridBagConstraints setup = new GridBagConstraints();
        setup.weightx = 1;
        frame.add(leftArrowPanel, setup);
        setup.weightx = 2;
        frame.add(centrePanel, setup);
        setup.weightx = 1;
        frame.add(rightArrowPanel, setup);
        setup.weightx = 1.5;
        frame.add(optionsPanel, setup);
        frame.revalidate();
    }

    // Effects: Colours all the panels
    void colorAllPanels(Color c) {
        leftArrowPanel.setBackground(c);
        rightArrowPanel.setBackground(c);
        centrePanel.setBackground(c);
        // optionsPanel.setBackground(c);
        optionsPanel.setBackground(new Color(0x7a7a7a));
    }

    // Effects: Sets up the arrow button information
    void setArrowButtons() {
        hatLeft = new JLabel();
        hatRight = new JLabel();
        upperLeft = new JLabel();
        upperRight = new JLabel();
        lowerLeft = new JLabel();
        lowerRight = new JLabel();
        bottomLeft = new JLabel();
        bottomRight = new JLabel();
        hatLeft.addMouseListener(this);
        upperLeft.addMouseListener(this);
        lowerLeft.addMouseListener(this);
        bottomLeft.addMouseListener(this);
        hatRight.addMouseListener(this);
        upperRight.addMouseListener(this);
        lowerRight.addMouseListener(this);
        bottomRight.addMouseListener(this);
        setArrowImages();
    }

    // Effects: Sets the arrow images
    void setArrowImages() {
        hatLeft.setSize(58, 42);
        upperLeft.setSize(58, 42);
        lowerLeft.setSize(58, 42);
        bottomLeft.setSize(58, 42);
        hatRight.setSize(58, 42);
        upperRight.setSize(58, 42);
        lowerRight.setSize(58, 42);
        bottomRight.setSize(58, 42);
        hatLeft.setIcon(left);
        upperLeft.setIcon(left);
        lowerLeft.setIcon(left);
        bottomLeft.setIcon(left);
        hatRight.setIcon(right);
        upperRight.setIcon(right);
        lowerRight.setIcon(right);
        bottomRight.setIcon(right);
    }

    // Effects: adds all arrow buttons into the JPanels
    void addArrowButtonsIn() {
        leftArrowPanel = new JPanel(new GridBagLayout());
        rightArrowPanel = new JPanel(new GridBagLayout());
        GridBagConstraints arrowConstraints = new GridBagConstraints();
        arrowConstraints.insets = new Insets(40,0,40,0);
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


    // Effects: sets up the options panel buttons
    void setupOptionsPanel() {
        setupOptionsPanelButtons();
        GridBagConstraints optionsConstraints = new GridBagConstraints();
        optionsConstraints.insets = new Insets(10,0,10,0);
        optionsConstraints.gridy = 0;
        addItem.addActionListener(this);
        removeItem.addActionListener(this);
        //        openListingWindow.addActionListener(this);
        //        addOutfit.addActionListener(this);
        //        openOutfitWindow.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        name.addActionListener(this);
        deFocusButtons();
        optionsConstraints.gridy = 0;
        optionsPanel.add(addItem, optionsConstraints);
        optionsConstraints.gridy = 1;
        optionsPanel.add(removeItem, optionsConstraints);
        optionsConstraints.gridy = 2;
        optionsPanel.add(save, optionsConstraints);
        optionsConstraints.gridy = 3;
        optionsPanel.add(load, optionsConstraints);
        optionsConstraints.gridy = 4;
        optionsPanel.add(name, optionsConstraints);
//        optionsConstraints.gridy = 5;
//        optionsPanel.add(addOutfit, optionsConstraints);
//        optionsConstraints.gridy = 6;
//        optionsPanel.add(openListingWindow, optionsConstraints);
//        optionsConstraints.gridy = 7;
//        optionsPanel.add(openOutfitWindow, optionsConstraints);
    }

    // Effects: modifies the visual elements of the buttons
    void deFocusButtons() {
        addItem.setFocusable(false);
        removeItem.setFocusable(false);
        save.setFocusable(false);
        load.setFocusable(false);
        name.setFocusable(false);
        //addItem.set
    }

    // Effects: Sets up the buttons for the options panel
    void setupOptionsPanelButtons() {
        optionsPanel = new JPanel(new GridBagLayout());
        addItem = new JButton();
        removeItem = new JButton();
//      openListingWindow = new JButton();
//      addOutfit = new JButton();
//      openOutfitWindow = new JButton();
        save = new JButton();
        load = new JButton();
        name = new JButton();
        addItem.setText("Add Item");
        removeItem.setText("Remove Item");
//      openListingWindow.setText("Go to List View");
//      addOutfit.setText("Add Outfit");
//      openOutfitWindow.setText("Go to Outfits View");
        save.setText("Save To File");
        load.setText("Load From File");
        name.setText("Name Wardrobe");
    }

    // Effects: sets up all the panels with the demo texts and labels
    void setupCentrePanel() {
        setupHeadWearAndText();
        setupUpperWearAndText();
        setupLowerWearAndText();
        setupFootwearAndText();
        addAllToCentrePanel();
    }

    // Effects: Adds all the labels to the center panel
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

    // Effects: sets up the upper wear fields for the center panel
    void setupUpperWearAndText() {
        upperLabel = new JLabel();
        if (this.backUI.userWardrobe.getAllUpperWear().size() == 0) {
            String title = "No Upper Wear";
            upperText = new JLabel(title);
            upperLabel.setIcon(nullSquare);
        } else {
            String sub = this.backUI.userWardrobe.getAllUpperWear().get(currU).getPieceSubtype();
            upperWearIcon = this.backUI.userWardrobe.getAllUpperWear().get(currU).getImage(sub);
            int index = backUI.userWardrobe.getAllUpperWear().get(currU).getIndexNo();
            String name = backUI.userWardrobe.getAllUpperWear().get(currU).getPieceName();
            String title = "ID: " + index + ", " + name;
            Color c = getColorFromColour(backUI.userWardrobe.getAllUpperWear().get(currU).getPieceColour());
            upperText = new JLabel(title);
            upperLabel.setIcon(upperWearIcon);
            upperLabel.setBackground(c);
        }
        upperLabel.setSize(100, 100);
        upperLabel.setOpaque(true);
        upperText.setOpaque(false);
    }

    // Effects: sets up the head wear fields for the center panel
    void setupHeadWearAndText() {
        headLabel = new JLabel();
        if (this.backUI.userWardrobe.getAllHeadWear().size() == 0) {
            String title = "No Head Wear";
            headText = new JLabel(title);
            headLabel.setIcon(nullSquare);
        } else {
            String sub = this.backUI.userWardrobe.getAllHeadWear().get(currH).getPieceSubtype();
            headWearIcon = this.backUI.userWardrobe.getAllHeadWear().get(currH).getImage(sub);
            int index = this.backUI.userWardrobe.getAllHeadWear().get(currH).getIndexNo();
            String name = this.backUI.userWardrobe.getAllHeadWear().get(currH).getPieceName();
            String title = "ID: " + index + ", " + name;
            Color c = getColorFromColour(this.backUI.userWardrobe.getAllHeadWear().get(currH).getPieceColour());
            headText = new JLabel(title);
            headLabel.setIcon(headWearIcon);
            headLabel.setBackground(c);
        }
        headLabel.setSize(100, 100);
        headLabel.setOpaque(true);
        headText.setOpaque(false);
    }

    // Effects: sets up the lower wear fields for the center panel
    void setupLowerWearAndText() {
        lowerLabel = new JLabel();
        if (this.backUI.userWardrobe.getAllLowerWear().size() == 0) {
            String title = "No Lower Wear";
            lowerText = new JLabel(title);
            lowerLabel.setIcon(nullSquare);
        } else {
            String sub = this.backUI.userWardrobe.getAllLowerWear().get(currL).getPieceSubtype();
            lowerWearIcon = this.backUI.userWardrobe.getAllLowerWear().get(currL).getImage(sub);
            int index = this.backUI.userWardrobe.getAllLowerWear().get(currL).getIndexNo();
            String name = this.backUI.userWardrobe.getAllLowerWear().get(currL).getPieceName();
            String title = "ID: " + index + ", " + name;
            Color c = getColorFromColour(this.backUI.userWardrobe.getAllLowerWear().get(currL).getPieceColour());
            lowerText = new JLabel(title);
            lowerLabel.setIcon(lowerWearIcon);
            lowerLabel.setBackground(c);
        }
        lowerLabel.setSize(100, 100);
        lowerLabel.setOpaque(true);
        lowerText.setOpaque(false);
    }

    // Effects: sets up the foot wear fields for the center panel
    void setupFootwearAndText() {
        bottomLabel = new JLabel();
        if (this.backUI.userWardrobe.getAllFootwear().size() == 0) {
            String title = "No Footwear";
            bottomText = new JLabel(title);
            bottomLabel.setIcon(nullSquare);
        } else {
            String sub = this.backUI.userWardrobe.getAllFootwear().get(currF).getPieceSubtype();
            footwearIcon = this.backUI.userWardrobe.getAllFootwear().get(currF).getImage(sub);
            int index = this.backUI.userWardrobe.getAllFootwear().get(currF).getIndexNo();
            String name = this.backUI.userWardrobe.getAllFootwear().get(currF).getPieceName();
            String title = "ID: " + index + ", " + name;
            Color c = getColorFromColour(this.backUI.userWardrobe.getAllFootwear().get(currF).getPieceColour());
            bottomText = new JLabel(title);
            bottomLabel.setIcon(footwearIcon);
            bottomLabel.setBackground(c);
        }
        bottomLabel.setSize(100, 100);
        bottomLabel.setOpaque(true);
        bottomText.setOpaque(false);
    }

    // Effects: Updates all the panels with central panels
    void updateWearAndText() {
        setupHeadWearAndText();
        setupUpperWearAndText();
        setupLowerWearAndText();
        setupFootwearAndText();
        updateCentrePanel();
        frame.revalidate();
        frame.repaint();
    }

    // Effects: removes all from the central panel and adds them back
    void updateCentrePanel() {
        centrePanel.removeAll();
        addAllToCentrePanel();
    }


    // Effects: gets a Java Colour from color
    public Color getColorFromColour(Colour c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        return new Color(r, g, b);
    }

    // Effects: Launches the addition window
    void launchAdditionWindow(Component parent) {
        setupAdditionWindowButtons();
        addFrame.setLocationRelativeTo(parent);
        addFrame.setIconImage(dressMeLogo.getImage());
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

    // Effects: sets up the buttons for the addition window
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

    // Effects: prompts the user to remove an item
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
                            "Operation Successful", JOptionPane.PLAIN_MESSAGE, dressMeLogo);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Index " + index + " not found",
                            "Operation Unsuccessful", JOptionPane.ERROR_MESSAGE, dressMeLogo);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Please only enter a number", "Invalid input", JOptionPane.ERROR_MESSAGE,
                        dressMeLogo);
            }
        }
    }


    // Effects: updates the Current index positions after removing
    void removeUpdate() {
        if (backUI.userWardrobe.getAllHeadWear().size() > 0) {
            currH = currH % backUI.userWardrobe.getAllHeadWear().size();
        }
        if (backUI.userWardrobe.getAllUpperWear().size() > 0) {
            currU = currU % backUI.userWardrobe.getAllUpperWear().size();
        }
        if (backUI.userWardrobe.getAllLowerWear().size() > 0) {
            currL = currL % backUI.userWardrobe.getAllLowerWear().size();
        }
        if (backUI.userWardrobe.getAllFootwear().size() > 0) {
            currF = currF % backUI.userWardrobe.getAllFootwear().size();
        }
        updateWearAndText();
    }

    // Effects: sets up radio buttons for head/lower wear
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

    // Effects: sets up radio buttons for upper wear
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


    // Effects: adds in the radio buttons
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

    // Effects: returns the acceptable items list depending on the type code
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


    // Effects: runs the colour picker sequence
    void runCreateColourSequence() {
        if (getColour != null) {
            addFrame.remove(getColour);
            selectedOutfitColour = null;
        }
        getColour = new JButton("Pick a Colour");
        getColour.addActionListener(this);
        confirmation = new JButton("Add Clothing");
        confirmation.addActionListener(this);
        addFrame.add(getColour);
        try {
            addFrame.remove(confirmation);
        } catch (NullPointerException e) {
            //
        }
        addFrame.add(confirmation);
        confirmation.setVisible(false);
    }

    // Effects: sets up the confirmation button
    void setupConfirmationButton() {
        selectedOutfitColour = JColorChooser.showDialog(null, "Select Outfit Colour", Color.BLUE);
        getColour.setBackground(selectedOutfitColour);
        getColour.setOpaque(true);
        if (selectedOutfitColour != null) {
            confirmation.setVisible(true);
        }
    }

    // Effects: adds clothing into data
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
        int indexOfAdded = backUI.addToWardrobe(superCode, subtypeCode, name, genre, c);
        setCurrLocation(superCode, indexOfAdded);
        addFrame.dispose();
    }

    // Effects: Sets up current indexes of the added item
    void setCurrLocation(int superCode, int indexOfAdded) {
        if (superCode == 0) {
            currH = backUI.userWardrobe.getSubListIndex(indexOfAdded);
        } else if (superCode == 1) {
            currU = backUI.userWardrobe.getSubListIndex(indexOfAdded);
        } else if (superCode == 2) {
            currL = backUI.userWardrobe.getSubListIndex(indexOfAdded);
        } else {
            currF = backUI.userWardrobe.getSubListIndex(indexOfAdded);
        }
    }

    // effects : moves clothing row to the right
    void hatGoRight() {
        int size = backUI.userWardrobe.getAllHeadWear().size();
        if (size > 0) {
            currH = (currH + 1) % size;
            updateWearAndText();
        }
    }

    // effects : moves clothing row to the right
    void upGoRight() {
        int size = backUI.userWardrobe.getAllUpperWear().size();
        if (size > 0) {
            currU = (currU + 1) % size;
            updateWearAndText();
        }
    }

    // effects : moves clothing row to the right
    void lowGoRight() {
        int size = backUI.userWardrobe.getAllLowerWear().size();
        if (size > 0) {
            currL = (currL + 1) % size;
            updateWearAndText();
        }
    }

    // effects : moves clothing row to the right
    void footGoRight() {
        int size = backUI.userWardrobe.getAllFootwear().size();
        if (size > 0) {
            currF = (currF + 1) % size;
            updateWearAndText();
        }
    }

    // effects : moves clothing row to the left
    void hatGoLeft() {
        int size = backUI.userWardrobe.getAllHeadWear().size();
        if (size > 0) {
            if (currH == 0) {
                currH = size - 1;
            } else {
                currH--;
            }
            updateWearAndText();
        }

    }

    // effects : moves clothing row to the left
    void upGoLeft() {
        int size = backUI.userWardrobe.getAllUpperWear().size();
        if (size > 0) {
            if (currU == 0) {
                currU = size - 1;
            } else {
                currU--;
            }
            updateWearAndText();
        }

    }

    // effects : moves clothing row to the left
    void lowGoLeft() {
        int size = backUI.userWardrobe.getAllLowerWear().size();
        if (size > 0) {
            if (currL == 0) {
                currL = size - 1;
            } else {
                currL--;
            }
            updateWearAndText();
        }

    }

    // effects : moves clothing row to the left
    void footGoLeft() {
        int size = backUI.userWardrobe.getAllFootwear().size();
        if (size > 0) {
            if (currF == 0) {
                currF = size - 1;
            } else {
                currF--;
            }
            updateWearAndText();
        }
    }

    //effects : runs the save sequence
    void runSave() {
        if (backUI.userWardrobe.getName() == null) {
            runName();
        }
        String answer = JOptionPane.showInputDialog("Enter save file location (without the .json extension)",
                "wardrobe");
        if (!answer.equals("")) {
            backUI.saveWardrobe(answer);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Location", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // effects: runs the load sequence
    void runLoad() {
        String answer = JOptionPane.showInputDialog("Enter file name to load from (without the .json extension)",
                "wardrobe");
        backUI.loadWardrobe(answer);
        frame.setTitle("Dress Me Wardrobe : " + backUI.userWardrobe.getName());
    }

    // EFFECTS: NAMES THE WARDROBE FROM THE USER
    void runName() {
        String answer;
        if (backUI.userWardrobe.getName() == null) {
            answer = JOptionPane.showInputDialog("What would you like to name this Wardrobe?",
                    "default");
            backUI.userWardrobe.setName(answer);
        } else {
            int x = JOptionPane.showConfirmDialog(null,
                    "Would you like to rename this wardrobe?", "Rename Wardrobe?",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, dressMeLogo);
            if (x == 0) {
                answer = JOptionPane.showInputDialog("What would you like to rename this Wardrobe? to");
                backUI.userWardrobe.setName(answer);
            }
        }
        frame.setTitle("Dress Me Wardrobe : " + backUI.userWardrobe.getName());
    }

    // EFFECTS: HANDLES ALL ACTIONS FROM UI
    @Override
    @SuppressWarnings("methodlength")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            runSave();
        }  else if (e.getSource() == load) {
            runLoad();
            updateWearAndText();
        } else if (e.getSource() == name) {
            runName();
        } else if (e.getSource() == addItem) {
            launchAdditionWindow(addItem);
        } else if (e.getSource() == removeItem) {
            launchRemoveWindow();
            removeUpdate();
            updateWearAndText();
        } else if (e.getSource() == superTypeSelect) {
            try {
                getColour.setVisible(false);
                addFrame.remove(getColour);
                selectedOutfitColour = null;
            } catch (NullPointerException x) {
                //
            }
            try {
                confirmation.setVisible(false);
                addFrame.remove(confirmation);
            } catch (NullPointerException x) {
                //
            }
            runSuperTypeSelectSequence();
        } else if (e.getSource() == b1 || e.getSource() ==  b2 || e.getSource() ==  b3  || e.getSource() ==  b4) {
            try {
                getColour.setVisible(false);
                addFrame.remove(getColour);
                selectedOutfitColour = null;
            } catch (NullPointerException x) {
                //
            }
            try {
                confirmation.setVisible(false);
                addFrame.remove(confirmation);
            } catch (NullPointerException x) {
                //
            }
            runCreateColourSequence();
        } else if (e.getSource() == getColour) {
            setupConfirmationButton();
        } else if (e.getSource() == confirmation) {
            if (selectedOutfitColour != null) {
                addClothing();
                removeUpdate();
                updateWearAndText();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == hatRight) {
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

    // Gives the arrow buttons the darker animation when pressed
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == hatLeft) {
            hatLeft.setIcon(leftPressed);
        } else if (e.getSource() == hatRight) {
            hatRight.setIcon(rightPressed);
        } else if (e.getSource() == upperLeft) {
            upperLeft.setIcon(leftPressed);
        } else if (e.getSource() == upperRight) {
            upperRight.setIcon(rightPressed);
        } else if (e.getSource() == lowerLeft) {
            lowerLeft.setIcon(leftPressed);
        } else if (e.getSource() == lowerRight) {
            lowerRight.setIcon(rightPressed);
        } else if (e.getSource() == bottomLeft) {
            bottomLeft.setIcon(leftPressed);
        } else if (e.getSource() == bottomRight) {
            bottomRight.setIcon(rightPressed);
        }
    }

    // Gives the arrow buttons the original animation when unpressed
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == hatLeft) {
            hatLeft.setIcon(left);
        } else if (e.getSource() == hatRight) {
            hatRight.setIcon(right);
        } else if (e.getSource() == upperLeft) {
            upperLeft.setIcon(left);
        } else if (e.getSource() == upperRight) {
            upperRight.setIcon(right);
        } else if (e.getSource() == lowerLeft) {
            lowerLeft.setIcon(left);
        } else if (e.getSource() == lowerRight) {
            lowerRight.setIcon(right);
        } else if (e.getSource() == bottomLeft) {
            bottomLeft.setIcon(left);
        } else if (e.getSource() == bottomRight) {
            bottomRight.setIcon(right);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //
    }

    /*
    // Listing buttons
    JLabel listOfItems = new JLabel("Items List: ");
    DefaultListModel listModel = new DefaultListModel();
    JList items = new JList();
    JButton goToPicker;
    JButton goToOutfit;
    JButton addItemToList;
    JButton removeFromList;
    JButton filter;
    JPanel listPanel;

    void listingFrameSetup() {
        listPanel = new JPanel();
        frame = new JFrame();
        frame.setLocation(locationX, locationY);
        frame.setSize(800, 500); // sets x and y dimensions of outfitFrame
        frame.setVisible(true);
        frame.setTitle("Listing Window : " + backUI.userWardrobe.getName());
        frame.getContentPane().setBackground(backGroundColour);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupListingPanels();
        frame.revalidate();
        frame.repaint();
    }

    void setupListingPanels() {
        setListPanel();
        //setListOptionsPanel();
        listPanel.setBackground(backGroundColour);
        optionsPanel.setBackground(backGroundColour);
        GridBagConstraints setup = new GridBagConstraints();
        setup.weightx = 3;
        frame.add(listPanel, setup);
        setup.weightx = 1;
        frame.add(optionsPanel, setup);
    }

    void setListPanel() {
        for (Clothing item : backUI.userWardrobe.getInternalWardrobe()) {
            String s = backUI.printClothingDetails(item);
            listModel.addElement(s);
        }
        items.setModel(listModel);
        listPanel.setLayout(new GridBagLayout());
        GridBagConstraints setup = new GridBagConstraints();
        setup.gridy = 0;
        setup.gridx = 0;
        listPanel.add(listOfItems);
        setup.gridy = 1;
        listPanel.add(items);
        listPanel.setVisible(true);

    }

    void outfitFrameSetup() {
        frame = new JFrame();
        frame.setLocation(locationX, locationY);
        frame.setSize(850, 500); // sets x and y dimensions of outfitFrame
        frame.setVisible(true);
        frame.setTitle("Outfit Window : " + backUI.userWardrobe.getName());
        frame.getContentPane().setBackground(backGroundColour);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.revalidate();
        frame.repaint();
    }

void addOutfitFromSelected() {
        int answer = JOptionPane.showConfirmDialog(null,
                "Would you like to add the selected items into an outfit?", "Add Outfit?",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, dressMeLogo);
        if (answer == 0) { // yes
            int hs = backUI.userWardrobe.getAllHeadWear().size();
            int us = backUI.userWardrobe.getAllUpperWear().size();
            int ls = backUI.userWardrobe.getAllLowerWear().size();
            int fs = backUI.userWardrobe.getAllFootwear().size();
            if (hs > 0 && us  > 0 && ls  > 0 && fs  > 0) {
                Clothing h = backUI.userWardrobe.getAllHeadWear().get(currH);
                Clothing u = backUI.userWardrobe.getAllUpperWear().get(currU);
                Clothing l = backUI.userWardrobe.getAllLowerWear().get(currL);
                Clothing f = backUI.userWardrobe.getAllFootwear().get(currF);
                Outfit o = new Outfit(h, u, l, f);
                String msg = "Outfit ID -" + o.getIndexNo() + ", of pieces [" + h.getIndexNo() + ", " + u.getIndexNo()
                        + ", " + l.getIndexNo() + ", " + f.getIndexNo() + "] was added";
                backUI.userWardrobe.addOutfit(o);
                JOptionPane.showMessageDialog(null,
                        msg,
                        "Operation Successful", JOptionPane.PLAIN_MESSAGE, dressMeLogo);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Not Enough Items To Be An Outfit",
                        "Operation Failure", JOptionPane.ERROR_MESSAGE, dressMeLogo);
            }
        } else if (answer == 1) {
            JOptionPane.showMessageDialog(null,
                    "Outfit not created",
                    "Operation Cancelled", JOptionPane.PLAIN_MESSAGE, dressMeLogo);
        }
    }
    * */
}
