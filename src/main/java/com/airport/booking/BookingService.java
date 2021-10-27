package com.airport.booking;

import com.airport.Main;
import com.airport.email.Email;
import com.airport.passenger.Passenger;
import com.airport.flight.FlightService;
import com.airport.flight.Flight;
import com.airport.passenger.PassengerService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class BookingService {
    private ArrayList<Booking> bookings = new ArrayList<>();

    public void requestBooking(Passenger passenger, FlightService fs, Flight flight) {
        if (fs.getFlights().contains(flight)) {
            if (flight.getCurrentlyOccupied() < flight.getCapacity()) {
                if (!Arrays.stream(flight.getPassengers()).anyMatch(passenger::equals)) {
                    flight.setPassengers(flight.getCurrentlyOccupied(), passenger);
                    flight.setCurrentlyOccupied(flight.getCurrentlyOccupied() + 1);
                    passenger.addFlight(flight);
                    Booking booking = new Booking(flight, passenger);
                    bookings.add(booking);
                    booking.setId(bookings.indexOf(booking));
                    System.out.println(bookings);
//                    System.out.println(fs.getFlights());
                }
            } else System.out.println("Flight full");
        } else System.out.println("flight does not exist");
    }



    public void setBooking(PassengerService ps, FlightService fs) {
        System.out.println("Enter passenger email");
        String email = Main.getUserInput();
        Passenger p = ps.getPassengerByID(email);
        if (!(p == null)) {
            System.out.println("Enter flight id that you want to book");
            int flightID = Integer.parseInt(Main.getUserInput());
            Flight f = fs.getFlightByID(flightID);
            if (!(f == null)) {
                this.requestBooking(p, fs, f);
            } else System.out.println("flight does not exist");
        } else System.out.println("User does not exist, please create user");
    }


    public Booking getBookingByEmailAndFlightID(String email, int id){
        for (Booking booking : bookings){
            if (booking.getPassenger().getEmail().equals(email)){
                if (booking.getFlight().getId() == id){
                    return booking;
                }
            }
        }
        return null;
    }

    public void cancelBooking(FlightService fs, PassengerService ps) {
        ArrayList<Flight> flights = fs.getFlights();
        System.out.println("Please enter email address of passenger");
        String email = Email.getEmail(Main.getUserInput());
        System.out.println("Please enter flight ID");
        try {
            int id = Integer.parseInt(Main.getUserInput());
            for (Flight flight : flights) {
                if (flight.getId() == id) {
                    String[] passengers = flight.getPassengers();
                    for (int i = 0; i < passengers.length; i++) {
                        String passenger = passengers[i];
                        if (passenger == null) {
                            System.out.println("Passenger not found");
                            break;
                        }
                        else if (passenger.equals(email)) {
                            passengers[i] = null;
                            System.out.println(email + " " + id);
                            Booking booking = getBookingByEmailAndFlightID(email, id);
                            booking.setBookingStatus(BookingStatus.CANCELLED);
                            flight.setCurrentlyOccupied(flight.getCurrentlyOccupied() - 1);
                            for (int j = i; j < passengers.length - 1; j++) {
                                if (passengers[j + 1] != null) {
                                    passengers[j] = passengers[j + 1];
                                    passengers[j + 1] = null;
                                } else break;
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
        catch (NumberFormatException e){
            System.out.println("make sure to use an integer");
        }

        System.out.println("Booking cancelled");
    }
}