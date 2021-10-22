package com.airport;

import com.airport.booking.BookingService;
import com.airport.flight.Flight;
import com.airport.flight.FlightService;
import com.airport.flight.FlightStatus;
import com.airport.passenger.Passenger;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        someFlights();
    }

    public static void someFlights(){

        Flight flight1 = new Flight(50, 0, FlightStatus.OK, "London", "Edinburgh", LocalDate.of(2021, 10,15));
        Flight flight2 = new Flight( 12, 0, FlightStatus.CANCELLED, "NY", "London", LocalDate.of(2021, 8,10));
        Flight flight3 = new Flight(100, 0, FlightStatus.OK, "Istanbul", "Luton", LocalDate.of(2021, 12,25));
        FlightService flightService = new FlightService();
        flightService.addFlight(flight1);
        flightService.addFlight(flight2);
        flightService.addFlight(flight3);

        //make a new passenger
        Passenger passenger1 = new Passenger("Bob Smith", "bob@gmail.com", 1234567, 6);

        //make a new bookingservice with that passenger, a flight, and the flight service
        BookingService bookingService = new BookingService();

        bookingService.requestBooking(passenger1, flightService, flight1);
        bookingService.requestBooking(passenger1, flightService, flight2);
//        System.out.println(passenger1.getFlights());
        System.out.println(flightService.getBookedFlights());

//        System.out.println(flightService.getFlights());
    }


}
