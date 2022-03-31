package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;


// dresses up the user
public class DressMeApp extends JFrame {
    private static final String JSON_STORE_BASE = "./data/";
    private static final String JSON_STORE_EXTENSION = ".json";

    Wardrobe userWardrobe;
    Scanner inputScan;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private UIRunner render;

    /*
     * Effects: Runs the Application loop
     * */
    public DressMeApp() {
        userWardrobe = new Wardrobe();
        inputScan = new Scanner(System.in);
        jsonWriter = new JsonWriter();
        jsonReader = new JsonReader();
        userWardrobe.createTypeLists();
        render = new UIRunner(this);
        //runDressMe();
    }

    // returns internal user wardrobe
    public Wardrobe getUserWardrobe() {
        return userWardrobe;
    }


    /* Requires: An integer input from the user
     * Effects: Gets user input and either quits or loops depending on what is entered
     * */
    public void runDressMe() {
        boolean keepGoing = true;

        System.out.println("Welcome to Dress Me!!");
        System.out.println();

        while (keepGoing) {
            displayMainMenu();
            String stringInput = inputScan.nextLine();
            if (stringInput.equalsIgnoreCase("X")) {
                keepGoing = false;
                System.out.println("Goodbye <3");
                endLine();
            } else {
                int inp = Integer.parseInt(stringInput); // turns string input into
                processCommand(inp);
                flatLine();
            }
        }

    }

    //Effects: Prints a list of options for the user
    public void displayMainMenu() {
        System.out.println("What would you like to do");
        System.out.println("1 - Add an Item");
        System.out.println("2 - Remove an Item");
        System.out.println("3 - List all items in the Wardrobe");
        System.out.println("4 - Filter Wardrobe");
        System.out.println("5 - Go to Outfits menu");
        System.out.println("6 - Save wardrobe to a file");
        System.out.println("7 - Load wardrobe from a file");
        System.out.println("X - Exit");
        System.out.print("Enter your option: ");
    }

    /* Requires: an integer input from the user
     * Effects: Launches the user selected input
     * */
    public void processCommand(int input) {
        if (input == 1) {
            runAdditionSequence();
        } else if (input == 2) {
            removeFromWardrobe();
        } else if (input == 3) {
            listItems(userWardrobe.getInternalWardrobe());
        } else if (input == 4) {
            runFilterSequence();
        } else if (input == 5) {
            // runOutfitSequence();
        } else if (input == 6) {
            // saveWardrobe();
        } else if (input == 7) {
            // loadWardrobe();
        } else {
            System.out.println("Please only input one of the given options!!");
            System.out.println();
        }
    }


    //Effects: Prints a list of options for the user for filtering
    public void displayFilterMenu() {
        // Filter menu
        System.out.println("How would you like to filter?");
        System.out.println("1 - List all items of a certain color");
        System.out.println("2 - List all items of a certain Genre/Formality Type");
        System.out.println("3 - List all items of by Kind");
        System.out.println("x - Go back to main menu");
    }

    //Effects: Prints a list of options for the user for affecting outfits
    public void displayOutfitMenu() {
        // Outfit Menu
        System.out.println("What would you like to do?");
        System.out.println("1 - List all Outfits");
        System.out.println("2 - Add an Outfit");
        System.out.println("3 - Remove an Outfit");
        System.out.println("x - Go back to main menu");
    }


    //Effects: Runs the filter sequence while providing options and selecting
    public void runFilterSequence() {
        boolean keepGoing = true;
        while (keepGoing) {
            displayFilterMenu();
            String stringInput = inputScan.nextLine();
            if (stringInput.equalsIgnoreCase("X")) {
                keepGoing = false;
                System.out.println("Returning to Main Menu");
            } else {
                int inp = Integer.parseInt(stringInput); // turns string input into
                if (inp == 1) {
                    runColourFilter();
                } else if (inp == 2) {
                    runGenreFilter();
                } else if (inp == 3) {
                    runTypeFilter();
                } else {
                    System.out.println("Please only input one of the given options!!");
                    System.out.println();
                }
            }
            flatLine();
        }
    }

    /*
     * Effects: Takes the user input for what kind of object to instantiate and passes the information to the
     * second part of the addition sequence
     * */
    public void runAdditionSequence() {
        System.out.println("What kind of item would you like to add:");
        System.out.println("1 - Head Wear");
        System.out.println("2 - Upper Wear");
        System.out.println("3 - Lower Wear");
        System.out.println("4 - Footwear");
        System.out.println("Or enter X to cancel");
        System.out.print("Enter selected option: ");
        String stringInput = inputScan.nextLine();
        if (stringInput.equalsIgnoreCase("X")) {
            System.out.println("Operation Cancelled");
            System.out.println();
        } else {
            int inp = Integer.parseInt(stringInput);
            if (inp == 1 || inp == 2 || inp == 3 || inp == 4) {
                addToWardrobe(inp);
            } else {
                System.out.println("Operation Unsuccessful");
                System.out.println();
            }
        }
    }

