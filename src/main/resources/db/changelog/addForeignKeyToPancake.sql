-- liquibase formatted sql

-- changeset liquibase:1

ALTER TABLE pancake
ADD FOREIGN KEY (order_id) REFERENCES order_p(id);