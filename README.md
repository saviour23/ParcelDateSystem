#Parcel Systems, Date comparison Tool
# Requirements
##Input 
Dates with following format:-
DD MM YYYY , DD MM YYYY

Validate input and find the difference in days between supplied dates.

##Output:-

DD MM YYYY , DD MM YYYY , difference

1) first date is earliest
2) the second date is latest
3) difference is the number of days

##Constraints
limit input range of dates between 1900 to 2020


##Solution
Java 8 has provided the Time library which is equivalent to Joda-Time and it's recommended to use java 8 library instead of joda.
Ref [Java 8 Recommended](https://www.joda.org/joda-time/).

Date diff finding method is
```dtd
ChronoUnit.DAYS.between(fromDate, toDate)
```
This method will find the difference and it also caters to the LEAP year calculations as well.

As per the requirement, I have used the formatter provided by java 8 i.e. `DateTimeFormatter` which is immutable and thread safe.

***RegEx used for validation:-***
```
"^(0[1-9]|[12][0-9]|3[01])\\s(0[1-9]|1[012])\\s(19[0-9][0-9]|20(0[0-9]|1[0-9]|20))$"
```
regex is validating the basic input format "DD MM YYYY" and that the year must be in between 1900 to 2020


## Classes used
1) **ApplicationMain**:- Main class to read the input via scanner API
2) **DateDifferenceFinderService**:- Service class responsible to finding the difference and populate the model class as well
3) **ValidateInput**:- Class validating if input has 2 dates and if it's passing the regEx defined.
4) **DateDiffModel**:- Model class holding the FROM, TO and DateDiff result.
5) **DateException**:- Custom Exception class.
6) **AppConstant**:- Application constants.