    /* Requires: A encoding to generate the clothing object by type
     * Modifies: userWardrobe
     * Effects: Takes user input to create a new item or clothing apparent type and selected actual type
     * and then adds that to the user wardrobe
     * */
    public void addToWardrobe(int code) {
        System.out.println("Enter the following details:");
        String name = getInputText("Please enter Item Name");
        String genre = getInputText("Please enter Item Genre/Formality");
        genre = genre.toLowerCase(Locale.ROOT);
        //String subType = getInputText("Please enter Item Subtype");
        String subType = getSubType(code);
        System.out.println("Please enter Item Color");
        Colour color = getColourComponentsFromUser();

        Clothing newItem;
        if (code == 1) {
            newItem = new HeadWear(color, genre, subType, name);
        } else if (code == 2) {
            newItem = new UpperWear(color, genre, subType, name);
        } else if (code == 3) {
            newItem = new LowerWear(color, genre, subType, name);
        } else {
            newItem = new FootWear(color, genre, subType, name);
        }
        userWardrobe.addItem(newItem);
        System.out.println("Operation Successful");
        System.out.println();
    }

    // Requires : valid encoding from the UI class
    // Modifies : this
    // Effects : Adds an item into the wardrobe
    public int addToWardrobe(int superCode, int subCode, String name, String genre, Colour colour) {
        String subType = getSubType(superCode, subCode);
        superCode++;
        Clothing newItem;
        if (superCode == 1) {
            newItem = new HeadWear(colour, genre.toLowerCase(Locale.ROOT), subType, name);
        } else if (superCode == 2) {
            newItem = new UpperWear(colour, genre.toLowerCase(Locale.ROOT), subType, name);
        } else if (superCode == 3) {
            newItem = new LowerWear(colour, genre.toLowerCase(Locale.ROOT), subType, name);
        } else {
            newItem = new FootWear(colour, genre.toLowerCase(Locale.ROOT), subType, name);
        }
        userWardrobe.addItem(newItem);
        return newItem.getIndexNo();
    }

    /* Requires: A string from the user as the output/ instruction method
     * Effects: gets the user input and returns it.
     * */
    public String getInputText(String outMsg) {
        System.out.println(outMsg);
        System.out.print("Enter input here: ");
        return inputScan.nextLine();
    }

    /* Requires: A valid input code from the previous function on what items are acceptable
    * Effects: Asks the user for what subtype they want to make and returns it to other functions
    * */
    public String getSubType(int code) {
        String[] acceptableItems;
        if (code == 1) {
            acceptableItems = HeadWear.getAcceptableItems();
        } else if (code == 2) {
            acceptableItems = UpperWear.getAcceptableItems();
        } else if (code == 3) {
            acceptableItems = LowerWear.getAcceptableItems();
        } else if (code == 4) {
            acceptableItems = FootWear.getAcceptableItems();
        } else {
            acceptableItems = new String[0];
        }
        System.out.println("Input one of the following");
        for (int i = 0; i < acceptableItems.length; i++) {
            int indexing = i + 1;
            System.out.println(indexing + "- " + acceptableItems[i]);
        }
        String index = getInputText("Enter the number beside the subtype");
        int indexing = Integer.parseInt(index) - 1;
        return acceptableItems[indexing];
    }

    // Effects: returns the subtype of an item given its supertype and subtype index
    public String getSubType(int code, int subCode) {
        String[] acceptableItems;
        if (code == 0) {
            acceptableItems = HeadWear.getAcceptableItems();
        } else if (code == 1) {
            acceptableItems = UpperWear.getAcceptableItems();
        } else if (code == 2) {
            acceptableItems = LowerWear.getAcceptableItems();
        } else if (code == 3) {
            acceptableItems = FootWear.getAcceptableItems();
        } else {
            acceptableItems = new String[0];
        }
        return acceptableItems[subCode];
    }

    /* Requires: the wardrobe must not be empty
     * Effects: Lists all items with their index codes and takes an input from the user and removes the selected item
     * */
    public void removeFromWardrobe() {
        System.out.println("Which of the following items would you like to remove?");
        listItems(userWardrobe.getInternalWardrobe());
        System.out.println("Please enter the item Index No.");
        System.out.print("Enter your selection or X to cancel: ");
        String stringInput = inputScan.nextLine();
        if (stringInput.equals("X")) {
            System.out.println("Operation Cancelled");
        } else {
            int inp = Integer.parseInt(stringInput);
            boolean flag = userWardrobe.removeItemByIndex(inp);
            if (flag) {
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Unsuccessful - index not found");
            }
        }
        System.out.println();
    }



