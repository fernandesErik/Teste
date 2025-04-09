
CREATE TABLE pessoa (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    
    
    logradouro VARCHAR(255)NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(50),
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL
);



INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES 
('João Silva', TRUE, 'Avenida Paulista', '1000', 'Apto 202', 'Centro', '12345-678', 'São Paulo', 'SP'),

('Maria Oliveira', TRUE, 'Rua das Palmeiras', '250', 'Casa 2', 'Jardins', '98765-432', 'Rio de Janeiro', 'RJ'),

('Carlos Souza', FALSE, 'Travessa Santa Luzia', '50', NULL, 'Bela Vista', '54321-876', 'Belo Horizonte', 'MG'),

('Ana Pereira', TRUE, 'Praça do Comércio', '75', 'Fundos', 'Boa Viagem', '67890-123', 'Recife', 'PE');



























