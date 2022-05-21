package com.example.lab_3;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "jsonServlet", value = "/jsonServlet")
public class jsonServlet extends HttpServlet {
    private final LaptopService laptops = new LaptopService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");

        try(PrintWriter out = response.getWriter()) {
            // сериализация в модели
            out.write(laptops.serialize());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            // входящая строка
            String input = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
            // дессериализация в модели
            laptops.deserialize(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}