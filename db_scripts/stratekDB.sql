-- AUTHOR(S): ECS
DROP DATABASE IF EXISTS stratek;
CREATE DATABASE stratek;
USE stratek;

DROP USER IF EXISTS 'groot'@'localhost';
CREATE USER 'groot'@'localhost' IDENTIFIED BY 'iamgroot';
GRANT ALL ON * TO 'groot'@'localhost';

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

-- AUTHOR(S): ECS
CREATE VIEW product_list AS
SELECT
	CONCAT(manufacturer,' ' , name) AS name,
    price,
    category,
    ean
FROM products
ORDER BY name;

-- AUTHOR(S): ECS
CREATE VIEW product_list_admin AS
SELECT
	ean,
	CONCAT(manufacturer,' ' , name) AS name,
    quantity,
    price,
    category
FROM products
ORDER BY category, name;

-- AUTHOR(S): LKB, ECS
CREATE VIEW order_list AS
SELECT
	product_orders.order_id,
    date,
    customer_name,
    customer_email,
    product_orders.product_ean,
    product_orders.quantity
FROM orders
JOIN product_orders ON id=product_orders.order_id
ORDER BY id;