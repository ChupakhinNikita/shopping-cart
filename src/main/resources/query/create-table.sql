CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    names VARCHAR(255),
    surname VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255)
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    order_date DATE,
    order_status VARCHAR(20),
    payment_method VARCHAR(20),
    customer_id INT REFERENCES customer(id)
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    price DECIMAL(10,2),
    description TEXT,
    in_stock BOOLEAN
);

CREATE TABLE order_detail (
    id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(id),
    product_id INT REFERENCES product(id),
    price DECIMAL(10,2),
    quantity INT
);