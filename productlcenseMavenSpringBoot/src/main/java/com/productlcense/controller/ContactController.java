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
import org.springframework.web.bind.annotation.PathVariable;

@Controller // This means that this class is a Controller
public class ContactController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private Contact contact;
    private static final Logger mLog = LoggerFactory.getLogger(ContactController.class.getName());

//@Autowired
    // private IAuthenticationFacade authenticationFacade;
    @GetMapping(path = "/activeContracts")
    public String getAllActive(Model model) {
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

    @GetMapping(path = "/inActiveContracts")
    public String getAllInactive(Model model) {
        mLog.info("starting getAll");

        // Authentication authentication = authenticationFacade.getAuthentication();
        // sort by nameAuthentication authentication =
        // authenticationFacade.getAuthentication();
        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        Iterable<Contact> contacts = contactService.fetchInActiveContactList(sort);
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

    @GetMapping(path = "/allContracts")
    public String getAll(Model model) {
        mLog.info("starting getAll");

        // Authentication authentication = authenticationFacade.getAuthentication();
        // sort by nameAuthentication authentication =
        // authenticationFacade.getAuthentication();
        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        Iterable<Contact> contacts = contactService.fetchContactList(sort);
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

    @GetMapping(path = "/")
    public String defaut(Model model) {
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

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Contact contact = contactService.findByUUID(id);
                
        model.addAttribute("contact", contact);
        return "detail";
    }

}
