package com.airport.phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    public static final Pattern VALID_PHONE_NUMBER_REGEX =
            Pattern.compile("^\\d{11}$");

    public static boolean validate(String phoneStr) {
        Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(phoneStr);
        return matcher.find();
    }

    public static String getPhone(String number) {
        if(validate(number)) return number;
        else return null;
    }
}
