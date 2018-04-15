package lab1.date;

public class Date {


    public static enum Month{
        YANUARY(1, 31),
        FEBRUARY(2, 28),
        MARTH(3, 31),
        APRIL(4, 30),
        MAY(5, 31),
        JUNE(6, 30),
        JULY(7, 31),
        AUGUST(8, 31),
        SEPTEMBER(9, 30),
        OCTOBER(10, 31),
        NOVEMBER(11, 30),
        DECEMBER(12, 31);

        private final int numOfMonth;
        private final int numDays;

        Month(int numOfMonth, int numDays) {
            this.numOfMonth = numOfMonth;
            this.numDays = numDays;
        }

        public static Month number(int numOfMonth) {
            for (Month month : Month.values()) {
                if (month.numOfMonth == numOfMonth) {
                    return month;
                }
            }
            throw new IllegalArgumentException("Month index unsupported");
        }

        public boolean is(Month that) {
            return this == that;
        }

        public int getNumDays() {
            return numDays;
        }
    }

    private final int day;
    private final Month month;

    Date(int day, Month month) {
        this.day = day;
        this.month = month;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return day + " " + month;
    }
}
