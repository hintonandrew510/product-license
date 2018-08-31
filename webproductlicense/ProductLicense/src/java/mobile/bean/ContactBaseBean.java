/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile.bean;

import com.mobile.dto.Contact;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import mobile.helper.RijndaelCrypt;
import org.json.JSONObject;

/**
 *
 * @author wtccuser
 */
public class ContactBaseBean {
    
    private String key = "Bar12345Bar12345";
    
    private final static Logger LOGGER = Logger.getLogger(ContactBaseBean.class
            .getName());
    
    public String convertDateToMilliseconds(Date date) {
        SimpleDateFormat xxxFormat = new SimpleDateFormat("yyyy-mm-dd");
        String dateStr = xxxFormat.format(date);
        String yearStr = dateStr.substring(0, 4);
        String monthStr = dateStr.substring(5, 7);
        String dayofMonthStr = dateStr.substring(8, 10);
        //year + month + day

        int endYearInt = Integer.parseInt(yearStr);
        int endMonthInt = Integer.parseInt(monthStr);
        int dayofMonthInt = Integer.parseInt(dayofMonthStr);
        StringBuilder yearMonthDay = new StringBuilder();
        yearMonthDay.append(endYearInt);
        if (endMonthInt < 10) {
            yearMonthDay.append(0);
            yearMonthDay.append(endMonthInt);
        } else {
            yearMonthDay.append(endMonthInt);
        }
        if (dayofMonthInt < 10) {
            yearMonthDay.append(0);
            yearMonthDay.append(dayofMonthInt);
        } else {
            yearMonthDay.append(dayofMonthInt);
        }
        
        
        
       // long mill = Long.parseLong(yearMonthDay.toString());
        return yearMonthDay.toString();
    }
    
    public ContactValidate validate(Contact contact, HttpServletRequest request) {
        ContactValidate contactValidate = new ContactValidate();
        String typeofclient = request.getParameter("typeofclient");
        contact.setClientType(typeofclient);
        String txtPhoneNumber = request.getParameter("nameInputPhone");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        
        if (txtPhoneNumber == null) {
            contactValidate.getMessage().append("Runtime error missing [nameInputPhone[");
            
        }
        if (startDate == null) {
            contactValidate.getMessage().append(" Runtime error missing [startDate[");
            
        }
        if (endDate == null) {
            contactValidate.getMessage().append(" Runtime error missing [endDate[");
            
        }

        //check fatal errors
        if (contactValidate.getMessage().length() > 0) {
            return contactValidate;
        }
        
        if (txtPhoneNumber.trim().equals("+1")) {
            contactValidate.getMessage().append("Enter phone number");
            
        }
        txtPhoneNumber = this.parsePhoneNumber(txtPhoneNumber);
        if (txtPhoneNumber.length() < 10) {
            contactValidate.getMessage().append(" Enter a valid phone number");
        }
        contact.setPhone(txtPhoneNumber);
        
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        
        try {
            Date stdate = formatter.parse(startDate);
            Date enddate = formatter.parse(endDate);
            if (stdate.after(enddate)) {
                contactValidate.getMessage().append(" Start date must be before end date");
                
            }
            contact.setStartDate(stdate);
            contact.setEndDate(enddate);

            ///add uuid 
            if (contact.getUuid() == null || contact.getUuid().length() < 1) {
                String uuid = java.util.UUID.randomUUID().toString();
                contact.setUuid(uuid);
            }
            //add encryption
            JSONObject json = new JSONObject();
            //   this.contact.setAddress(exampleInputEmail);
            String startDayMills = this.convertDateToMilliseconds(contact.getStartDate());
            
            
            StringBuilder builder = new StringBuilder();
            //{\"enddate\":20200513,\"startdate\":20171003,\"uuid\":\"a2772b00-b162-450b-9f50-c31a9a371ec3\"}
            
            String endDayMills = this.convertDateToMilliseconds(contact.getEndDate());
           builder.append("{\"enddate\":");
           builder.append("\"");
            builder.append(endDayMills);
            builder.append("\"");
           builder.append(",\"startdate\":");
           builder.append("\"");
            builder.append(startDayMills);
            builder.append("\"");
             builder.append(",\"uuid\":");
             builder.append("\"");
            builder.append(contact.getUuid());
            builder.append("\"}");
            json.put("startdate", startDayMills);
            json.put("enddate", endDayMills);
            json.put("uuid", contact.getUuid());
            //{"enddate":20200513,"startdate":20171003,"uuid":"0e9393e1-10ce-42dc-98c4-a4165a1004ac"}
            //{"enddate":20200513,"startdate":20171003,"uuid":"a2772b00-b162-450b-9f50-c31a9a371ec3"}
           String test = json.toString();
           //{"enddate":"20200513","startdate":"20171003","uuid":"a2772b00-b162-450b-9f50-c31a9a371ec3"}
           String finalJSON = builder.toString();
            RijndaelCrypt rijndaelCrypt = new RijndaelCrypt(key);
            String encrypt = rijndaelCrypt.encrypt(test.getBytes());
            contact.setLicense(encrypt);
            contactValidate.setContact(contact);
            
        } catch (Exception e) {
            contactValidate.getMessage().append("Invalid date");
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        
        return contactValidate;
    }
    
    public String parsePhoneNumber(String txtPhoneNumber) {
        
        txtPhoneNumber = removeChr(txtPhoneNumber, '+');
       txtPhoneNumber = txtPhoneNumber.substring(1); 
        //txtPhoneNumber = removeChr(txtPhoneNumber, '1');
        txtPhoneNumber = removeChr(txtPhoneNumber, '-');
        txtPhoneNumber = removeChr(txtPhoneNumber, '(');
        txtPhoneNumber = removeChr(txtPhoneNumber, ')');
        
        txtPhoneNumber = txtPhoneNumber.trim();
        txtPhoneNumber = removeChr(txtPhoneNumber, ' ');
        
        return txtPhoneNumber;
    }
    public String removeChr(String str, String rep) {
        String replaceStr = str.replaceFirst(rep, "");
        return replaceStr;
    }
    public String removeChr(String str, char x) {
       
        StringBuilder strBuilder = new StringBuilder();
        char[] rmString = str.toCharArray();
        for (int i = 0; i < rmString.length; i++) {
            if (rmString[i] == x) {
                
            } else {
                strBuilder.append(rmString[i]);
               
            }
        }
        return strBuilder.toString();
    }
    
}
