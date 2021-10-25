package com.airport.flight;

import com.airport.passenger.Passenger;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightService {
    private ArrayList<Flight> flights = new ArrayList<>();


    public void addFlight(Flight flight){
        if (!flights.contains(flight)) {
            flights.add(flight);
            flight.setId(flights.indexOf(flight));
        }
    }


    public ArrayList<Flight> getFlights(){
        return this.flights;
    }

    public void cancelFlight(Flight flight){
        if(flight != null) {
            flight.setStatus(FlightStatus.CANCELLED);
            System.out.println("Flight cancelled :(");
        }
        else{
            System.out.println("Flight not found");
        }

    }

    public ArrayList<Flight> getBookedFlights() {
        ArrayList<Flight> bookedFlights = new ArrayList<>();
        for (Flight flight: this.flights){
            if (flight.getPassengers()[0]!=null){
                bookedFlights.add(flight);
            }
        }
        return bookedFlights;
    }
    public Flight getFlightByID(int id){
        for(Flight flight : flights){
            if (flight.getId()==id) return flight;
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

    public Flight generateFlight(){
        System.out.println("Please type flight capacity");
        int capacity = Integer.parseInt(getUserInput());
        System.out.println("Please type flight departure");
        String departure = getUserInput();
        System.out.println("Please type flight destination");
        String destination = getUserInput();
        System.out.println("Please type flight date in the format YYYY-MM-DD");

        try{
            LocalDate date = LocalDate.parse(getUserInput());
            Flight flight = new Flight(capacity, 0, departure, destination, date );
            System.out.println("Success! \n");
            System.out.println(flight);
            addFlight(flight);
            return flight;

        }catch(DateTimeParseException e){
            System.out.println("Please enter a valid date");
        }
        return null;

    }


}
