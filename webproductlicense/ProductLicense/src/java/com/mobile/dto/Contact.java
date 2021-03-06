/*
 * This file was generated - do not edit it directly !!
 * Generated by AuDAO tool, a product of Spolecne s.r.o.
 * For more information please visit http://www.spoledge.com
 */
package com.mobile.dto;

import java.sql.Timestamp;

import com.spoledge.audao.db.dto.AbstractDto;

/**
 * This is a DTO class.
 *
 * @author generated
 */
public class Contact extends AbstractDto {

    ////////////////////////////////////////////////////////////////////////////
    // Static
    ////////////////////////////////////////////////////////////////////////////

    public static final String TABLE = "contact";

    ////////////////////////////////////////////////////////////////////////////
    // Attributes
    ////////////////////////////////////////////////////////////////////////////

    private Integer contactId;
    private String password;
    private String name;
    private String uuid;
    private String clientType;
    private String license;
    private String generalInformation;
    private String phone;
    private Timestamp createdDate;
    private Timestamp startDate;
    private Timestamp usageDate;
    private Timestamp endDate;
    private String address;
    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private Boolean active;

    private boolean isPasswordModified;
    private boolean isPhoneModified;
    private boolean isActiveModified;

    ////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Creates a new empty DTO.
     */
    public Contact() {
    }

    ////////////////////////////////////////////////////////////////////////////
    // Public
    ////////////////////////////////////////////////////////////////////////////

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId( Integer _val) {
        this.contactId = _val;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String _val) {
        this.password = _val;
        this.isPasswordModified = true;
    }

    public boolean isPasswordModified() {
        return isPasswordModified;
    }

    public String getName() {
        return name;
    }

