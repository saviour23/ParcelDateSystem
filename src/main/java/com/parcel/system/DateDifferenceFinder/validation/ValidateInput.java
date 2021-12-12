package com.parcel.system.DateDifferenceFinder.validation;

import static com.parcel.system.DateDifferenceFinder.constant.AppConstant.DATE_REGEX;

/**
 * Input validation class.
 * Validating following:-
 * 1) format should be in dd mm yyyy format
 * 2) year should be in between 1900 to 2020.
 */
public final class ValidateInput {

    public static boolean validateInputDates(String[] datesArr) {

        boolean isValid = false;

        if (datesArr.length == 2 && datesArr[0].trim().matches(DATE_REGEX) && datesArr[1].trim().matches(DATE_REGEX)) {
            isValid = true;
        }

        return isValid;

    }
}
