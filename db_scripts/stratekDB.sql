-- AUTHOR(S): ECS
DROP DATABASE IF EXISTS stratek;
CREATE DATABASE stratek;
USE stratek;

-- AUTHOR(S): ECS
CREATE TABLE orders(
	id INT AUTO_INCREMENT PRIMARY KEY,
    customer_email VARCHAR(50) NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    date DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- AUTHOR(S): ECS
CREATE TABLE categories(
	name VARCHAR(25) PRIMARY KEY
);

-- AUTHOR(S): ECS
CREATE TABLE products(
	ean VARCHAR(13) PRIMARY KEY,
    manufacturer VARCHAR(20) NOT NULL,
    name VARCHAR(50) NOT NULL,
    quantity INT,
    price DOUBLE(7,2),
    category VARCHAR(25),
    description TEXT,
    FOREIGN KEY(category) REFERENCES categories(name)
);

-- AUTHOR(S): ECS
CREATE TABLE product_orders(
	order_id INT,
    product_ean VARCHAR(13),
    quantity INT DEFAULT 1,
    PRIMARY KEY(order_id, product_ean),
    FOREIGN KEY(order_id) REFERENCES orders(id),
    FOREIGN KEY(product_ean) REFERENCES products(ean)
);