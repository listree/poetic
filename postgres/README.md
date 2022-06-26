list all databases

postgres=# \l

switch to database

postgres=# \c testdb

list all tables

testdb=# \dt

describe a table

testdb=# \d testtable

PostgreSQL 10 or higher is expected. Once installed you need to create a database with the default credentials:

$ psql postgres

postgres=# create database poet; 

postgres=# create user poet with password 'poet';

postgres=# grant all privileges on database poet to poet;


Common functions:

Time: now()

UUID: gen_random_uuid()
