/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile.bean;

import com.mobile.dto.Contact;
import data.helper.ContactHelper;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import mobile.helper.Encryptor;
import static mobile.helper.Encryptor.decrypt;
import static mobile.helper.Encryptor.encrypt;
import org.json.JSONObject;

/**
 *
 * @author wtccuser
 */
@ManagedBean
public class AddContactBean extends ContactBaseBean implements Serializable {
     
    public static final String CONTACT = "CONTACT";
    private final static Logger LOGGER = Logger.getLogger(AddContactBean.class
            .getName());
    private List<Contact> contactList;
    private Contact contact = new Contact();
        private String emailMessage;

    public String getEmailMessage() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("?");
        buffer.append("subject=");
        buffer.append("License key ");
        buffer.append("&");
        buffer.append("body=");
        buffer.append(contact.getLicense());
        emailMessage = buffer.toString();
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Contact> getContactList() {
        contactList = ContactHelper.findAll();
        return contactList;
    }

    
    
    
    public String add() {
        LOGGER.log(Level.OFF, "start add");
        //default 
        this.contact.setActive(Boolean.TRUE);
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ContactValidate contactValidate = this.validate(this.contact, request);
       
        //has error
        if (contactValidate.getMessage().length() > 0) {
             FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(contactValidate.getMessage().toString()));
            return null;
        }
        this.contact = ContactHelper.add(contactValidate.getContact());
       
       
        LOGGER.log(Level.OFF, "end add ");
        //ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        //ec.getRequestMap().put(CONTACT, this.contact);

        return "confirmationContact?faces-redirect=true"+ "&id=" + this.contact.getContactId();
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

}
