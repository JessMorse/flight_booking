package com.airport.booking;

import com.airport.Main;
import com.airport.passenger.Passenger;
import com.airport.flight.FlightService;
import com.airport.flight.Flight;
import com.airport.passenger.PassengerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BookingService {
    private ArrayList<Booking> bookings = new ArrayList<>();

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

    public void setBooking(PassengerService ps, FlightService fs){
        System.out.println("Enter passenger email");
        String email = Main.getUserInput();
        Passenger p = ps.getPassengerByID(email);
        if (!(p == null)) {
            System.out.println("Enter flight id that you want to book");
            int flightID = Integer.parseInt(Main.getUserInput());
            Flight f = fs.getFlightByID(flightID);
            if (!(f == null)){
                this.requestBooking(p, fs, f);
            } else System.out.println("flight does not exist");
        }else System.out.println("User does not exist, please create user");
    }

    public void cancelBooking(Passenger passenger, FlightService fs, Flight flight){
//        TODO: add booking to arraylist when set,       remove when cancelled/change status

    }






}
