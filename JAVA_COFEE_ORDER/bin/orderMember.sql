CREATE TABLE ORDER_MEMBER(
	ID VARCHAR2(30) PRIMARY KEY,
	PWD VARCHAR2(30) NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	EMAIL VARCHAR2(50) UNIQUE,
	AUTH NUMBER(1) NOT NULL
);

select * from ORDER_MEMBER;