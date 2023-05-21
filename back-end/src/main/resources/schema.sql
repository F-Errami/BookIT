DROP Database bookit  ;
CREATE DATABASE IF NOT EXISTS bookit;
USE bookit;

CREATE TABLE if not exists livre (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(255),
    auteur VARCHAR(255),
    resume TEXT,
    date_publication DATE
    );
