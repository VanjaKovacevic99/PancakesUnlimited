-- liquibase formatted sql

-- changeset liquibase:1
ALTER TABLE pancake
ADD COLUMN order_id INT ;

