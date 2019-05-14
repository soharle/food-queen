-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 14-Maio-2019 às 02:25
-- Versão do servidor: 10.1.37-MariaDB
-- versão do PHP: 7.3.1

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
(10, 'Lanche');

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
  `consumidor_id` int(11) NOT NULL,
  `loja_id` int(11) NOT NULL,
  `valor` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `estado` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id`, `consumidor_id`, `loja_id`, `valor`, `estado`) VALUES
(37, 10, 4, '27.0', 'Aguardando');

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
(20, 4, 'Pizza de calabresa grande', '30', 0, 'Deliciosa pizza de calabresa e mussarela', 'https://t1.rg.ltmcdn.com/pt/images/9/8/3/img_pizza_calabresa_e_mussarela_4389_600.jpg', NULL, 3),
(21, 4, 'Pizza de Frango com Catupiry', '30', 0, 'Deliciosa pizza de Frango com catupiry', 'http://www.folhadomate.com//imagens/noticia/39710/48448-pizza_frango_com_catupiry.png', NULL, 1),
(22, 5, 'Portobello', '25', 0, 'ELEITO O MELHOR BURGER DE JUIZ DE FORA EM 2017. Origem portuÃ?Â¡ria e relevÃ?Â¢ncia de um premiado. Combinado bovino 160g, creme de gorgonzola com cream c', 'https://static-images.ifood.com.br/image/upload/f_auto,t_medium/pratos/17c617a7-2537-4c3c-9cd0-93bee3813d3f/201809111129_premi.jpg', NULL, 1),
(23, 4, 'Pizza 4 queijos', '25', 0, 'Deliciosa pizza de 4 queijos', 'https://abrilmdemulher.files.wordpress.com/2017/11/pizza-quatro-queijos-comitc3aa-umami.jpg?quality=90&strip=info&w=654&h=436&crop=1', NULL, 3),
(24, 5, 'BigJack', '29', 0, 'Gigante no sabor e no tamanho. Combinado bovino 200g, queijo cheddar em fatia, cream cheese, bacon, cebola crispy, alface americana, tomate e pÃ?Â£o de brioche.', 'https://static-images.ifood.com.br/image/upload/f_auto,t_high/pratos/17c617a7-2537-4c3c-9cd0-93bee3813d3f/201809111133_bigja.jpg', NULL, 2),
(25, 5, 'Bucaneiro', '24', 1, 'O legÃ­timo burger da casa. Combinado bovino 160g, fondue de queijo provolone, bacon, cebola crispy e pÃ£o de brioche.', 'https://static-images.ifood.com.br/image/upload/f_auto,t_medium/pratos/17c617a7-2537-4c3c-9cd0-93bee3813d3f/201809111108_bcaneo.jpg', NULL, 4),
(26, 5, 'Classic', '19', 1, 'O sabor de um verdadeiro burger Bucaneiro. Combinado bovino 160g, queijo prato, alface americana, tomate, picles da casa e pÃ£o de brioche.', 'https://static-images.ifood.com.br/image/upload/f_auto,t_medium/pratos/17c617a7-2537-4c3c-9cd0-93bee3813d3f/201809111103_origi.jpg', NULL, 4),
(27, 5, 'Fritas', '10', 0, 'Fritas RÃ??Ã?Âºsticas 200 g', 'data:image/jpeg;base64,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', NULL, 4),
(28, 4, 'Pizza portuguesa', '33', 1, 'A tradicional pizza portuguesa', 'http://www.folhadomate.com//imagens/noticia/39679/48388-receita-de-pizza-portuguesa-1.jpg', NULL, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_has_pedido`
--

CREATE TABLE `produto_has_pedido` (
  `id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `pedido_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `produto_has_pedido`
--

INSERT INTO `produto_has_pedido` (`id`, `produto_id`, `pedido_id`) VALUES
(64, 21, 30),
(65, 21, 31),
(68, 20, 32),
(69, 21, 32),
(70, 20, 33),
(71, 21, 33),
(93, 20, 36),
(94, 21, 36),
(95, 21, 37);

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
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `loja.id` (`loja_id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `produto_has_pedido`
--
ALTER TABLE `produto_has_pedido`
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
-- AUTO_INCREMENT for table `cartao`
--
ALTER TABLE `cartao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `produto_has_pedido`
--
ALTER TABLE `produto_has_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=96;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
