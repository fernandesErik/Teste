CREATE TABLE lancamento(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	tipo VARCHAR(20) NOT NULL,
	codigo_categoria BIGINT(20) NOT NULL,
	codigo_pessoa BIGINT(20) NOT NULL,
	FOREIGN KEY 	(codigo_categoria) REFERENCES categoria(codigo),
	FOREIGN KEY 	(codigo_pessoa) REFERENCES pessoa(codigo)

	
) ENGINE=innoDB DEFAULT CHARSET=UTF8;

INSERT INTO lancamento 
(descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa)
VALUES
('Conta de Luz', '2025-05-20', '2025-05-18', 200.50, 'Pagamento via Pix', 'Despesa', 1, 1),
('Salário', '2025-05-30', '2025-05-30', 3500.00, 'Pagamento recebido', 'Receita', 2, 2),
('Internet', '2025-05-25', NULL, 120.00, 'Aguardando pagamento', 'Despesa', 1, 3);
