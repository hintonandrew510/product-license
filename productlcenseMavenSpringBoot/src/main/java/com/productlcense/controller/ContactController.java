package com.productlcense.controller;

import com.productlcense.model.Contact;
import com.productlcense.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller // This means that this class is a Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private Contact contact;
	private static final Logger mLog = LoggerFactory.getLogger(ContactController.class.getName());

//@Autowired
	// private IAuthenticationFacade authenticationFacade;

	
	



	@GetMapping(path = "/contacts")
	public String getAll(Model model) {
		mLog.info("starting getAll");
		
		
		// Authentication authentication = authenticationFacade.getAuthentication();
		// sort by nameAuthentication authentication =
		// authenticationFacade.getAuthentication();
		Sort sort = Sort.by(Sort.Direction.ASC, "name");

		Iterable<Contact> contacts = contactService.fetchActiveContactList(sort);
		boolean hasRows = false;
		if (contacts != null) {
			long size = contacts.spliterator().getExactSizeIfKnown();
			if (size > 0) {
				hasRows = true;
			}
		}

		mLog.info("has rows [" + hasRows + "]");
		// add to model
		model.addAttribute("contacts", contacts);
		// add to model
		model.addAttribute("hasRows", hasRows);
	

		return "contacts";

	}

}
