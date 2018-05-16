-- AUTHOR(S): ECS
CREATE VIEW product_list AS
SELECT
	CONCAT(manufacturer,' ' , name) AS name,
    price,
    category
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