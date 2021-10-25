package com.airport.flight;
import com.airport.passenger.Passenger;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Flight {
    private int id;
    private Passenger[] passengers;
    private int capacity;
    private int currentlyOccupied;
    private FlightStatus status = FlightStatus.OK;
    private String departure;
    private String destination;
    private LocalDate date;

    public Flight(int capacity, int currentlyOccupied, String destination, String departure, LocalDate date) {
        //this.id = id;
        this.passengers = new Passenger[capacity];
        this.capacity = capacity;
        this.currentlyOccupied = currentlyOccupied;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }


    public void setId(int id){
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public FlightStatus getStatus(){
        return this.status;
    }

    public int getCurrentlyOccupied() {
        return currentlyOccupied;
    }

    public Passenger[] getPassengers(){
        return this.passengers;
    }

    public void setPassengers(int index, Passenger passenger) {
        this.passengers[index] = passenger;
    }

    public void setCurrentlyOccupied(int currentlyOccupied) {
        this.currentlyOccupied = currentlyOccupied;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return  capacity == flight.capacity && status == flight.status && Objects.equals(departure, flight.departure) && Objects.equals(destination, flight.destination) && Objects.equals(date, flight.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, status, departure, destination, date);
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
                '}' + '\n' + '\n';
    }
}
