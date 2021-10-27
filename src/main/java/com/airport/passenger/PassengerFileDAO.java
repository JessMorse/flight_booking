package com.airport.passenger;

import com.airport.dateTimeDeserializers.LocalDateDeserializer;
import com.airport.dateTimeDeserializers.LocalDateSerializer;
import com.airport.dateTimeDeserializers.LocalDateTimeDeserializer;
import com.airport.dateTimeDeserializers.LocalDateTimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PassengerFileDAO implements PassengerDAO{

    //Gson gson = new Gson();

    @Override
    public int saveUserList(PassengerService ps) {
//        String json = new Gson().toJson(ps);

        //gson builders from https://www.javaguides.net/2019/11/gson-localdatetime-localdate.html
        GsonBuilder gsonBuilder = new GsonBuilder();
        /*gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());*/
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        String json = gson.toJson(ps);
        System.out.println(json);

        try {
            File file = new File("src/main/resources/users.json");
            if (!file.exists()) {
                System.out.println(file.createNewFile());
            } else {
                System.out.println("File already exists");
            }
            FileWriter fileWriter = new FileWriter(file, false);

            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(json);

            printWriter.flush();
            printWriter.close();
            return 1;

        } catch (IOException e) {
            return 0;
        }
    }

    @Override
    public PassengerService getUserList() {
        File file = new File("src/main/resources/users.json");
        try {
            JsonReader reader = new JsonReader(new FileReader(file));
            //gson builders from https://www.javaguides.net/2019/11/gson-localdatetime-localdate.html
            GsonBuilder gsonBuilder = new GsonBuilder();
            /*gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());*/
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            PassengerService ps = gson.fromJson(reader,PassengerService.class);
            System.out.println(ps.getUsers());
            return ps;
        } catch (FileNotFoundException e) {
            System.out.println("No users file found");
        }
        return null;
    }
}
