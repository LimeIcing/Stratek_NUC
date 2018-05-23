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

CREATE VIEW order_list AS
SELECT product_orders.order_id, date, customer_name, customer_email, product_orders.product_ean, product_orders.quantity
FROM orders
JOIN product_orders ON id=product_orders.order_id
ORDER BY id;