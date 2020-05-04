DROP DATABASE IF EXISTS fileshare;
CREATE DATABASE fileshare;
USE fileshare;

CREATE TABLE user(
	Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL DEFAULT '',
    password VARCHAR(255) NOT NULL
);

CREATE TABLE folder(
	Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    owner_id INT NOT NULL,
    FOREIGN KEY(owner_id) REFERENCES user(Id) ON DELETE CASCADE
);

CREATE TABLE file(
	Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    path VARCHAR(255) NOT NULL,
    owner_id INT NOT NULL,
    folder_id INT NOT NULL,
    FOREIGN KEY(owner_id) REFERENCES user(Id) ON DELETE CASCADE,
    FOREIGN KEY(folder_id) REFERENCES folder(Id) ON DELETE CASCADE
);






SELECT * FROM user;

INSERT INTO file (name, path, type, owner_id) VALUES ('meshka.txt', '/', 'file', 1);
INSERT INTO file (name, path, type, owner_id) VALUES ('ranichka.txt', '/', 'file', 1);
INSERT INTO file (name, path, type, owner_id) VALUES ('ranica.txt', '/', 'file', 1);
INSERT INTO file (name, path, type, owner_id) VALUES ('ranichishte.txt', '/', 'file', 1);
INSERT INTO file (name, path, type, owner_id) VALUES ('ranicozavyr.txt', '/', 'file', 1);