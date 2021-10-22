package com.airport;

import com.airport.flight.Flight;
import com.airport.flight.FlightService;
import com.airport.flight.FlightStatus;

public class Main {
    public static void main(String[] args) {
        someFlights();
    }

    public static void someFlights(){

        Flight flight1 = new Flight(50, 0, FlightStatus.OK, "London", "Edinburgh" );
        Flight flight2 = new Flight( 12, 0, FlightStatus.CANCELLED, "NY", "London" );
        Flight flight3 = new Flight(100, 0, FlightStatus.OK, "Istanbul", "Luton" );
        FlightService flightService = new FlightService();
        flightService.addFlight(flight1);
        flightService.addFlight(flight2);
        flightService.addFlight(flight3);

        System.out.println(flightService.getFlights());
    }
}
