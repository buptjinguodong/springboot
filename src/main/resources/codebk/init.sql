create table USER(
	USER_ID	CHAR(21),
	USER_NAME	CHAR(100),
	TEL_PHONE	CHAR(20),
	USER_PASSWD	CHAR(30),
	LOGIN_DATE	CHAR(8),
	primary key(USER_ID)
);

create table ACTI_INFO(
	ACTI_ID	CHAR(14),
	ACTI_TITLE	VARCHAR(255),
	ACTI_ADDR	VARCHAR(255),
	ACTI_START_DATE	CHAR(8),
	ACTI_END_DATE	CHAR(9),
	ACTI_PRICE_TOTAL	Integer(11),
	ACTI_PRICE_PRE	Integer(11),
	ACTI_CREATOR	VARCHAR(100),
	ACTI_CREATOR_ID	CHAR(21),
	ACTI_CAPACITY	Integer(11),
	ACTI_APLY_TIME	TimeStamp,
	ACTI_STATUS_CD	CHAR(2),
	ACTI_ABS	VARCHAR(600),
	primary key(ACTI_ID)
);

create table ACTI_DETAIL(
	ACTI_ID	CHAR(14),
	ACTI_BASEINFO	VARCHAR(3000),
	ACTI_PREPARE	VARCHAR(3000),
	ACTI_PRICE_DETAIL	VARCHAR(3000),
	ACTI_APLY_DETAIL	VARCHAR(3000),
	primary key(ACTI_ID)
);

create table ACTI_APLY_INFO(
	APLY_ID	CHAR(35),
	ACTI_ID	CHAR(14),
	USER_ID	CHAR(21),
	APLY_USER_AMOUNT	Integer(11),
	APLY_TIME	TimeStamp,
	APLY_PRICE_TOTAL	Integer(11),
	APLY_PRICE_PRE	Integer(11),
	APLY_REPORT_IND	CHAR(1),
	primary key(APLY_ID)
);

create table ACTI_APLY_DETAIL(
	APLY_ID	CHAR(35),
	APLY_USER_NAME	CHAR(100),
	TEL_PHONE	CHAR(20),
	USER_GENDER	CHAR(1),
	APLY_ABOARD_CD	CHAR(2),
	APLY_ABOARD_NAME	VARCHAR(100),
	APLY_REMARK	VARCHAR(1000),
	primary key(APLY_ID)
);