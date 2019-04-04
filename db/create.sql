

INSERT INTO `conta`(`id`, `login`, `senha`, `tipo`) VALUES (1, 1, 1, 'adm');
INSERT INTO `conta`(`id`, `login`, `senha`, `tipo`) VALUES (2, 2, 2, 'adm');
INSERT INTO `conta`(`id`, `login`, `senha`, `tipo`) VALUES (3, 3, 3, 'cliente');
INSERT INTO `conta`(`id`, `login`, `senha`, `tipo`) VALUES (4, 4, 4, 'cliente');
INSERT INTO `conta`(`id`, `login`, `senha`, `tipo`) VALUES (5, 5, 5, 'cliente');
INSERT INTO `conta`(`id`, `login`, `senha`, `tipo`) VALUES (6, 6, 6, 'adm');
INSERT INTO `conta`(`id`, `login`, `senha`, `tipo`) VALUES (6, 6, 6, 'adm');


INSERT INTO `contato`(`id`, `telefone`, `ddd`, `email`) VALUES (1, '32345673', '32', 'raissa123456@hotmail.com');
INSERT INTO `contato`(`id`, `telefone`, `ddd`, `email`, `telefone_complementar`) VALUES (2, '32323671', '33', 'matheus123456@hotmail.com', '991156879');
INSERT INTO `contato`(`id`, `telefone`, `ddd`, `email`, `telefone_complementar`) VALUES (3, '34544419', '91', 'jessica123456@hotmail.com', '12346879');
INSERT INTO `contato`(`id`, `telefone`, `ddd`, `email`) VALUES (4, '34567890', '33', 'rafael123456@hotmail.com');
INSERT INTO `contato`(`id`, `telefone`, `ddd`, `email`, `telefone_complementar`) VALUES (5, '34560987', '11', 'gabriel123456@hotmail.com', '68795467');
INSERT INTO `contato`(`id`, `telefone`, `ddd`, `email`, `telefone_complementar`) VALUES (6, '34511130', '61', 'rafaela123456@hotmail.com', '65786879');




INSERT INTO `endereco_loja`(`id`, `logradouro`, `numero`, `bairro`, `cidade`, `estado`, `pais`) VALUES ( 1, 'rua A', 10, 'centro', 'Juiz de Fora', 'MG', 'BR');
INSERT INTO `endereco_loja`(`id`, `logradouro`, `numero`, `bairro`, `cidade`, `estado`, `pais`) VALUES ( 2, 'rua B', 20, 'Linhares', 'Juiz de Fora', 'MG', 'BR');
INSERT INTO `endereco_loja`(`id`, `logradouro`, `numero`, `bairro`, `cidade`, `estado`, `pais`) VALUES ( 3, 'rua C', 30, 'Cidade do Sol', 'Juiz de Fora', 'MG', 'BR');



INSERT INTO `categoria`(`id`, `nome`) VALUES (1,'atacado');
INSERT INTO `categoria`(`id`, `nome`) VALUES (2,'varejo');



INSERT INTO `consumidor`(`id`, `nome`, `cpf`, `nascimento`, `conta_id`, `contato_id`) VALUES (1, 'Raissa', '107756656598', 01061994, 1, 1), (2, 'Matheus', '10775695598', 08061996, 2, 2), (3, 'Jessica', '107759586598', 01061990, 3, 3), (4, 'Rafael', '10772316598', 01061996, 4, 4), (5, 'Gabriel', '107756656598', 01061990, 5, 5), (6, 'Rafaela', '103456656598', 01061964, 6, 6);


INSERT INTO `carrinho`(`id`, `consumidor_id`, `valor`, `data`, `hora`, `pagamento`, `estado`) VALUES (1,1,'30.00', '01012019', '18:00', 'a vista', '2 itens'), (2,2,'0', '0', '-', 'a combinar', '0 itens');



INSERT INTO `cartao`(`id`, `numero`, `cod`, `titular`, `validade`, `consumidor_id`) VALUES (1,'123456789','9', 'Raissa Fonseca Alves', '01012020', 1), (2,'987654321','1', 'Matheus da Silva', '01012022', 2), (3,'678954321','1', 'Jessica Fonseca Vargas', '06012022', 3), (4,'543216789','9', 'Rafael Fonseca Alves', '01062000', 4), (5,'6543217890','0', 'Gabriel de Souza', '08082022', 5), (6,'0987659713','3', 'Rafaela Cristina', '20122088', 6);

INSERT INTO `endereco_consumidor`(`id`, `consumidor_id`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `pais`) VALUES (1, 1, 'Rua A', '123', 'casa', 'Jardim Gaucho', 'Juiz de Fora',  'MG', 'BR');
INSERT INTO `endereco_consumidor`(`id`, `consumidor_id`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `pais`) VALUES (2, 2, 'Rua Agua Limpa', '1223', 'casa', 'Santa Luzia', 'Juiz de Fora',  'MG', 'BR');
INSERT INTO `endereco_consumidor`(`id`, `consumidor_id`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `pais`) VALUES (3, 3, 'Rua A', '123', 'casa', 'Linhares', 'Juiz de Fora',  'MG', 'BR');
INSERT INTO `endereco_consumidor`(`id`, `consumidor_id`, `logradouro`, `numero`, `bairro`, `cidade`, `estado`, `pais`) VALUES (4, 4, 'Rua T', '123', 'Cidade do Sol', 'Juiz de Fora',  'MG', 'BR');
INSERT INTO `endereco_consumidor`(`id`, `consumidor_id`, `logradouro`, `numero`, `bairro`, `cidade`, `estado`, `pais`) VALUES (5, 5, 'Rua A', '123', 'Sagrado Cora��o', 'Juiz de Fora',  'MG', 'BR');
INSERT INTO `endereco_consumidor`(`id`, `consumidor_id`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `pais`) VALUES (6, 6, 'Rua B', '13', 'Apartamento 203', 'Vivendas da Serra', 'Juiz de Fora',  'MG', 'BR');



