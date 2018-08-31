/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.helper;

import com.mobile.dao.DaoFactory;
import com.mobile.dao.ContactDao;
import com.mobile.dto.Contact;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wtccuser
 */
public class ContactHelper {

    // use the classname for the logger, this way you can refactor
    private final static Logger LOGGER = Logger.getLogger(ContactHelper.class
            .getName());
     public static com.mobile.dto.Contact findByContactId(int id) {
        Connection connection = null;
        try {
            connection = data.DatabaseManager.getConnection();
            ContactDao serviceDao = DaoFactory.createContactDao(connection);
            com.mobile.dto.Contact contact = serviceDao.findByPrimaryKey(id);
            return contact;
        } catch (Exception ex) {
            Logger.getLogger(ContactHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    /**
     * add user to database make sure no exception are thrown
     *
     * @param contact
     * @return
     */
    public static Contact add(Contact contact) {
        LOGGER.log(Level.OFF, "started add ");
        Connection connection = null;
        try {
            // <editor-fold defaultstate="collapsed" desc="Validate parameters">
            if (contact == null) {
                LOGGER.log(Level.OFF, "Null Service");
            }

            // </editor-fold>
            // <editor-fold defaultstate="collapsed" desc="Add to database">
            //get a connection to the database
            connection = data.DatabaseManager.getConnection();
            //generated class to manage the table
            ContactDao dao = DaoFactory.createContactDao(connection);
            //setting the properties

            //Department does not exist
            java.util.Date date = new java.util.Date();
            contact.setCreatedDate(date);

            //perform an insert to the database
            Integer primaryKey = null;

            primaryKey = dao.insert(contact);
            

            if (primaryKey > 0) {
                contact.setContactId(primaryKey);
                LOGGER.log(Level.OFF, "added to database key [" + primaryKey + "]");

                // end of send email
                return contact;
            } else {
                LOGGER.log(Level.SEVERE, "Cannot add to Service");
                return null;
            }

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }
        LOGGER.log(Level.OFF, "ended add ");
        return null;
    }

    public static Contact update(Contact contact) {

        LOGGER.log(Level.OFF, "started update ");
        Connection connection = null;
        try {
            // <editor-fold defaultstate="collapsed" desc="Validate parameters">
            if (contact == null) {
                LOGGER.log(Level.OFF, "Null Service");
            }

            // </editor-fold>
            // <editor-fold defaultstate="collapsed" desc="Update database">
            //get a connection to the database
            connection = data.DatabaseManager.getConnection();
            //generated class to manage the table
            ContactDao dao = DaoFactory.createContactDao(connection);
            //setting the properties

            //try update
            if (dao.update(contact.getContactId().intValue(), contact)) {
                LOGGER.log(Level.OFF, "updated database");
                LOGGER.log(Level.OFF, "ended update ");
                
                return contact;
            } else {
                LOGGER.log(Level.SEVERE, "Cannot update Service");
                LOGGER.log(Level.OFF, "ended update ");
                return null;
            }
            // </editor-fold>

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }
        LOGGER.log(Level.OFF, "ended update");
        return null;

    }

    public static Contact delete(Contact contact) {

        LOGGER.log(Level.OFF, "started delete ");
        Connection connection = null;
        try {
            // <editor-fold defaultstate="collapsed" desc="Validate parameters">
            if (contact == null) {
                LOGGER.log(Level.OFF, "Null Service");
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc="Delete service">
            //get a connection to the database
            connection = data.DatabaseManager.getConnection();
            //generated class to manage the table
            ContactDao dao = DaoFactory.createContactDao(connection);
            //setting the properties

            //try delete
            if (dao.deleteByPrimaryKey(contact.getContactId().intValue())) {

                LOGGER.log(Level.OFF, "deleted service");
                LOGGER.log(Level.OFF, "ended delete ");
               
                return null;
            } else {
                LOGGER.log(Level.SEVERE, "Cannot delete Service");
                LOGGER.log(Level.OFF, "ended delete ");
                return contact;
            }
            // </editor-fold>

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }
        LOGGER.log(Level.OFF, "ended delete");
        return null;

    }

     /**
     * find all services in database
     *
     * @return
     */
    public static List<com.mobile.dto.Contact> findAllInactive() {
        LOGGER.log(Level.OFF, "start findAll ");
        Connection connection = null;
        try {
            //get a connection to the database
            connection = data.DatabaseManager.getConnection();

            //generated class to manage the table
            ContactDao dao = DaoFactory.createContactDao(connection);
           
            //com.mobile.dto.Contact[] services = dao.findAllByActive(Boolean.FALSE);
 com.mobile.dto.Contact[] services = dao.findAllByInActive();
 
            //Convert array to list and return the list
            List<com.mobile.dto.Contact> list = Arrays.asList(services);
            if (list != null) {
                LOGGER.log(Level.OFF, "FOUND records [" + list.size() + "]");
            } else {
                LOGGER.log(Level.OFF, "FOUND no records ");
            }
            LOGGER.log(Level.OFF, "end findAll ");
            return list;
        } catch (Exception ex) {
            Logger.getLogger(ContactHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }
        LOGGER.log(Level.OFF, "end findAll ");
        return null;
    }
    
    /**
     * find all services in database
     *
     * @return
     */
    public static List<com.mobile.dto.Contact> findAll() {
        LOGGER.log(Level.OFF, "start findAll ");
        Connection connection = null;
        try {
            //get a connection to the database
            connection = data.DatabaseManager.getConnection();

            //generated class to manage the table
            ContactDao dao = DaoFactory.createContactDao(connection);
            com.mobile.dto.Contact[] services = dao.findAll();

            //Convert array to list and return the list
            List<com.mobile.dto.Contact> list = Arrays.asList(services);
            if (list != null) {
                LOGGER.log(Level.OFF, "FOUND records [" + list.size() + "]");
            } else {
                LOGGER.log(Level.OFF, "FOUND no records ");
            }
            LOGGER.log(Level.OFF, "end findAll ");
            return list;
        } catch (Exception ex) {
            Logger.getLogger(ContactHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }
        LOGGER.log(Level.OFF, "end findAll ");
        return null;
    }

    /**
     * find all services in database
     *
     * @param deptID
     * @return
     */
    public static com.mobile.dto.Contact findByUUid(String uuid) {
        Connection connection = null;
        try {
            connection = data.DatabaseManager.getConnection();
            ContactDao serviceDao = DaoFactory.createContactDao(connection);
       
            com.mobile.dto.Contact[] contact = serviceDao.findUUid(uuid);
            if (contact != null && contact.length > 0) {
                //update usage date
                java.util.Date today = new java.util.Date();
                contact[0].setUsageDate(today);
                update(contact[0]);
                return contact[0];
            }
        } catch (Exception ex) {
            Logger.getLogger(ContactHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

}
