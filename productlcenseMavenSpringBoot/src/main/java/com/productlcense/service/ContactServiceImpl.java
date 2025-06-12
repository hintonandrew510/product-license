package com.productlcense.service;

import com.productlcense.helper.LicenseHelper;
import com.productlcense.model.Contact;
import com.productlcense.repository.ContactRepository;
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

}
