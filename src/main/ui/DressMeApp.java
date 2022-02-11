package ui;

import model.*;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

// console application that communicates with the user.
public class DressMeApp {
    Wardrobe userWardrobe = new Wardrobe();
    Scanner inputScan = new Scanner(System.in);

    public DressMeApp() {
        runDressMe();
    }

    public void runDressMe() {
        boolean keepGoing = true;

        System.out.println("Welcome to Dress Me!!");
        System.out.println();

        while (keepGoing) {
            displayMenu();
            String stringInput = inputScan.next();
            int inp = Integer.parseInt(stringInput); // turns string input into
            if (inp == 6) {
                keepGoing = false;
                System.out.println("Goodbye <3");
            } else {
                processCommand(inp);
            }
        }

    }

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

    public void runAdditionSequence() {
        System.out.println("What kind of item would you like to add:");
        System.out.println("1 - Head Wear");
        System.out.println("2 - Upper Wear");
        System.out.println("3 - Lower Wear");
        System.out.println("4 - Footwear");
        System.out.println("Or enter X to cancel");
        System.out.print("Enter selected option: ");
        String stringInput = inputScan.next();
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

    @SuppressWarnings("methodlength")
    public void addToWardrobe(int code) {
        String color;
        String genre;
        String kind;
        String name;

        System.out.println("Enter the following details:");
        System.out.print("Item Name: ");
        name = inputScan.next();
        System.out.print("Item Genre: ");
        genre = inputScan.next();
        System.out.print("Item Kind: ");
        kind = inputScan.next();
        System.out.print("Item color: ");
        color = inputScan.next();
        Clothing newItem;
        switch (code) {
            case 1:
                newItem = new HeadWear(color, genre, name, kind);
                break;
            case 2:
                newItem = new UpperWear(color, genre, name, kind);
                break;
            case 3:
                newItem = new LowerWear(color, genre, name, kind);
                break;
            case 4:
                newItem = new FootWear(color, genre, name, kind);
                break;
            default:
                newItem = new Clothing(color, genre, name, kind);
        }
        userWardrobe.addItem(newItem);
        System.out.println("Operation Successful");
        System.out.println();
    }

    public void removeFromWardrobe() {
        System.out.println("Which of the following items would you like to remove?");
        listItems(userWardrobe.getUserWardrobe());
        System.out.println("Please enter the number beside the listing");
        System.out.print("Enter your selection or X to cancel: ");
        String stringInput = inputScan.next();
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
        }
        System.out.println();
    }

    public void runColourFilter() {
        System.out.println("Enter the Colour you're searching for");
        System.out.println("Enter Filter Colour Here: ");
        String input = inputScan.next().toLowerCase(Locale.ROOT);
        listItems(userWardrobe.getClothesOfColour(input));
    }

    public void runGenreFilter() {
        System.out.println("Enter the Genre/Apparel Type you're searching for");
        System.out.println("Enter Filter Genre Here: ");
        String input = inputScan.next().toLowerCase(Locale.ROOT);
        listItems(userWardrobe.getClothesOfApparelGenre(input));
    }
}