    public void setName( String _val) {
        this.name = _val;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid( String _val) {
        this.uuid = _val;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType( String _val) {
        this.clientType = _val;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense( String _val) {
        this.license = _val;
    }

    public String getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation( String _val) {
        this.generalInformation = _val;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone( String _val) {
        this.phone = _val;
        this.isPhoneModified = true;
    }

    public boolean isPhoneModified() {
        return isPhoneModified;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate( java.util.Date _val ) {
        setCreatedDate((Timestamp)( _val != null ? new Timestamp( _val.getTime()) : null ));
    }

    public void setCreatedDate( Timestamp _val) {
        this.createdDate = _val;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate( java.util.Date _val ) {
        setStartDate((Timestamp)( _val != null ? new Timestamp( _val.getTime()) : null ));
    }

    public void setStartDate( Timestamp _val) {
        this.startDate = _val;
    }

    public Timestamp getUsageDate() {
        return usageDate;
    }

    public void setUsageDate( java.util.Date _val ) {
        setUsageDate((Timestamp)( _val != null ? new Timestamp( _val.getTime()) : null ));
    }

    public void setUsageDate( Timestamp _val) {
        this.usageDate = _val;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate( java.util.Date _val ) {
        setEndDate((Timestamp)( _val != null ? new Timestamp( _val.getTime()) : null ));
    }

    public void setEndDate( Timestamp _val) {
        this.endDate = _val;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String _val) {
        this.address = _val;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress( String _val) {
        this.streetaddress = _val;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String _val) {
        this.city = _val;
    }

    public String getState() {
        return state;
    }

    public void setState( String _val) {
        this.state = _val;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode( String _val) {
        this.zipcode = _val;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive( Boolean _val) {
        this.active = _val;
        this.isActiveModified = true;
    }

    public boolean isActiveModified() {
        return isActiveModified;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Uses 'columns' equality type.
     */
    @Override
    public boolean equals( Object _other ) {
        if (_other == this) return true;
        if (_other == null || (!(_other instanceof Contact))) return false;

        Contact _o = (Contact) _other;

        if ( contactId == null ) {
            if ( _o.contactId != null ) return false;
        }
        else if ( _o.contactId == null || contactId.intValue() != _o.contactId.intValue()) return false;

        if ( password == null ) {
            if ( _o.password != null ) return false;
        }
        else if ( _o.password == null || !password.equals( _o.password )) return false;

        if ( name == null ) {
            if ( _o.name != null ) return false;
        }
        else if ( _o.name == null || !name.equals( _o.name )) return false;

        if ( uuid == null ) {
            if ( _o.uuid != null ) return false;
        }
        else if ( _o.uuid == null || !uuid.equals( _o.uuid )) return false;

        if ( clientType == null ) {
            if ( _o.clientType != null ) return false;
        }
        else if ( _o.clientType == null || !clientType.equals( _o.clientType )) return false;

        if ( license == null ) {
            if ( _o.license != null ) return false;
        }
        else if ( _o.license == null || !license.equals( _o.license )) return false;

        if ( generalInformation == null ) {
            if ( _o.generalInformation != null ) return false;
        }
        else if ( _o.generalInformation == null || !generalInformation.equals( _o.generalInformation )) return false;

        if ( phone == null ) {
            if ( _o.phone != null ) return false;
        }
        else if ( _o.phone == null || !phone.equals( _o.phone )) return false;

        if ( createdDate == null ) {
            if ( _o.createdDate != null ) return false;
        }
        else if ( _o.createdDate == null || createdDate.getTime() != _o.createdDate.getTime()) return false;

        if ( startDate == null ) {
            if ( _o.startDate != null ) return false;
        }
        else if ( _o.startDate == null || startDate.getTime() != _o.startDate.getTime()) return false;

        if ( usageDate == null ) {
            if ( _o.usageDate != null ) return false;
        }
        else if ( _o.usageDate == null || usageDate.getTime() != _o.usageDate.getTime()) return false;

        if ( endDate == null ) {
            if ( _o.endDate != null ) return false;
        }
        else if ( _o.endDate == null || endDate.getTime() != _o.endDate.getTime()) return false;

        if ( address == null ) {
            if ( _o.address != null ) return false;
        }
        else if ( _o.address == null || !address.equals( _o.address )) return false;

        if ( streetaddress == null ) {
            if ( _o.streetaddress != null ) return false;
        }
        else if ( _o.streetaddress == null || !streetaddress.equals( _o.streetaddress )) return false;

        if ( city == null ) {
            if ( _o.city != null ) return false;
        }
        else if ( _o.city == null || !city.equals( _o.city )) return false;

        if ( state == null ) {
            if ( _o.state != null ) return false;
        }
        else if ( _o.state == null || !state.equals( _o.state )) return false;

        if ( zipcode == null ) {
            if ( _o.zipcode != null ) return false;
        }
        else if ( _o.zipcode == null || !zipcode.equals( _o.zipcode )) return false;

        if ( active == null ) {
            if ( _o.active != null ) return false;
        }
        else if ( _o.active == null || active.booleanValue() != _o.active.booleanValue()) return false;

        return true;
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
        int _ret = -1678787584; // = "Contact".hashCode()
        _ret += contactId == null ? 0 : contactId;
        _ret = 29 * _ret + (password == null ? 0 : password.hashCode());
        _ret = 29 * _ret + (name == null ? 0 : name.hashCode());
        _ret = 29 * _ret + (uuid == null ? 0 : uuid.hashCode());
        _ret = 29 * _ret + (clientType == null ? 0 : clientType.hashCode());
        _ret = 29 * _ret + (license == null ? 0 : license.hashCode());
        _ret = 29 * _ret + (generalInformation == null ? 0 : generalInformation.hashCode());
        _ret = 29 * _ret + (phone == null ? 0 : phone.hashCode());
        _ret = 29 * _ret + (createdDate == null ? 0 : (int)createdDate.getTime());
        _ret = 29 * _ret + (startDate == null ? 0 : (int)startDate.getTime());
        _ret = 29 * _ret + (usageDate == null ? 0 : (int)usageDate.getTime());
        _ret = 29 * _ret + (endDate == null ? 0 : (int)endDate.getTime());
        _ret = 29 * _ret + (address == null ? 0 : address.hashCode());
        _ret = 29 * _ret + (streetaddress == null ? 0 : streetaddress.hashCode());
        _ret = 29 * _ret + (city == null ? 0 : city.hashCode());
        _ret = 29 * _ret + (state == null ? 0 : state.hashCode());
        _ret = 29 * _ret + (zipcode == null ? 0 : zipcode.hashCode());
        _ret = 29 * _ret + (active == null ? 0 : (active ? 1 : 0));

        return _ret;
    }


    ////////////////////////////////////////////////////////////////////////////
    // Protected
    ////////////////////////////////////////////////////////////////////////////
		
    /**
     * Constructs the content for the toString() method.
     */
    protected void contentToString(StringBuffer sb) {
        append( sb, "contactId", contactId );
        append( sb, "password", password );
        append( sb, "name", name );
        append( sb, "uuid", uuid );
        append( sb, "clientType", clientType );
        append( sb, "license", license );
        append( sb, "generalInformation", generalInformation );
        append( sb, "phone", phone );
        append( sb, "createdDate", createdDate );
        append( sb, "startDate", startDate );
        append( sb, "usageDate", usageDate );
        append( sb, "endDate", endDate );
        append( sb, "address", address );
        append( sb, "streetaddress", streetaddress );
        append( sb, "city", city );
        append( sb, "state", state );
        append( sb, "zipcode", zipcode );
        append( sb, "active", active );
    }
}
