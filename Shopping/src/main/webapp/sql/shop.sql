CREATE TABLE topcategory (
	topcategory_id number primary key,
	category_name varchar(30)
);

create table subcategory(
	subcategory_id number primary key,
	category_name varchar(30),
	topcategory_id number,
	constraint fk_topcategory_subcategory foreign key (topcategory_id) references topcategory(topcategory_id) 
);

create table product(
	product_id number primary key,
	product_name varchar(80),
	brand varchar(30),
	price number default 0,
	memo varchar(1000),
	detail clob,
	product_img varchar(100),
	subcategory_id number,
	constraint fk_subcategory_product foreign key (subcategory_id) references subcategory(subcategory_id)
);

create sequence seq_topcategory
increment by 1
start with 1;

create sequence seq_subcategory
increment by 1
start with 1;

create sequence seq_product
increment by 1
start with 1;



CREATE TABLE MEMBER (
	member_id number PRIMARY KEY,
	customer_id varchar(30),
	customer_name varchar(30),
 	customer_pass varchar(30),
 	customer_email varchar(50)
);


CREATE SEQUENCE seq_member INCREMENT BY 1 START WITH 1;
===============================================

create table paymethod(
	paymethod_id number primary key,
	payname varchar(30)
);


create table ordersummary (
	ordersummary_id number primary key,
	member_id number,
	paymethod_id number,
	totalbuy number default 0,
	totalpay number default 0,
	buydate date default sysdate,
	constraint fk_member_ordersummary foreign key (member_id) references member (member_id),
	constraint fk_paymethod_ordersummary foreign key (paymethod_id) references paymethod(paymethod_id)
);

create table orderdetail (
	product_id number,
	orderdetail_id number,
	ea number default 0,
	ordersummary_id number,
	constraint fk_product_orderdetail foreign key (product_id) references product (product_id),
	constraint fk_ordersummary_orderdetail foreign key (ordersummary_id) references ordersummary (ordersummary_id)
);

create sequence seq_paymethod
increment by 1
start with 1;

create sequence seq_orderdetail
increment by 1
start with 1;

create sequence seq_ordersummary
increment by 1
start with 1;


insert into paymethod (paymethod_id, payname) values (seq_paymethod.nextval, '카드결제');
insert into paymethod (paymethod_id, payname) values (seq_paymethod.nextval, '핸드폰');
insert into paymethod (paymethod_id, payname) values (seq_paymethod.nextval, '가상계좌');
insert into paymethod (paymethod_id, payname) values (seq_paymethod.nextval, '온라인입금');


