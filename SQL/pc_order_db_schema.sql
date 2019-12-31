-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PC_Order_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PC_Order_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PC_Order_DB` DEFAULT CHARACTER SET utf8 ;
USE `PC_Order_DB` ;

-- -----------------------------------------------------
-- Table `PC_Order_DB`.`CUSTOMERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PC_Order_DB`.`CUSTOMERS` (
  `cID` INT NOT NULL AUTO_INCREMENT COMMENT '고객번호',
  `cNAME` VARCHAR(20) NOT NULL COMMENT '고객 이름(유니크)',
  `cPW` VARCHAR(10) NOT NULL COMMENT '고객 비밀번호',
  `cNICKNAME` VARCHAR(20) NOT NULL COMMENT '고객 닉네임(유니크)',
  `cEMAIL` VARCHAR(30) NOT NULL COMMENT '고객 이메일(유니크)',
  `cMODE` INT(1) NOT NULL DEFAULT 1 COMMENT 'cMODE\n1 : 사용자\n0 : 관리자\n',
  `cBALANCE` INT NOT NULL DEFAULT 0 COMMENT 'cBALANCE\n잔액 초기값 : 0',
  PRIMARY KEY (`cID`),
  UNIQUE INDEX `cNAME_UNIQUE` (`cNAME` ASC) VISIBLE,
  UNIQUE INDEX `cNICKNAME_UNIQUE` (`cNICKNAME` ASC) VISIBLE,
  UNIQUE INDEX `cEMAIL_UNIQUE` (`cEMAIL` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PC_Order_DB`.`PRODUCTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PC_Order_DB`.`PRODUCTS` (
  `pID` INT NOT NULL AUTO_INCREMENT COMMENT '관리번호(PK)',
  `pNAME` VARCHAR(20) NULL COMMENT '상품 이름',
  `pPRICE` INT NULL COMMENT '상품 가격',
  `pTYPE` VARCHAR(10) NULL COMMENT '상품_카테고리',
  `pMANUF` VARCHAR(20) NULL COMMENT '상품_제조사',
  PRIMARY KEY (`pID`))
ENGINE = InnoDB
COMMENT = '				';


-- -----------------------------------------------------
-- Table `PC_Order_DB`.`ORDERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PC_Order_DB`.`ORDERS` (
  `oID` INT NOT NULL AUTO_INCREMENT COMMENT '주문 번호',
  `CUSTOMERS_cID` INT NOT NULL,
  `PRODUCTS_pID` INT NOT NULL,
  `oCNT` INT NOT NULL COMMENT '주문 수량',
  `oDATE` DATETIME NULL,
  PRIMARY KEY (`oID`, `CUSTOMERS_cID`, `PRODUCTS_pID`),
  INDEX `fk_ORDERS_PRODUCTS_idx` (`PRODUCTS_pID` ASC) VISIBLE,
  INDEX `fk_ORDERS_CUSTOMERS1_idx` (`CUSTOMERS_cID` ASC) VISIBLE,
  CONSTRAINT `fk_ORDERS_PRODUCTS`
    FOREIGN KEY (`PRODUCTS_pID`)
    REFERENCES `PC_Order_DB`.`PRODUCTS` (`pID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ORDERS_CUSTOMERS1`
    FOREIGN KEY (`CUSTOMERS_cID`)
    REFERENCES `PC_Order_DB`.`CUSTOMERS` (`cID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
