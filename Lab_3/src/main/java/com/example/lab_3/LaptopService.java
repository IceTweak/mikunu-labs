package com.example.lab_3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class LaptopService {

    // Абсолютный путь к файлу для записи
    private final String pathFile = "W:\\JavaLabs\\Lab_3\\src\\main\\webapp\\js\\records";

    public String serialize() {
        try {
            return FileUtils.readFileToString(new File(pathFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return """
[{"WARNING": "File is empty!"}]
                    """;
        }
    }

    public void deserialize(String input){

        try
        {
            File file = new File(pathFile);
            if(!file.exists()){
                Files.createFile(Path.of(pathFile));
            }
            FileReader reader = new FileReader(pathFile, StandardCharsets.UTF_8);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JSONParser parser = new JSONParser();

            // дессериализация JSON строки
            Laptop inputLaptop = gson.fromJson(input, Laptop.class);
            JSONObject jsonLine = (JSONObject) parser.parse(inputLaptop.toString());


            if(file.length() == 0) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(jsonLine);

                FileWriter writer = new FileWriter(pathFile, StandardCharsets.UTF_8);
                writer.write(gson.toJson(jsonArray));
                writer.close();
            }else{
                JSONArray jsonArray;
                jsonArray = (JSONArray) parser.parse(reader);
                jsonArray.add(jsonLine);

                FileWriter writer = new FileWriter(pathFile, StandardCharsets.UTF_8);
                writer.write(gson.toJson(jsonArray));
                writer.close();
            }
            reader.close();

        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
}
