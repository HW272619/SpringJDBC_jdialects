# SpringJDBC_jdialects

CREATE TABLE DATA_CENTER.HS_PRODUCE_CLASS (
	ID VARCHAR2(32),
	CODE VARCHAR2(50),
	R_DATE DATE,
	CLASS VARCHAR2(50),
	R_TIME VARCHAR2(50),
	DATAVALUE1 NUMBER(22,127),
	DATAVALUE2 NUMBER(22,127),
	DECIDE NUMBER(22,127),
	"TYPE" VARCHAR2(50),
	PROPERTY VARCHAR2(50),
	REPORT_NAME VARCHAR2(100),
	CREATE_BY VARCHAR2(50),
	CREATE_TIME DATE,
	MODIFY_BY VARCHAR2(50),
	MODIFY_TIME DATE,
	CONSTRAINT SYS_C0014055 CHECK (ID)
);


CREATE TABLE `users` (
  `age` int(11) default NULL,
  `firstName` varchar(255) default NULL,
  `id` varchar(255) NOT NULL default '',
  `lastName` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8


