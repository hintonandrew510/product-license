/*
 * This file was generated - do not edit it directly !!
 * Generated by AuDAO tool, a product of Spolecne s.r.o.
 * For more information please visit http://www.spoledge.com
 */
package com.mobile.dao.mysql;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import java.util.ArrayList;

import com.spoledge.audao.db.dao.AbstractDaoImpl;
import com.spoledge.audao.db.dao.DBException;
import com.spoledge.audao.db.dao.DaoException;


import com.mobile.dao.ContactDao;
import com.mobile.dto.Contact;


/**
 * This is the DAO imlementation class.
 *
 * @author generated
 */
public class ContactDaoImpl extends AbstractDaoImpl<Contact> implements ContactDao {

    private static final String TABLE_NAME = "contact";

    protected static final String SELECT_COLUMNS = "contact_id, name, uuid, license, client_type, general_information, phone, usage_date, created_date, start_date, end_date, address, active";

    protected static final String PK_CONDITION = "contact_id=?";

    private static final String SQL_INSERT = "INSERT INTO contact (name,uuid,license,client_type,general_information,phone,usage_date,created_date,start_date,end_date,address,active) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    public ContactDaoImpl( Connection conn ) {
        super( conn );
    }

    /**
     * Finds a record identified by its primary key.
     * @return the record found or null
     */
    public Contact findByPrimaryKey( int contactId ) {
        return findOne( PK_CONDITION, contactId);
    }

    /**
     * Finds records ordered by name.
     */
    public Contact[] findAll( ) {
        return findManyArray( "1=1 ORDER BY name", 0, -1);
    }

    /**
     * Finds records ordered by name.
     */
    public Contact[] findFindByUUid( String uuid ) {
        return findManyArray( "uuid = ? ORDER BY name", 0, -1, uuid);
    }

    /**
     * Finds records ordered by name.
     */
    public Contact[] findAllByActive( Boolean active ) {
        return findManyArray( "active = ? ORDER BY name", 0, -1, (active == null ? null : (active ? ((byte)1) : ((byte)0))));
    }

    /**
     * Deletes a record identified by its primary key.
     * @return true iff the record was really deleted (existed)
     */
    public boolean deleteByPrimaryKey( int contactId ) throws DaoException {
        return deleteOne( PK_CONDITION, contactId);
    }

    /**
     * Inserts a new record.
     * @return the generated primary key - contactId
     */
    public int insert( Contact dto ) throws DaoException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        debugSql( SQL_INSERT, dto );

        try {
            stmt = conn.prepareStatement( SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS );

            if ( dto.getName() == null ) {
                throw new DaoException("Value of column 'name' cannot be null");
            }
            checkMaxLength( "name", dto.getName(), 250 );
            stmt.setString( 1, dto.getName() );

            if ( dto.getUuid() == null ) {
                throw new DaoException("Value of column 'uuid' cannot be null");
            }
            checkMaxLength( "uuid", dto.getUuid(), 200 );
            stmt.setString( 2, dto.getUuid() );

            if ( dto.getLicense() == null ) {
                throw new DaoException("Value of column 'license' cannot be null");
            }
            checkMaxLength( "license", dto.getLicense(), 3000 );
            stmt.setString( 3, dto.getLicense() );

            if ( dto.getClientType() == null ) {
                throw new DaoException("Value of column 'client_type' cannot be null");
            }
            checkMaxLength( "client_type", dto.getClientType(), 50 );
            stmt.setString( 4, dto.getClientType() );

            if ( dto.getGeneralInformation() == null ) {
                throw new DaoException("Value of column 'general_information' cannot be null");
            }
            checkMaxLength( "general_information", dto.getGeneralInformation(), 3000 );
            stmt.setString( 5, dto.getGeneralInformation() );

            if ( dto.getPhone() != null ) {
                checkMaxLength( "phone", dto.getPhone(), 250 );
            }
            stmt.setString( 6, dto.getPhone() );

            if ( dto.getUsageDate() == null ) {
                dto.setUsageDate( new Timestamp( System.currentTimeMillis()));
            }
            stmt.setTimestamp( 7, dto.getUsageDate() );

            if ( dto.getCreatedDate() == null ) {
                dto.setCreatedDate( new Timestamp( System.currentTimeMillis()));
            }
            stmt.setTimestamp( 8, dto.getCreatedDate() );

            if ( dto.getStartDate() == null ) {
                dto.setStartDate( new Timestamp( System.currentTimeMillis()));
            }
            stmt.setTimestamp( 9, dto.getStartDate() );

            if ( dto.getEndDate() == null ) {
                dto.setEndDate( new Timestamp( System.currentTimeMillis()));
            }
            stmt.setTimestamp( 10, dto.getEndDate() );

            if ( dto.getAddress() == null ) {
                throw new DaoException("Value of column 'address' cannot be null");
            }
            checkMaxLength( "address", dto.getAddress(), 250 );
            stmt.setString( 11, dto.getAddress() );

            if ( dto.getActive() == null ) {
                stmt.setNull( 12, Types.TINYINT );
            }
            else {
                stmt.setByte( 12, dto.getActive() ? ((byte)1) : ((byte)0) );
            }

            int n = stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            rs.next();

            dto.setContactId( rs.getInt( 1 ));

            return dto.getContactId();
        }
        catch (SQLException e) {
            errorSql( e, SQL_INSERT, dto );
            handleException( e );
            throw new DBException( e );
        }
        finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
        }
    }

    /**
     * Updates one record found by primary key.
     * @return true iff the record was really updated (=found and any change was really saved)
     */
    public boolean update( int contactId, Contact dto ) throws DaoException {
        StringBuffer sb = new StringBuffer();
        ArrayList<Object> params = new ArrayList<Object>();

        if ( dto.getName() != null ) {
            checkMaxLength( "name", dto.getName(), 250 );
            sb.append( "name=?" );
            params.add( dto.getName());
        }

        if ( dto.getLicense() != null ) {
            if (sb.length() > 0) {
                sb.append( ", " );
            }

            checkMaxLength( "license", dto.getLicense(), 3000 );
            sb.append( "license=?" );
            params.add( dto.getLicense());
        }

        if ( dto.getClientType() != null ) {
            if (sb.length() > 0) {
                sb.append( ", " );
            }

            checkMaxLength( "client_type", dto.getClientType(), 50 );
            sb.append( "client_type=?" );
            params.add( dto.getClientType());
        }

        if ( dto.getGeneralInformation() != null ) {
            if (sb.length() > 0) {
                sb.append( ", " );
            }

            checkMaxLength( "general_information", dto.getGeneralInformation(), 3000 );
            sb.append( "general_information=?" );
            params.add( dto.getGeneralInformation());
        }

        if ( dto.isPhoneModified()) {
            if (sb.length() > 0) {
                sb.append( ", " );
            }

            if ( dto.getPhone() == null ) {
                sb.append( "phone=NULL" );
            }
            else {
                checkMaxLength( "phone", dto.getPhone(), 250 );
                sb.append( "phone=?" );
                params.add( dto.getPhone());
            }
        }

        if ( dto.isUsageDateModified()) {
            if (sb.length() > 0) {
                sb.append( ", " );
            }

            if ( dto.getUsageDate() == null ) {
                sb.append( "usage_date=NULL" );
            }
            else {
                sb.append( "usage_date=?" );
                params.add( dto.getUsageDate());
            }
        }

        if ( dto.getStartDate() != null ) {
            if (sb.length() > 0) {
                sb.append( ", " );
            }

            sb.append( "start_date=?" );
            params.add( dto.getStartDate());
        }

        if ( dto.getEndDate() != null ) {
            if (sb.length() > 0) {
                sb.append( ", " );
            }

            sb.append( "end_date=?" );
            params.add( dto.getEndDate());
        }

        if ( dto.getAddress() != null ) {
            if (sb.length() > 0) {
                sb.append( ", " );
            }

            checkMaxLength( "address", dto.getAddress(), 250 );
            sb.append( "address=?" );
            params.add( dto.getAddress());
        }

        if ( dto.isActiveModified()) {
            if (sb.length() > 0) {
                sb.append( ", " );
            }

            if ( dto.getActive() == null ) {
                sb.append( "active=NULL" );
            }
            else {
                sb.append( "active=?" );
                params.add( (dto.getActive() ? ((byte)1) : ((byte)0)));
            }
        }

        if (sb.length() == 0) {
            return false;
        }

        params.add( contactId );

        Object[] oparams = new Object[ params.size() ];

        return updateOne( sb.toString(), PK_CONDITION, params.toArray( oparams ));
    }

    /**
     * Returns the table name.
     */
    public String getTableName() {
        return TABLE_NAME;
    }

    protected String getSelectColumns() {
        return SELECT_COLUMNS;
    }

    protected Contact fetch( ResultSet rs ) throws SQLException {
        Contact dto = new Contact();
        dto.setContactId( rs.getInt( 1 ));
        dto.setName( rs.getString( 2 ));
        dto.setUuid( rs.getString( 3 ));
        dto.setLicense( rs.getString( 4 ));
        dto.setClientType( rs.getString( 5 ));
        dto.setGeneralInformation( rs.getString( 6 ));
        dto.setPhone( rs.getString( 7 ));
        dto.setUsageDate( rs.getTimestamp( 8 ));
        dto.setCreatedDate( rs.getTimestamp( 9 ));
        dto.setStartDate( rs.getTimestamp( 10 ));
        dto.setEndDate( rs.getTimestamp( 11 ));
        dto.setAddress( rs.getString( 12 ));
        dto.setActive( rs.getBoolean( 13 ) ? Boolean.TRUE : Boolean.FALSE );

        if ( rs.wasNull()) {
            dto.setActive( null );
        }


        return dto;
    }

    protected Contact[] toArray(ArrayList<Contact> list ) {
        Contact[] ret = new Contact[ list.size() ];
        return list.toArray( ret );
    }

}
