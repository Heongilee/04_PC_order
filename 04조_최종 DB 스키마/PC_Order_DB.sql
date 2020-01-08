-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pc_order_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pc_order_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pc_order_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `pc_order_db` ;

-- -----------------------------------------------------
-- Table `pc_order_db`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pc_order_db`.`customers` (
  `cID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '고객번호 (Primary_Key)',
  `cNAME` VARCHAR(20) NOT NULL COMMENT '고객 이름(Unique Attribute)',
  `cPW` VARCHAR(10) NOT NULL COMMENT '고객 비밀번호 ',
  `cNICKNAME` VARCHAR(20) NOT NULL COMMENT '고객 닉네임(Unique Attribute)',
  `cEMAIL` VARCHAR(30) NOT NULL COMMENT '고객 이메일(Unique Attribute)',
  `cMODE` INT(1) NOT NULL DEFAULT '1' COMMENT '고객 권한 :0은 관리자, 1은 사용자_default: 1(사용자)',
  `cBALANCE` INT(11) NOT NULL DEFAULT '0' COMMENT '고객 잔액_default : 0(원)',
  `CHECK` INT(11) NOT NULL DEFAULT '0' COMMENT '중복 로그인 체크값 (0: 로그아웃, 1: 로그인)',
  PRIMARY KEY (`cID`),
  UNIQUE INDEX `cNAME_UNIQUE` (`cNAME` ASC) VISIBLE,
  UNIQUE INDEX `cNICKNAME_UNIQUE` (`cNICKNAME` ASC) VISIBLE,
  UNIQUE INDEX `cEMAIL_UNIQUE` (`cEMAIL` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 94
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pc_order_db`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pc_order_db`.`orders` (
  `oID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '주문 번호 (Primary Key)',
  `cNAME` VARCHAR(20) NULL DEFAULT NULL COMMENT '주문 고객 이름',
  `pNAME` VARCHAR(20) NULL DEFAULT NULL COMMENT '주문 상품 이름',
  `oCNT` INT(11) NOT NULL DEFAULT '0' COMMENT '주문 상품 수량',
  PRIMARY KEY (`oID`))
ENGINE = InnoDB
AUTO_INCREMENT = 61
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pc_order_db`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pc_order_db`.`products` (
  `pID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '상품_번호 (Primary Key)',
  `pNAME` VARCHAR(20) NULL DEFAULT NULL COMMENT '상품_이름',
  `pPRICE` INT(11) NULL DEFAULT NULL COMMENT '상품_가격',
  `pTYPE` VARCHAR(10) NULL DEFAULT NULL COMMENT '상품_카테고리',
  `pMANUF` VARCHAR(20) NULL DEFAULT NULL COMMENT '상품_제조사',
  PRIMARY KEY (`pID`))
ENGINE = InnoDB
AUTO_INCREMENT = 125
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = '				';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
