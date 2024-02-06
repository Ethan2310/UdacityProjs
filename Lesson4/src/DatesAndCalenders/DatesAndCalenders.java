package DatesAndCalenders;

import java.util.Calendar;
import java.util.Date;

public class DatesAndCalenders {

    public static void main(String args[])
    {
displayCurrentDate();
displaySetDate();
    }

    public static  void displayCurrentDate(){

        Calendar calender = Calendar.getInstance();
        Date date = new Date();
        calender.setTime(date);
        System.out.println(calender.getTime());
    }

    public static void displaySetDate(){

        Calendar calender = Calendar.getInstance();
        calender.set(2031,02,02);
        Date date = new Date();
        date = calender.getTime();
        System.out.println(date);



    }
}
