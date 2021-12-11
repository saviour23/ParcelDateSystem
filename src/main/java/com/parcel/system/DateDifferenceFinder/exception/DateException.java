package com.parcel.system.DateDifferenceFinder.exception;

/**
 * Custom exception for DateDiff program.
 */
public class DateException extends Exception {

    public DateException(String errorMessage, Throwable e) {
        super(errorMessage, e);
    }
}
