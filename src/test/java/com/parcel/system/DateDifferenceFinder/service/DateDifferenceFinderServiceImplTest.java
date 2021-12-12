package com.parcel.system.DateDifferenceFinder.service;

import com.parcel.system.DateDifferenceFinder.exception.DateException;
import com.parcel.system.DateDifferenceFinder.model.DateDiffModel;
import com.parcel.system.DateDifferenceFinder.service.impl.DateDifferenceFinderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateDifferenceFinderServiceImplTest {

    private DateDifferenceFinderService dateDifferenceFinderService;

    @Before
    public void init() {
        dateDifferenceFinderService = new DateDifferenceFinderServiceImpl();

    }

    /**
     * Testing valid date scenario.
     *
     * @throws DateException
     */
    @Test
    public void findDifferenceInDays_validateDateDiff() throws DateException {
        String[] dates = new String[2];
        dates[0] = "02 03 2020";
        dates[1] = "03 03 2020";
        DateDiffModel model = dateDifferenceFinderService.findDifferenceInDays(dates);
        assertEquals(1, model.getDifferenceInDays());

    }

    /**
     * Scenario to check leap year handling, 2020 is a leap year with 29 days in Feb
     *
     * @throws DateException
     */
    @Test
    public void findDifferenceInDays_LeapYear_withValidInput() throws DateException {
        String[] dates = new String[2];
        dates[0] = "27 02 2020";
        dates[1] = "01 03 2020";
        DateDiffModel model = dateDifferenceFinderService.findDifferenceInDays(dates);
        assertEquals(3, model.getDifferenceInDays());

    }

    /**
     * Validating full return object for positive scenario.
     *
     * @throws DateException
     */

    @Test
    public void findDifferenceInDays_fullModelValidation() throws DateException {

        String fromDate = "02 03 2020";
        String toDate = "03 03 2020";
        String[] dates = new String[2];
        dates[0] = fromDate;
        dates[1] = toDate;

        DateDiffModel model = dateDifferenceFinderService.findDifferenceInDays(dates);
        assertEquals(1, model.getDifferenceInDays());

        assertEquals(fromDate, model.getFromDate());
        assertEquals(toDate, model.getToDate());

    }

    /**
     * Negative scenario, trying to parse 30th Feb which is invalid date
     *
     * @throws DateException
     */
    @Test(expected = DateException.class)
    public void findDifferenceInDays_invalidDate() throws DateException {
        String[] dates = new String[2];
        dates[0] = "30 02 2020";
        dates[1] = "01 03 2020";
        dateDifferenceFinderService.findDifferenceInDays(dates);

    }


    /**
     * Scenario testing, even if first date is later and second date is previous, still it find the difference and shows correct dates.
     *
     * @throws DateException
     */
    @Test
    public void findDifferenceInDays_validateDateDiff_withRandomDates() throws DateException {
        String fromDate = "02 03 2020";
        String toDate = "03 03 2020";
        String[] dates = new String[2];
        dates[0] = toDate; // latest date in 0th position
        dates[1] = fromDate; // previous date in 1st position

        DateDiffModel model = dateDifferenceFinderService.findDifferenceInDays(dates);
        assertEquals(1, model.getDifferenceInDays());

        assertEquals(fromDate, model.getFromDate());
        assertEquals(toDate, model.getToDate());

    }


}
