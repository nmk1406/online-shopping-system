create database script;

use script;

create table roles(
	id int auto_increment not null,
    name varchar(64),
    primary key(id)
);

create table users(
	id int auto_increment not null,
    email varchar(64),
    password varchar(64),
    phone varchar(10),
    status int default 1, -- 1:dang duoc mo, 0:da bi khoa
    role_id int,
    primary key(id),
    foreign key(role_id) references roles(id)
);

create table categories(
	id int auto_increment not null,
    name varchar(64),
    primary key(id)
);

create table products(
	id int auto_increment not null,
    name varchar(64),
	quantity int,
    price double,
    description varchar(1024),
	image varchar(1024),
    status int default 1, -- 1:dang ton tai, 0:da bi an
    category_id int,
    primary key(id),
    foreign key(category_id) references categories(id)
);

create table orders(
	id int auto_increment not null,
	order_date date,
    total_money double,
    fullname varchar(64),
    address varchar(256),
    email varchar(64),
    phone varchar(10),
    status int default 1, -- 1:dang xu ly, 2:dang van chuyen, 3:da nhan hang, 0:da huy don
    user_id int,
    primary key(id),
    foreign key(user_id) references users(id)
);

create table order_details(
	order_id int,
    product_id int,
    quantity int,
    price double,
    primary key(order_id, product_id),
    foreign key(order_id) references orders(id),
    foreign key(product_id) references products(id)
);