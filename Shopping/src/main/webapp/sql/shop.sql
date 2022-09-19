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