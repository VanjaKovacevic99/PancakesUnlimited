-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE ingredient (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(50) NOT NULL ,price DECIMAL(6,2) NOT NULL, category_id INT ,PRIMARY KEY (id), FOREIGN KEY (category_id) REFERENCES category(id));