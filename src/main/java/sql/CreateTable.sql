/**
 * Author:  HEILJulian
 * Created: 12.02.2020
 */

CREATE TABLE BlogEntry(
   	id SERIAL PRIMARY KEY,
	nickname VARCHAR (50) NOT NULL, 
   	eMail VARCHAR (50) NOT NULL,
	comment VARCHAR (50) NOT NULL,
   	rate INTEGER NOT NULL
);