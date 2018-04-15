package lab1;

import lab1.date.Date;
import lab1.date.DateUtils;

import java.text.MessageFormat;
import java.util.Scanner;


/**
 * List of leap years can be found here:
 * http://shpargalkablog.ru/2013/10/leap-year.html
 */
public class Main {
    public static void main(String[] args) {

        show(1, 1998);
        show(31, 1998);
        show(60, 1998);
        show(365, 1998);
        System.out.println();

        show(1, 2004);
        show(31, 2004);
        show(60, 2004);
        show(365, 2004);
        show(366, 2004);
        System.out.println();

        show(1, 1918);
        show(31, 1918);
        show(60, 1918);
        show(352, 1918);
        System.out.println();

        show(1, 1900);
        show(31, 1900);
        show(60, 1900);
        show(366, 1900);
        System.out.println();

        show(1, 2000);
        show(31, 2000);
        show(60, 2000);
        show(365, 2000);
        System.out.println();
        System.out.println();

        for (;;) {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter year: ");
            int year = s.nextInt();
            System.out.print("Enter day: ");
            int day = s.nextInt();

            if (DateUtils.isValid(day, year)) {
                show(day, year);
            }
            else {
                System.out.println("Incorrect input");
            }
            System.out.println("Try again? y/n");
            String answer = s.next();
            if (answer.equals("n")) return;
        }


    }

    private static void show(int dayNumber, int year) {
        Date date = DateUtils.getDate(dayNumber, year);
        System.out.println(MessageFormat.format("The {0} day of {1}: {2}", dayNumber ,Long.toString(year), date));
    }
}
