package com.productlcense.service;

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
    public Contact save(Contact contact) {
         return contactRepository.save(contact);
    }

    @Override
    public List<Contact> fetchContactList(org.springframework.data.domain.Sort sort) {
        return (List<Contact>) contactRepository.findAll(sort);
    }
@Override
    public Contact updateContact(Contact contact) {
            

        return contactRepository.save(contact);
    }

    @Override
      @Query(value = "SELECT * FROM contact where active = 1 ", nativeQuery = true)
    public List<Contact> fetchActiveContactList(Sort sort) {
      
        return (List<Contact>) contactRepository.findAll(sort);
    }

    



}