    /* Requires: the list not be empty
     * Effects: Lists all items with their index codes to the user
     * */
    public void listItems(ArrayList<Clothing> clothesList) {
        flatLine();
        for (Clothing item: clothesList) {
            printClothingDetails(item);
        }
        System.out.println();
    }

    //Requires: An item of clothing as an input
    //Effects: Returns all the data of thw clothing item in the CLI
    public String printClothingDetails(Clothing item) {
        Colour color;
        String genre;
        String subType;
        String name;
        int index;
        color = item.getPieceColour();
        genre = item.getPieceGenre();
        subType = item.getPieceSubtype();
        name = item.getPieceName();
        index = item.getIndexNo();
        String s1 = ("Index: " + index);
        String s2 = (", Name: " + name);
        String s3 = (", SubType: " + subType);
        String s4 = (", Formality: " + genre);
        String s5 = (", Color: [R: " + color.getRed() + ", G: " + color.getGreen());
        String s6 = (", B: " + color.getBlue() + "]");
        return s1 + s2 + s3 + s4 + s5 + s6;
    }

    /* Requires: input color from the user
     * Effects: Lists all items that match the required filter specification
     * */
    public void runColourFilter() {
        System.out.println("Enter Filter Colour you're searching for through fields below");
        Colour c = getColourComponentsFromUser();
        listItems(userWardrobe.getClothesOfColour(c));
    }

    /* Requires: input color from the user
     * Effects: Lists all items that match the required filter specification
     * */
    public void runGenreFilter() {
        System.out.println("Enter the Genre/Formality you're searching for");
        System.out.print("Enter Filter Genre Here: ");
        String input = inputScan.nextLine();
        input = input.toLowerCase();
        listItems(userWardrobe.getClothesOfApparelGenre(input));
    }

    // EFFECTS: saves the wardrobe to a new file unless previously loaded by user
    public void saveWardrobe(String ans) {
        try {
            String jsonStore = JSON_STORE_BASE + ans + JSON_STORE_EXTENSION;
            jsonWriter.open(jsonStore);
            jsonWriter.write(userWardrobe);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null,
                    "Saved to file : " + ans,
                    "Operation Successful", JOptionPane.PLAIN_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "File " + ans + " not found",
                    "Operation Unsuccessful", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads wardrobe from file specified by user
    public void loadWardrobe(String ans) {
        try {
            String jsonStore = JSON_STORE_BASE + ans + JSON_STORE_EXTENSION;
            userWardrobe = jsonReader.read(jsonStore);
            JOptionPane.showMessageDialog(null,
                    "Loaded from File " + ans,
                    "Operation Successful", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "File " + ans + " not found",
                    "Operation Unsuccessful", JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: prints a line of X characters
    private void endLine() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    // EFFECTS: prints a line of _ characters
    private void flatLine() {
        System.out.println("__________________________________________________________________");
    }

    // Effects: Runs the filter sequence for Types of wear
    private void runTypeFilter() {
        System.out.println("Enter the Kind of Wear you're searching for");
        System.out.println("1 - Head Wear");
        System.out.println("2 - Upper Wear");
        System.out.println("3 - Lower Wear");
        System.out.println("4 - Footwear");
        System.out.print("Enter Filter Type Here: ");
        String input = inputScan.nextLine();
        int inp = Integer.parseInt(input);
        listItems(userWardrobe.getClothesByType(inp));
    }

    // Modifies : this
    // Effects : Gets a colour from the user through rgb and initializes and returns it
    public Colour getColourComponentsFromUser() {
        int r;
        int g;
        int b;
        System.out.println("Please enter a number from 0-255");
        r = getSingleComponentFromUser("RED");
        g = getSingleComponentFromUser("GREEN");
        b = getSingleComponentFromUser("BLUE");
        return new Colour(r, g, b);
    }

    // Effects : Gets a RED/GREEN/BLUE value between 0-225 between the user
    public int getSingleComponentFromUser(String colourName) {
        boolean valid = false;
        int c = 0;
        while (!valid) {
            System.out.print("Enter " + colourName + " value: ");
            String input = inputScan.nextLine();
            c = Integer.parseInt(input);
            if (c >= 0 && c <= 255) {
                valid = true;
            } else {
                System.out.println("Please enter a value between 0 and 255!");
            }
        }
        return c;
    }



}