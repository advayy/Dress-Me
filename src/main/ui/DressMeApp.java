package ui;

import model.*;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

// console application that communicates with the user.
public class DressMeApp {
    Wardrobe userWardrobe = new Wardrobe();
    Scanner inputScan = new Scanner(System.in);

    /*
     * Effects: Runs the Application loop
     * */
    public DressMeApp() {
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
            int inp = Integer.parseInt(stringInput); // turns string input into
            if (inp == 6) {
                keepGoing = false;
                System.out.println("Goodbye <3");
            } else {
                processCommand(inp);
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
        System.out.println("6 - Exit");
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
            listItems(userWardrobe.getUserWardrobe());
        } else if (input == 4) {
            runColourFilter();
        } else if (input == 5) {
            runGenreFilter();
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
        if (stringInput.equals("X")) {
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
        String kind = getInputText("Please enter Item Kind");
        kind = kind.toUpperCase(Locale.ROOT);
        String color = getInputText("Please enter Item Color");
        color = color.toLowerCase(Locale.ROOT);

        Clothing newItem;
        if (code == 1) {
            newItem = new HeadWear(color, genre, kind, name);
        } else if (code == 2) {
            newItem = new UpperWear(color, genre, kind, name);
        } else if (code == 3) {
            newItem = new LowerWear(color, genre, kind, name);
        } else if (code == 4) {
            newItem = new FootWear(color, genre, kind, name);
        } else {
            newItem = new Clothing(color, genre, kind, name);
        }
        userWardrobe.addItem(newItem);
        System.out.println("Operation Successful");
        System.out.println();
    }

    public String getInputText(String outMsg) {
        System.out.println(outMsg);
        System.out.print("Enter input here: ");
        return inputScan.nextLine();
    }

    /* Requires: the wardrobe must not be empty
     * Modifies: this
     * Effects: Lists all items with their index codes and takes an input from the user and removes the selected item
     * */
    public void removeFromWardrobe() {
        System.out.println("Which of the following items would you like to remove?");
        listItems(userWardrobe.getUserWardrobe());
        System.out.println("Please enter the number beside the listing");
        System.out.print("Enter your selection or X to cancel: ");
        String stringInput = inputScan.nextLine();
        if (stringInput.equals("X")) {
            System.out.println("Operation Cancelled");
            System.out.println();
        } else {
            int inp = Integer.parseInt(stringInput);
            inp -= 1;
            userWardrobe.removeItem(inp);
            System.out.println("Operation Successful");
            System.out.println();
        }
    }

    /* Requires: the list not be empty
     * Effects: Lists all items with their index codes to the user
     * */
    public void listItems(ArrayList<Clothing> clothesList) {
        String color;
        String genre;
        String kind;
        String name;
        for (Clothing item: clothesList) {
            color = item.getPieceColour();
            genre = item.getPieceGenre();
            kind = item.getPieceKind();
            name = item.getPieceName();
            System.out.print("Item Index: " + (clothesList.indexOf(item) + 1));
            System.out.print(", Item Name: " + name);
            System.out.print(", Item Kind: " + kind);
            System.out.print(", Item Genre: " + genre);
            System.out.print(", Item Color: " + color);
            System.out.println();
        }
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
}