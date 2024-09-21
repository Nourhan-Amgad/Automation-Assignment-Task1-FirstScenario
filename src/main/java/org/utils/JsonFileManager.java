package org.utils;

import io.restassured.path.json.JsonPath;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonFileManager {
    private final String jsonFilePath;
    private FileReader reader;

    public JsonFileManager(String jsonFilePath) throws FileNotFoundException {
        this.jsonFilePath = jsonFilePath;
        reader = new FileReader(jsonFilePath);
    }

    public String getTestData(String jsonPath) {
        Object testData = null;
        try {
            reader = new FileReader(jsonFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        testData = JsonPath.from(reader).getString(jsonPath);
        return String.valueOf(testData);
    }

}
