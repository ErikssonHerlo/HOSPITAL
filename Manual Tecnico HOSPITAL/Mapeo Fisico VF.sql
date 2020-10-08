-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema HOSPITAL
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema HOSPITAL
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `HOSPITAL` ;
USE `HOSPITAL` ;

-- -----------------------------------------------------
-- Table `HOSPITAL`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Usuario` (
  `Codigo` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(100) NULL,
  `DPI` VARCHAR(45) NULL,
  `Telefono` VARCHAR(45) NULL,
  `Correo` VARCHAR(45) NULL,
  `Password` VARCHAR(100) NULL,
  `Tipo_Usuario` INT NULL,
  PRIMARY KEY (`Codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Paciente` (
  `Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(100) NULL,
  `Sexo` VARCHAR(45) NULL,
  `Nacimiento` DATE NULL,
  `Peso` VARCHAR(45) NULL,
  `Tipo_Sangre` VARCHAR(45) NULL,
  `Estado` TINYINT(1) NULL,
  PRIMARY KEY (`Usuario_Codigo`),
  INDEX `fk_Paciente_Usuario1_idx` (`Usuario_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Paciente_Usuario1`
    FOREIGN KEY (`Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Usuario` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Medico` (
  `Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(100) NULL,
  `Colegiado` INT NULL,
  `Hora_Entrada` TIME NULL,
  `Hora_Salida` TIME NULL,
  `Fecha_Inicio` VARCHAR(45) NULL,
  `Estado` TINYINT(1) NULL,
  PRIMARY KEY (`Usuario_Codigo`),
  CONSTRAINT `fk_Medico_Usuario1`
    FOREIGN KEY (`Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Usuario` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Examen` (
  `Codigo` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(200) NULL,
  `Orden` TINYINT(1) NULL,
  `Descripcion` VARCHAR(2500) NULL,
  `Costo` DOUBLE NULL,
  `Formato` VARCHAR(45) NULL,
  `Estado` TINYINT(1) NULL,
  PRIMARY KEY (`Codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Laboratorista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Laboratorista` (
  `Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(100) NULL,
  `Registro` VARCHAR(45) NULL,
  `Nombre_Examen` VARCHAR(200) NULL,
  `Fecha_Inicio` DATE NULL,
  `Estado` TINYINT(1) NULL,
  `Examen_Codigo` INT NOT NULL,
  PRIMARY KEY (`Usuario_Codigo`),
  INDEX `fk_Laboratoristas_Usuario1_idx` (`Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Laboratorista_Examen1_idx` (`Examen_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Laboratoristas_Usuario1`
    FOREIGN KEY (`Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Usuario` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Laboratorista_Examen1`
    FOREIGN KEY (`Examen_Codigo`)
    REFERENCES `HOSPITAL`.`Examen` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Turno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Turno` (
  `idTurno` INT NOT NULL AUTO_INCREMENT,
  `Dia_Turno` VARCHAR(45) NULL,
  `Laboratorista_Usuario_Codigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTurno`, `Laboratorista_Usuario_Codigo`),
  INDEX `fk_Turno_Laboratoristas1_idx` (`Laboratorista_Usuario_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Turno_Laboratoristas1`
    FOREIGN KEY (`Laboratorista_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Laboratorista` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Informe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Informe` (
  `idInforme` INT NOT NULL AUTO_INCREMENT,
  `Paciente_Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Medico_Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(2500) NULL,
  `Fecha` DATE NULL,
  `Hora` TIME NULL DEFAULT '1',
  `Estado` TINYINT(1) NULL,
  `Cita_Medico_Codigo` VARCHAR(45) NULL,
  PRIMARY KEY (`idInforme`),
  INDEX `fk_Informe_Paciente1_idx` (`Paciente_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Informe_Medico1_idx` (`Medico_Usuario_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Informe_Paciente1`
    FOREIGN KEY (`Paciente_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Paciente` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Informe_Medico1`
    FOREIGN KEY (`Medico_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Medico` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Especialidad` (
  `idEspecialidad` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(200) NULL,
  `Estado` TINYINT(1) NULL DEFAULT 1,
  `Medico_Usuario_Codigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEspecialidad`),
  INDEX `fk_Especialidad_Medico1_idx` (`Medico_Usuario_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Especialidad_Medico1`
    FOREIGN KEY (`Medico_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Medico` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Administrador` (
  `Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(100) NULL,
  PRIMARY KEY (`Usuario_Codigo`),
  INDEX `fk_Administrador_Usuario1_idx` (`Usuario_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Administrador_Usuario1`
    FOREIGN KEY (`Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Usuario` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Consulta` (
  `Tipo` VARCHAR(200) NOT NULL,
  `Costo` DOUBLE NULL,
  PRIMARY KEY (`Tipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Resultado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Resultado` (
  `Codigo_Resultado` INT NOT NULL AUTO_INCREMENT,
  `Paciente_Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Medico_Usuario_Codigo` VARCHAR(45) NULL,
  `Laboratorista_Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Examen_Codigo` INT NOT NULL,
  `Orden` VARCHAR(300) NULL,
  `Informe_Examen` VARCHAR(300) NULL,
  `Fecha` DATE NULL,
  `Hora` TIME NULL,
  `Estado` TINYINT(1) NULL,
  PRIMARY KEY (`Codigo_Resultado`),
  INDEX `fk_Resultado_Paciente1_idx` (`Paciente_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Resultado_Laboratoristas1_idx` (`Laboratorista_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Resultado_Examen1_idx` (`Examen_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Resultado_Paciente1`
    FOREIGN KEY (`Paciente_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Paciente` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Resultado_Laboratoristas1`
    FOREIGN KEY (`Laboratorista_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Laboratorista` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Resultado_Examen1`
    FOREIGN KEY (`Examen_Codigo`)
    REFERENCES `HOSPITAL`.`Examen` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Cita_Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Cita_Medico` (
  `Codigo` INT NOT NULL AUTO_INCREMENT,
  `Paciente_Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Medico_Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Consulta_Tipo` VARCHAR(200) NOT NULL,
  `Fecha` DATE NULL,
  `Hora` TIME NULL,
  `Estado` TINYINT(1) NULL,
  PRIMARY KEY (`Codigo`),
  INDEX `fk_Cita_Paciente2_idx` (`Paciente_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Cita_Medico1_idx` (`Medico_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Cita_Medico_Consulta1_idx` (`Consulta_Tipo` ASC) VISIBLE,
  CONSTRAINT `fk_Cita_Paciente2`
    FOREIGN KEY (`Paciente_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Paciente` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_Medico1`
    FOREIGN KEY (`Medico_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Medico` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_Medico_Consulta1`
    FOREIGN KEY (`Consulta_Tipo`)
    REFERENCES `HOSPITAL`.`Consulta` (`Tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Cita_Laboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Cita_Laboratorio` (
  `Codigo` INT NOT NULL AUTO_INCREMENT,
  `Paciente_Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Laboratorista_Usuario_Codigo` VARCHAR(45) NOT NULL,
  `Examen_Codigo` INT NOT NULL,
  `Orden` VARCHAR(300) NULL,
  `Fecha` DATE NULL,
  `Hora` TIME NULL,
  `Estado` TINYINT(1) NULL,
  PRIMARY KEY (`Codigo`),
  INDEX `fk_Cita_Laboratorio_Paciente1_idx` (`Paciente_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Cita_Laboratorio_Laboratorista1_idx` (`Laboratorista_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Cita_Laboratorio_Examen1_idx` (`Examen_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Cita_Laboratorio_Paciente1`
    FOREIGN KEY (`Paciente_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Paciente` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_Laboratorio_Laboratorista1`
    FOREIGN KEY (`Laboratorista_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Laboratorista` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_Laboratorio_Examen1`
    FOREIGN KEY (`Examen_Codigo`)
    REFERENCES `HOSPITAL`.`Examen` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Ingresos_Laboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Ingresos_Laboratorio` (
  `idIngresos_Laboratorio` INT NOT NULL AUTO_INCREMENT,
  `Paciente_Usuario_Codigo` VARCHAR(45) NULL,
  `Laboratorista_Usuario_Codigo` VARCHAR(45) NULL,
  `Fecha` DATE NULL,
  `Total` DOUBLE NULL,
  `Cita_Laboratorio_Codigo` INT NOT NULL,
  PRIMARY KEY (`idIngresos_Laboratorio`),
  INDEX `fk_Ingresos_Laboratorio_Paciente1_idx` (`Paciente_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Ingresos_Laboratorio_Laboratorista1_idx` (`Laboratorista_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Ingresos_Laboratorio_Cita_Laboratorio1_idx` (`Cita_Laboratorio_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Ingresos_Laboratorio_Paciente1`
    FOREIGN KEY (`Paciente_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Paciente` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ingresos_Laboratorio_Laboratorista1`
    FOREIGN KEY (`Laboratorista_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Laboratorista` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ingresos_Laboratorio_Cita_Laboratorio1`
    FOREIGN KEY (`Cita_Laboratorio_Codigo`)
    REFERENCES `HOSPITAL`.`Cita_Laboratorio` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HOSPITAL`.`Ingresos_Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HOSPITAL`.`Ingresos_Medico` (
  `idIngresos_Medico` INT NOT NULL AUTO_INCREMENT,
  `Paciente_Usuario_Codigo` VARCHAR(45) NULL,
  `Medico_Usuario_Codigo` VARCHAR(45) NULL,
  `Fecha` DATE NULL,
  `Total` DOUBLE NULL,
  `Cita_Medico_Codigo` INT NOT NULL,
  PRIMARY KEY (`idIngresos_Medico`),
  INDEX `fk_Ingresos_Medico_Paciente1_idx` (`Paciente_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Ingresos_Medico_Medico1_idx` (`Medico_Usuario_Codigo` ASC) VISIBLE,
  INDEX `fk_Ingresos_Medico_Cita_Medico1_idx` (`Cita_Medico_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Ingresos_Medico_Paciente1`
    FOREIGN KEY (`Paciente_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Paciente` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ingresos_Medico_Medico1`
    FOREIGN KEY (`Medico_Usuario_Codigo`)
    REFERENCES `HOSPITAL`.`Medico` (`Usuario_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ingresos_Medico_Cita_Medico1`
    FOREIGN KEY (`Cita_Medico_Codigo`)
    REFERENCES `HOSPITAL`.`Cita_Medico` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
