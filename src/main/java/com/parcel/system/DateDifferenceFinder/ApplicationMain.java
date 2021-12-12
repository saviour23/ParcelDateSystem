package com.parcel.system.DateDifferenceFinder;

import com.parcel.system.DateDifferenceFinder.service.DateDifferenceFinderService;
import com.parcel.system.DateDifferenceFinder.service.impl.DateDifferenceFinderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.util.Scanner;

import static com.parcel.system.DateDifferenceFinder.constant.AppConstant.COMMA_SPLITTER;

/**
 * Main class for calculating the difference in days between 2 dates.
 * User in expected to input  From and To date in comma saperated and in "DD MM YYYY" format.
 * Program will calculate the difference in days.
 */
public class ApplicationMain {

    private static Logger LOG = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new InputStreamReader(System.in))) {
            LOG.info("Please enter From and To date in comma separated in dd MM yyyy format");
            String inputString = scanner.nextLine();
            String[] datesArr = inputString.split(COMMA_SPLITTER);

            DateDifferenceFinderService serviceObject = new DateDifferenceFinderServiceImpl();
            serviceObject.findDifferenceInDays(datesArr);
        } catch (Exception e) {
            LOG.error("Error in  application, errorMessage= {}", e.getMessage());
        }
    }

}
