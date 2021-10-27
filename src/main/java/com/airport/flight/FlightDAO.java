package com.airport.flight;

import com.airport.passenger.PassengerService;

public interface FlightDAO {
    int saveFlightList(FlightService fs);
    FlightService getUserList();
}
