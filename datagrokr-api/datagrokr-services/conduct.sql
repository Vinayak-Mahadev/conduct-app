-- Prepared by Vinayak-Mahadev (vinayakmahadev.nm@gmail.com)

DROP SCHEMA IF EXISTS DATAENGINE CASCADE;
CREATE SCHEMA DATAENGINE;

DROP TABLE IF EXISTS DATAENGINE.TR_CONDUCTS CASCADE;
CREATE TABLE DATAENGINE.TR_CONDUCTS
(
	ID_N 	                SERIAL NOT NULL,
	NAME_V 	                CHARACTER VARYING(40) NOT NULL,
	FIRST_NAME_V 	        CHARACTER VARYING(40),
	LAST_NAME_V 	        CHARACTER VARYING(40),
	EMAIL_ID_V 	            CHARACTER VARYING(80) NOT NULL,
	PHONE_NUMBER_N 	        NUMERIC(19,0) NOT NULL,
	CITY_V                  CHARACTER VARYING(40),
	STATE_V                 CHARACTER VARYING(40),
	COUNTRY_V               CHARACTER VARYING(40),
	PINCODE_N 	            NUMERIC(10,0),
	CREATED_TIME_DT 	    TIMESTAMP WITH TIME ZONE,
	LAST_UPDATED_TIME_DT    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
	CONSTRAINT TR_CONDUCTS_PKEY PRIMARY KEY (ID_N )
);

--INSERT INTO DATAENGINE.TR_CONDUCTS(NAME_V, FIRST_NAME_V, LAST_NAME_V, EMAIL_ID_V, PHONE_NUMBER_N, CITY_V, STATE_V, COUNTRY_V, PINCODE_N, CREATED_TIME_DT, LAST_UPDATED_TIME_DT) VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?, ?);

INSERT INTO DATAENGINE.TR_CONDUCTS(NAME_V, FIRST_NAME_V, LAST_NAME_V, EMAIL_ID_V, PHONE_NUMBER_N, CITY_V, STATE_V, COUNTRY_V, PINCODE_N, CREATED_TIME_DT, LAST_UPDATED_TIME_DT) VALUES ('Vinayak-Mahadev' , 'Vinayak', 'Mahadev', 'vinayakmahadev.nm@gmail.com', 9787480000, 'Bangalore', 'Karnataka', 'India', 560034, NOW(), NOW());

