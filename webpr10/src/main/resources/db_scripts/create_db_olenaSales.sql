DROP DATABASE IF EXISTS olenasales;
CREATE database olenasales;
USE olenasales;

CREATE TABLE vendor(
vendor_id int NOT NULL AUTO_INCREMENT,
vendor_name varchar(255) NOT NULL,
vendor_address varchar(255) NOT NULL,
PRIMARY KEY (vendor_id)
);

CREATE TABLE product_colour(
product_colour_id int NOT NULL AUTO_INCREMENT,
product_colour_name varchar(255) NOT NULL,
PRIMARY KEY (product_colour_id)
);

CREATE TABLE product(
product_id int NOT NULL AUTO_INCREMENT,
product_price double NOT NULL,
product_price_currency int,
product_colour_id int,
vendor_id int,
category_id int,
product_name varchar(255) NOT NULL,
product_description varchar(255),
product_image varchar(255),
qty_in_stock int NOT NULL,
numOfStarRatingVotes int DEFAULT 0,
starRatingSum int DEFAULT 0,
PRIMARY KEY (product_id)
);

CREATE TABLE category(
category_id int NOT NULL AUTO_INCREMENT,
category_name varchar(255) NOT NULL,
category_pic varchar(255),
PRIMARY KEY (category_id)
);

CREATE TABLE order_details(
order_details_id int NOT NULL AUTO_INCREMENT,
product_id int,
order_id int,
order_qty int NOT NULL,
PRIMARY KEY (order_details_id)
);

CREATE TABLE orders(
order_id int NOT NULL AUTO_INCREMENT,
customer_id int,
order_date date NOT NULL, 
order_sent_date date,
total_order_price int, 
PRIMARY KEY (order_id)
);

CREATE TABLE payment(
payment_id int NOT NULL AUTO_INCREMENT,
order_id int UNIQUE,
payment_method_id int,
payment_status boolean NOT NULL,
PRIMARY KEY (payment_id)
);

CREATE TABLE payment_method(
payment_method_id int NOT NULL AUTO_INCREMENT,
payment_method_name varchar(255) NOT NULL,
credit_card int,
PRIMARY KEY (payment_method_id)
);

CREATE TABLE customers(
customer_id int NOT NULL AUTO_INCREMENT,
customer_name varchar(255) NOT NULL,
customer_surname varchar(255) NOT NULL,
customer_phone varchar(255) NOT NULL,
customer_address varchar(255) NOT NULL,
customer_email varchar(255) NOT NULL,
customer_password varchar(255) NOT NULL,
PRIMARY KEY (customer_id)
);

CREATE TABLE roles(
id int NOT NULL AUTO_INCREMENT,
name varchar(255) NOT NULL,
customers_id int,
PRIMARY KEY (id)
);

CREATE TABLE currency(
currency_id int NOT NULL AUTO_INCREMENT,
currency_name varchar(255) NOT NULL,
currency_sign varchar(40) NOT NULL,
PRIMARY KEY (currency_id)
);

ALTER TABLE product
ADD FOREIGN KEY (product_colour_id) REFERENCES product_colour(product_colour_id),
ADD FOREIGN KEY (vendor_id) REFERENCES vendor(vendor_id),
ADD FOREIGN KEY (category_id) REFERENCES category(category_id),
ADD FOREIGN KEY (product_price_currency) REFERENCES currency(currency_id);

ALTER TABLE order_details
ADD FOREIGN KEY (product_id) REFERENCES product(product_id),
ADD FOREIGN KEY (order_id) REFERENCES orders(order_id);

ALTER TABLE orders
ADD FOREIGN KEY (customer_id) REFERENCES customers(customer_id);

ALTER TABLE payment
ADD FOREIGN KEY (order_id) REFERENCES orders(order_id),
ADD FOREIGN KEY (payment_method_id) REFERENCES payment_method(payment_method_id);