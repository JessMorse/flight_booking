package com.airport.booking;

import java.util.Objects;

import com.airport.flight.Flight;
import com.airport.passenger.Passenger;


public class Booking {
    private Flight flight;
    private Passenger passenger;
    private BookingStatus status;
    private int id;

    public Booking(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
        this.status = BookingStatus.BOOKED;
        //this.id = id;
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

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "flight=" + flight +
                ", passenger=" + passenger +
                ", status=" + status +
                ", id=" + id +
                '}';
    }


}
