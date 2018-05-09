DROP DATABASE IF EXISTS stratek;
CREATE DATABASE stratek;
USE stratek;

CREATE TABLE customers(
	ean INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL
);

CREATE TABLE orders(
	ean INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    date DATETIME NOT NULL,
    FOREIGN KEY(customer_id) REFERENCES customers(ean)
);

CREATE TABLE categories(
	name VARCHAR(25) PRIMARY KEY
);

CREATE TABLE products(
	ean INT PRIMARY KEY,
    manufacturer VARCHAR(20) NOT NULL,
    name VARCHAR(50) NOT NULL,
    quantity INT,
    price DOUBLE(7,2),
    category VARCHAR(25),
    description TEXT,
    FOREIGN KEY(category) REFERENCES categories(name)
);

CREATE TABLE product_orders(
	order_id INT,
    product_ean INT,
    quantity INT DEFAULT 1,
    PRIMARY KEY(order_id, product_ean),
    FOREIGN KEY(order_id) REFERENCES orders(ean),
    FOREIGN KEY(product_ean) REFERENCES products(ean)
);