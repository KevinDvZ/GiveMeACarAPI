-- MySQL Script generated by MySQL Workbench
-- Wed Feb 24 13:09:55 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema givemeacar00
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `givemeacar00` ;

-- -----------------------------------------------------
-- Schema givemeacar00
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `givemeacar00` DEFAULT CHARACTER SET utf8 ;
USE `givemeacar00` ;

-- -----------------------------------------------------
-- Table `givemeacar00`.`Adresse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar00`.`Adresse` ;

CREATE TABLE IF NOT EXISTS `givemeacar00`.`Adresse` (
  `idAdresse` INT NOT NULL,
  `rue` VARCHAR(45) NOT NULL,
  `ville` VARCHAR(45) NOT NULL,
  `codePostal` INT NOT NULL,
  PRIMARY KEY (`idAdresse`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `givemeacar00`.`Agence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar00`.`Agence` ;

CREATE TABLE IF NOT EXISTS `givemeacar00`.`Agence` (
  `idAgence` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `Adresse_idAdresse` INT NOT NULL,
  PRIMARY KEY (`idAgence`),
  INDEX `fk_Agence_Adresse1_idx` (`Adresse_idAdresse` ASC) VISIBLE,
  UNIQUE INDEX `idAgence_UNIQUE` (`idAgence` ASC) VISIBLE,
  CONSTRAINT `fk_Agence_Adresse1`
    FOREIGN KEY (`Adresse_idAdresse`)
    REFERENCES `givemeacar00`.`Adresse` (`idAdresse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `givemeacar00`.`Véhicule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar00`.`Véhicule` ;

CREATE TABLE IF NOT EXISTS `givemeacar00`.`Véhicule` (
  `idVéhicule` INT NOT NULL AUTO_INCREMENT,
  `marque` VARCHAR(25) NOT NULL,
  `modele` VARCHAR(25) NOT NULL,
  `immatriculation` INT NOT NULL,
  `km` INT NOT NULL,
  `typeEnergie` VARCHAR(45) NOT NULL,
  `geolocalisation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idVéhicule`),
  UNIQUE INDEX `idVéhicule_UNIQUE` (`idVéhicule` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 35
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `givemeacar00`.`VehiculeStockes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar00`.`VehiculeStockes` ;

CREATE TABLE IF NOT EXISTS `givemeacar00`.`VehiculeStockes` (
  `idVehiculeStockes` INT NOT NULL,
  `dateEntree` DATE NOT NULL,
  `dateSortie` DATE NOT NULL,
  `present` TINYINT NOT NULL,
  `Véhicule_idVéhicule` INT NOT NULL,
  PRIMARY KEY (`idVehiculeStockes`),
  UNIQUE INDEX `idVehiculeStockes_UNIQUE` (`idVehiculeStockes` ASC) VISIBLE,
  INDEX `fk_VehiculeStockes_Véhicule1_idx` (`Véhicule_idVéhicule` ASC) VISIBLE,
  CONSTRAINT `fk_VehiculeStockes_Véhicule1`
    FOREIGN KEY (`Véhicule_idVéhicule`)
    REFERENCES `givemeacar00`.`Véhicule` (`idVéhicule`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `givemeacar00`.`Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar00`.`Location` ;

CREATE TABLE IF NOT EXISTS `givemeacar00`.`Location` (
  `idLocation` INT NOT NULL,
  `dateDebut` DATE NOT NULL,
  `dateFin` DATE NOT NULL,
  `kmParcourus` INT NOT NULL,
  `VehiculeStockes_idVehiculeStockes` INT NOT NULL,
  PRIMARY KEY (`idLocation`),
  UNIQUE INDEX `idLocation_UNIQUE` (`idLocation` ASC) VISIBLE,
  INDEX `fk_Location_VehiculeStockes1_idx` (`VehiculeStockes_idVehiculeStockes` ASC) VISIBLE,
  CONSTRAINT `fk_Location_VehiculeStockes1`
    FOREIGN KEY (`VehiculeStockes_idVehiculeStockes`)
    REFERENCES `givemeacar00`.`VehiculeStockes` (`idVehiculeStockes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `givemeacar00`.`Client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar00`.`Client` ;

CREATE TABLE IF NOT EXISTS `givemeacar00`.`Client` (
  `idClient` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `compteOdoo` VARCHAR(45) NOT NULL,
  `Adresse_idAdresse` INT NOT NULL,
  `Location_idLocation` INT NOT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE INDEX `idClient_UNIQUE` (`idClient` ASC) VISIBLE,
  INDEX `fk_Client_Adresse1_idx` (`Adresse_idAdresse` ASC) VISIBLE,
  INDEX `fk_Client_Location1_idx` (`Location_idLocation` ASC) VISIBLE,
  CONSTRAINT `fk_Client_Adresse1`
    FOREIGN KEY (`Adresse_idAdresse`)
    REFERENCES `givemeacar00`.`Adresse` (`idAdresse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_Location1`
    FOREIGN KEY (`Location_idLocation`)
    REFERENCES `givemeacar00`.`Location` (`idLocation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `givemeacar00`.`Client_has_Agence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar00`.`Client_has_Agence` ;

CREATE TABLE IF NOT EXISTS `givemeacar00`.`Client_has_Agence` (
  `Client_idClient` INT NOT NULL,
  `Agence_idAgence` INT NOT NULL,
  PRIMARY KEY (`Client_idClient`, `Agence_idAgence`),
  INDEX `fk_Client_has_Agence_Agence1_idx` (`Agence_idAgence` ASC) VISIBLE,
  INDEX `fk_Client_has_Agence_Client1_idx` (`Client_idClient` ASC) VISIBLE,
  CONSTRAINT `fk_Client_has_Agence_Client1`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `givemeacar00`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Client_has_Agence_Agence1`
    FOREIGN KEY (`Agence_idAgence`)
    REFERENCES `givemeacar00`.`Agence` (`idAgence`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `givemeacar00`.`Agence_has_VehiculeStockes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `givemeacar00`.`Agence_has_VehiculeStockes` ;

CREATE TABLE IF NOT EXISTS `givemeacar00`.`Agence_has_VehiculeStockes` (
  `Agence_idAgence` INT NOT NULL,
  `VehiculeStockes_idVehiculeStockes` INT NOT NULL,
  PRIMARY KEY (`Agence_idAgence`, `VehiculeStockes_idVehiculeStockes`),
  INDEX `fk_Agence_has_VehiculeStockes_VehiculeStockes1_idx` (`VehiculeStockes_idVehiculeStockes` ASC) VISIBLE,
  INDEX `fk_Agence_has_VehiculeStockes_Agence1_idx` (`Agence_idAgence` ASC) VISIBLE,
  CONSTRAINT `fk_Agence_has_VehiculeStockes_Agence1`
    FOREIGN KEY (`Agence_idAgence`)
    REFERENCES `givemeacar00`.`Agence` (`idAgence`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Agence_has_VehiculeStockes_VehiculeStockes1`
    FOREIGN KEY (`VehiculeStockes_idVehiculeStockes`)
    REFERENCES `givemeacar00`.`VehiculeStockes` (`idVehiculeStockes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
