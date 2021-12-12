package com.parcel.system.DateDifferenceFinder.service;


import com.parcel.system.DateDifferenceFinder.constant.AppConstant;
import com.parcel.system.DateDifferenceFinder.exception.DateException;
import com.parcel.system.DateDifferenceFinder.model.DateDiffModel;
import com.parcel.system.DateDifferenceFinder.validation.ValidateInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;

/**
 * Service class to find the date difference.
 */
public interface DateDifferenceFinderService {


    /**
     * Service to calculate the difference between the dates.
     *
     * @param datesArr array containing the dates.
     * @return DateDiff model object containing from, to and date diff.
     */
    DateDiffModel findDifferenceInDays(String[] datesArr) throws DateException;
}
