package com.productlcense.service;

import com.productlcense.model.Contact;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


@Service
public interface ContactService {
     // save operation
    Contact save(Contact Contact);

    // read operation
    List<Contact> fetchContactList(org.springframework.data.domain.Sort sort);

    // update operation
    Contact updateContact(Contact contact);
	

}
