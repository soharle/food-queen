-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 17-Abr-2019 às 05:31
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.1.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food_queen`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `carrinho`
--

CREATE TABLE `carrinho` (
  `id` int(11) NOT NULL,
  `consumidor_id` int(11) NOT NULL,
  `loja_id` int(11) NOT NULL,
  `valor` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `estado` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `carrinho`
--

INSERT INTO `carrinho` (`id`, `consumidor_id`, `loja_id`, `valor`, `estado`) VALUES
(33, 10, 4, '57.0', 'Aguardando');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartao`
--

CREATE TABLE `cartao` (
  `id` int(11) NOT NULL,
  `numero` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `cod` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `titular` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `validade` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `consumidor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `cartao`
--

INSERT INTO `cartao` (`id`, `numero`, `cod`, `titular`, `validade`, `consumidor_id`) VALUES
(1, '000000', '000', 'Gabriel Beto Rocha', '12/24', 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id`, `nome`) VALUES
(1, 'Pizzaria'),
(3, 'Comida japonesa '),
(8, 'Almoço'),
(9, 'Jantar'),
(10, 'Lanches'),
(11, 'Vegana'),
(12, 'Comida árabe');

-- --------------------------------------------------------

--
-- Estrutura da tabela `consumidor`
--

CREATE TABLE `consumidor` (
  `id` int(11) NOT NULL,
  `endereco_id` int(11) DEFAULT NULL,
  `nome` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `cpf` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `nascimento` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `conta_id` int(11) NOT NULL,
  `contato_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `consumidor`
--

INSERT INTO `consumidor` (`id`, `endereco_id`, `nome`, `cpf`, `nascimento`, `conta_id`, `contato_id`) VALUES
(10, 12, 'GABRIEL BETO ROCHA', '00000000000', '10/12/1997', 29, 25);

-- --------------------------------------------------------

--
-- Estrutura da tabela `conta`
--

CREATE TABLE `conta` (
  `id` int(11) NOT NULL,
  `login` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `senha` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `tipo` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `conta`
--

INSERT INTO `conta` (`id`, `login`, `senha`, `tipo`) VALUES
(28, 'pizzaria', '123', 'Loja'),
(29, 'gabriel', '123', 'Consumidor'),
(30, 'boucan', '123', 'Loja');

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

CREATE TABLE `contato` (
  `id` int(11) NOT NULL,
  `telefone` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ddd` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `telefone_complementar` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `contato`
--

INSERT INTO `contato` (`id`, `telefone`, `ddd`, `email`, `telefone_complementar`) VALUES
(24, '32991459856', '32', 'gabrielbeto83@gmail.com', '3232214591'),
(25, '32991459856', '32', 'gabrielbeto83@gmail.com', '3232214591'),
(26, '32991459856', '32', 'boucan@boucan.com', '3232214591');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `cep` varchar(45) COLLATE utf8_bin NOT NULL,
  `logradouro` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `numero` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `complemento` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `bairro` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `cidade` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `estado` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `pais` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `cep`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `pais`) VALUES
(11, '36085350', 'Rua floriano peixoto', '555', 'loja 20', 'centro', 'Juiz de Fora', 'MG', 'Brasil'),
(12, '36085350', 'Rua Franklin De Paula Marques', '423', '423', 'cidade do sol', 'Juiz de Fora', 'MG', 'Brasil'),
(13, '36085350', 'Rua qualquer', '000', 'loja 1', 'centro', 'Juiz de Fora', 'MG', 'Brasil');

-- --------------------------------------------------------

--
-- Estrutura da tabela `loja`
--

CREATE TABLE `loja` (
  `id` int(11) NOT NULL,
  `endereco_id` int(11) NOT NULL,
  `conta_id` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `cnpj` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `descricao` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `imagem` text COLLATE utf8_bin NOT NULL,
  `contato_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `loja`
--

INSERT INTO `loja` (`id`, `endereco_id`, `conta_id`, `nome`, `cnpj`, `descricao`, `imagem`, `contato_id`, `categoria_id`) VALUES
(4, 11, 28, 'O Farao Pizzaria', '11111111111', 'Pizzaria forno a lenha de tradiÃ§Ã£o na cidade, fazendo sempre o melhor para agradar nossos clientes', 'https://www.ofaraopizzaria.com.br/conteudo/farao-pizzaria.png', 24, 1),
(5, 13, 30, 'Boucan Hamburgueria', '00000000', 'Melhor hamburgueria ', 'https://static-images.ifood.com.br/image/upload/f_auto,t_high/logosgde/17c617a7-2537-4c3c-9cd0-93bee3813d3f/201809111218_36176.png', 26, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `carrinho_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id`, `produto_id`, `carrinho_id`) VALUES
(64, 21, 30),
(65, 21, 31),
(68, 20, 32),
(69, 21, 32),
(70, 20, 33),
(71, 21, 33);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `loja_id` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `preco` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `disponivel` tinyint(4) DEFAULT NULL,
  `descricao` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `imagem` text COLLATE utf8_bin NOT NULL,
  `valor_promocional` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `promocao_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `loja_id`, `nome`, `preco`, `disponivel`, `descricao`, `imagem`, `valor_promocional`, `promocao_id`) VALUES
(20, 4, 'Pizza de calabresa grande', '30', 0, 'Deliciosa pizza de calabresa e mussarela', 'https://t1.rg.ltmcdn.com/pt/images/9/8/3/img_pizza_calabresa_e_mussarela_4389_600.jpg', NULL, 4),
(21, 4, 'Pizza de Frango com Catupiry', '30', 1, 'Deliciosa pizza de Frango com catupiry', 'http://www.folhadomate.com//imagens/noticia/39710/48448-pizza_frango_com_catupiry.png', NULL, 1),
(22, 5, 'Portobello', '25', 1, 'ELEITO O MELHOR BURGER DE JUIZ DE FORA EM 2017. Origem portuÃ¡ria e relevÃ¢ncia de um premiado. Combinado bovino 160g, creme de gorgonzola com cream c', 'https://static-images.ifood.com.br/image/upload/f_auto,t_medium/pratos/17c617a7-2537-4c3c-9cd0-93bee3813d3f/201809111129_premi.jpg', NULL, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `promocao`
--

CREATE TABLE `promocao` (
  `id` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `promocao`
--

INSERT INTO `promocao` (`id`, `nome`) VALUES
(1, 'SextaFeira'),
(2, 'Especial'),
(3, 'Padrao'),
(4, 'Nenhuma');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carrinho`
--
ALTER TABLE `carrinho`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `loja.id` (`loja_id`);

--
-- Indexes for table `cartao`
--
ALTER TABLE `cartao`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `consumidor`
--
ALTER TABLE `consumidor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `endereco` (`endereco_id`);

--
-- Indexes for table `conta`
--
ALTER TABLE `conta`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `contato`
--
ALTER TABLE `contato`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `loja`
--
ALTER TABLE `loja`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `promocao`
--
ALTER TABLE `promocao`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carrinho`
--
ALTER TABLE `carrinho`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `cartao`
--
ALTER TABLE `cartao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `consumidor`
--
ALTER TABLE `consumidor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `conta`
--
ALTER TABLE `conta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `contato`
--
ALTER TABLE `contato`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `loja`
--
ALTER TABLE `loja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
