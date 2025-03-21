CREATE TABLE categoria(
	
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
	
)ENGINE=innoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) values ('laser');
INSERT INTO categoria (nome) values ('Outros');
INSERT INTO categoria (nome) values ('Supermercado');
INSERT INTO categoria (nome) values ('Farmacia');
INSERT INTO categoria (nome) values ('Alimentação');