-- -----------------------------------------------------
-- Schema food_queen
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS food_queen ;

-- -----------------------------------------------------
-- Schema food_queen
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS food_queen DEFAULT CHARACTER SET utf8 ;
USE food_queen ;

-- -----------------------------------------------------
-- Table food_queen.conta
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.conta ;

CREATE TABLE IF NOT EXISTS food_queen.conta (
  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(45) NULL,
  senha VARCHAR(45) NULL,
  tipo VARCHAR(45) NULL,
  UNIQUE INDEX id_UNIQUE (id ASC) ,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.contato
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.contato ;

CREATE TABLE IF NOT EXISTS food_queen.contato (
  id INT NOT NULL AUTO_INCREMENT,
  telefone VARCHAR(45) NULL,
  ddd VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  telefone_complementar VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.consumidor
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.consumidor ;

CREATE TABLE IF NOT EXISTS food_queen.consumidor (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  cpf VARCHAR(45) NULL,
  nascimento VARCHAR(45) NULL,
  conta_id INT NOT NULL,
  contato_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.endereco_loja
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.endereco_loja ;

CREATE TABLE IF NOT EXISTS food_queen.endereco_loja (
  id INT NOT NULL AUTO_INCREMENT,
  cep VARCHAR(45) NULL,
  logradouro VARCHAR(45) NULL,
  numero VARCHAR(45) NULL,
  complemento VARCHAR(45) NULL,
  bairro VARCHAR(45) NULL,
  cidade VARCHAR(45) NULL,
  estado VARCHAR(45) NULL,
  pais VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.categoria
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.categoria ;

CREATE TABLE IF NOT EXISTS food_queen.categoria (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.loja
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.loja ;

CREATE TABLE IF NOT EXISTS food_queen.loja (
  id INT NOT NULL AUTO_INCREMENT,
  endereco_loja_id INT NOT NULL,
  conta_id INT NOT NULL,
  nome VARCHAR(45) NULL,
  cnpj VARCHAR(45) NULL,
  descricao VARCHAR(150) NULL,
  contato_id INT NOT NULL,
  categoria_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.promocao
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.promocao ;

CREATE TABLE IF NOT EXISTS food_queen.promocao (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  desconto VARCHAR(45) NULL,
  tipo VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.produto
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.produto ;

CREATE TABLE IF NOT EXISTS food_queen.produto (
  id INT NOT NULL AUTO_INCREMENT,
  loja_id INT NOT NULL,
  promocao_id INT NOT NULL,
  nome VARCHAR(45) NULL,
  preco VARCHAR(45) NULL,
  disponivel TINYINT NULL,
  descricao VARCHAR(150) NULL,
  imagem VARCHAR(150) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.endereco_consumidor
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.endereco_consumidor ;

CREATE TABLE IF NOT EXISTS food_queen.endereco_consumidor (
  id INT NOT NULL AUTO_INCREMENT,
  consumidor_id INT NOT NULL,
  cep VARCHAR(45) NULL,
  logradouro VARCHAR(45) NULL,
  numero VARCHAR(45) NULL,
  complemento VARCHAR(45) NULL,
  bairro VARCHAR(45) NULL,
  cidade VARCHAR(45) NULL,
  estado VARCHAR(45) NULL,
  pais VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.carrinho
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.carrinho ;

CREATE TABLE IF NOT EXISTS food_queen.carrinho (
  id INT NOT NULL AUTO_INCREMENT,
  consumidor_id INT NOT NULL,
  valor VARCHAR(45) NULL,
  data VARCHAR(45) NULL,
  hora VARCHAR(45) NULL,
  pagamento VARCHAR(45) NULL,
  estado VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.pedido
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.pedido ;

CREATE TABLE IF NOT EXISTS food_queen.pedido (
  id INT NOT NULL AUTO_INCREMENT,
  produto_id INT NOT NULL,
  carrinho_id INT NOT NULL,
  observacao VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.entrega
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.entrega ;

CREATE TABLE IF NOT EXISTS food_queen.entrega (
  id INT NOT NULL AUTO_INCREMENT,
  loja_id INT NOT NULL,
  carrinho_id INT NOT NULL,
  estado VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.favoritos
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.favoritos ;

CREATE TABLE IF NOT EXISTS food_queen.favoritos (
  id INT NOT NULL AUTO_INCREMENT,
  consumidor_id INT NOT NULL,
  loja_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table food_queen.cartao
-- -----------------------------------------------------
DROP TABLE IF EXISTS food_queen.cartao ;

CREATE TABLE IF NOT EXISTS food_queen.cartao (
  id INT NOT NULL AUTO_INCREMENT,
  numero VARCHAR(45) NULL,
  cod VARCHAR(45) NULL,
  titular VARCHAR(45) NULL,
  validade VARCHAR(45) NULL,
  consumidor_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) )
ENGINE = InnoDB;
