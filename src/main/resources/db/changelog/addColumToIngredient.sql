-- liquibase formatted sql

-- changeset liquibase:1
ALTER TABLE ingredient
    ADD COLUMN healty_or_no BIT ;

