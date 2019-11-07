package database.raw_database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static utils.Constants.CONST_RECORDS_HEADER;
import static utils.Constants.KEY_CUSS_WORD_NAME;
import static utils.Constants.rawDirtyWordsJsonLocation;

public class ParseDirtyWords {

    private static List<String> cussWordsList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            getCussWordsList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> getCussWordsList() throws Exception {

        JSONArray jsonArray = getCussWordsArray();

        for (Object item : jsonArray) addCussWordToList((JSONObject) item);

        return cussWordsList;
    }

    private static JSONArray getCussWordsArray() throws Exception {
        return (JSONArray) getParsedFileObject().get(CONST_RECORDS_HEADER);
    }

    private static JSONObject getParsedFileObject() throws Exception {
        return (JSONObject) new JSONParser().parse(new FileReader(rawDirtyWordsJsonLocation));
    }

    private static void addCussWordToList(JSONObject cussWord) {
        cussWordsList.add(cussWord.get(KEY_CUSS_WORD_NAME).toString());
    }
}