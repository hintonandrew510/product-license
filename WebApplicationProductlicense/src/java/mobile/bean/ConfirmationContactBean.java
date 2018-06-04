/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile.bean;

import com.mobile.dto.Contact;
import data.helper.ContactHelper;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wtccuser
 */
@ManagedBean
public class ConfirmationContactBean implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(ConfirmationContactBean.class
            .getName());
    private Contact contact;
            private String emailMessage;

    public String getEmailMessage() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("?");
        buffer.append("subject=");
        buffer.append("License key for " + contact.getClientType());
        buffer.append("&");
        buffer.append("body=");
        buffer.append(contact.getLicense());
        
        
        
        
        
        emailMessage = buffer.toString();
        return emailMessage;
    }


    public Contact getContact() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //note the difference when getting the parameter
        String id = request.getParameter("id");
        if (id != null) {
            int idInt = Integer.parseInt(id);
            contact = ContactHelper.findByContactId(idInt);

        }
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
