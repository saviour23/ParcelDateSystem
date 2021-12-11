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
public final class DateDifferenceFinderService {

    private static Logger LOG = LoggerFactory.getLogger(DateDifferenceFinderService.class);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConstant.DATE_PATTERN).withResolverStyle(ResolverStyle.STRICT);

    /**
     * Function to calculate the difference between the dates.
     *
     * @param datesArr array containing the dates.
     * @return DateDiff model object containing from, to and date diff.
     */
    public DateDiffModel findDifferenceInDays(String[] datesArr) throws DateException {
        DateDiffModel dateDiffModel = null;
        try {

            if (ValidateInput.validateInputDates(datesArr)) {

                DateDiffModel.DateDiffModelBuilder dateDiffModelBuilder = DateDiffModel.builder();
                LocalDate dateAtIndexZero = LocalDate.parse(datesArr[0].trim(), dateTimeFormatter);
                LocalDate dateAtIndexFirst = LocalDate.parse(datesArr[1].trim(), dateTimeFormatter);

                if (dateAtIndexZero.isAfter(dateAtIndexFirst)) {
                    dateDiffModelBuilder.fromDate(datesArr[1].trim()).toDate(datesArr[0].trim());
                    dateDiffModelBuilder.differenceInDays(getDateDiff(dateAtIndexFirst, dateAtIndexZero));
                } else {
                    dateDiffModelBuilder.fromDate(datesArr[0].trim()).toDate(datesArr[1].trim());
                    dateDiffModelBuilder.differenceInDays(getDateDiff(dateAtIndexZero, dateAtIndexFirst));
                }

                dateDiffModel = dateDiffModelBuilder.build();

                LOG.info("{}, {}, {}", dateDiffModel.getFromDate(), dateDiffModel.getToDate(),
                        dateDiffModel.getDifferenceInDays());
            } else {
                LOG.error(AppConstant.ERROR_MESSAGE);
            }


        } catch (Exception e) {
            LOG.error("Error in  application, errorMessage= {}", e.getMessage());
            throw new DateException("Error in Application, error Message= ", e);
        }
        return dateDiffModel;

    }

    private long getDateDiff(LocalDate fromDate, LocalDate toDate) {
        return ChronoUnit.DAYS.between(fromDate, toDate);
    }
}
