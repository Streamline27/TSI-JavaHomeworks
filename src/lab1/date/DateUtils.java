package lab1.date;

import static lab1.date.Date.Month.FEBRUARY;

public class DateUtils {

    public static boolean isValid(int dayNumber, int year) {
        int numOfDaysInYear = isLeap(year) ? 366 : 365;
        if (year == 1918 && dayNumber > 32) dayNumber += 13;

        return (year <= 2800 && year >= 1800) &&  (dayNumber <= numOfDaysInYear && dayNumber > 0);
    }

    public static Date getDate(int dayNumber, int year) {

        if (!isValid(dayNumber, year)) throw new IllegalArgumentException("Year or day out of bounds");

        if (year == 1918 && dayNumber > 32) dayNumber += 13;
        int daysToCount = dayNumber;

        for (int i = 1; i <= 12; i++) {
            Date.Month month = Date.Month.number(i);
            int daysAtMonth = numOfDaysAt(month, year);
            if (daysToCount <= daysAtMonth) {
                return new Date(daysToCount, month);
            }
            daysToCount -= daysAtMonth;
        }
        throw new IllegalArgumentException();
    }

    static private int numOfDaysAt(Date.Month month, int year) {
        int numDays = month.getNumDays();
        if (isLeap(year) && month.is(FEBRUARY)) {
            return numDays + 1;
        }

        return numDays;
    }

    static private boolean isLeap(int year) {
        if (year > 1918) {
            return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
        }
        else return year % 4 == 0;
    }
}
