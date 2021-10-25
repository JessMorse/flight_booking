package com.airport.passenger;

import com.airport.email.Email;
import com.airport.phone.Phone;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PassengerService {
    private List<Passenger> users = new ArrayList<>();
    private Gson gson = new Gson();

    public void addUser(Passenger user){
        if (!users.contains(user) && user.getEmail()!=null) {
            users.add(user);
            System.out.println("Success! \n" + user);
        }
        else System.out.println("User already exists with this email or passport number or your email is not valid");
    }

    public Passenger getPassengerByID(String email){
        for(Passenger passenger : users){
//            System.out.println("checking");
            if (passenger.getEmail().equals(email)) {
//                System.out.println("found");
                return passenger;
            }
        }
        return null;
    }

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        if (response != "") return response;
        else{
            System.out.println("Please provide a non empty response");
            return getUserInput();
        }
    }

    public Passenger generatePassenger(){
        System.out.println("Please type passenger name");

        String userName = getUserInput();

        System.out.println("Please type email address");

        String email = getUserInput();
        while (Email.getEmail(email) == null){
            System.out.println("please use a valid email");
            email = getUserInput();
        }

        System.out.println("Please type passport number");

        int passportNo = Integer.parseInt(getUserInput());

        System.out.println("Please type phone number");

        String phoneNo = getUserInput();
        while (Phone.getPhone(phoneNo) == null){
            System.out.println("please use a valid phone number");
            phoneNo = getUserInput();
        }

        Passenger passenger = new Passenger(userName, email, passportNo, phoneNo);
        addUser(passenger);
        return passenger;
    }

    /*public void outputAllUsers(){
        //File file = new File("users.json");
        try {
            FileWriter fw = new FileWriter("users.json");
            Type listType = new TypeToken<List<Passenger>>() {}.getType();
            System.out.println(gson.toJson(users, listType));
            //fw.write(gson.toJson(users));;
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //Type listType = new TypeToken<List<Passenger>>() {}.getType();
//        Object[] temp =  users.toArray();
//        System.out.println(gson.toJson(temp));
//        System.out.println(gson.toJson(users, listType));


    /*public void importUsers(){
        try {
            JsonReader reader = new JsonReader(new FileReader("users.json"));
            Passenger[] passengers = gson.fromJson(reader, Passenger[].class);
            users = Arrays.asList(passengers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
