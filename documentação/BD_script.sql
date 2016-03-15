-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema vvv
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `vvv` ;

-- -----------------------------------------------------
-- Schema vvv
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vvv` DEFAULT CHARACTER SET utf8 ;
USE `vvv` ;

-- -----------------------------------------------------
-- Table `vvv`.`Transportadora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Transportadora` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Transportadora` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`Modal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Modal` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Modal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Transportadora_id` INT NOT NULL,
  `tipo` VARCHAR(255) NOT NULL,
  `capacidade` INT NOT NULL,
  `modelo` VARCHAR(255) NOT NULL,
  `ano_fab` DATE NOT NULL,
  `manutencao` TINYINT(1) NOT NULL,
  `vagasDisponiveis` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Modal_Transportadora_idx` (`Transportadora_id` ASC),
  CONSTRAINT `fk_Modal_Transportadora`
    FOREIGN KEY (`Transportadora_id`)
    REFERENCES `vvv`.`Transportadora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `telefone` VARCHAR(32) NOT NULL,
  `profissao` VARCHAR(64) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Funcionario` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(32) NOT NULL,
  `cargo` TINYINT(1) NOT NULL,
  `senha` BINARY(60) NOT NULL,
  `usuario` VARCHAR(32) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userName_UNIQUE` (`usuario` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`Viagem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Viagem` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Viagem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valor` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`Reserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Reserva` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Reserva` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Cliente_id` INT NOT NULL,
  `data` DATE NOT NULL,
  `status` TINYINT(1) NOT NULL,
  `Funcionario_id` INT NOT NULL,
  `Viagem_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Reserva_Cliente_idx` (`Cliente_id` ASC),
  INDEX `fk_Reserva_Funcionario_idx` (`Funcionario_id` ASC),
  INDEX `fk_Reserva_Viagem_idx` (`Viagem_id` ASC),
  CONSTRAINT `fk_Reserva_Cliente`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `vvv`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Funcionario`
    FOREIGN KEY (`Funcionario_id`)
    REFERENCES `vvv`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Viagem`
    FOREIGN KEY (`Viagem_id`)
    REFERENCES `vvv`.`Viagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`Cidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Cidade` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `identificador` VARCHAR(3) NOT NULL,
  `pais` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`identificador` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`Escala`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Escala` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Escala` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Viagem_id` INT NOT NULL,
  `Cidade_origem_id` INT NOT NULL,
  `Cidade_destino_id` INT NOT NULL,
  `saida` DATETIME NOT NULL,
  `chegada` DATETIME NOT NULL,
  `Modal_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Escala_Viagem_idx` (`Viagem_id` ASC),
  INDEX `fk_Escala_Cidade_origem_idx` (`Cidade_origem_id` ASC),
  INDEX `fk_Escala_Cidade_destino_idx` (`Cidade_destino_id` ASC),
  INDEX `fk_Escala_Modal1_idx` (`Modal_id` ASC),
  CONSTRAINT `fk_Escala_Viagem`
    FOREIGN KEY (`Viagem_id`)
    REFERENCES `vvv`.`Viagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Escala_Cidade_origem`
    FOREIGN KEY (`Cidade_origem_id`)
    REFERENCES `vvv`.`Cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Escala_Cidade_destino`
    FOREIGN KEY (`Cidade_destino_id`)
    REFERENCES `vvv`.`Cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Escala_Modal1`
    FOREIGN KEY (`Modal_id`)
    REFERENCES `vvv`.`Modal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `vvv`.`PontoDeVenda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`PontoDeVenda` ;

CREATE TABLE IF NOT EXISTS `vvv`.`PontoDeVenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `endereco` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `cnpj` VARCHAR(14) NOT NULL,
  `telefone` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`Funcionario_has_PontoDeVenda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Funcionario_has_PontoDeVenda` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Funcionario_has_PontoDeVenda` (
  `Funcionario_id` INT NOT NULL,
  `PontoDeVenda_id` INT NOT NULL,
  PRIMARY KEY (`Funcionario_id`, `PontoDeVenda_id`),
  INDEX `fk_Funcionario_has_PontoDeVenda_PontoDeVenda1_idx` (`PontoDeVenda_id` ASC),
  INDEX `fk_Funcionario_has_PontoDeVenda_Funcionario1_idx` (`Funcionario_id` ASC),
  CONSTRAINT `fk_Funcionario_has_PontoDeVenda_Funcionario1`
    FOREIGN KEY (`Funcionario_id`)
    REFERENCES `vvv`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_has_PontoDeVenda_PontoDeVenda1`
    FOREIGN KEY (`PontoDeVenda_id`)
    REFERENCES `vvv`.`PontoDeVenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`PontoDeVenda_Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`PontoDeVenda_Funcionario` ;

CREATE TABLE IF NOT EXISTS `vvv`.`PontoDeVenda_Funcionario` (
  `PontoDeVenda_id` INT NOT NULL,
  `Funcionario_id` INT NOT NULL,
  `escala` BINARY(7) NOT NULL,
  PRIMARY KEY (`PontoDeVenda_id`, `Funcionario_id`),
  INDEX `fk_PontoDeVenda_Funcionario_Funcionario_idx` (`Funcionario_id` ASC),
  INDEX `fk_PontoDeVenda_Funcionario_PontoDeVenda_idx` (`PontoDeVenda_id` ASC),
  CONSTRAINT `fk_PontoDeVenda_Funcionario_PontoDeVenda`
    FOREIGN KEY (`PontoDeVenda_id`)
    REFERENCES `vvv`.`PontoDeVenda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PontoDeVenda_Funcionario_Funcionario`
    FOREIGN KEY (`Funcionario_id`)
    REFERENCES `vvv`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vvv`.`Aeroporto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vvv`.`Aeroporto` ;

CREATE TABLE IF NOT EXISTS `vvv`.`Aeroporto` (
  `nome` VARCHAR(255) NOT NULL,
  `identificador` VARCHAR(3) NOT NULL,
  `Cidade_id` INT NOT NULL,
  PRIMARY KEY (`identificador`),
  INDEX `fk_Aeroporto_Cidade_idx` (`Cidade_id` ASC),
  CONSTRAINT `fk_Aeroporto_Cidade`
    FOREIGN KEY (`Cidade_id`)
    REFERENCES `vvv`.`Cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
