/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andrewhinton
 * Created: Jun 30, 2018
 */

CREATE TABLE contact
(
contact_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
name VARCHAR(500) NOT NULL,
Uuid VARCHAR(500),
client_type VARCHAR(500),
license VARCHAR(3000),
general_information VARCHAR(3000),
phone VARCHAR(3000),
created_date timestamp,
start_date timestamp,
usage_date timestamp,
end_date timestamp,
address VARCHAR(500),
streetaddress VARCHAR(500),
city VARCHAR(500),
state VARCHAR(500),
zipcode VARCHAR(500),
active boolean,
UNIQUE (contact_id)
)