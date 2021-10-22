package com.airport.flight;

import java.util.ArrayList;

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
        flight.setStatus(FlightStatus.CANCELLED);
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

}
