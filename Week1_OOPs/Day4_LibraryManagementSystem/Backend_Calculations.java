package Day_4_LibraryManagementSystem;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;

public class Backend_Calculations {
    //assuming perday fine of Rs 10;
    public int calculateFine_Overdue(int days){
        return 10*days;
    }
    public int findDateDifference(String start_date, String end_date) throws ParseException{
 
        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf
            = new SimpleDateFormat(
                "dd-MM-yyyy");
 
                int noOfDays;
 
            // parse method is used to parse
            // the text from a string to
            // produce the date
            Date d1 = (Date) sdf.parse(start_date);
            Date d2 = (Date) sdf.parse(end_date);
 
            // Calculate time difference
            // in milliseconds
            long difference_In_Time
                = d2.getTime() - d1.getTime();
 
            // Calculate time difference in
            //  years,
            // and days
 
            long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time)% 365;
 
            long difference_In_Years= TimeUnit.MILLISECONDS.toDays(difference_In_Time)/ 365l;
 
            noOfDays = (int) ((int) (difference_In_Years*365) + (difference_In_Days));
            

        return noOfDays;
    }
    
}
