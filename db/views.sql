CREATE VIEW product_list AS
SELECT
	CONCAT(manufacturer,' ' , name) AS name,
    price,
    category
FROM products;