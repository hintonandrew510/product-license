/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile.service;

import com.mobile.dto.Contact;
import data.helper.ContactHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import mobile.helper.RijndaelCrypt;

/**
 * REST Web Service
 *
 * @author wtccuser
 */
//Path("mobile")
public class LicenseResource {

//    private final static Logger LOGGER = Logger.getLogger(LicenseResource.class
//            .getName());
//
//    @Context
//    private ServletContext ctx;
//
//    @GET
//    @Path("/getAll")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Contact> getAll() {
//        LOGGER.log(Level.OFF, "start getLicense");
//        List<Contact> contactList = ContactHelper.findAll();
//        if (contactList == null) {
//
//           // throw new Exception();
//        }
//        return contactList;
//
//    }
//
//    @GET
//    @Path("/getLicense")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getLicense(@QueryParam("uuid") String uuid) {
//        LOGGER.log(Level.OFF, "start getLicense");
//        Contact contact = ContactHelper.findByUUid(uuid);
//        if (contact != null) {
//            LOGGER.log(Level.OFF, "end getLicense");
//            return contact.getLicense();
//        } else {
//            LOGGER.log(Level.OFF, "end getLicense");
//            return "error finding license";
//        }
//
//    }
//    @GET
//    @Path("/getDecrpytLicense")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getDecryptLicense(@QueryParam("uuid") String uuid) {
//        LOGGER.log(Level.OFF, "start getLicense");
//        String key = "Bar12345Bar12345";
//        Contact contact = ContactHelper.findByUUid(uuid);
//        if (contact != null) {
//            LOGGER.log(Level.OFF, "end getLicense");
//           RijndaelCrypt rijndaelCrypt = new RijndaelCrypt(key);
//           String decrypt = rijndaelCrypt.decrypt(contact.getLicense());
//            return decrypt;
//        } else {
//            LOGGER.log(Level.OFF, "end getLicense");
//            return "error finding license";
//        }
//
//    }

}
