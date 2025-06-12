/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productlcense.helper;

import com.productlcense.encrypt.RijndaelCrypt;
import com.productlcense.model.Contact;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author andrewhinton
 */
public class LicenseHelper {

    private static String convertDateToMilliseconds(Date date) {
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

    public static String generateLicense(Contact contact) {
        String key = "Bar12345Bar12345";
        //add encryption
        JSONObject json = new JSONObject();
        //   this.contact.setAddress(exampleInputEmail);
        String startDayMills = convertDateToMilliseconds(contact.getStartDate());

        StringBuilder builder = new StringBuilder();
        //{\"enddate\":20200513,\"startdate\":20171003,\"uuid\":\"a2772b00-b162-450b-9f50-c31a9a371ec3\"}

        String endDayMills = convertDateToMilliseconds(contact.getEndDate());
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
        return null;
    }

}
