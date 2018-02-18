package com.epam.testauto.hw7;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import static com.epam.testauto.Constants.JSON_FILE_PATH;

public class JsonReader {

    private static Map<String, JsonData> dataMap = null;
    private static File file = new File(JSON_FILE_PATH);

    public static Map<String, JsonData> readFile() {
        try (com.google.gson.stream.JsonReader jsonReader = new com.google.gson.stream.JsonReader(new FileReader(file))) {
            Type token = new TypeToken<Map<String, JsonData>>() {{
            }}.getType();
            dataMap = new Gson().fromJson(jsonReader, token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }
}
