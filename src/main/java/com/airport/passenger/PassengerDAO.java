package com.airport.passenger;

import com.google.gson.Gson;

public interface PassengerDAO {
    int saveUserList(PassengerService ps);
    int getUserList();
}
