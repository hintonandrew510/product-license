package com.productlcense.service;

import com.productlcense.helper.LicenseHelper;
import com.productlcense.model.Contact;
import com.productlcense.repository.ContactRepository;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

   

    @Override
    public List<Contact> fetchContactList(org.springframework.data.domain.Sort sort) {
        return (List<Contact>) contactRepository.findAll(sort);
    }

    @Override
    public Contact updateContact(Contact contact) {

         contact.setEmailaddress(contact.getAddress());
         String license = LicenseHelper.generateLicense(contact);
    
         contact.setLicense(license);
        return contactRepository.save(contact);
    }

    @Override
    @Query(value = "SELECT * FROM contact where active = 1 ", nativeQuery = true)
    public List<Contact> fetchActiveContactList(Sort sort) {

        return (List<Contact>) contactRepository.findAll(sort);
    }

    @Override
    @Query(value = "SELECT * FROM contact where active = 0 ", nativeQuery = true)
    public List<Contact> fetchInActiveContactList(Sort sort) {

        return (List<Contact>) contactRepository.findAll(sort);
    }

    @Override
    public Contact findByUUID(String UUID) {
       
         return contactRepository.findByUUID(UUID);
    }

    @Override
    public Contact add(Contact contact) {
             String uuid = java.util.UUID.randomUUID().toString();
         String license = LicenseHelper.generateLicense(contact);
         contact.setUuid(uuid);
         contact.setLicense(license);
           contact.setEmailaddress(contact.getAddress());
         return contactRepository.save(contact);
    }

    @Override
    public Contact getNewDaultContact() {
        
        java.time.LocalDate startlocalDate =  java.time.LocalDate.now();
        java.time.LocalDate endlocalDate =  startlocalDate.plusYears(1);
        // Convert LocalDate to java.util.Date
        Date startDate = Date.from(startlocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
  Date endDate = Date.from(endlocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

         String uuid = java.util.UUID.randomUUID().toString();
        // Contact("unknownpassword","unknownname",uuid,"TV","generalInformation","unknown number",startDate,startDate,endDate,"unknown@gmail.com","unknown@gmail.com","Raleigh","NC","unknown zip",true);
        Contact contact = new  Contact("unknownpassword", "unknownname", uuid, "TV", "generalInformation", "7777777777"
                , startDate, startDate, endDate, "emailaddress@gmail.com"
                , "emailaddress@gmail.com"
                , "streetaddress", "city", "NC", "zipcode", true) ;
   
        return contact;
    }

}
