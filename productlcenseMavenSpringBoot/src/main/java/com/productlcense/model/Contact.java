package com.productlcense.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "contact")
@SessionScope
@Component
//need to serialize for  session
public class Contact implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contactId;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(String generalInformation) {
        this.generalInformation = generalInformation;
    }

    public String getPhone() {
       
        
        String phoneMask = "###-###-####";
        String phoneNumber = phone;

        MaskFormatter maskFormatter;

        try {
            maskFormatter = new MaskFormatter(phoneMask);
            maskFormatter.setValueContainsLiteralCharacters(false);
            phone = maskFormatter.valueToString(phoneNumber);
            return phone;
        } catch (ParseException ex) {
            //Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
            return phone;
        }
    

    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(Date usageDate) {
        this.usageDate = usageDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Column(name = "password")
    private String password;
    private String name;
    private String uuid;
    private String clientType;
    private String license;
    private String generalInformation;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date usageDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String address;
    @Column(name = "emailaddress")
    private String emailaddress;
    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private Boolean active;
   
}
