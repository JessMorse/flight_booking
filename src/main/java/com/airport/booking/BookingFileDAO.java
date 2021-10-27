package com.airport.booking;

import com.airport.dateTimeDeserializers.LocalDateDeserializer;
import com.airport.dateTimeDeserializers.LocalDateSerializer;
import com.airport.dateTimeDeserializers.LocalDateTimeDeserializer;
import com.airport.dateTimeDeserializers.LocalDateTimeSerializer;
import com.airport.flight.FlightService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingFileDAO implements BookingDAO{
    @Override
    public int saveBookingList(BookingService bs) {
        //        String json = new Gson().toJson(ps);

        //gson builders from https://www.javaguides.net/2019/11/gson-localdatetime-localdate.html
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());

        Gson gson = gsonBuilder.setPrettyPrinting().create();

        String json = gson.toJson(bs);
        System.out.println(json);

        try {
            File file = new File("src/main/resources/bookings.json");
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
    public BookingService getBookingList() {
        File file = new File("src/main/resources/bookings.json");
        try {
            JsonReader reader = new JsonReader(new FileReader(file));
            //gson builders from https://www.javaguides.net/2019/11/gson-localdatetime-localdate.html
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            BookingService bs = gson.fromJson(reader,BookingService.class);
//            System.out.println("Helloooo");
//            System.out.println(bs.get);
            return bs;
        } catch (FileNotFoundException e) {
            System.out.println("No bookings file found");
        }
        return null;
    }
}
