-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.21-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para projetox
CREATE DATABASE IF NOT EXISTS `projetox` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `projetox`;


-- Copiando estrutura para tabela projetox.clientefornecedor
CREATE TABLE IF NOT EXISTS `clientefornecedor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `celular` varchar(255) DEFAULT NULL,
  `clienteFornecedorAmbos` varchar(255) DEFAULT NULL,
  `cpfCnpj` varchar(255) NOT NULL,
  `emailNfe` varchar(255) NOT NULL,
  `estadoCivil` varchar(255) DEFAULT NULL,
  `fantasia` varchar(255) NOT NULL,
  `fone` varchar(255) NOT NULL,
  `incricaoEstatual` varchar(255) DEFAULT NULL,
  `informacaoAdicional` varchar(255) DEFAULT NULL,
  `limiteCredito` decimal(19,2) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `nomeMae` varchar(255) DEFAULT NULL,
  `nomePai` varchar(255) DEFAULT NULL,
  `operadora` varchar(255) DEFAULT NULL,
  `origem` varchar(255) DEFAULT NULL,
  `ramoAtividade` varchar(255) DEFAULT NULL,
  `rg` varchar(255) DEFAULT NULL,
  `situacao` varchar(255) DEFAULT NULL,
  `tipoPessoa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.clientefornecedor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clientefornecedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientefornecedor` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.clientefornecedor_contato
CREATE TABLE IF NOT EXISTS `clientefornecedor_contato` (
  `ClienteFornecedor_id` bigint(20) NOT NULL,
  `contatos_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_87xk51b2xa2t0dard9jwkx7kb` (`contatos_id`),
  KEY `FK8od484yqhr20fm8stoio3svh6` (`ClienteFornecedor_id`),
  CONSTRAINT `FK8od484yqhr20fm8stoio3svh6` FOREIGN KEY (`ClienteFornecedor_id`) REFERENCES `clientefornecedor` (`id`),
  CONSTRAINT `FKjrr8u3qhkmkf2hd1uwim7saw2` FOREIGN KEY (`contatos_id`) REFERENCES `contato` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.clientefornecedor_contato: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clientefornecedor_contato` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientefornecedor_contato` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.clientefornecedor_endereco
CREATE TABLE IF NOT EXISTS `clientefornecedor_endereco` (
  `ClienteFornecedor_id` bigint(20) NOT NULL,
  `enderecos_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_3bsef4xun0f1x8rq54gp8v8h9` (`enderecos_id`),
  KEY `FKair5tq2e94vj39072yvtc7ldb` (`ClienteFornecedor_id`),
  CONSTRAINT `FKair5tq2e94vj39072yvtc7ldb` FOREIGN KEY (`ClienteFornecedor_id`) REFERENCES `clientefornecedor` (`id`),
  CONSTRAINT `FKsfivyb16xvtvixetoaatw43ch` FOREIGN KEY (`enderecos_id`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.clientefornecedor_endereco: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clientefornecedor_endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientefornecedor_endereco` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.contato
CREATE TABLE IF NOT EXISTS `contato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `celular` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fone` varchar(255) DEFAULT NULL,
  `nomeContato` varchar(255) NOT NULL,
  `operadora` int(11) DEFAULT NULL,
  `tipoContato_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3jwvcq8g6yy9i0slgld1ph8p1` (`tipoContato_id`),
  CONSTRAINT `FK3jwvcq8g6yy9i0slgld1ph8p1` FOREIGN KEY (`tipoContato_id`) REFERENCES `tipocontato` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.contato: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.controleestoque
CREATE TABLE IF NOT EXISTS `controleestoque` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantidadeEstoque` decimal(19,2) DEFAULT NULL,
  `valorEstoque` decimal(19,2) DEFAULT NULL,
  `produto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjrusn97ky5joycfrnc5omrm6v` (`produto_id`),
  CONSTRAINT `FKjrusn97ky5joycfrnc5omrm6v` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.controleestoque: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `controleestoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `controleestoque` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.empresa: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`id`, `nome`) VALUES
	(2, 'FBPIMENTEL - ME');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.endereco
CREATE TABLE IF NOT EXISTS `endereco` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `principal` bit(1) NOT NULL,
  `proximidade` varchar(255) DEFAULT NULL,
  `referencia` varchar(255) DEFAULT NULL,
  `tipoEndereco` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.endereco: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` (`id`, `bairro`, `cep`, `cidade`, `complemento`, `endereco`, `estado`, `numero`, `principal`, `proximidade`, `referencia`, `tipoEndereco`) VALUES
	(1, 'Conjunto Habitacional Sumaré (Sumaré)', '87720235', 'Paranavaí', NULL, 'Rua dos Pardais', 15, '157', b'0', NULL, NULL, 'COMERCIAL');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.familia
CREATE TABLE IF NOT EXISTS `familia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomeFamilia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.familia: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `familia` DISABLE KEYS */;
/*!40000 ALTER TABLE `familia` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.filial
CREATE TABLE IF NOT EXISTS `filial` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Cnpj` varchar(255) NOT NULL,
  `fantasia` varchar(255) NOT NULL,
  `nomefilial` varchar(255) NOT NULL,
  `situacao` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `empresa_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2qx1amhlxptscf2csrmibfd9r` (`empresa_id`),
  CONSTRAINT `FK2qx1amhlxptscf2csrmibfd9r` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.filial: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `filial` DISABLE KEYS */;
