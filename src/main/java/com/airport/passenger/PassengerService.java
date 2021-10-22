package com.airport.passenger;

import java.util.ArrayList;
import java.util.Scanner;

public class PassengerService {
    private ArrayList<Passenger> users = new ArrayList<>();

    public void addUser(Passenger user){
        if (!users.contains(user) && user.getEmail()!=null) {
            users.add(user);
        }
    }

    public Passenger getPassengerByID(String email){
        for(Passenger passenger : users){
            if (passenger.getEmail().equals(email)) return passenger;
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

        System.out.println("Please type passport number");

        int passportNo = Integer.parseInt(getUserInput());

        System.out.println("Please type phone number");

        long phoneNo = Long.parseLong(getUserInput());

        Passenger passenger = new Passenger(userName, email, passportNo, phoneNo);
        System.out.println("Success! \n");
        System.out.println(passenger);
        addUser(passenger);
        return passenger;
    }

}
