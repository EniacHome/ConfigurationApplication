package com.EniacDevelopment.Configuration_Application.util;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Helper functions for handling dates
 *
 * Created by nickd on 01/02/2017.
 */
public class Date_to_String {

    /*The date pattern that is used for conversion. Change as you wish*/
    private static final String DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";

    /*The date formatter*/
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    /*Returns the given data as a well formatted String. The above defined*/
    public static String format(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /*Converts a String to a LocalDate object*/
    public static LocalDateTime parse_to_LocalDate(String date_String){
        try {
            return DATE_FORMATTER.parse(date_String, LocalDateTime::from);
        }
        catch (DateTimeParseException e){
            return null;
        }
    }

    /*Checks the String whether it is a valid date*/
    public static boolean valid_date(String date_String){
        /*Try to parse the String*/
        return Date_to_String.parse_to_LocalDate(date_String) != null;
    }
}
