package com.example.lab_2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.simple.parser.ParseException;

@WebServlet(name = "jsonServlet", value = "/jsonServlet")
public class jsonServlet extends HttpServlet {

    // Путь к файлу для записи - абсолютный
    private final String pathFile = "W:\\JavaLabs\\Lab_2\\src\\main\\webapp\\js\\records.json";

    public static String readFileAsString(String file) throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            String json = readFileAsString(pathFile);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try{
            File file = new File(pathFile);
            // Если файла нет, то создаем
            if(!file.exists()){
                Files.createFile(Path.of(pathFile));
            }
            FileReader reader = new FileReader(pathFile);

            String input = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8); // входящая строка
            JSONParser parser = new JSONParser();
            // Преобразуем входящие данные в JSON Object
            JSONObject jsonLine = (JSONObject) parser.parse(input);
            // Если файл пустой
            if(file.length() == 0){
                JSONArray jsonArray = new JSONArray();  // Создаем пустой массив из JSON Object
                jsonArray.add(jsonLine); // Добавляем входящие данные в массив
                FileWriter writer = new FileWriter(pathFile);  // записываем в файл
                writer.write(jsonArray.toJSONString());
                writer.close(); reader.close();
            }else{  // Иначе просто добавим и запишем в файл
                JSONArray jsonArray;
                jsonArray = (JSONArray) parser.parse(reader);
                jsonArray.add(jsonLine);
                FileWriter writer = new FileWriter(pathFile);
                writer.write(jsonArray.toJSONString());
                writer.flush(); reader.close(); writer.close();
            }
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}

