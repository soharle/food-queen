
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
