package com.airport.booking;

import com.airport.passenger.PassengerService;

import java.awt.print.Book;

public interface BookingDAO {
    int saveBookingList(BookingService bs);
    BookingService getBookingList();
}
