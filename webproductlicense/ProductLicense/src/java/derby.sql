/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  andrewhinton
 * Created: Jun 30, 2018
 */


CREATE TABLE contact1
(
contact_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
name VARCHAR(24) NOT NULL,
REGION VARCHAR(26),
AREA DECIMAL(8,4) NOT NULL,
PHOTO_FORMAT VARCHAR(26) NOT NULL,
PICTURE BLOB(102400),
UNIQUE (contact_id)
)