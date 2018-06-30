/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile.bean;

import com.mobile.dto.Contact;
import data.DatabaseManager;
import data.helper.ContactHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wtccuser
 */
@ManagedBean
public class ListContactBean implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(ListContactBean.class
            .getName());
    private List<Contact> contactList;
    private List<Contact> inActiveContactList;

    @PostConstruct
    public void init() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        boolean production = true;
        if (url.contains("local")) {
            production = false;
        }
        if (url.contains("127")) {
            production = false;
        }
        DatabaseManager.setIsProduction(production);

    }

    public List<Contact> getInActiveContactList() {

        if (inActiveContactList == null || inActiveContactList.size() < 1) {
            inActiveContactList = ContactHelper.findAllInactive();

        }
        if (inActiveContactList != null) {
            LOGGER.info("Found records [" + inActiveContactList.size() + "]");
        } else {
            LOGGER.info("Found not records ");
        }
        return inActiveContactList;
    }

    public void setInActiveContactList(List<Contact> inActiveContactList) {
        this.inActiveContactList = inActiveContactList;
    }
    private List<Contact> expiredContactList = new ArrayList<Contact>();

    public List<Contact> getExpiredContactList() {
        if (expiredContactList.size() > 0) {
            return expiredContactList;
        }
        ContactUtilBean util = new ContactUtilBean();

        List<Contact> fullList = this.getContactList();
        if (fullList != null) {
            //loop thru list and fix days left
            for (Contact contact : fullList) {
                long dayLeft = util.getDaysLeft(contact);
                if (dayLeft < 0) {
                    expiredContactList.add(contact);
                }
            }
        }
        return expiredContactList;
    }

    public void setExpiredContactList(List<Contact> expiredContactList) {
        this.expiredContactList = expiredContactList;
    }

    public List<Contact> getContactList() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();

        contactList = ContactHelper.findAll();
        if (contactList != null) {
            LOGGER.info("Found records [" + contactList.size() + "]");
        } else {
            LOGGER.info("Found not records ");
        }

        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

}
