DROP DATABASE IF EXISTS USUARIOS;
CREATE DATABASE IF NOT EXISTS USUARIOS;
USE USUARIOS;

DROP TABLE IF EXISTS USUARIO;
CREATE TABLE IF NOT EXISTS USUARIO (
    NOMBRE VARCHAR(16) NOT NULL,
    CONTRASEÑA VARCHAR(16) NOT NULL,
    ADMINISTRADOR BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY(NOMBRE)
) ENGINE=INNODB;

INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, ADMINISTRADOR) VALUES ('usuario1', 'pass1', FALSE);
INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, ADMINISTRADOR) VALUES ('admin', 'adminpass', TRUE);