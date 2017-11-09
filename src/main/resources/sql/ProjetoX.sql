
INSERT INTO `empresa` (`id`, `nome`) VALUES
	(2, 'FBPIMENTEL - ME');

INSERT INTO `endereco` (`id`, `bairro`, `cep`, `cidade`, `complemento`, `endereco`, `estado`, `numero`, `principal`, `proximidade`, `referencia`, `tipoEndereco`) VALUES
	(1, 'Conjunto Habitacional Sumaré (Sumaré)', '87720235', 'Paranavaí', NULL, 'Rua dos Pardais', 15, '157', b'0', NULL, NULL, 'COMERCIAL');

INSERT INTO `filial` (`id`, `Cnpj`, `fantasia`, `nomefilial`, `situacao`, `telefone`, `empresa_id`) VALUES
	(1, '05433048000107', 'FBPSYTEM', 'MATRIZ TESTE', 'ATIVO', '(44)-3422-8000', 2);

INSERT INTO `filial_endereco` (`Filial_id`, `enderecos_id`) VALUES
	(1, 1);

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(1);

INSERT INTO `usuario` (`id`, `celular`, `email`, `nomeCompleto`, `operadora`, `senha`, `telefoneFixo`, `usuario`, `filial_id`) VALUES
	(1, '44 99915-8935', 'suporte@incopostes.com.br', 'FÁBIO B PIMENTEL', 'TIM', '[B@31544af4', '44 3422-8000', 'FBELMONTE', 1);

