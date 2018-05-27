CREATE TABLE spring.users (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    email varchar(255)
);
insert into spring.users (id,name,email) values (1,"john","john@gmail.com");
insert into spring.users (id,name,email) values (2,"jack","jack@gmail.com");
insert into spring.users (id,name,email) values (3,"tom","tom@gmail.com");