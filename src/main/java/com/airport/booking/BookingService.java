package com.airport.booking;

import com.airport.passenger.Passenger;
import com.airport.flight.FlightService;
import com.airport.flight.Flight;

import java.util.Arrays;
import java.util.Scanner;

public class BookingService {


    public void requestBooking(Passenger passenger, FlightService fs, Flight flight){
        if(fs.getFlights().contains(flight)){
            if (flight.getCurrentlyOccupied() < flight.getCapacity()) {
                if(!Arrays.stream(flight.getPassengers()).anyMatch(passenger::equals)){
                    flight.setPassengers(flight.getCurrentlyOccupied(), passenger);
                    flight.setCurrentlyOccupied(flight.getCurrentlyOccupied()+1);
                    passenger.addFlight(flight);
//                    System.out.println(fs.getFlights());
                }
            }
        }
        else System.out.println("flight does not exist");
    }
    public static void addToDatabase() {
    }





}
