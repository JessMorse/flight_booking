package com.airport.flight;
import com.airport.passenger.Passenger;

public class Flight {
    private int id;
    private Passenger[] passengers;
    private int capacity;
    private int currentlyOccupied;
    private FlightStatus status;

    public Flight(int id, Passenger[] passengers, int capacity, int currentlyOccupied, FlightStatus status) {
        this.id = id;
        this.passengers = passengers;
        this.capacity = capacity;
        this.currentlyOccupied = currentlyOccupied;
        this.status = status;
    }
}
