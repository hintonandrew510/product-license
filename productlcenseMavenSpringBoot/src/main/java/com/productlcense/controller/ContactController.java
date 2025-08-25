package com.productlcense.controller;

import com.productlcense.model.Contact;
import com.productlcense.service.ContactService;
import java.sql.Timestamp;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        Sort sort = Sort.by(Sort.Direction.ASC, "city");

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
        Sort sort = Sort.by(Sort.Direction.ASC, "city");

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
        Sort sort = Sort.by(Sort.Direction.ASC, "city");

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
        Sort sort = Sort.by(Sort.Direction.ASC, "city");

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

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Contact contact,
            BindingResult result, Model model) {

        ObjectError error = new ObjectError("contact","error");
        result.addError(error);
        if (result.hasErrors()) {
            //user.setId(id);
           // return "update-user";
        }

        contactService.updateContact(contact);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(@Valid Contact contact, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-user";
//        }

        contactService.add(contact);
        return "redirect:/";
    }
    
    @GetMapping("/create")
    public String showCreateForm(Model model) {
         Contact contact = contactService.getNewDaultContact();

        model.addAttribute("contact", contact);
        return "add";
    }
    
    

}
