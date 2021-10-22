package com.airport.booking;

import java.util.Objects;

import com.airport.flight.Flight;
import com.airport.passenger.Passenger;


public class Booking {
    private Flight flight;
    private Passenger passenger;
    private BookingStatus status;

    public Booking(Flight flight, Passenger passenger, BookingStatus status) {
        this.flight = flight;
        this.passenger = passenger;
        this.status = status;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setBookingStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "flight=" + flight +
                ", passenger=" + passenger +
                ", status=" + status +
                '}';
    }


}
