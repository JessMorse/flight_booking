package com.airport.passenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import com.airport.email.Email;
import com.airport.flight.Flight;

public class Passenger {
    private String passenger;
    private String email;
    private int passportNo;
    private long phoneNo;
    private ArrayList<Flight> flights = new ArrayList<>();
    private Email myEmail = new Email();

    public Passenger(String passenger, String email, int passportNo, long phoneNo) {
        this.passenger = passenger;
        this.email = myEmail.getEmail(email);
        this.passportNo = passportNo;
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
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

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setMyEmail(Email myEmail) {
        this.myEmail = myEmail;
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
        return passportNo == passenger1.passportNo && phoneNo == passenger1.phoneNo && Objects.equals(passenger, passenger1.passenger) && Objects.equals(email, passenger1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passenger, email, passportNo, phoneNo);
    }
}