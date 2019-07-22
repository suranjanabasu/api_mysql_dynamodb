create database db_example;
create user 'springuser'@'%' identified by 'ThePassword';
grant all on db_example.* to 'springuser'@'%';

use db_example;
CREATE TABLE IF NOT EXISTS user (uid VARCHAR(255) ,first_name VARCHAR(255), last_name VARCHAR(255), email VARCHAR(255), external_id VARCHAR(255), access_token VARCHAR(255), api_key VARCHAR(255), access_token_expires_at TIMESTAMP,
   PRIMARY KEY (uid)) ;


