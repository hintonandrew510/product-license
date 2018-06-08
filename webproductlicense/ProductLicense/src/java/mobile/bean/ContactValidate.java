/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobile.bean;

import com.mobile.dto.Contact;

/**
 *
 * @author wtccuser
 */
public class ContactValidate {

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public StringBuilder getMessage() {
        return message;
    }

    public void setMessage(StringBuilder message) {
        this.message = message;
    }
    private Contact contact;
    private StringBuilder message = new StringBuilder();
    
}
