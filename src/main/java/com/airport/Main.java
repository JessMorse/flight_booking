package com.airport;

import com.airport.booking.BookingService;
import com.airport.flight.Flight;
import com.airport.flight.FlightService;
import com.airport.flight.FlightStatus;
import com.airport.passenger.Passenger;
import com.airport.passenger.PassengerService;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    PassengerService ps = new PassengerService();
    FlightService fs = new FlightService();
    BookingService bs = new BookingService();
    public static void main(String[] args) {
        //someFlights();
        new Main();

    }

    //testing method
    public static void someFlights(){

        Flight flight1 = new Flight(50, 0,  "London", "Edinburgh", LocalDate.of(2021, 10,15));
        Flight flight2 = new Flight( 12, 0,  "NY", "London", LocalDate.of(2021, 8,10));
        Flight flight3 = new Flight(100, 0, "Istanbul", "Luton", LocalDate.of(2021, 12,25));
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

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void initProgram(){
        System.out.println("1. Add user");
        System.out.println("2. Book a flight");
        System.out.println("3. Display all flights");
        System.out.println("4. Display booked flights");
        System.out.println("5. Cancel a flight");
        System.out.println("6. Add a new flight");
    }

    public void runAppropriateTask(){
        while (true){
            initProgram();
            String query = getUserInput();
            if (query.equals("exit")){
                break;
            }
            else if(query.equals("1")){
                //run method that collects data for a new user
                ps.generatePassenger();
            }
            else if(query.equals("2")){
                //Todo: fix request booking method to use passenger id and flight id
                //bs.requestBooking();
            }
            else if(query.equals("3")) {
                //run method that displays all flights
                fs.getFlights();
            }
            else if(query.equals("4")){
                //run method that displays all booked flights
                fs.getBookedFlights();
            }
            else if(query.equals("5")){
                //run method that cancels a flight
                System.out.println("What is the ID of flight would you like to cancel?");
                int id = Integer.parseInt(getUserInput());
                fs.cancelFlight(fs.getFlightByID(id));
                System.out.println("Flight cancelled :(" );
            }
            else if (query.equals("6")){
                fs.generateFlight();
            }
        }
    }

    public Main(){
        runAppropriateTask();

    }



}