INSERT INTO `filial` (`id`, `Cnpj`, `fantasia`, `nomefilial`, `situacao`, `telefone`, `empresa_id`) VALUES
	(1, '05433048000107', 'FBPSYTEM', 'MATRIZ TESTE', 'ATIVO', '(44)-3422-8000', 2);
/*!40000 ALTER TABLE `filial` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.filial_endereco
CREATE TABLE IF NOT EXISTS `filial_endereco` (
  `Filial_id` bigint(20) NOT NULL,
  `enderecos_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_4gcxtr1rub2m2odmtf7t44o4g` (`enderecos_id`),
  KEY `FK1kt8lfdusp67ryd1eam29f567` (`Filial_id`),
  CONSTRAINT `FK1kt8lfdusp67ryd1eam29f567` FOREIGN KEY (`Filial_id`) REFERENCES `filial` (`id`),
  CONSTRAINT `FKo2f1yjfmyqdsnimv7tj5l84qb` FOREIGN KEY (`enderecos_id`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.filial_endereco: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `filial_endereco` DISABLE KEYS */;
INSERT INTO `filial_endereco` (`Filial_id`, `enderecos_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `filial_endereco` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.hibernate_sequence: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomeMarca` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.marca: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.movimentoestoque
CREATE TABLE IF NOT EXISTS `movimentoestoque` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataMovimento` date DEFAULT NULL,
  `observacaoMovimento` varchar(255) DEFAULT NULL,
  `quantidadeMovimentada` decimal(19,2) DEFAULT NULL,
  `tipoMovimento` varchar(255) DEFAULT NULL,
  `valorMovimento` decimal(19,2) DEFAULT NULL,
  `produto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKirjnnfbsoyd9wwp3i16yefyh0` (`produto_id`),
  CONSTRAINT `FKirjnnfbsoyd9wwp3i16yefyh0` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.movimentoestoque: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `movimentoestoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimentoestoque` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.newentity
CREATE TABLE IF NOT EXISTS `newentity` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.newentity: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `newentity` DISABLE KEYS */;
/*!40000 ALTER TABLE `newentity` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comprado` varchar(255) DEFAULT NULL,
  `custo` decimal(19,2) DEFAULT NULL,
  `dataAlteracao` date DEFAULT NULL,
  `dataCadastro` date DEFAULT NULL,
  `descricao` varchar(255) NOT NULL,
  `peso` decimal(19,2) DEFAULT NULL,
  `requisitado` varchar(255) DEFAULT NULL,
  `saldoEstoque` decimal(19,2) DEFAULT NULL,
  `situacao` varchar(255) NOT NULL,
  `tipoProduto` varchar(255) DEFAULT NULL,
  `usuarioAlteracao` int(11) DEFAULT NULL,
  `usuarioCadastro` int(11) DEFAULT NULL,
  `valorEmEstoque` decimal(19,2) DEFAULT NULL,
  `vendido` varchar(255) DEFAULT NULL,
  `familia_id` bigint(20) NOT NULL,
  `filial_id` bigint(20) NOT NULL,
  `marca_id` bigint(20) NOT NULL,
  `unidadeMedida_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhxffwfhjwjles77hfliqbgn8v` (`familia_id`),
  KEY `FKtoxlapaghu9yjufw6v92mkxdi` (`filial_id`),
  KEY `FKk1rkkokyj8lgp301ac8m7cp1j` (`marca_id`),
  KEY `FKilbrksk5y5r94h02mx4ga9y8b` (`unidadeMedida_id`),
  CONSTRAINT `FKhxffwfhjwjles77hfliqbgn8v` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`),
  CONSTRAINT `FKilbrksk5y5r94h02mx4ga9y8b` FOREIGN KEY (`unidadeMedida_id`) REFERENCES `unidademedida` (`id`),
  CONSTRAINT `FKk1rkkokyj8lgp301ac8m7cp1j` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`id`),
  CONSTRAINT `FKtoxlapaghu9yjufw6v92mkxdi` FOREIGN KEY (`filial_id`) REFERENCES `filial` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.produto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.tipocontato
CREATE TABLE IF NOT EXISTS `tipocontato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipoContato` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.tipocontato: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tipocontato` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipocontato` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.unidademedida
CREATE TABLE IF NOT EXISTS `unidademedida` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.unidademedida: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `unidademedida` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidademedida` ENABLE KEYS */;


-- Copiando estrutura para tabela projetox.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `celular` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nomeCompleto` varchar(255) DEFAULT NULL,
  `operadora` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `telefoneFixo` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `filial_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlqrep9jpsgrj2qtnrtlwxrkgk` (`filial_id`),
  CONSTRAINT `FKlqrep9jpsgrj2qtnrtlwxrkgk` FOREIGN KEY (`filial_id`) REFERENCES `filial` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela projetox.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `celular`, `email`, `nomeCompleto`, `operadora`, `senha`, `telefoneFixo`, `usuario`, `filial_id`) VALUES
	(1, '44 99915-8935', 'suporte@incopostes.com.br', 'FÁBIO B PIMENTEL', 'TIM', '[B@31544af4', '44 3422-8000', 'FBELMONTE', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
