-- Insert some categories
INSERT INTO categories (name, created_at, updated_at) VALUES
    ('Electronics', now(), now()),
    ('Clothing', now(), now()),
    ('Books', now(), now());

-- Insert some products
INSERT INTO products (name, price, category_id, created_at, updated_at) VALUES
    ('Smartphone', 499.99, 1, now(), now()),
    ('Laptop', 999.99, 1, now(), now()),
    ('T-Shirt', 19.99, 2, now(), now()),
    ('Jeans', 39.99, 2, now(), now()),
    ('The Great Gatsby', 9.99, 3, now(), now()),
    ('To Kill a Mockingbird', 7.99, 3, now(), now());