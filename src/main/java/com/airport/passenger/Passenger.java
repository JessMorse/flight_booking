package com.airport.passenger;

import java.util.ArrayList;
import java.util.Arrays;
import com.airport.flight.Flight;

public class Passenger {
    private String passenger;
    private String email;
    private int passportNo;
    private long phoneNo;
    private ArrayList<Flight> flights = new ArrayList<>();

    public Passenger(String passenger, String email, int passportNo, long phoneNo) {
        this.passenger = passenger;
        this.email = email;
        this.passportNo = passportNo;
        this.phoneNo = phoneNo;
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

    public String getFlights() {
        String temp = "";
        for (Flight flight : flights){
            temp+="FlightID: ";
            temp+=flight.getId();
            temp+=", ";
        }
        return temp;
    }

    @Override
    public String toString() {
        return "passenger=" + passenger;
    }
}