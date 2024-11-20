DROP DATABASE IF EXISTS VALORANT;
CREATE DATABASE IF NOT EXISTS VALORANT;
USE VALORANT;


DROP TABLE IF EXISTS ROLES;
CREATE TABLE IF NOT EXISTS ROLES (
    ID_ROL INT UNSIGNED AUTO_INCREMENT NOT NULL,
    NOMBRE_ROL ENUM('INICIADOR', 'CONTROLADOR', 'DUELISTA', 'CENTINELA') NOT NULL,
    DESCRIP_ROL VARCHAR(500) NOT NULL,
    PRIMARY KEY (ID_ROL)
) ENGINE=INNODB;

DROP TABLE IF EXISTS AGENTES;
CREATE TABLE IF NOT EXISTS AGENTES(
	ID_AG INT UNSIGNED AUTO_INCREMENT NOT NULL,
    NOMBRE_AG VARCHAR(15) NOT NULL,
    DESCRIP_AG VARCHAR(500),
	ID_ROL_AG INT UNSIGNED NOT NULL,
    PRIMARY KEY(ID_AG),
    FOREIGN KEY (ID_ROL_AG) REFERENCES ROLES(ID_ROL), 
    INDEX FK_ROL(ID_ROL_AG)
)ENGINE INNODB;

DROP TABLE IF EXISTS HABILIDADES_AGENTES;
CREATE TABLE IF NOT EXISTS HABILIDADES_AGENTES(
	ID_AG_PER INT UNSIGNED NOT NULL,
    NOMBRE_HAB VARCHAR(25) NOT NULL,
    DESCRIP_HAB VARCHAR(500) NOT NULL,
    FOREIGN KEY(ID_AG_PER) REFERENCES AGENTES(ID_AG),
    PRIMARY KEY(NOMBRE_HAB),
    INDEX FK_AGENTE(ID_AG_PER)
)ENGINE INNODB;
