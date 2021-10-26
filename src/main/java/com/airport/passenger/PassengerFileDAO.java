package com.airport.passenger;

import com.airport.dateTimeDeserializers.LocalDateDeserializer;
import com.airport.dateTimeDeserializers.LocalDateSerializer;
import com.airport.dateTimeDeserializers.LocalDateTimeDeserializer;
import com.airport.dateTimeDeserializers.LocalDateTimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());

        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

        Gson gson = gsonBuilder.setPrettyPrinting().create();

        //String json = gson.toJson(ps);
        //System.out.println(ps.getPassengerByID("bob@bob.com").getFlights());
        //System.out.println(json);
        return 0;
    }

    @Override
    public int getUserList() {
        return 0;
    }
}
