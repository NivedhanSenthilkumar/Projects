/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anubhavgupta
 */
public class DateUtils {

    public static Date stringToDate(String dateString) {

        try {
            return new SimpleDateFormat("MM/dd/yy").parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Date();
    }

    public static String dateToString(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = formatter.format(date);
        return dateString;

    }
    
    public static String dateToTimeString(Date date){
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
        
    }

    public static boolean isExpired(Date date) {

        return date.before(new Date());

    }

    public static int getYearFromDate(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);

    }
    
    public static Date convertStringToDateTime(String date, String time){
        
        String dateString = date + " " + time;
         try {
            return new SimpleDateFormat("MM/dd/yy HH:mm").parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Date();
        
        
    }
    
    public static String getTimeFromDate(Date date){
        
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(date);
        
    }
    

}
