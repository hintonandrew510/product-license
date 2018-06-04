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
    private String name;
    private String license;
    private String generalInformation;
    private String phone;
    private Timestamp createdDate;
    private Timestamp startDate;
    private Timestamp endDate;
    private String address;
    private Boolean active;

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

    public String getName() {
        return name;
    }

    public void setName( String _val) {
        this.name = _val;
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

        if ( name == null ) {
            if ( _o.name != null ) return false;
        }
        else if ( _o.name == null || !name.equals( _o.name )) return false;

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

        if ( endDate == null ) {
            if ( _o.endDate != null ) return false;
        }
        else if ( _o.endDate == null || endDate.getTime() != _o.endDate.getTime()) return false;

        if ( address == null ) {
            if ( _o.address != null ) return false;
        }
        else if ( _o.address == null || !address.equals( _o.address )) return false;

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
        _ret = 29 * _ret + (name == null ? 0 : name.hashCode());
        _ret = 29 * _ret + (license == null ? 0 : license.hashCode());
        _ret = 29 * _ret + (generalInformation == null ? 0 : generalInformation.hashCode());
        _ret = 29 * _ret + (phone == null ? 0 : phone.hashCode());
        _ret = 29 * _ret + (createdDate == null ? 0 : (int)createdDate.getTime());
        _ret = 29 * _ret + (startDate == null ? 0 : (int)startDate.getTime());
        _ret = 29 * _ret + (endDate == null ? 0 : (int)endDate.getTime());
        _ret = 29 * _ret + (address == null ? 0 : address.hashCode());
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
        append( sb, "name", name );
        append( sb, "license", license );
        append( sb, "generalInformation", generalInformation );
        append( sb, "phone", phone );
        append( sb, "createdDate", createdDate );
        append( sb, "startDate", startDate );
        append( sb, "endDate", endDate );
        append( sb, "address", address );
        append( sb, "active", active );
    }
}
