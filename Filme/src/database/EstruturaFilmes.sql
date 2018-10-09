/**
 * Author:  Logan Michel
 * Created: 09/10/2018
 */

DROP DATABASE IF EXISTS exercicio;
CREATE DATABASE exercicio;
USE exercicio; 

CREATE TABLE filmes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    diretor VARCHAR(100),
    categoria VARCHAR(100),
    ano SMALLINT,
    atorPrincipal VARCHAR(100),
    tempoFilme SMALLINT,
    orcamento DOUBLE,
    faturamento DOUBLE,
    faixaEtaria VARCHAR(100),
    legenda BOOLEAN,
    dublado BOOLEAN,
    idiomaOriginal VARCHAR(100)
);
