INSERT INTO customer (names, surname, address, email, phone) VALUES
    ('John', 'Doe', '123 Main St', 'john.doe@example.com', '123-456-7890'),
    ('Jane', 'Smith', '456 Elm St', 'jane.smith@example.com', '987-654-3210');

INSERT INTO orders (order_date, order_status, payment_method, customer_id) VALUES
    ('2023-06-01', 'created', 'CREDIT_CARD', 1),
    ('2023-06-02', 'processing', 'PAY_PAL', 2);

INSERT INTO product (name, price, description, in_stock) VALUES
    ('Product 1', 10.99, 'Description 1', true),
    ('Product 2', 20.99, 'Description 2', true);

INSERT INTO order_detail (order_id, product_id, price, quantity) VALUES
    (1, 1, 10.99, 2),
    (2, 2, 20.99, 1);