-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE order_p (id INT AUTO_INCREMENT NOT NULL, description VARCHAR(255) , time VARCHAR(10) NOT NULL, PRIMARY KEY (id));