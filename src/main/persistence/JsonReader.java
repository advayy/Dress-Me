package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
 * Reference Code from: JsonSerialization Demo
 * URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 * */
import org.json.*;

// Represents a reader that reads wardrobe from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads wardrobe from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Wardrobe read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWardrobe(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses wardrobe from JSON object and returns it
    private Wardrobe parseWardrobe(JSONObject jsonObject) {
        Wardrobe wardrobe = new Wardrobe();
        addClothes(wardrobe, jsonObject);
        return wardrobe;
    }

    // MODIFIES: wardrobe
    // EFFECTS: parses clothes and looks from JSON object and adds them to wardrobe
    private void addClothes(Wardrobe wardrobe, JSONObject jsonObject) {
        JSONArray jsonArrayClothes = jsonObject.getJSONArray("clothes");
        for (Object json : jsonArrayClothes) {
            JSONObject nextClothing = (JSONObject) json;
            wardrobe.addItem(parseClothing(nextClothing));
        }
        JSONArray jsonArrayLooks = jsonObject.getJSONArray("looks");
        for (Object json : jsonArrayLooks) {
            JSONObject nextLook = (JSONObject) json;
            wardrobe.addLook(parseLook(nextLook));
        }
    }

    // MODIFIES: wardrobe
    // EFFECTS: parses clothing from JSON object and adds it to wardrobe
    private Clothing parseClothing(JSONObject jsonObject) {
        //int index = jsonObject.getInt("index");
        String colour = jsonObject.getString("colour");
        String genre = jsonObject.getString("genre");
        String subType = jsonObject.getString("subtype");
        String name = jsonObject.getString("name");
        int code = determineKind(subType);
        Clothing newItem;
        if (code == 1) {
            newItem = new HeadWear(colour, genre, subType, name);
        } else if (code == 2) {
            newItem = new UpperWear(colour, genre, subType, name);
        } else if (code == 3) {
            newItem = new LowerWear(colour, genre, subType, name);
        } else {
            newItem = new FootWear(colour, genre, subType, name);
        }
        return newItem;
    }

    private Looks parseLook(JSONObject jsonObject) {
        JSONObject head = jsonObject.getJSONObject("head");
        JSONObject upper = jsonObject.getJSONObject("upper");
        JSONObject lower = jsonObject.getJSONObject("lower");
        JSONObject foot = jsonObject.getJSONObject("foot");

        Looks lookToReturn = new Looks(parseClothing(head),
                parseClothing(upper),
                parseClothing(lower),
                parseClothing(foot));
        return lookToReturn;
    }

    //Requires: A Sub Type string from the calling code
    //Effects: Returns an integer code depending on the kind of wear the subtype is part of
    private int determineKind(String subtype) {
        String[] head = HeadWear.getAcceptableItems();
        String[] upper = UpperWear.getAcceptableItems();
        String[] lower = LowerWear.getAcceptableItems();
        //String[] foot = FootWear.getAcceptableItems();
        int code;
        if (subtypeMatch(head, subtype)) {
            code = 1;
        } else if (subtypeMatch(upper, subtype)) {
            code = 2;
        } else if (subtypeMatch(lower, subtype)) {
            code = 3;
        } else {
            code = 4;
        }
        return code;
    }

    //Requires: A string array of types and a subtype
    //Effects:  Sees if the type is contained in the given list, else returns false
    private boolean subtypeMatch(String[] list, String subtype) {
        boolean flag = false;
        for (String s : list) {
            if (subtype.equals(s)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
