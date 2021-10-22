package com.airport.flight;
import com.airport.passenger.Passenger;

import java.util.Arrays;
import java.util.Objects;

public class Flight {
    private int id;
    private Passenger[] passengers;
    private int capacity;
    private int currentlyOccupied;
    private FlightStatus status;
    private String departure;
    private String destination;

    public Flight(int capacity, int currentlyOccupied, FlightStatus status, String destination, String departure) {
        //this.id = id;
        //this.passengers = passengers;
        this.capacity = capacity;
        this.currentlyOccupied = currentlyOccupied;
        this.status = status;
        this.departure = departure;
        this.destination = destination;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && capacity == flight.capacity && status == flight.status && Objects.equals(departure, flight.departure) && Objects.equals(destination, flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacity, status, departure, destination);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", passengers=" + Arrays.toString(passengers) +
                ", capacity=" + capacity +
                ", currentlyOccupied=" + currentlyOccupied +
                ", status=" + status +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
