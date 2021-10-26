package com.airport.passenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import com.airport.email.Email;
import com.airport.flight.Flight;
import com.airport.phone.Phone;

public class Passenger {
    private final String passenger;
    private final String email;
    private final int passportNo;
    private final String phoneNo;
    private final ArrayList<Flight> flights = new ArrayList<>();
    //private Email myEmail = new Email();

    public Passenger(String passenger, String email, int passportNo, String phoneNo) {
        this.passenger = passenger;
        this.email = Email.getEmail(email);
        this.passportNo = passportNo;
        this.phoneNo = Phone.getPhone(phoneNo);
    }

    public String getEmail() {
        return email;
    }

    public void addFlight(Flight flight){
        System.out.println(this.flights);
        this.flights.add(flight);
        System.out.println(this.flights);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger1 = (Passenger) o;
        //System.out.println("A user already has this passport number or email address");
        return passportNo == passenger1.passportNo || Objects.equals(email, passenger1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passenger, email, passportNo, phoneNo);
    }
}