/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile.bean;

import com.mobile.dto.Contact;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author wtccuser
 */
@ManagedBean
public class ContactUtilBean {

    private final static Logger LOGGER = Logger.getLogger(ContactUtilBean.class
            .getName());

    SimpleDateFormat _simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
    /*
    
     */

    public String getFormattedDate(java.util.Date date) {
        _simpleFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        String formattedDate = _simpleFormat.format(date);
        return formattedDate;
    }

    public static void main(String args[]) {

        // start 2017-07-15
        //end 2018-07-04
        String test = "2018-07-15";
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        Calendar cal = Calendar.getInstance();
        try {
            date = (Date) formatter.parse(test);
            cal.setTime(date);
            System.out.println("Today is " + date);
        } catch (ParseException ex) {
            Logger.getLogger(ContactUtilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Date getConvertFormattedDate(String dateStr) {
        _simpleFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        try {
            Date date = _simpleFormat.parse(dateStr);
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(ContactUtilBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getFormattedPhone(Contact contact) {
        String phoneMask = "###-###-####";
        String phoneNumber = contact.getPhone();

        MaskFormatter maskFormatter;
        try {
            maskFormatter = new MaskFormatter(phoneMask);
            maskFormatter.setValueContainsLiteralCharacters(false);
            String formatted = maskFormatter.valueToString(phoneNumber);
            return formatted;
        } catch (ParseException ex) {
            Logger.getLogger(ContactUtilBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contact.getPhone();
    }

    public String getEmailMessage(Contact contact) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("?");
        buffer.append("subject=");
        buffer.append("License key ");
        buffer.append("&");
        buffer.append("body=");
        buffer.append(contact.getLicense());
       // emailMessage = buffer.toString();
        return buffer.toString();
    }

    public long getDaysLeft(Contact contact) {

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Calendar calNowNewYork = Calendar.getInstance();
        calNowNewYork.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Calendar calLaterNewYork = Calendar.getInstance();
        int nowYear = calNowNewYork.get(Calendar.YEAR);
///int endMonth = contact.getEndDate().
        int nowDayOfMonth = calNowNewYork.get(Calendar.DAY_OF_MONTH);
        int nowMonth = calNowNewYork.get(Calendar.MONTH);
        if (nowMonth < 12) {
            calNowNewYork.set(Calendar.MONTH, nowMonth + 1);
        }

        try {

            //Date dateNow = formatter.parse("07/15/17");
            //calNowNewYork.setTime(dateNow);
            SimpleDateFormat xxxFormat = new SimpleDateFormat("yyyy-mm-dd");
            String endDateStr = xxxFormat.format(contact.getEndDate());
            String yearStr = endDateStr.substring(0, 4);
            String monthStr = endDateStr.substring(5, 7);
            String dayofMonthStr = endDateStr.substring(8, 10);
            int endYearInt = Integer.parseInt(yearStr);
            int endMonthInt = Integer.parseInt(monthStr);
            int dayofMonthInt = Integer.parseInt(dayofMonthStr);

            //calLaterNewYork.setTime(dateLater);
            calLaterNewYork.set(Calendar.YEAR, endYearInt);
            calLaterNewYork.set(Calendar.MONTH, endMonthInt);
            calLaterNewYork.set(Calendar.DAY_OF_MONTH, dayofMonthInt);

            calLaterNewYork.set(Calendar.MINUTE, 1);
            calLaterNewYork.set(Calendar.HOUR_OF_DAY, 12);
            calLaterNewYork.set(Calendar.SECOND, 1);

            int endYear = calLaterNewYork.get(Calendar.YEAR);
            int endMonth = calLaterNewYork.get(Calendar.MONTH);
            int endDayOfMonth = calLaterNewYork.get(Calendar.DAY_OF_MONTH);

            long milliseconds1 = calNowNewYork.getTimeInMillis();
            long milliseconds2 = calLaterNewYork.getTimeInMillis();
            long diff = milliseconds2 - milliseconds1;
            long diffSeconds = diff / 1000;
            long diffMinutes = diff / (60 * 1000);
            long diffHours = diff / (60 * 60 * 1000);
            long diffDays = diff / (24 * 60 * 60 * 1000);
            return diffDays;

        } catch (Exception ex) {
            Logger.getLogger(ContactUtilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    private long daysBetween(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();

        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffDays;
        //return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

}
