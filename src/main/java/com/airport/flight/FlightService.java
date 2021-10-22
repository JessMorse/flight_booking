package com.airport.flight;

import java.util.ArrayList;

public class FlightService {
    private ArrayList<Flight> flights = new ArrayList<>();


    public void addFlight(Flight flight){
        if (!flights.contains(flight)) {
            flights.add(flight);
        }
    }

    public ArrayList<Flight> getFlights(){
        return this.flights;
    }
}
