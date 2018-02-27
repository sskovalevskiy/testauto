package com.epam.testauto.hw7;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import static com.epam.testauto.Constants.JSON_FILE_PATH;

public class MyJsonReader {

    private static Map<String, MetalsColorsFormData> dataMap = null;
    private static File file = new File(JSON_FILE_PATH);

    public static Map<String, MetalsColorsFormData> readFile() {
        try (JsonReader jsonReader = new JsonReader(new FileReader(file))) {
            Type token = new TypeToken<Map<String, MetalsColorsFormData>>() {{
            }}.getType();
            dataMap = new Gson().fromJson(jsonReader, token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }
}
