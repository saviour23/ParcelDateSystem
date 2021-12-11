package com.parcel.system.DateDifferenceFinder.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Model class for holding To, From and difference in days between dates.
 */
@EqualsAndHashCode
@Getter
@Builder
public class DateDiffModel {

    private String fromDate;

    private String toDate;

    private long differenceInDays;


}
