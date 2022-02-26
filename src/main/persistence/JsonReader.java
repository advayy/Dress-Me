package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
    // EFFECTS: parses clothes from JSON object and adds them to wardrobe
    private void addClothes(Wardrobe wardrobe, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("clothes");
        for (Object json : jsonArray) {
            JSONObject nextClothing = (JSONObject) json;
            addClothing(wardrobe, nextClothing);
        }
    }

    // MODIFIES: wardrobe
    // EFFECTS: parses clothing from JSON object and adds it to wardrobe
    private void addClothing(Wardrobe wardrobe, JSONObject jsonObject) {
        int index = jsonObject.getInt("index");
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
        } else if (code == 4) {
            newItem = new FootWear(colour, genre, subType, name);
        } else {
            newItem = new Clothing(colour, genre, subType, name);
        }
        wardrobe.addItem(newItem);
    }

    private int determineKind(String subtype) {
        String[] head = HeadWear.getAcceptableItems();
        String[] upper = UpperWear.getAcceptableItems();
        String[] lower = LowerWear.getAcceptableItems();
        String[] foot = FootWear.getAcceptableItems();
        int code;
        if (subtypeMatch(head, subtype)) {
            code = 1;
        } else if (subtypeMatch(upper, subtype)) {
            code = 2;
        } else if (subtypeMatch(lower, subtype)) {
            code = 3;
        } else if (subtypeMatch(foot, subtype)) {
            code = 4;
        } else {
            code = 0;
        }
        return code;
    }

    private boolean subtypeMatch(String[] list, String subtype) {
        boolean flag = false;
        for (String s : list) {
            if (subtype.equals(s)) {
                flag = true;
            }
        }
        return flag;
    }

}
