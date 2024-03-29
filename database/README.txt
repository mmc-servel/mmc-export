====================ORACLE================
CREATE USER USER01 IDENTIFIED BY USER01;
GRANT CONNECT TO USER01;
GRANT CREATE TABLE TO USER01;
==========================================
1) connect to database with super-user "postgres" and run below commands.
CREATE ROLE ehk WITH LOGIN NOSUPERUSER NOCREATEDB NOCREATEROLE NOINHERIT NOREPLICATION CONNECTION LIMIT -1; 
ALTER USER ehk WITH PASSWORD 'POIqwe#123';
create database ehk;
GRANT CONNECT ON DATABASE ehk TO ehk;
-- ?? GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO ehk;
\connect ehk
create schema ehk;
GRANT USAGE ON SCHEMA ehk TO ehk;
SET search_path TO ehk;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA ehk TO ehk;
GRANT CREATE ON SCHEMA ehk TO ehk;
