package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;



// console application that communicates with the user.
// dresses up the user
public class DressMeApp {
    private static final String JSON_STORE = "./data/wardrobe.json";
    Wardrobe userWardrobe;
    Scanner inputScan;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    /*
     * Effects: Runs the Application loop
     * */
    public DressMeApp() throws FileNotFoundException {
        userWardrobe = new Wardrobe();
        inputScan = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runDressMe();
    }

    /* Requires: An integer input from the user
     * Effects: Gets user input and either quits or loops depending on what is entered
     * */
    public void runDressMe() {
        boolean keepGoing = true;

        System.out.println("Welcome to Dress Me!!");
        System.out.println();

        while (keepGoing) {
            displayMenu();
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

    /*
     * Effects: Prints a list of options from the user
     * */
    public void displayMenu() {
        System.out.println("What would you like to do");
        System.out.println("1 - Add an Item");
        System.out.println("2 - Remove an Item");
        System.out.println("3 - List all items in the Wardrobe");
        System.out.println("4 - List all items of a certain color");
        System.out.println("5 - List all items of a certain Genre/Apparel Type");
        System.out.println("6 - List all items of by Kind");
        System.out.println("7 - Save wardrobe to a file");
        System.out.println("8 - Load wardrobe from a file");
        System.out.println("9 - List all \"looks\"");
        System.out.println("10 - Add a \"look\"");
        System.out.println("11 - Remove a \"look\"");
        System.out.println("X - Exit");
        System.out.print("Enter your option: ");
    }

    /* Requires: an integer input from the user
     * Effects: Launches the user selected input
     * */
    @SuppressWarnings("methodlength")
    public void processCommand(int input) {
        if (input == 1) {
            runAdditionSequence();
        } else if (input == 2) {
            removeFromWardrobe();
        } else if (input == 3) {
            listItems(userWardrobe.getInternalWardrobe());
        } else if (input == 4) {
            runColourFilter();
        } else if (input == 5) {
            runGenreFilter();
        } else if (input == 6) {
            runTypeFilter();
        } else if (input == 7) {
            saveWardrobe();
        } else if (input == 8) {
            loadWardrobe();
        } else if (input == 9) {
            listAllLooks();
        } else if (input == 10) {
            runAddLookSequence();
        } else if (input == 11) {
            runRemoveLookSequence();
        } else {
            System.out.println("Please only input one of the given options!!");
            System.out.println();
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
        String genre = getInputText("Please enter Item Genre");
        genre = genre.toLowerCase(Locale.ROOT);
        //String subType = getInputText("Please enter Item Subtype");
        String subType = getSubType(code);
        String color = getInputText("Please enter Item Color");
        color = color.toLowerCase(Locale.ROOT);

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
            System.out.println();
        } else {
            int inp = Integer.parseInt(stringInput);
            boolean flag = userWardrobe.removeItemByIndex(inp);
            if (flag) {
                System.out.println("Operation Successful");
                System.out.println();
            } else {
                System.out.println("Operation Unsuccessful - index not found");
                System.out.println();
            }
        }
    }



    /* Requires: the list not be empty
     * Effects: Lists all items with their index codes to the user
     * */
    public void listItems(ArrayList<Clothing> clothesList) {
        flatLine();
        for (Clothing item: clothesList) {
            printClothingDetails(item);
            System.out.println();
        }
        System.out.println();
    }

    //Requires: An item of clothing as an input
    //Effects: Returns all the data of thw clothing item in the CLI
    public void printClothingDetails(Clothing item) {
        String color;
        String genre;
        String subType;
        String name;
        int index;
        color = item.getPieceColour();
        genre = item.getPieceGenre();
        subType = item.getPieceSubtype();
        name = item.getPieceName();
        index = item.getIndexNo();
        System.out.print("Item Index: " + index);
        System.out.print(", Item Name: " + name);
        System.out.print(", Item SubType: " + subType);
        System.out.print(", Item Genre: " + genre);
        System.out.print(", Item Color: " + color);
        System.out.println();
    }

    /* Requires: input color from the user
     * Effects: Lists all items that match the required filter specification
     * */
    public void runColourFilter() {
        System.out.println("Enter the Colour you're searching for");
        System.out.print("Enter Filter Colour Here: ");
        String input = inputScan.nextLine();
        input = input.toLowerCase();
        listItems(userWardrobe.getClothesOfColour(input));
    }

    /* Requires: input color from the user
     * Effects: Lists all items that match the required filter specification
     * */
    public void runGenreFilter() {
        System.out.println("Enter the Genre/Apparel Type you're searching for");
        System.out.print("Enter Filter Genre Here: ");
        String input = inputScan.nextLine();
        input = input.toLowerCase();
        listItems(userWardrobe.getClothesOfApparelGenre(input));
    }

    // EFFECTS: saves the wardrobe to file
    private void saveWardrobe() {
        try {
            jsonWriter.open();
            jsonWriter.write(userWardrobe);
            jsonWriter.close();
            System.out.println("Saved Wardrobe to " + JSON_STORE);
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
            System.out.println();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads wardrobe from file
    private void loadWardrobe() {
        try {
            userWardrobe = jsonReader.read();
            System.out.println("Loaded Wardrobe from " + JSON_STORE);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
            System.out.println();
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

    //Effects: Lists all "Looks" to the CLI
    private void listAllLooks() {
        flatLine();
        System.out.println("Here Are Your Looks: ");
        for (Looks l : userWardrobe.getInternalLooks()) {
            flatLine();
            System.out.println("Look index " + l.getIndexNo());
            printClothingDetails(l.getHeadWear());
            printClothingDetails(l.getUpperWear());
            printClothingDetails(l.getLowerWear());
            printClothingDetails(l.getFootWear());
            flatLine();
            System.out.println();
        }
    }

    //Requires: Valid user input
    //Modifies: this
    //Effects : Creates a new look from items of clothing by type from user and saves it to the wardrobe
    public void runAddLookSequence() {
        System.out.println("Pick an item of Head Wear");
        listItems(userWardrobe.getClothesByType(1));
        System.out.print("Enter its index here: ");
        int n = Integer.parseInt(inputScan.nextLine());
        Clothing head = (HeadWear) userWardrobe.getClothesByIndex(n);

        System.out.println("Pick an item of Upper Wear");
        listItems(userWardrobe.getClothesByType(2));
        System.out.print("Enter its index here: ");
        n = Integer.parseInt(inputScan.nextLine());
        Clothing upper = (UpperWear) userWardrobe.getClothesByIndex(n);

        System.out.println("Pick an item of Lower Wear");
        listItems(userWardrobe.getClothesByType(3));
        System.out.print("Enter its index here: ");
        n = Integer.parseInt(inputScan.nextLine());
        Clothing lower = (LowerWear) userWardrobe.getClothesByIndex(n);

        System.out.println("Pick an item of Footwear");
        listItems(userWardrobe.getClothesByType(4));
        System.out.print("Enter its index here: ");
        n = Integer.parseInt(inputScan.nextLine());
        Clothing foot = (FootWear) userWardrobe.getClothesByIndex(n);

        userWardrobe.addLook(new Looks(head, upper, lower, foot));
        System.out.println("Look Added");
        flatLine();
    }

    // Requires: Inout from user
    // Modifies: this
    // Effects : removes a look from the wardrobe
    public void runRemoveLookSequence() {
        listAllLooks();
        System.out.println("Which look index would you like to remove");
        System.out.print("Enter index here: ");
        int input = Integer.parseInt(inputScan.nextLine());
        userWardrobe.removeLookItemByIndex(input);
        System.out.println("Look Removed");
        flatLine();
    }
}