package com.parcel.system.DateDifferenceFinder.validation;

import org.junit.Assert;
import org.junit.Test;

public class ValidateInputTest {

    /**
     * Positive scenario with valid input dates
     */
    @Test
    public void validateDates_validScenario() {
        String[] dates = new String[2];
        dates[0] = "02 03 2020";
        dates[1] = "03 03 2020";

        boolean isValid = ValidateInput.validateInputDates(dates);
        Assert.assertTrue(isValid);
    }


    /**
     * Negative scenario, year >2020
     */

    @Test
    public void validateDates_InvalidInput1() {
        String[] dates = new String[2];
        dates[0] = "02 03 2021";
        dates[1] = "03 03 2020";

        boolean isValid = ValidateInput.validateInputDates(dates);
        Assert.assertFalse(isValid);
    }

    /**
     * Negative scenario, year <1900
     */
    @Test
    public void validateDates_InvalidInput2() {
        String[] dates = new String[2];
        dates[0] = "02 03 2020";
        dates[1] = "03 03 1899";

        boolean isValid = ValidateInput.validateInputDates(dates);
        Assert.assertFalse(isValid);
    }

    /**
     * Nagative Scenario, month >12
     */
    @Test
    public void validateDates_InvalidInput3() {
        String[] dates = new String[2];
        dates[0] = "02 13 2020";
        dates[1] = "03 03 2020";

        boolean isValid = ValidateInput.validateInputDates(dates);
        Assert.assertFalse(isValid);
    }

    /**
     * Negative scenario, day >31
     */
    @Test
    public void validateDates_InvalidInput4() {
        String[] dates = new String[2];
        dates[0] = "32 13 2020";
        dates[1] = "03 03 2020";

        boolean isValid = ValidateInput.validateInputDates(dates);
        Assert.assertFalse(isValid);
    }

    /**
     * Negative scenario, input dates more than 2
     */
    @Test
    public void validateDates_InvalidInput5() {
        String[] dates = new String[3];
        dates[0] = "32 13 2020";
        dates[1] = "03 03 2020";
        dates[2] = "03 03 2020";

        boolean isValid = ValidateInput.validateInputDates(dates);
        Assert.assertFalse(isValid);
    }

    /**
     * Negative scenario, Feb month with date
     *//*
    @Test
    public void validateDates_InvalidInput5() {
        String[] dates = new String[2];
        dates[0] = "30 02 2020";
        dates[1] = "03 03 2020";

        boolean isValid = ValidateInput.validateInputDates(dates);
        Assert.assertTrue(false);
    }*/




}
